package com.example.a.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDemo, btnPlay, backtoHome;
    private TextView tvGameTitle;
    int GameID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btnDemo = (Button) findViewById(R.id.demoBtn);
        btnPlay = (Button) findViewById(R.id.playBtn);
        backtoHome = (Button) findViewById(R.id.backtoHome);
        tvGameTitle = (TextView) findViewById(R.id.tvGameTitle);

        btnDemo.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        backtoHome.setOnClickListener(this);

        Intent intent = getIntent();
        GameID = intent.getIntExtra("GameID",0);

        switch (GameID){
            case 1:
                tvGameTitle.setText("Quiz Game");
                break;
            case 2:
                tvGameTitle.setText("Jigsaw Puzzle");
                break;
            case 3:
                tvGameTitle.setText("Water Pipe Game");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.demoBtn:
                Intent demo = new Intent(getApplicationContext(), Demo.class);
                demo.putExtra("GameID", GameID);
                startActivity(demo);
                break;
           case R.id.playBtn:
                if (GameID == 1){
                    Intent game1 = new Intent(getApplicationContext(), Game1_Main.class);
                    startActivity(game1);
                } else if (GameID == 2){
                    Intent game2 = new Intent(getApplicationContext(), Game2_Main.class);
                    startActivity(game2);
                } else {
                    Intent game3 = new Intent(getApplicationContext(), Game3_Main.class);
                    startActivity(game3);
                }
                break;
            case R.id.backtoHome:
                Intent backtoHome = new Intent(StartActivity.this, GameMenu.class);
                startActivity(backtoHome);
                break;
        }
    }
}
