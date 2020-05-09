package com.example.a.myapplication;

import android.app.Application;

public class GlobalScore extends Application {
    private float score1, score2, score3;
    private String txtscore1, txtscore2, txtscore3;

    public String getScore1() {
        txtscore1 = Float.toString(score1)+"/10";
        return txtscore1;
    }

    public void setScore1(float score) {
        this.score1 = score;
    }

    public String getScore2() {
        txtscore2 = Float.toString(score2)+"/10";
        return txtscore2;
    }

    public void setScore2(float score) {
        this.score2 = score;
    }

    public String getScore3() {
        txtscore3 = Float.toString(score3)+"/10";
        return txtscore3;
    }

    public void setScore3(float score) {
        this.score3 = score;
    }
}
