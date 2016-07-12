package com.hpes.listofprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
    Spinner s;
    String planets[]={"Mercury","Venus","Earth","Mars"};

    void showToast(String msg){
        Toast.makeText(SpinnerActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        s = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(SpinnerActivity.this,android.R.layout.simple_spinner_item,planets);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(planets[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                showToast("Nothing Selected");

            }
        });
    }


}
