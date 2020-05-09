package com.example.a.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity implements View.OnClickListener
{
    Button btnReturn;
    private float score;
    int gameID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1_result);

        TextView resultLabel = (TextView)findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoretLabel);
        btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);

        this.score = getIntent().getFloatExtra("RIGHT_ANSWER_COUNT",0);
        this.gameID = getIntent().getIntExtra("GameID",0);

        String name = "john";
        Log.d("Result: ",score+"");
        resultLabel.setText(score+"/10");
        totalScoreLabel.setText("Total Score : "+ score);

        switch (gameID){
            case 1:
                ((GlobalScore) this.getApplication()).setScore1(score);
                break;
            case 2:
                ((GlobalScore) this.getApplication()).setScore2(score);
                break;
            case 3:
                ((GlobalScore) this.getApplication()).setScore3(score);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnReturn:
                Intent intent = new Intent(getApplicationContext(), GameMenu.class);
                startActivity(intent);
                break;
        }
    }
}
