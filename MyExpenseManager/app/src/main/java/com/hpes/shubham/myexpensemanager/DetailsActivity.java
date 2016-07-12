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
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    Spinner s1;
    ArrayList al;
    ListView lv;
    String[] options = {"category","trip_id","date","amount_spent"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        lv = (ListView)findViewById(R.id.listView);
        s1 = (Spinner)findViewById(R.id.spinnerDetailsCat);
        ArrayAdapter ar = new ArrayAdapter(DetailsActivity.this,android.R.layout.simple_spinner_item,options);
        ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(ar);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, final int i1, long l) {
                al= new ArrayList();
                SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
                String q = "Select * from Expense_Details  GROUP BY " + options[i1] + "";
                Cursor c = db.rawQuery(q,null);
                int j = c.getColumnIndex(options[i1]);
                while(c.moveToNext()){
                    String name = c.getString(j);
                    al.add(name);
                }
                db.close();
                ArrayAdapter a = new ArrayAdapter(DetailsActivity.this,android.R.layout.simple_list_item_1,al);
                lv.setAdapter(a);


                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String r = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(DetailsActivity.this, r, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DetailsActivity.this,ViewTableActivity.class);
                        String t = String.valueOf(adapterView.getItemAtPosition(i1));
                        Toast.makeText(DetailsActivity.this, t, Toast.LENGTH_SHORT).show();
                        intent.putExtra("spinner",t);
                        intent.putExtra("options",r);
                        startActivity(intent);
                    }

                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(DetailsActivity.this, "Select an Option", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
