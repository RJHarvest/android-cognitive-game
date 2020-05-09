package com.example.a.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Demo extends AppCompatActivity implements View.OnClickListener {
    private Button btnReturn;
    MediaController mController;
    int GameID;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.demo);
        VideoView simpleview = (VideoView)findViewById(R.id.DemoVideo);

        Intent intent = getIntent();
        GameID = intent.getIntExtra("GameID", 0);
        btnReturn = (Button)findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(this);

        mController = new MediaController(this);
        switch (GameID){
            case 1:
                simpleview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.demo1));
                break;
            case 2:
                simpleview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.demo2));
                break;
            case 3:
                simpleview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.demo3));
                break;
        }
        mController.setAnchorView(simpleview);
        simpleview.setMediaController(mController);
        simpleview.start();
        simpleview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    public void returnTop(View view) {
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        intent.putExtra("GameID",GameID);
        startActivity(intent);
    }
}
