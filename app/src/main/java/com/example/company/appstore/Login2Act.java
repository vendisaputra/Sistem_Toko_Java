package com.example.company.appstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login2Act extends AppCompatActivity {

    Button btn_kcabang,btn_login;
    private EditText xusername, xpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btn_kcabang = findViewById(R.id.btn_kcabang);
        btn_login = findViewById(R.id.btn_login);

        btn_kcabang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Login2Act.this,LoginAct.class);
                startActivity(go);

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation() == true) {
                    Intent go = new Intent(Login2Act.this, OwnerDashbordAct.class);
                    startActivity(go);
                }
            }
        });
    }
    public boolean validation(){
        boolean valid = true;
        xusername = findViewById(R.id.username);
        xpass = findViewById(R.id.pass);
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
