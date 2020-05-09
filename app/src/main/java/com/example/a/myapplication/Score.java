package com.example.a.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Score extends AppCompatActivity implements View.OnClickListener {
    private ListView listScore, listName;
    private String score1, score2, score3;
    Button btnBack;
    ArrayList<String> StringArray;
    ArrayList<Float> FloatArray;
    BarChart chart;
    ArrayList<BarEntry> BARENTRY;
    ArrayList<String> BarEntryLabels;
    BarDataSet Bardataset;
    BarData BARDATA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            // highly not prefer using internet in main thread
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        listName = (ListView) findViewById(R.id.listView_Name);
        listScore = (ListView) findViewById(R.id.listView_Score);
        StringArray = new ArrayList<String>();
        ArrayAdapter<String> adapterName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, StringArray){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        StringArray = new ArrayList<>();
        ArrayAdapter<String> adapterScore = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, StringArray){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        adapterName.add("Quiz Game:");
        adapterName.add("Puzzle Game:");
        adapterName.add("Water Pipe Game:");
        score1 = ((GlobalScore) this.getApplication()).getScore1();
        score2 = ((GlobalScore) this.getApplication()).getScore2();
        score3 = ((GlobalScore) this.getApplication()).getScore3();

        adapterScore.add(score1);
        adapterScore.add(score2);
        adapterScore.add(score3);
        listName.setAdapter(adapterName);
        listScore.setAdapter(adapterScore);

        //Declare_BarCart
        chart = (BarChart) findViewById(R.id.barchart_bygame);
        BARENTRY = new ArrayList<BarEntry>();
        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY(R.id.btn_quizz);
        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Projects");
        BARDATA = new BarData(Bardataset);
        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(BARDATA);
        chart.animateY(2000);
    }

    // Button Events
    public void onClick_filterChart(View v) {
        AddValuesToBARENTRY(v.getId());
    }

    // Get Data
    public void AddValuesToBARENTRY(int btnID) {
        BARENTRY.clear();
        switch (btnID) {
            case R.id.btn_quizz:
                BARENTRY.add(new BarEntry(2f, 0));
                BARENTRY.add(new BarEntry(4f, 1));
                BARENTRY.add(new BarEntry(6f, 2));
                BARENTRY.add(new BarEntry(4f, 3));
                BARENTRY.add(new BarEntry(0f, 4));
                BARENTRY.add(new BarEntry(3f, 5));
                BARENTRY.add(new BarEntry(3f, 6));
                break;
            case R.id.btn_puzzle:
                BARENTRY.add(new BarEntry(3f, 0));
                BARENTRY.add(new BarEntry(6f, 1));
                BARENTRY.add(new BarEntry(1f, 2));
                BARENTRY.add(new BarEntry(1f, 3));
                BARENTRY.add(new BarEntry(2f, 4));
                BARENTRY.add(new BarEntry(3f, 5));
                BARENTRY.add(new BarEntry(7f, 6));
                break;
            case R.id.btn_waterpipe:
                BARENTRY.add(new BarEntry(2f, 0));
                BARENTRY.add(new BarEntry(1f, 1));
                BARENTRY.add(new BarEntry(3f, 2));
                BARENTRY.add(new BarEntry(5f, 3));
                BARENTRY.add(new BarEntry(5f, 4));
                BARENTRY.add(new BarEntry(3f, 5));
                BARENTRY.add(new BarEntry(6f, 6));
                break;
        }

        chart.setData(BARDATA);
        chart.animateY(2000);
    }

    public void AddValuesToBarEntryLabels() {
        BarEntryLabels.add("Sun");
        BarEntryLabels.add("Mon");
        BarEntryLabels.add("Tue");
        BarEntryLabels.add("Wed");
        BarEntryLabels.add("Thur");
        BarEntryLabels.add("Fri");
        BarEntryLabels.add("Sat");
    }

    @Override
    public void onClick(View v) {
        Intent gameMenu = new Intent(this, GameMenu.class);
        startActivity(gameMenu);
    }
}