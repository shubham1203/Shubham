package com.neuron.shubham.login;

import android.os.Bundle;
import android.widget.TextView;
public class UserActivity extends LoginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        TextView user = (TextView)findViewById(R.id.txtUsername);
        TextView pass = (TextView)findViewById(R.id.txtPassword);
        String usern = getIntent().getStringExtra("user1");
        String passw = getIntent().getStringExtra("pass1");
        user.setText(usern);
        pass.setText(passw);

    }

}
