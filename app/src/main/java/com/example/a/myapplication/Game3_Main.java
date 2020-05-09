package com.example.a.myapplication;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Game3_Main extends AppCompatActivity implements OnClickListener {
    private Timer moleTimer, gameTimer;
    private TimerTask moleTask, gameTask;
    private Game3_Whack whack;
    public static ImageView pipe1, pipe2, pipe3, pipe4, pipe5, pipe6, pipe7, pipe8, pipe9;
    public static TextView timeText, scoreText;
    public static Button pause, newGame;
    public static TextView endMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game3_main);

        moleTimer = new Timer();
        gameTimer = new Timer();
        whack = new Game3_Whack(this);
        moleTask = new TimerTask() {
            @Override
            public void run() {
                whack.spawnWater();

            }
        };
        gameTask = new TimerTask(){
            @Override
            public void run() {
                whack.setTimer();
            }
        };
        moleTimer.schedule(moleTask,0, 1500);
        gameTimer.schedule(gameTask, 0, 1000);
        timeText = (TextView)findViewById(R.id.txtTime);
        scoreText = (TextView)findViewById(R.id.txtScore);
        endMessage = (TextView)findViewById(R.id.lblGameOver);
        timeText.setKeyListener(null);
        scoreText.setKeyListener(null);
        pipe1 = (ImageView)findViewById(R.id.btnMole1);
        pipe2 = (ImageView)findViewById(R.id.btnMole2);
        pipe3 = (ImageView)findViewById(R.id.btnMole3);
        pipe4 = (ImageView)findViewById(R.id.btnMole4);
        pipe5 = (ImageView)findViewById(R.id.btnMole5);
        pipe6 = (ImageView)findViewById(R.id.btnMole6);
        pipe7 = (ImageView)findViewById(R.id.btnMole7);
        pipe8 = (ImageView)findViewById(R.id.btnMole8);
        pipe9 = (ImageView)findViewById(R.id.btnMole9);
        pause = (Button)findViewById(R.id.btnPause);
        newGame = (Button)findViewById(R.id.btnNew);
        pipe1.setOnClickListener(this);
        pipe2.setOnClickListener(this);
        pipe3.setOnClickListener(this);
        pipe4.setOnClickListener(this);
        pipe5.setOnClickListener(this);
        pipe6.setOnClickListener(this);
        pipe7.setOnClickListener(this);
        pipe8.setOnClickListener(this);
        pipe9.setOnClickListener(this);
        pause.setOnClickListener(this);
        newGame.setOnClickListener(this);
    }

    public void onClick(View view){
        if(whack.paused==false && whack.endGame==false) {
            if (pipe1 == view && whack.waterSpawn1 == 1) {
                whack.waterSpawn1 = 0;
                pipe1.setImageResource(R.drawable.pipe1);
                whack.addScore();
            } else if (pipe2 == view && whack.waterSpawn2 == 1) {
                whack.waterSpawn2 = 0;
                pipe2.setImageResource(R.drawable.pipe2);
                whack.addScore();
            } else if (pipe3 == view && whack.waterSpawn3 == 1) {
                whack.waterSpawn3 = 0;
                pipe3.setImageResource(R.drawable.pipe3);
                whack.addScore();
            } else if (pipe4 == view && whack.waterSpawn4 == 1) {
                whack.waterSpawn4 = 0;
                pipe4.setImageResource(R.drawable.pipe4);
                whack.addScore();
            } else if (pipe5 == view && whack.waterSpawn5 == 1) {
                whack.waterSpawn5 = 0;
                pipe5.setImageResource(R.drawable.pipe5);
                whack.addScore();
            } else if (pipe6 == view && whack.waterSpawn6 == 1) {
                whack.waterSpawn6 = 0;
                pipe6.setImageResource(R.drawable.pipe6);
                whack.addScore();
            } else if (pipe7 == view && whack.waterSpawn7 == 1) {
                whack.waterSpawn7 = 0;
                pipe7.setImageResource(R.drawable.pipe7);
                whack.addScore();
            } else if (pipe8 == view && whack.waterSpawn8 == 1) {
                whack.waterSpawn8 = 0;
                pipe8.setImageResource(R.drawable.pipe8);
                whack.addScore();
            } else if (pipe9 == view && whack.waterSpawn9 == 1) {
                whack.waterSpawn9 = 0;
                pipe9.setImageResource(R.drawable.pipe9);
                whack.addScore();
            }
        }

        if(pause==view){
            whack.setPaused();
        }
        if(newGame==view){
            whack.newGame();
        }
    }

    public void onGameOver(float finalScore){
        Intent intent = new Intent(this, ResultPage.class);
        finalScore = Math.round(finalScore*10);
        intent.putExtra("RIGHT_ANSWER_COUNT", finalScore);
        intent.putExtra("GameID", 3);
        startActivity(intent);
    }
}