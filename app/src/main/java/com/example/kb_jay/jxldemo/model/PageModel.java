package com.example.kb_jay.jxldemo.model;

import android.util.Log;

/**
 * Created by kb_jay on 2018/4/17.
 */

public class PageModel {
    private static String Title = "<!DOCTYPE html >\n" +
            "<html lang=\"{{ config('app.locale') }}\">\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\"\n" +
            "          content=\"width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\">\n" +
            "    <meta http - equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
            "    <meta http - equiv=\"Access-Control-Allow-Origin\" content=\"*\">\n" +
            "    <link rel=\"stylesheet\" href=\"http://static.51zuoyeben.cn/static/css/reset.css\">\n" +
            "    <script type=\"text/javascript\" src=\"/js/resize_page.js\"></script>\n" +
            "    <script type=\"text/javascript\" src=\"http://static.51zuoyeben.cn/static/js/jquery-3.2.0.min.js\"></script>\n" +
            "    <style>\n" +
            "        .card_root {\n" +
            "            width: 80%;\n" +
            "            margin: 2rem auto;\n" +
            "            padding: 1.5rem 0rem 1.5rem 0rem;\n" +
            "            box-shadow: 0.2rem 0.2rem 0.1rem #aaaaaa;\n" +
            "            border-radius: 1rem;\n" +
            "            background: #eee;\n" +
            "        }\n" +
            "\n" +
            "        .count_down_bg {\n" +
            "            display: none;\n" +
            "            width: 3rem;\n" +
            "            margin: 0 auto 0rem auto;\n" +
            "            height: 3rem;\n" +
            "            border: 0.1rem solid #F26C61;\n" +
            "            border-radius: 50%;\n" +
            "            -moz-border-radius: 50%;\n" +
            "            -webkit-border-radius: 50%;\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "\n" +
            "        .count_down_bg .count_down_tv {\n" +
            "            line-height: 3rem;\n" +
            "            font-size: 1.4rem;\n" +
            "            color: #F26C61;\n" +
            "        }\n" +
            "\n" +
            "        .select_root {\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        .select_root .select_stem_root {\n" +
            "            margin: 0.5rem 0rem 0.5rem 0.6rem;\n" +
            "            float: left;\n" +
            "            clear: both;\n" +
            "        }\n" +
            "\n" +
            "        .select_root .select_stem_root .select_stem_number {\n" +
            "            float: left;\n" +
            "            width: 1.8rem;\n" +
            "            height: 1.8rem;\n" +
            "            font-size: 1.3rem;\n" +
            "            text-align: center;\n" +
            "            letter-spacing: 0;\n" +
            "            margin-top: 0.15rem;\n" +
            "            border-radius: 50%;\n" +
            "            background: #F26C61;\n" +
            "            color: white;\n" +
            "            line-height: 1.8rem;\n" +
            "            display: inline-block;\n" +
            "        }\n" +
            "\n" +
            "        .select_root .select_stem_root .select_stem_content {\n" +
            "            font-size: 1.3rem;\n" +
            "            float: right;\n" +
            "            width: 20rem;\n" +
            "            margin-left: 0.475rem;\n" +
            "            line-height: 1.7rem;\n" +
            "            text-align: justify;\n" +
            "            color: #583a11;\n" +
            "        }\n" +
            "\n" +
            "        .select_root .select_stem_root .select_stem_content img {\n" +
            "            max-width: 18rem;\n" +
            "            padding-top: 0.8rem;\n" +
            "            padding-bottom: 0.8rem;\n" +
            "        }\n" +
            "\n" +
            "        .select_root .select_option_root {\n" +
            "            margin: 0 2.5rem 1rem 2.5rem;\n" +
            "            padding-top: 1rem;\n" +
            "            clear: both;\n" +
            "        }\n" +
            "\n" +
            "        .select_root .select_item_root {\n" +
            "            color: #583a11;\n" +
            "            width: 20rem;\n" +
            "            margin-bottom: 1.5rem;\n" +
            "            overflow: hidden;\n" +
            "        }\n" +
            "\n" +
            "        .select_root .select_item_root .select_item_left {\n" +
            "            width: 1.0rem;\n" +
            "            height: 1.3rem;\n" +
            "            font-weight: bold;\n" +
            "            text-align: center;\n" +
            "            line-height: 1.3rem;\n" +
            "            font-size: 1.3rem;\n" +
            "            float: left;\n" +
            "        }\n" +
            "\n" +
            "        .select_root .select_item_root .select_item_right {\n" +
            "            width: 18.5rem;\n" +
            "            float: left;\n" +
            "            font-size: 1.3rem;\n" +
            "            letter-spacing: 0;\n" +
            "            line-height: 1.3rem;\n" +
            "            margin-top: 0rem;\n" +
            "            margin-left: 0.4rem;\n" +
            "        }\n" +
            "\n" +
            "        .wait_other_player {\n" +
            "            width: 9rem;\n" +
            "            border: 0.1rem solid #AB9F9A;\n" +
            "            border-radius: 1.5rem;\n" +
            "            padding: 0.5rem 1rem;\n" +
            "            margin: 0 auto;\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "\n" +
            "        .wait_other_player .wait_other_player_tv {\n" +
            "            font-size: 1.3rem;\n" +
            "            color: #c00;\n" +
            "            line-height: 2rem;\n" +
            "        }\n" +
            "\n" +
            "        .record_root {\n" +
            "            display: inline-block;\n" +
            "            background: #3F51B5;\n" +
            "            width: 30%;\n" +
            "            padding-top: 0.5rem;\n" +
            "            padding-bottom: 0.5rem;\n" +
            "            text-align: center;\n" +
            "            margin: 1rem 2rem;\n" +
            "            border-radius: 1rem;\n" +
            "        }\n" +
            "\n" +
            "        .record_span {\n" +
            "            font-size: 1.3rem;\n" +
            "            color: #fff;\n" +
            "        }\n" +
            "\n" +
            "        .watch_root {\n" +
            "            display: inline-block;\n" +
            "            background: #3F51B5;\n" +
            "            width: 30%;\n" +
            "            padding-top: 0.5rem;\n" +
            "            padding-bottom: 0.5rem;\n" +
            "            text-align: center;\n" +
            "            margin: 1rem 2rem;\n" +
            "            border-radius: 1rem;\n" +
            "        }\n" +
            "\n" +
            "        .watch_span {\n" +
            "            font-size: 1.3rem;\n" +
            "            color: #fff;\n" +
            "        }\n" +
            "\n" +
            "        .bottom_root {\n" +
            "        }\n" +
            "\n" +
            "        .right_root {\n" +
            "            display: none;\n" +
            "            margin: 0 auto;\n" +
            "            padding-top: 0.5rem;\n" +
            "            padding-bottom: 0.5rem;\n" +
            "            text-align: center;\n" +
            "            width: 7rem;\n" +
            "            border-radius: 1rem;\n" +
            "            background: #090;\n" +
            "        }\n" +
            "\n" +
            "        .right_tv {\n" +
            "            font-size: 1.3rem;\n" +
            "            color: #fff;\n" +
            "        }\n" +
            "\n" +
            "        .wrong_tv {\n" +
            "            font-size: 1.5rem;\n" +
            "            color: #000;\n" +
            "        }\n" +
            "\n" +
            "        .no_answer_tv {\n" +
            "            font-size: 1.5rem;\n" +
            "            color: #000;\n" +
            "        }\n" +
            "\n" +
            "        .wrong_root {\n" +
            "            display: none;\n" +
            "            text-align: center;\n" +
            "            margin: 0 auto;\n" +
            "        }\n" +
            "\n" +
            "        .no_answer_root {\n" +
            "            display: none;\n" +
            "            text-align: center;\n" +
            "            margin: 0 auto;\n" +
            "        }\n" +
            "\n" +
            "        .log {\n" +
            "        }\n" +
            "\n" +
            "        .top_root {\n" +
            "            margin-top: 1rem;\n" +
            "            margin-bottom: 1rem;\n" +
            "        }\n" +
            "\n" +
            "        .wait_next_que {\n" +
            "            height: 3rem;\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "    </style>\n" +
            "\n" +
            "</head>";

    public static String getQuestionHtml(TeamBean.QuestionBean bean) {
        StringBuilder html = new StringBuilder();
        html.append(Title);
        html.append("<div class=\"card_root\">\n" +
                "    <div class=\"top_root\">\n" +
                "        <div class=\"wait_other_player\">\n" +
                "        <span class=\"wait_other_player_tv\">\n" +
                "           题目检查\n" +
                "        </span>\n" +
                "        </div>\n" +
                "    </div>");
        html.append("<div class=\"select_root\">");


        html.append("<div class='select_stem_root'>")
                .append("<span class='select_stem_number'>")
                .append(bean.number)
                .append("</span>")
                .append("<span class='select_stem_content'>")
                .append(replaceQuestion(bean.questionStem))
                .append("</span>")
                .append("</div>");
        html.append("<ol class='select_option_root'>");
        String[] strings = {"A", "B", "C", "D"};
        for (int i = 0; i < bean.qustionSelection.size(); i++) {
            html.append("<li class='select_item_root'>")
                    .append("<span class='select_item_left'>")
                    .append(strings[i])
                    .append("</span>")
                    .append("<span class='select_item_right'>")
                    .append(replaceQuestion(bean.qustionSelection.get(i)))
                    .append("</span>")
                    .append("</li>");
        }
        html.append("</ol>");
        html.append("</div>");
        html.append("</div>\n" +
                "</body>");
        Log.d("html", html.toString());
        return html.toString();
    }

    private static String replaceQuestion(String questionStem) {
        String r1 = questionStem.replace("\\n", "<br />");
        String r2 = r1.replace("zybimg", "http://static.51zuoyeben.cn/question/zybimg");
        return r2.replace("\\r", "<br />");
    }
}
