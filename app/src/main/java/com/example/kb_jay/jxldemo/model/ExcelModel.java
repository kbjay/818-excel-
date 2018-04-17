package com.example.kb_jay.jxldemo.model;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by kb_jay on 2018/4/17.
 */

public class ExcelModel {
    private static ExcelModel instance;
    private Context context;
    private Workbook workbook;

    private ExcelModel(Context context) {
        this.context = context;
    }

    public static ExcelModel getInstance(Context context) {
        Context app = context.getApplicationContext();
        if (instance == null) {
            synchronized (ExcelModel.class) {
                if (instance == null) {
                    instance = new ExcelModel(app);
                }
            }
        }
        return instance;
    }


    public void getTeams(final String path, final GetDataCallback callback) {
        final ArrayList<TeamBean> teamBeans = new ArrayList<>();
        Observable.create(new Observable.OnSubscribe<File>() {
            @Override
            public void call(Subscriber<? super File> subscriber) {
                File file = new File(path);
                if ((file.isFile() && file.exists())) {
                    subscriber.onNext(file);
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new Throwable("文件不存在"));
                }

            }
        }).flatMap(new Func1<File, Observable<Sheet>>() {
            @Override
            public Observable<Sheet> call(File file) {

                workbook = null;
                try {
                    workbook = Workbook.getWorkbook(file);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }
                Sheet[] sheets = workbook.getSheets();
                return Observable.from(sheets);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Sheet>() {
                    @Override
                    public void call(Sheet sheet) {
                        TeamBean teamBean = new TeamBean();
                        teamBean.mQustions = new ArrayList<>();
                        Cell[] questionStems = sheet.getColumn(0);
                        Cell[] questionSelections = sheet.getColumn(1);
                        if (questionStems.length > 1 && "题干".equals(questionStems[0].getContents()) && "选项".equals(questionSelections[0].getContents())) {
                            for (int i = 1; i < questionStems.length; i++) {
                                TeamBean.QuestionBean questionBean = new TeamBean.QuestionBean();
                                questionBean.number = i;
                                questionBean.qustionSelection = new ArrayList<>();

                                questionBean.questionStem = questionStems[i].getContents();
                                if (TextUtils.isEmpty(questionBean.questionStem)) {
                                    break;
                                }
                                String contents = questionSelections[i].getContents();
                                String[] split = contents.split("\\|");
                                questionBean.qustionSelection.addAll(Arrays.asList(split));
                                teamBean.mQustions.add(questionBean);
                            }
                        } else {
                            Toast.makeText(context, "excel error", Toast.LENGTH_SHORT).show();
                        }
                        teamBeans.add(teamBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        if (callback != null) {
                            callback.onFailed();
                        }
                        if (workbook != null) {
                            workbook.close();
                        }
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        if (callback != null) {
                            callback.onSuccess(teamBeans);
                        }
                        if (workbook != null) {
                            workbook.close();
                        }
                    }
                });
    }

    public interface GetDataCallback {
        void onSuccess(ArrayList<TeamBean> teamBeans);

        void onFailed();
    }
}
