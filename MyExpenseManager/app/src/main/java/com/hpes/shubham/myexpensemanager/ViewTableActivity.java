package com.hpes.shubham.myexpensemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.Toast;

public class ViewTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_table);
        TableRow tr;
        SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
        Intent intent = getIntent();
        String s = intent.getStringExtra("option");
        //String u = intent.getStringExtra("spinner");
        Toast.makeText(ViewTableActivity.this, s, Toast.LENGTH_SHORT).show();
        //Toast.makeText(ViewTableActivity.this, u, Toast.LENGTH_SHORT).show();
    }
}
