package com.example.company.appstore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.company.appstore.sqllite.SqlLiteHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginAct extends AppCompatActivity {

    EditText xusername, xpass;
    Button btn_login, btn_owner;
    boolean doubleBackToExitPressedOnce = false;

    DatabaseReference reference;

    SqlLiteHelper sqlLiteHelper;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sqlLiteHelper = new SqlLiteHelper(this);

        btn_login = findViewById(R.id.btn_login);
        btn_owner = findViewById(R.id.btn_owner);
        xusername = findViewById(R.id.xusername);
        xpass = findViewById(R.id.xpass);


// Login

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation() == true) {
                    //loading
                    btn_login.setEnabled(false);
                    btn_login.setText("Loading...");

                    //database
                    String username = xusername.getText().toString();
                    final String password = xpass.getText().toString();

                    reference = FirebaseDatabase.getInstance().getReference().
                            child("KepalaCabang").child(username);

                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {

                                // ambil data password dari firbase
                                String passwordFromFirebase = dataSnapshot.child("password").getValue().toString();

                                //Validasi password dengan firebase
                                if (password.equals(passwordFromFirebase)) {


                                    //Simpan username key pada local
                                    SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString(username_key, xusername.getText().toString());
                                    editor.apply();

                                    //pindah activity
                                    Intent gotoprofil = new Intent(LoginAct.this, DashbordAct.class);
                                    startActivity(gotoprofil);


                                } else {
                                    Toast.makeText(getApplicationContext(), "Password salah!", Toast.LENGTH_SHORT).show();
                                    btn_login.setEnabled(true);
                                    btn_login.setText("Login");
                                }

                            } else {
                                Toast.makeText(getApplicationContext(), "Username tidak ada!", Toast.LENGTH_SHORT).show();
                                btn_login.setEnabled(true);
                                btn_login.setText("Login");
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
        });




//Pindah activity
        btn_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(LoginAct.this,Login2Act.class);
                startActivity(go);

            }
        });
    }

// Exit
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finishAffinity();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Klik lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    public boolean validation(){
        boolean valid = true;
        xusername = findViewById(R.id.xusername);
        xpass = findViewById(R.id.xpass);
        String username = xusername.getText().toString();
        final String password = xpass.getText().toString();
        if (username.isEmpty() || username.length() < 3) {
            xusername.setError("at least 3 characters");
            xusername.requestFocus();
            valid = false;
        }else if (password.isEmpty()){
            xpass.setError("Please Insert Password!");
            xpass.requestFocus();
            valid = false;
        }else {
            xusername.setError(null);
            xpass.setError(null);
        }

        return valid;
    }

}
