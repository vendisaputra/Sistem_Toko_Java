package com.example.company.appstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login2Act extends AppCompatActivity {

    Button btn_kcabang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btn_kcabang = findViewById(R.id.btn_kcabang);

        btn_kcabang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Login2Act.this,LoginAct.class);
                startActivity(go);

            }
        });
    }
}
