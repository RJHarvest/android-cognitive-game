package com.example.a.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameMenu extends AppCompatActivity implements View.OnClickListener{
    Button btnGame1, btnGame2, btnGame3, btnScore, btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        btnGame1 = (Button) findViewById(R.id.btnGame1);
        btnGame2 = (Button) findViewById(R.id.btnGame2);
        btnGame3 = (Button) findViewById(R.id.btnGame3);
        btnScore = (Button)findViewById(R.id.btnScore);
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnGame1.setOnClickListener(this);
        btnGame2.setOnClickListener(this);
        btnGame3.setOnClickListener(this);
        btnScore.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(GameMenu.this, StartActivity.class);
        switch (v.getId()){
            case R.id.btnGame1:
                intent.putExtra("GameID", 1);
                startActivity(intent);
                break;
            case R.id.btnGame2:
                intent.putExtra("GameID", 2);
                startActivity(intent);
                break;
            case R.id.btnGame3:
                intent.putExtra("GameID", 3);
                startActivity(intent);
                break;
            case R.id.btnScore:
                Intent scorePage = new Intent(this, Score.class);
                startActivity(scorePage);
                break;
            case R.id.btnLogout:
                Intent logout = new Intent(this, Login.class);
                startActivity(logout);
                break;
        }
    }
}
