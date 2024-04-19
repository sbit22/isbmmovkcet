package com.sbit.ISBMCOE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    CardView aboutus,contactus,gallery,exam,video,course,placement,brochure;
    LinearLayout link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aboutus=findViewById(R.id.about);
        contactus=findViewById(R.id.contactus);
        gallery=findViewById(R.id.gallery);
        exam=findViewById(R.id.exam);
        link=findViewById(R.id.link);
        course=findViewById(R.id.course);
        placement=findViewById(R.id.placement);
        brochure=findViewById(R.id.brochure);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),WebViewlink.class);
                intent.putExtra("res","link");
                startActivity(intent);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
            }
        });

        placement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Placement.class);
                startActivity(intent);
            }
        });

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Courses.class);
                startActivity(intent);
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactUs.class);
                startActivity(intent);
            }
        });

        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exam.class);
                startActivity(intent);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Gallery.class);
                startActivity(intent);
            }
        });

        brochure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BrochurePDF.class);
                startActivity(intent);
            }
        });
    }
}