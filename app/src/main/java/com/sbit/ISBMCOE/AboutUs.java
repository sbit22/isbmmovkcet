package com.sbit.ISBMCOE;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.LineBreaker;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    TextView textview;
    MediaPlayer music ;
    ImageView volumnup,volumndown;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Us");
        textview=findViewById(R.id.aboutus);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textview.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

        volumnup=findViewById(R.id.volumeupc);
        volumndown=findViewById(R.id.volumedownc);

        volumnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (music!= null) {
                    music.stop();
                    music.release();
                    i=0;
                    music= null;
                }
                volumnup.setVisibility(View.GONE);
                volumndown.setVisibility(View.VISIBLE);
            }
        });

        volumndown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                music = MediaPlayer.create(AboutUs.this, R.raw.isbmabout);
                if(i==0){
                    music.start();
                    i=1;
                    volumnup.setVisibility(View.VISIBLE);
                    volumndown.setVisibility(View.GONE);
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed () {
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(i==1){
            music.stop();
            i=0;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(i==1){
            music.stop();
            i=0;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(i==1){
            music.stop();
            i=0;
        }
    }
}