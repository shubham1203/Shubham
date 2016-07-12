package com.hpes.listofprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUser;
    EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser = (EditText)findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);

    }
    public void show(View v){
        String s1 = etUser.getText().toString();
        String s2 = etPass.getText().toString();
        if(s1.isEmpty()){
            Toast.makeText(LoginActivity.this,"Enter Username",Toast.LENGTH_SHORT).show();
        }
        else if(s2.isEmpty()){
            Toast.makeText(LoginActivity.this,"Enter Password",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(LoginActivity.this,LoginResultActivity.class);
            intent.putExtra("user",s1);
            intent.putExtra("pass",s2);
            startActivity(intent);
        }

    }
}
