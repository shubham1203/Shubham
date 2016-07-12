package com.hpes.shubham.myexpensemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddExpenseActivity extends AppCompatActivity {
    EditText amount;
    EditText date;
    Spinner s1;
    Spinner s2;
    String [] Cat = {"Travel","Lodge","Meal","Office Expenses"};
    ArrayList trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        amount = (EditText)findViewById(R.id.etAmtSpent);
        date = (EditText)findViewById(R.id.etDate);
        s1 = (Spinner)findViewById(R.id.spinID);
        s2 = (Spinner)findViewById(R.id.spinCat);
        ArrayAdapter cat = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Cat);
        cat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(cat);
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
    public void submitExpense(View v){
//        try{
            String cat = s2.getSelectedItem().toString();
            int amt = Integer.parseInt(amount.getText().toString());
            String dt = date.getText().toString();
            String tripid = s1.getSelectedItem().toString();
            SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
            String q = "Insert into Expense_Details(category,amount_spent,date,trip_id) values('"+ cat +"','"+ amt +"','"+ dt +"','"+ tripid +"')";
            db.execSQL(q);

            String s = "Select amount_spent from Expense_Details WHERE trip_id = '" + tripid + "'";
            Cursor c = db.rawQuery(s,null);
            int amt_total = 0;
       // c.moveToNext();
       while(c.moveToNext()){
        //   Toast.makeText(this,String.valueOf(c.getColumnIndex("amount_spent")),Toast.LENGTH_SHORT).show();
            amt_total = amt_total + c.getInt(0);
            }
        Toast.makeText(this,String.valueOf(amt_total),Toast.LENGTH_SHORT).show();
            String e = "Select bud_approved from Trip_Details where trip_id = '" + tripid + "'";
            Cursor d = db.rawQuery(e,null);
        if(d.moveToNext()){
            int amt_bud = d.getInt(0);
            amt_bud = amt_bud - amt_total;
            Toast.makeText(AddExpenseActivity.this, String.valueOf(amt_bud), Toast.LENGTH_SHORT).show();
          db.execSQL("Update Trip_Details SET bud_bal = "+ amt_bud + " WHERE trip_id = '" + tripid + "'");
            Toast.makeText(AddExpenseActivity.this, amt_bud+ ":" +tripid +":" + amt_total , Toast.LENGTH_SHORT).show();
        }


       /*     Log.d("TEST","----------------1");
            String s = "Select exp_id from Expense_Details where trip_id = 'e125'";
            Cursor c = db.rawQuery(s,null);
            Log.d("TEST","----------------2");
            String t = c.getString(0);
            Log.d("TEST","----------------3");
            Toast.makeText(AddExpenseActivity.this, t, Toast.LENGTH_SHORT).show();
            Toast.makeText(AddExpenseActivity.this, "Expense Inserted", Toast.LENGTH_SHORT).show();
*/
        }

    }

