package com.example.company.appstore;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.company.appstore.sqllite.SqlLiteHelper;

public class StartAct extends AppCompatActivity {

    SqlLiteHelper sqlLiteHelper;
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        sqlLiteHelper = new SqlLiteHelper(this);

        btn_start = findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = sqlLiteHelper.getSplash();
                sqlLiteHelper.updateSplash();
                Intent gotosign = new Intent(StartAct.this,LoginAct.class);
                startActivity(gotosign);
            }
        });


    }
}
