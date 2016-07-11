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
    EditText category;
    EditText amount;
    EditText date;
    Spinner s1;
    ArrayList trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        category = (EditText)findViewById(R.id.etCategory);
        amount = (EditText)findViewById(R.id.etAmtSpent);
        date = (EditText)findViewById(R.id.etDate);
        s1 = (Spinner)findViewById(R.id.spinner);
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
        try{
            String cat = category.getText().toString();
            int amt = Integer.parseInt(amount.getText().toString());
            String dt = date.getText().toString();
            String tripid = s1.getSelectedItem().toString();
            SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
            String q = "Insert into Expense_Details(category,amount_spent,date,trip_id) values('"+ cat +"','"+ amt +"','"+ dt +"','"+ tripid +"')";
            db.execSQL(q);
            String s = "Select amount_spent from Expense_details where trip_id = '" + tripid + "'";
            Cursor c = db.rawQuery(s,null);
            int amt_total = 0;
            while(c.moveToNext()){
                amt_total = amt_total + Integer.parseInt(c.getString(0));
            }
            String e = "Select bud_approved from Trip_Details where trip_id = " + tripid + "'";
            c = db.rawQuery(e,null);
            int amt_bud = Integer.parseInt(c.getString(0));
            amt_bud = amt_bud - amt_total;
            db.execSQL("Update Trip_Details SET bud_bal = "+ amt_bud + "WHERE trip_id = "+ tripid +"'");
//            Log.d("TEST","----------------1");
//            String s = "Select exp_id from Expense_Details where trip_id = 'e125'";
//            Cursor c = db.rawQuery(s,null);
//            Log.d("TEST","----------------2");
//            String t = c.getString(0);
//            Log.d("TEST","----------------3");
//            Toast.makeText(AddExpenseActivity.this, t, Toast.LENGTH_SHORT).show();
            Toast.makeText(AddExpenseActivity.this, "Expense Inserted", Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){
            Toast.makeText(AddExpenseActivity.this, "Could Not Insert", Toast.LENGTH_SHORT).show();
        }
    }
}
