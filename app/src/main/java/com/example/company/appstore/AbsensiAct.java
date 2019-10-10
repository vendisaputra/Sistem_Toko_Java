package com.example.company.appstore;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AbsensiAct extends AppCompatActivity {
    Button btnplus2,btnsave2,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        btnplus2 = findViewById(R.id.btnplus2);
        btnsave2 = findViewById(R.id.btnsave2);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(AbsensiAct.this,DashbordAct.class);
                startActivity(go);

            }
        });

        btnplus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(AbsensiAct.this);
                dialog.setContentView(R.layout.dialogview_absensi);
                dialog.show();

//                btnsave2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });

            }
        });
    }
}
