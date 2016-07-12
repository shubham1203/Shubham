package com.hpes.listofprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LoginResultActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);
        text = (TextView)findViewById(R.id.text);
        Intent intent = getIntent();
        String u = intent.getStringExtra("user");
        String p = intent.getStringExtra("pass");
        text.setText("Username is " + u);
        text.append("\n\nPassword is " + p);
        if(u.contentEquals(p)){
            text.append("\n\nSuccessful Authentication");
        }
        else{
            text.append("\n\nAuthentication Failed");
        }
    }

}

