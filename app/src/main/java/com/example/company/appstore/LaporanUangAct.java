package com.example.company.appstore;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaporanUangAct extends AppCompatActivity {

    Button btnplus,btnsave,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_uang);

        btnplus = findViewById(R.id.btnplus);
        btnsave = findViewById(R.id.btnsave);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(LaporanUangAct.this,DashbordAct.class);
                startActivity(go);

            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(LaporanUangAct.this);
                dialog.setContentView(R.layout.dialogview_keuangan);
                dialog.show();

//                btnsave.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });

            }
        });
    }
}
