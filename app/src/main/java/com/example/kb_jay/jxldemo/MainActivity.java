package com.example.kb_jay.jxldemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kb_jay.jxldemo.model.ExcelModel;
import com.example.kb_jay.jxldemo.model.PageModel;
import com.example.kb_jay.jxldemo.model.TeamBean;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private StringBuilder mMsg = new StringBuilder();
    private WebView mWebView;
    private int mCurrentSheetIndex = 0;
    private int mCurrentQuestionIndex = 0;
    private Button mBtStart;
    private EditText mEtFileName;
    private Button mBtNextQuesion;
    private Button mBtPreQeustion;
    private Button mBtNextSheet;
    private Button mBtPreSheet;
    private ArrayList<TeamBean> mData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) this.findViewById(R.id.web_demo);
        mBtStart = (Button) this.findViewById(R.id.bt_start);
        mEtFileName = (EditText) this.findViewById(R.id.et_file_name);
        mBtNextQuesion = (Button) this.findViewById(R.id.tv_next_question);
        mBtPreQeustion = (Button) this.findViewById(R.id.tv_pre_question);
        mBtNextSheet = (Button) this.findViewById(R.id.tv_next_sheet);
        mBtPreSheet = (Button) this.findViewById(R.id.tv_pre_sheet);

        mBtNextQuesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData != null
                        && mData.get(mCurrentSheetIndex) != null
                        && mData.get(mCurrentSheetIndex).mQustions != null
                        && mCurrentQuestionIndex < mData.get(mCurrentSheetIndex).mQustions.size() - 1) {
                    mCurrentQuestionIndex++;
                    handleData();
                } else {
                    Toast.makeText(MainActivity.this, "已经最后一道题了", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBtPreQeustion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData != null
                        && mData.get(mCurrentSheetIndex) != null
                        && mData.get(mCurrentSheetIndex).mQustions != null
                        && mCurrentQuestionIndex > 0) {
                    mCurrentQuestionIndex--;
                    handleData();
                } else {
                    Toast.makeText(MainActivity.this, "已经是第一道题了", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtPreSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData != null && mCurrentSheetIndex > 0) {
                    mCurrentSheetIndex--;
                    mCurrentQuestionIndex = 0;
                    handleData();
                } else {
                    Toast.makeText(MainActivity.this, "已经是第一张表了", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBtNextSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData != null && mCurrentSheetIndex < mData.size() - 1) {
                    mCurrentSheetIndex++;
                    mCurrentQuestionIndex = 0;
                    handleData();
                } else {
                    Toast.makeText(MainActivity.this, "已经是最后一张表了", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mBtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mEtFileName.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    name="demo.xls";
                }
                ExcelModel.getInstance(MainActivity.this).getTeams(Environment.getExternalStorageDirectory() + File.separator + name, new ExcelModel.GetDataCallback() {
                    @Override
                    public void onSuccess(ArrayList<TeamBean> teamBeans) {
                        mData.clear();
                        mData.addAll(teamBeans);
                        handleData();
                    }

                    @Override
                    public void onFailed() {

                    }
                });
            }
        });

    }

    private void handleData() {
        if (mData != null) {
            TeamBean.QuestionBean bean = mData.get(mCurrentSheetIndex).mQustions.get(mCurrentQuestionIndex);
            String questionHtml = PageModel.getQuestionHtml(bean);
            mWebView.loadDataWithBaseURL(null,questionHtml,
                    "text/html", "utf-8",null);

        }
    }

}
