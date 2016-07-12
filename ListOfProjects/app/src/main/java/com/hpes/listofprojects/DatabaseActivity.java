package com.hpes.listofprojects;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DatabaseActivity extends AppCompatActivity {

    TableLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        tl = (TableLayout)findViewById(R.id.tableDBAct1);
        SQLiteDatabase db = openOrCreateDatabase("DemoDB",MODE_APPEND,null);
        db.execSQL("Create table if not exists Student(name varchar, phone number)");
        SharedPreferences sp = getSharedPreferences("DemoDB",0);
        String msg = sp.getString("STATUS","Not Initialized");
        if(msg.equals("Not Initialized")){
            db.execSQL("Insert into Student(name,phone) values ('Shubham','7838162596')");
            db.execSQL("Insert into Student(name,phone) values ('Home','9999229714')");
            db.execSQL("Insert into Student(name,phone) values ('Office','9999999999')");
            db.execSQL("Insert into Student(name,phone) values ('Personal','8855885588')");
            db.execSQL("Insert into Student(name,phone) values ('Work','7755775575')");
            Toast.makeText(DatabaseActivity.this, "Table Created", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("STATUS","Initialized");
            edit.commit();
        }

        //Table Created
        //Print the Table
        TableRow tr;
        String q = "Select * from Student";
        Cursor c = db.rawQuery(q,null);
        String name;
        String phone;
        while (c.moveToNext()){
            name = c.getString(0);
            phone = c.getString(1);
            tr = new TableRow(this);
            TextView tv1 = new TextView(this);
            tv1.setText(name);
            TextView tv2 = new TextView(this);
            tv2.setText(phone);
            tr.addView(tv1);
            tr.addView(tv2);
            tl.addView(tr);
        }
        db.close();
        Toast.makeText(DatabaseActivity.this, "Table Created", Toast.LENGTH_SHORT).show();
    }
}
