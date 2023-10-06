package com.example.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;


public class splashScreen extends AppCompatActivity {
   LottieAnimationView animationView ,animationView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        animationView = findViewById( R.id.animationView);
        animationView1 = findViewById( R.id.animationView1);



        animationView.animate().scaleX(5);
        animationView1.animate().translationX(1000).setStartDelay(2000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);

            }
        } ,3000);
    }
}