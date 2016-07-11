package com.hpes.shubham.myexpensemanager;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTripActivity extends AppCompatActivity {
    EditText etTrip;
    EditText etSource;
    EditText etDest;
    EditText etStartDate;
    EditText etEndDate;
    EditText etBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);
        etTrip = (EditText)findViewById(R.id.etTripId);
        etSource = (EditText)findViewById(R.id.etFromLoc);
        etDest = (EditText)findViewById(R.id.etToLoc);
        etStartDate = (EditText)findViewById(R.id.etStartDate);
        etEndDate = (EditText)findViewById(R.id.etEndDate);
        etBudget = (EditText)findViewById(R.id.etBudApp);
    }

    public void submitTrip(View v){
        try{
            String trip = etTrip.getText().toString();
            String source = etSource.getText().toString();
            String dest = etDest.getText().toString();
            int budget = Integer.parseInt(etBudget.getText().toString());
            String dstart = etStartDate.getText().toString();
            String dend = etEndDate.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("db_expense",MODE_APPEND,null);
            String q = "Insert into Trip_Details values('" + trip + "','" + source + "','" + dest + "','" + dstart + "','" + dend +"','" + budget + "','" + budget + "')";
            db.execSQL(q);
            Toast.makeText(AddTripActivity.this, "Inserted Values", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(AddTripActivity.this, "Values not Inserted", Toast.LENGTH_SHORT).show();
        }

    }
}
