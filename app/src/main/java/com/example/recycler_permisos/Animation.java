package com.example.recycler_permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.airbnb.lottie.LottieAnimationView;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        Intent main = new Intent(this, MainActivity.class);

        new CountDownTimer(5000, 1000) {
            public void onFinish() {
                startActivity(main);
            }

            public void onTick(long millisUntilFinished) {
                //Nothing to do here
            }
        }.start();

    }
}