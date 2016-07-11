package com.hpes.shubham.myexpensemanager;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv = (ImageView)findViewById(R.id.imageView);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent i = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });
        t.start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
