package com.hpes.shubham.myexpensemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
        String q = "Create table if not exists Trip_Details(trip_id varchar, from_loc varchar, to_loc varchar, start_date date, end_date date, bud_approved number, bud_bal number, CONSTRAINT trip_pk PRIMARY KEY (trip_id))";
        db.execSQL(q);
        String s = "Create table if not exists Expense_Details(exp_id integer PRIMARY KEY AUTOINCREMENT,trip_id varchar,category varchar, " +
                "amount_spent integer, date date, CONSTRAINT fk_expense FOREIGN KEY(trip_id) REFERENCES Trip_Details(trip_id))";
        db.execSQL(s);
        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_LONG).show();
    }

    public void addTrip(View v){
        Intent i = new Intent(MainActivity.this,AddTripActivity.class);
        startActivity(i);
    }

    public void addExpense(View v){
        Intent i = new Intent(MainActivity.this,AddExpenseActivity.class);
        startActivity(i);
    }

    public void viewTrip(View v){
        Intent i = new Intent(MainActivity.this,DetailsActivity.class);
        startActivity(i);
    }

    public void balBudget(View v){

    }



}
