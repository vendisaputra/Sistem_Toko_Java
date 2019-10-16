package com.example.company.appstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class OwnerDashbordAct extends AppCompatActivity {

    LinearLayout gajik1,laporank1,datak1;
    Button logout, edit_toko;
    ImageView edit_owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dashbord);

        gajik1 = findViewById(R.id.gajik1);
        laporank1 = findViewById(R.id.laporank1);
        datak1 = findViewById(R.id.datak1);
        logout = findViewById(R.id.logout);
        edit_toko = findViewById(R.id.edit_toko);
        edit_owner = findViewById(R.id.edit_owner);


        gajik1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(OwnerDashbordAct.this,GajiAct.class);
                startActivity(go);

            }
        });

        laporank1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(OwnerDashbordAct.this,LaporanOwnerAct.class);
                startActivity(go);

            }
        });
        datak1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(OwnerDashbordAct.this,DataKaryawanAct.class);
                startActivity(go);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(OwnerDashbordAct.this,Login2Act.class);
                startActivity(go);

            }
        });

        edit_toko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(OwnerDashbordAct.this,EditTokoAct.class);
                startActivity(go);

            }
        });

        edit_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(OwnerDashbordAct.this,EditOwnerAct.class);
                startActivity(go);

            }
        });
    }
}
