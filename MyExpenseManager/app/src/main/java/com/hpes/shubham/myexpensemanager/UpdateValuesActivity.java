package com.hpes.shubham.myexpensemanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateValuesActivity extends AppCompatActivity {
    EditText etNew;
    EditText etOld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_values);
        etNew = (EditText)findViewById(R.id.etNewVal);
        etOld = (EditText)findViewById(R.id.etOldVal);


    }

    public void updateVal(View v){
        String s = etNew.getText().toString();
        String t = etOld.getText().toString();
        Intent intent = getIntent();
        String item = intent.getStringExtra("item_name");
        SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
        String r = "Select exp_id from Expense_Details WHERE " + item + " = '" + t + "'";
        Cursor c = db.rawQuery(r,null);
        c.moveToNext();
        int exp_id = c.getInt(0);
        if(item.equals("amount_spent")){
            String q = "UPDATE Expense_Details SET "+ item +" = '"+ Integer.parseInt(s) +"' WHERE exp_id = '"+ exp_id +"'";
            db.execSQL(q);
        }
        else{
            String q = "UPDATE Expense_Details SET "+ item +" = '"+ s +"' WHERE exp_id = '"+ exp_id +"'";
            db.execSQL(q);
        }
        Toast.makeText(UpdateValuesActivity.this, "Table Updated", Toast.LENGTH_SHORT).show();


    }
}
