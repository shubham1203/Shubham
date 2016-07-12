package com.hpes.listofprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity {

    RadioGroup rg;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        tv = (TextView)findViewById(R.id.textViewRadio);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedPosition) {
                String str = "You Have Selected ";
                switch(checkedPosition){
                    case R.id.radioButton: str = str + "Button 1";
                        break;
                    case R.id.radioButton2: str = str + "Button 2";
                        break;
                    case R.id.radioButton3: str = str + "Button 3";
                        break;
                    case R.id.radioButton4: str = str + "Button 4";
                        break;
                }
                tv.setText(str);
            }
        });
    }
    public void clear(View v){
        rg.clearCheck();
        tv.setText("Nothing Selected");
    }
}
