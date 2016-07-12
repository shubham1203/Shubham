package com.hpes.listofprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ButtonActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
        tv = (TextView)findViewById(R.id.textView);

    }

    public void show(View v){
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        int result = num1+num2;
        tv.setText(String.valueOf(result)); //text view displays only string values
    }
}
