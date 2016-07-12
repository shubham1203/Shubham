package com.hpes.shubham.myexpensemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewBalanceActivity extends AppCompatActivity {
    Spinner s1;
    TextView tv;
    ArrayList trips;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_balance);
        s1 = (Spinner)findViewById(R.id.spinTrip);
        tv = (TextView)findViewById(R.id.tvBalance);
        SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
        String q = "Select * from Trip_Details";
        Cursor c = db.rawQuery(q,null);
        trips = new ArrayList();
        while (c.moveToNext()){
            String name = c.getString(0);
            trips.add(name);
        }
        db.close();
        ArrayAdapter ar = new ArrayAdapter(this,android.R.layout.simple_spinner_item,trips);
        ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(ar);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
                String s = "Select bud_bal from Trip_Details WHERE trip_id = '" + s1.getSelectedItem().toString() + "'";
                Cursor c = db.rawQuery(s,null);
                c.moveToNext();
                String amt = String.valueOf(c.getInt(0));
                tv.setText(amt);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
