package com.neuron.shubham.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Shubham on 26-03-2016.
 */
public class LoginActivity extends AppCompatActivity
{
    EditText etUsername;
    EditText etPassword;
    Button btnLogin;
    String username;
    String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(
                    new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        username = etUsername.getText().toString();
                        password = etPassword.getText().toString();
                        Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                        intent.putExtra("user1",username);
                        intent.putExtra("pass1",password);
                        startActivity(intent);

                    }
                }
        );
    }
}
