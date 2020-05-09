package com.example.a.myapplication;

import android.app.Activity;
import android.view.View;

import java.util.Random;

public class Game3_Whack extends Activity{
    private int score = 0;
    private int count = 0;
    private int timer = 0;
    public int waterSpawn1 = 0;
    public int waterSpawn2 = 0;
    public int waterSpawn3 = 0;
    public int waterSpawn4 = 0;
    public int waterSpawn5 = 0;
    public int waterSpawn6 = 0;
    public int waterSpawn7 = 0;
    public int waterSpawn8 = 0;
    public int waterSpawn9 = 0;
    public boolean paused = false;
    public boolean endGame = false;
    private Game3_Main main;

    public Game3_Whack(Game3_Main main) {
        this.main = main;
    }

    protected void spawnWater(){
        if (!paused && !endGame) {
            Random r = new Random();
            waterSpawn1 = r.nextInt(4);
            waterSpawn2 = r.nextInt(4);
            waterSpawn3 = r.nextInt(4);
            waterSpawn4 = r.nextInt(4);
            waterSpawn5 = r.nextInt(4);
            waterSpawn6 = r.nextInt(4);
            waterSpawn7 = r.nextInt(4);
            waterSpawn8 = r.nextInt(4);
            waterSpawn9 = r.nextInt(4);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    main.pipe1.setImageResource(R.drawable.pipe1);
                    main.pipe2.setImageResource(R.drawable.pipe2);
                    main.pipe3.setImageResource(R.drawable.pipe3);
                    main.pipe4.setImageResource(R.drawable.pipe4);
                    main.pipe5.setImageResource(R.drawable.pipe5);
                    main.pipe6.setImageResource(R.drawable.pipe6);
                    main.pipe7.setImageResource(R.drawable.pipe7);
                    main.pipe8.setImageResource(R.drawable.pipe8);
                    main.pipe9.setImageResource(R.drawable.pipe9);
                    if (waterSpawn1 == 1) {
                        main.pipe1.setImageResource(R.drawable.water1);
                        count++;
                    }
                    if (waterSpawn2 == 1) {
                        main.pipe2.setImageResource(R.drawable.water2);
                        count++;
                    }
                    if (waterSpawn3 == 1) {
                        main.pipe3.setImageResource(R.drawable.water3);
                        count++;
                    }
                    if (waterSpawn4 == 1) {
                        main.pipe4.setImageResource(R.drawable.water4);
                        count++;
                    }
                    if (waterSpawn5 == 1) {
                        main.pipe5.setImageResource(R.drawable.water5);
                        count++;
                    }
                    if (waterSpawn6 == 1) {
                        main.pipe6.setImageResource(R.drawable.water6);
                        count++;
                    }
                    if (waterSpawn7 == 1) {
                        main.pipe7.setImageResource(R.drawable.water7);
                        count++;
                    }
                    if (waterSpawn8 == 1) {
                        main.pipe8.setImageResource(R.drawable.water8);
                        count++;
                    }
                    if (waterSpawn9 == 1) {
                        main.pipe9.setImageResource(R.drawable.water9);
                        count++;
                    }
                }
            });
        }
    }

    public void setPaused(){
        if (paused){
            paused = false;
            System.out.println("resumed and paused = "+paused);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    main.pause.setText("Pause");
                }
            });
        } else if (!paused) {
            paused = true;
            System.out.println("paused and pause = " + paused);
            runOnUiThread (new Runnable() {
                @Override
                public void run() {
                    main.pipe1.setImageResource(R.drawable.pipe1);
                    main.pipe2.setImageResource(R.drawable.pipe2);
                    main.pipe3.setImageResource(R.drawable.pipe3);
                    main.pipe4.setImageResource(R.drawable.pipe4);
                    main.pipe5.setImageResource(R.drawable.pipe5);
                    main.pipe6.setImageResource(R.drawable.pipe6);
                    main.pipe7.setImageResource(R.drawable.pipe7);
                    main.pipe8.setImageResource(R.drawable.pipe8);
                    main.pipe9.setImageResource(R.drawable.pipe9);
                    waterSpawn1 = 0;
                    waterSpawn2 = 0;
                    waterSpawn3 = 0;
                    waterSpawn4 = 0;
                    waterSpawn5 = 0;
                    waterSpawn6 = 0;
                    waterSpawn7 = 0;
                    waterSpawn8 = 0;
                    waterSpawn9 = 0;
                    main.pause.setText("Resume");
                }
            });
        }
    }

    public void setTimer(){
        if (timer<30 && !paused) {
            timer += 1;
            runOnUiThread (new Runnable() {
                @Override
                public void run() {
                    main.timeText.setText("Time: " + timer);
                }
            });
        }

        if (timer == 15){
            endGame=true;
            runOnUiThread (new Runnable() {
                @Override
                public void run() {
                    main.endMessage.setVisibility(View.VISIBLE);
                    main.pipe1.setImageResource(R.drawable.pipe1);
                    main.pipe2.setImageResource(R.drawable.pipe2);
                    main.pipe3.setImageResource(R.drawable.pipe3);
                    main.pipe4.setImageResource(R.drawable.pipe4);
                    main.pipe5.setImageResource(R.drawable.pipe5);
                    main.pipe6.setImageResource(R.drawable.pipe6);
                    main.pipe7.setImageResource(R.drawable.pipe7);
                    main.pipe8.setImageResource(R.drawable.pipe8);
                    main.pipe9.setImageResource(R.drawable.pipe9);
                    waterSpawn1 = 0;
                    waterSpawn2 = 0;
                    waterSpawn3 = 0;
                    waterSpawn4 = 0;
                    waterSpawn5 = 0;
                    waterSpawn6 = 0;
                    waterSpawn7 = 0;
                    waterSpawn8 = 0;
                    waterSpawn9 = 0;
                }
            });
            float finalScore = (float) score/count;
            main.onGameOver(finalScore);
        }
    }

    public void addScore() {
        if (!paused && !endGame) {
            score += 1;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    main.scoreText.setText("Score: " + score);
                }
            });
        }
    }

    public void newGame(){
        paused = false;
        score = 0;
        timer = 0;
        endGame = false;
        runOnUiThread (new Runnable() {
            @Override
            public void run() {
                main.pipe1.setImageResource(R.drawable.pipe1);
                main.pipe2.setImageResource(R.drawable.pipe2);
                main.pipe3.setImageResource(R.drawable.pipe3);
                main.pipe4.setImageResource(R.drawable.pipe4);
                main.pipe5.setImageResource(R.drawable.pipe5);
                main.pipe6.setImageResource(R.drawable.pipe6);
                main.pipe7.setImageResource(R.drawable.pipe7);
                main.pipe8.setImageResource(R.drawable.pipe8);
                main.pipe9.setImageResource(R.drawable.pipe9);
                waterSpawn1 = 0;
                waterSpawn2 = 0;
                waterSpawn3 = 0;
                waterSpawn4 = 0;
                waterSpawn5 = 0;
                waterSpawn6 = 0;
                waterSpawn7 = 0;
                waterSpawn8 = 0;
                waterSpawn9 = 0;
                main.scoreText.setText("Score: 0");
                main.timeText.setText("Time: 0");
                main.endMessage.setVisibility(View.INVISIBLE);
                main.pause.setText("Pause");
            }
        });
    }
}