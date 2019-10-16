package com.example.company.appstore;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class GajiAct extends AppCompatActivity {

    Button back, setting, print;
    LinearLayout inputgaji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji);

        back = findViewById(R.id.back);
        inputgaji = findViewById(R.id.inputgaji);
        setting = findViewById(R.id.setting);
        print= findViewById(R.id.print);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(GajiAct.this,OwnerDashbordAct.class);
                startActivity(go);

            }
        });

        inputgaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(GajiAct.this);
                dialog.setContentView(R.layout.dialogview_input_gaji);
                dialog.show();

            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(GajiAct.this);
                dialog.setContentView(R.layout.dialogview_setting_gaji);
                dialog.show();

            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(GajiAct.this);
                dialog.setContentView(R.layout.dialogview_pinjaman);
                dialog.show();

            }
        });


    }
}
