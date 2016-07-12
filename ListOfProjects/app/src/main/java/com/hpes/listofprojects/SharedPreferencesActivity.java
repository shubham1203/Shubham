package com.hpes.listofprojects;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferencesActivity extends AppCompatActivity {
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        et1 = (EditText)findViewById(R.id.etSharedPref);
        SharedPreferences sp = getSharedPreferences("DemoFile",MODE_PRIVATE);
        String msg = sp.getString("STATUS",null);
        et1.setText(msg);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sp = getSharedPreferences("DemoFile",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("STATUS",et1.getText().toString());
        editor.commit();
    }
}
