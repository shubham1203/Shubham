package com.hpes.listofprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DealActivity extends AppCompatActivity {
    EditText etQuant;
    EditText etPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        etQuant = (EditText)findViewById(R.id.etDeal1);
        etPrice = (EditText)findViewById(R.id.etDeal2);

    }

    public void getDeal(View v){
        Intent i = new Intent(DealActivity.this, DealConfirmActivity.class);
        i.putExtra("Q",etQuant.getText().toString());
        i.putExtra("P",etPrice.getText().toString());
        startActivityForResult(i,9999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String s = data.getStringExtra("msg");
        Toast.makeText(DealActivity.this,s,Toast.LENGTH_SHORT).show();
    }
}
