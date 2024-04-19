package com.sbit.ISBMCOE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    RecyclerView orien,blooddonation,forza,engineerday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gallery");

        orien = findViewById(R.id.orien);
        blooddonation = findViewById(R.id.blooddonation);
        forza = findViewById(R.id.forza);
        engineerday = findViewById(R.id.engineerday);

        ArrayList<Imagemodel> listphotos = new ArrayList<>();
        ArrayList<Imagemodel> blooddonationlist = new ArrayList<>();
        ArrayList<Imagemodel> engeeringday = new ArrayList<>();
        ArrayList<Imagemodel> firoza = new ArrayList<>();

        try {
//            listphotos.add(new Imagemodel(R.drawable.a));
            listphotos.add(new Imagemodel(R.drawable.b));
//            listphotos.add(new Imagemodel(R.drawable.c));
            listphotos.add(new Imagemodel(R.drawable.d));
            listphotos.add(new Imagemodel(R.drawable.g));
            listphotos.add(new Imagemodel(R.drawable.e));
            listphotos.add(new Imagemodel(R.drawable.aa));
            listphotos.add(new Imagemodel(R.drawable.ab));
            listphotos.add(new Imagemodel(R.drawable.h));

            blooddonationlist.add(new Imagemodel(R.drawable.m));
            blooddonationlist.add(new Imagemodel(R.drawable.j));
            blooddonationlist.add(new Imagemodel(R.drawable.n));

//            engeeringday.add(new Imagemodel(R.drawable.ea));
            engeeringday.add(new Imagemodel(R.drawable.eb));
            engeeringday.add(new Imagemodel(R.drawable.ec));

            firoza.add(new Imagemodel(R.drawable.fb));
            firoza.add(new Imagemodel(R.drawable.fc));
            firoza.add(new Imagemodel(R.drawable.fd));

//            listphotos.add(new Imagemodel(R.drawable.poster1));
//            listphotos.add(new Imagemodel(R.drawable.poster2));
//            listphotos.add(new Imagemodel(R.drawable.poster3));

        }catch (Exception e){
            e.printStackTrace();
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GalleryAdapter adapter = new GalleryAdapter(listphotos, this);
        orien.setAdapter(adapter);
        orien.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        GalleryAdapter adapter1 = new GalleryAdapter(blooddonationlist, this);
        blooddonation.setAdapter(adapter1);
        blooddonation.setLayoutManager(layoutManager1);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        GalleryAdapter adapter2 = new GalleryAdapter(firoza, this);
        forza.setAdapter(adapter2);
        forza.setLayoutManager(layoutManager2);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
        GalleryAdapter adapter3 = new GalleryAdapter(engeeringday, this);
        engineerday.setAdapter(adapter3);
        engineerday.setLayoutManager(layoutManager3);
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
}