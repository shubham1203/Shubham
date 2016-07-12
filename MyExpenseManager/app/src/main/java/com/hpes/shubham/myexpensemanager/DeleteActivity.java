package com.hpes.shubham.myexpensemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {
    Spinner s1;
    ArrayList trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        s1 = (Spinner)findViewById(R.id.spinTrip);
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
    }
    public void dropRecord(View v){
        SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
        String q = "DELETE FROM Trip_Details WHERE trip_id = '" + s1.getSelectedItem().toString() + "'";
        db.execSQL(q);
        String s = "DELETE FROM Expense_Details WHERE trip_id = '" + s1.getSelectedItem().toString() + "'";
        db.execSQL(s);
        Toast.makeText(DeleteActivity.this, "Trip Deleted", Toast.LENGTH_SHORT).show();
    }
}
