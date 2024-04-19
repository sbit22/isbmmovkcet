package com.sbit.ISBMCOE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Exam extends AppCompatActivity {

    Button btnLogin,btnSignin;
    MediaPlayer music ;
    ImageView volumnup,volumndown;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Exam");

        btnLogin=findViewById(R.id.btnLogin);
        btnSignin=findViewById(R.id.btnSignin);

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

                final Dialog dialog = new Dialog(Exam.this);
                dialog.setContentView(R.layout.app_functionality);
                // if button is clicked, close the custom dialog

                music = MediaPlayer.create(Exam.this, R.raw.exam);
                if(i==0) {
                    music.start();
                    i=1;
                }
                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );

                volumnup.setVisibility(View.VISIBLE);
                volumndown.setVisibility(View.GONE);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==1) {
                    music.stop();
                    i = 0;
                }
                Intent intent=new Intent(getApplicationContext(),WebViewPage.class);
                intent.putExtra("res","login");
                startActivity(intent);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==1) {
                    music.stop();
                    i = 0;
                }
                Intent intent=new Intent(getApplicationContext(),WebViewPage.class);
                intent.putExtra("res","registration");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        music.stop();
        i=0;
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