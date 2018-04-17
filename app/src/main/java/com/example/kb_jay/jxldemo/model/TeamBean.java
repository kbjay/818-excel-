package com.example.kb_jay.jxldemo.model;

import java.util.ArrayList;

/**
 * Created by kb_jay on 2018/4/17.
 */

public class TeamBean {
    public ArrayList<QuestionBean> mQustions;
    public static class QuestionBean {
        public int number;
        public String questionStem;
        public ArrayList<String> qustionSelection;
    }
}
