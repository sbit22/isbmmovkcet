package com.sbit.ISBMCOE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {

    LinearLayout li1,li2;

    ImageView img;
    Animation animSlideup,animFadein;
    MediaPlayer music ;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        li2=findViewById(R.id.li2);

        animSlideup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);

        music = MediaPlayer.create(SplashScreen.this, R.raw.isbmsplashcren);

        if(i==0){
            music.start();
            i=1;
        }
        li2.startAnimation(animSlideup);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        music.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        music.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        music.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        music.start();
    }
}