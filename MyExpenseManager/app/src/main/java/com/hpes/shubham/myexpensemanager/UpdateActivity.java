package com.hpes.shubham.myexpensemanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {
    Spinner s1;
    ArrayList trips;
    ListView lv;
    ArrayList al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        s1 = (Spinner)findViewById(R.id.spinTrip);
        lv = (ListView)findViewById(R.id.listView2);
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
                al= new ArrayList();
                SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
                String q = "Select * from Expense_Details";
                Cursor c = db.rawQuery(q,null);
                while(c.moveToNext()){
                    String name;
                    for(int k = 2; k <= 4; k++){
                        name = c.getColumnName(k);
                        al.add(name);
                    }


                }
                db.close();
                ArrayAdapter ar = new ArrayAdapter(UpdateActivity.this,android.R.layout.simple_list_item_1,al);
                lv.setAdapter(ar);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(UpdateActivity.this,UpdateValuesActivity.class);
                        String item = String.valueOf(adapterView.getItemAtPosition(i));
                        intent.putExtra("item_name",item);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
