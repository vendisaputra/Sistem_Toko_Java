package com.example.company.appstore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;

public class DashbordAct extends AppCompatActivity {

    TextView keuangan, absensi,namakepala,namatoko,tglKeuangan, jmlkaryawan;
    Button logout;
    LinearLayout linearlayout, linearlayout2;
    ImageView absen_belum,absen_sudah,laporan_belum,laporan_sudah;

    DatabaseReference reference;
    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        getUsernameLocal();

        namakepala = findViewById(R.id.namakepala);
        namatoko = findViewById(R.id.namatoko);
        tglKeuangan = findViewById(R.id.tglKeuangan);
        jmlkaryawan = findViewById(R.id.jmlkaryawan);
        keuangan = findViewById(R.id.keuangan);
        absensi = findViewById(R.id.absensi);
        linearlayout = findViewById(R.id.linearLayout);
        linearlayout2 = findViewById(R.id.linearLayout2);
        absen_belum = findViewById(R.id.absen_belum);
        absen_sudah = findViewById(R.id.absen_sudah);
        laporan_belum = findViewById(R.id.laporan_belum);
        laporan_sudah = findViewById(R.id.laporan_sudah);
        logout = findViewById(R.id.logout);

// notif



//set tgl
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String dateString = sdf.format(date);
        tglKeuangan.setText(dateString);

//database
        reference= FirebaseDatabase.getInstance().getReference().
                child("KepalaCabang").child(username_key_new);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                namakepala.setText(dataSnapshot.child("nama_lengkap").getValue().toString());
                namatoko.setText(dataSnapshot.child("nama_cabang").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //count jumlah karyawan
        reference = FirebaseDatabase.getInstance().getReference().
                child("Cabang").child(username_key_new).child("Karyawan");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer jml = (int) dataSnapshot.getChildrenCount();
                jmlkaryawan.setText("Jumlah Karyawan "+jml );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference = FirebaseDatabase.getInstance().getReference().
                child("Cabang").child(username_key_new).child("LaporanUang").child(dateString);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
//                    absen_sudah.animate().alpha(1).setDuration(300).start();
//                    absen_belum.animate().alpha(0).setDuration(300).start();
                    laporan_sudah.animate().alpha(1).setDuration(300).start();
                    laporan_belum.animate().alpha(0).setDuration(300).start();
                }else{
                    laporan_sudah.animate().alpha(0).setDuration(300).start();
                    laporan_belum.animate().alpha(1).setDuration(300).start();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





//Pindah activity
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
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(DashbordAct.this,LoginAct.class);
                startActivity(go);

            }
        });

    }

//fungsi mengambil username local sesuai login
    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new =sharedPreferences.getString(username_key, "");

    }
}
