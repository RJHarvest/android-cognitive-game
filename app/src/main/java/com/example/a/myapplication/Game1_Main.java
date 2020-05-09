package com.example.a.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game1_Main extends AppCompatActivity implements View.OnClickListener{
    private TextView questionLabel, countLabel, countDown;
    private ImageView textimageIV;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;
    private String rightAnswer;
    private Timer gameTimer;
    private TimerTask gameTask;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    private int timer = 6;
    static final private int QUIZ_COUNT = 5;
    ArrayList<Object> quizArray = new ArrayList<>();
    String textimage[] = {"question1" ,"question2" ,"question3" ,"question4" ,"question5" ,"question6" ,"question7" ,"question8" ,"question9" ,"question10" ,"question11" ,"question12" ,"question13" ,"question14" ,"question15"};
    String[] country = {"A123" ,"B456" ,"C789" ,"D123" ,"E456" ,"F789","G123" ,"H456" ,"I789" ,"J123" ,"K456" ,"L789" ,"M123" ,"N456" ,"O789"};
    String[] rightanswer = {"A123" ,"B456" ,"C789" ,"D123" ,"E456" ,"F789","G123" ,"H456" ,"I789" ,"J123" ,"K456" ,"L789" ,"M123" ,"N456" ,"O789"};
    String[] choicel = {"G123","E456" ,"A123" ,"B456" ,"C789" ,"E456" ,"D123" ,"A123" ,"L789" ,"F789","C789" ,"M123" ,"N456" ,"H456" ,"J123" };
    String[] choice2 = {"I789","N456" ,"I789" ,"F789", "K456" ,"H456" ,"M123","J123","E456" ,"I789" ,"E456","I789" ,"D123" ,"F789" ,"E456"};
    String[] choice3 = {"J123", "K456" ,"L789" ,"H456","N456","L789" ,"O789" ,"F789" ,"N456" ,"O789" ,"G123" ,"E456" ,"F789","J123" ,"C789" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //copy need to change the R.layout
        setContentView(R.layout.game1_main);
        textimageIV = (ImageView) findViewById(R.id.textimageIV);
        countLabel = (TextView) findViewById(R.id.countLabel);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        countDown = (TextView) findViewById(R.id.countDown);
        answerBtn1 = (Button) findViewById(R.id.answerBtn1);
        answerBtn2 = (Button) findViewById(R.id.answerBtn2);
        answerBtn3 = (Button) findViewById(R.id.answerBtn3);
        answerBtn4 = (Button) findViewById(R.id.answerBtn4);

        answerBtn1.setOnClickListener(this);
        answerBtn2.setOnClickListener(this);
        answerBtn3.setOnClickListener(this);
        answerBtn4.setOnClickListener(this);

        for (int i = 0; i < country.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(textimage[i]);
            tmpArray.add(country[i]);
            tmpArray.add(rightanswer[i]);
            tmpArray.add(choicel[i]);
            tmpArray.add(choice2[i]);
            tmpArray.add(choice3[i]);

            //add temparray to quizarray
            quizArray.add(tmpArray);
        }
        showQuestion();
        gameTimer = new Timer();
        gameTask = new TimerTask(){
            @Override
            public void run() {
                setTimer();
            }
        };
        gameTimer.schedule(gameTask, 0, 1000);
        countDown.setKeyListener(null);
    }

    public void showAnswer(int randomNum) {
        //pick one quiz set
        ArrayList<String> quiz = (ArrayList<String>) quizArray.get(randomNum);
        rightAnswer = quiz.get(2);

        quiz.remove(0);
        quiz.remove(0);
        Collections.shuffle(quiz);

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        countDown.setVisibility(View.INVISIBLE);
        answerBtn1.setVisibility(View.VISIBLE);
        answerBtn2.setVisibility(View.VISIBLE);
        answerBtn3.setVisibility(View.VISIBLE);
        answerBtn4.setVisibility(View.VISIBLE);
        quizArray.remove(randomNum);
    }

    public void showQuestion() {
        //able update the quizlabel
        countLabel.setText("Q" + quizCount);

        //generate ramdom number from 1-14 (quizarray size-1)
        Random random = new Random();
        final int randomNum = random.nextInt(quizArray.size());
        //pick one quiz set
        ArrayList<String> quiz = (ArrayList<String>) quizArray.get(randomNum);
        //set random image

        int test = getResources().getIdentifier(quiz.get(0) , "drawable", getPackageName());
        textimageIV.setImageResource(test);
        questionLabel.setText(quiz.get(1));
        textimageIV.setVisibility(View.VISIBLE);
        questionLabel.setVisibility(View.VISIBLE);
        answerBtn1.setVisibility(View.INVISIBLE);
        answerBtn2.setVisibility(View.INVISIBLE);
        answerBtn3.setVisibility(View.INVISIBLE);
        answerBtn4.setVisibility(View.INVISIBLE);
        countDown.setVisibility(View.VISIBLE);

        resetTimer();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textimageIV.setVisibility(View.INVISIBLE);
                questionLabel.setVisibility(View.INVISIBLE);
                showAnswer(randomNum);
            }
        }, (timer-1)*1000);
    }

    @Override
    public void onClick(View view) {
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            alertTitle = "Corrrect!";
            rightAnswerCount++;
        } else {
            alertTitle = "Wrong";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer:" + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                float result = (float) rightAnswerCount/quizCount;
                if (quizCount == QUIZ_COUNT) {
                    float finalScore = Math.round(result*10);
                    Intent intent = new Intent(getApplicationContext(), ResultPage.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", finalScore);
                    intent.putExtra("GameID", 1);
                    startActivity(intent);
                } else {
                    quizCount++;
                    showQuestion();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
        textimageIV.setVisibility(View.VISIBLE);
        questionLabel.setVisibility(View.VISIBLE);
    }

    public void setTimer(){
        if (timer > 0){
            timer -= 1;
            runOnUiThread (new Runnable() {
                @Override
                public void run() {
                    countDown.setText("Countdown: " + timer);
                }
            });
        }
    }

    public void resetTimer(){
        timer = 6;
    }
}



