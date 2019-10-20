package com.example.company.appstore;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AbsensiAct extends AppCompatActivity {
    Button btnsave2,back;

    DatabaseReference reference;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<AbsensiConst> absensiConsts;

    String USERNAME_KEY = "usernamekey";
    String username_key ="";
    String username_key_new ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        btnsave2 = findViewById(R.id.btnsave2);
        back = findViewById(R.id.back);

        rvView = (RecyclerView) findViewById(R.id.absensi_place);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        getUsernameLocal();
//database
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("Cabang").child(username_key_new).child("Karyawan")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                absensiConsts = new ArrayList<>();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    AbsensiConst aConst = dataSnapshot1.getValue(AbsensiConst.class);
                    aConst.setKey(dataSnapshot1.getKey());

                    absensiConsts.add(aConst);

                }
                adapter = new AbsensiAdapter(absensiConsts,AbsensiAct.this);
                rvView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//Pindah activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(AbsensiAct.this,DashbordAct.class);
                startActivity(go);

            }
        });


//
//        btnplus2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                final Dialog dialog = new Dialog(AbsensiAct.this);
//                dialog.setContentView(R.layout.dialogview_absensi);
//                dialog.show();
//
//                btnsave2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
//
//            }
//        });
    }

//mengambil data local
    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new =sharedPreferences.getString(username_key, "");

    }
}
