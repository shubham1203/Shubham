package com.hpes.listofprojects;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlertOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_options);
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Alert with Options");
        final String colors[] = {"RED", "BLUE", "GREEN", "YELLOW"};
        build.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertOptionsActivity.this,colors[i],Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dial = build.create();
        dial.show();
    }
}
