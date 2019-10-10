package com.example.company.appstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DashbordAct extends AppCompatActivity {

    TextView keuangan, absensi;
    LinearLayout linearlayout, linearlayout2;
    ImageView absen_belum,absen_sudah,laporan_belum,laporan_sudah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        keuangan = findViewById(R.id.keuangan);
        absensi = findViewById(R.id.absensi);
        linearlayout = findViewById(R.id.linearLayout);
        linearlayout2 = findViewById(R.id.linearLayout2);
        absen_belum = findViewById(R.id.absen_belum);
        absen_sudah = findViewById(R.id.absen_sudah);
        laporan_belum = findViewById(R.id.laporan_belum);
        laporan_sudah = findViewById(R.id.laporan_sudah);

        absen_sudah.animate().alpha(0).setDuration(300).start();
        laporan_sudah.animate().alpha(0).setDuration(300).start();

        absen_belum.animate().alpha(1).setDuration(300).start();
        laporan_belum.animate().alpha(1).setDuration(300).start();



        keuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(DashbordAct.this,LaporanUangAct.class);
                startActivity(go);

            }
        });
        absensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(DashbordAct.this,AbsensiAct.class);
                startActivity(go);

            }
        });
        linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(DashbordAct.this,AbsensiAct.class);
                startActivity(go);

            }
        });
        linearlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(DashbordAct.this,LaporanUangAct.class);
                startActivity(go);

            }
        });

    }
}
