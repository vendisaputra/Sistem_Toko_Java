package com.example.company.appstore;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // merubah activity ke activity lain
                Intent gogetstarted = new Intent(Splash_Act.this,StartAct.class);
                startActivity(gogetstarted);
                finish();
            }
        }, 1000); // 1000 ms = 1s
    }
}
