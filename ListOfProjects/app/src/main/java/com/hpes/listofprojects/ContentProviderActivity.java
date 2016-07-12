package com.hpes.listofprojects;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContentProviderActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        tv = (TextView)findViewById(R.id.tvConPro);
        SQLiteDatabase db = openOrCreateDatabase("hp_db",MODE_APPEND,null);
        String q = "Create table if not exists EMP(EMP_NAME varchar, EMP_ID number)";
        db.execSQL(q);
        q = "Insert into EMP values('Bob','7838')";
        db.execSQL(q);
        q = "Insert into EMP values('Marley','7895')";
        db.execSQL(q);
        q = "Insert into EMP values('Hum','9818')";
        db.execSQL(q);
        q = "Insert into EMP values('Na Maare','9999')";
        db.execSQL(q);
        //SELECT OPERATION
        String q2 = "Select * from EMP";
        Cursor c = db.rawQuery(q2,null);
        String data = "EMP Name\n----------\n ";
        while(c.moveToNext()) {
            data = data + c.getString(0) + "\n";
        }
        tv.setText(data);
        //FOLLOWING CODE IS TO AVOID REDUNDANCY JUST FOR THIS PROJECT
        String q6 = "Drop table EMP";
        db.execSQL(q6);
    }
}
