package com.hpes.listofprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DealConfirmActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    String s = "Store the result here";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_confirm);
        tv1 = (TextView)findViewById(R.id.tvDealConfQuant);
        tv2 = (TextView)findViewById(R.id.tvDealConfPrice);
        Intent i = getIntent();
        String q = i.getStringExtra("Q");
        String p = i.getStringExtra("P");
        tv1.setText("Quantity: " + q);
        tv2.setText("Price: " + p);

    }

    public void dealStatus(View v){
        int bid = v.getId();
        switch(bid){
            case R.id.buttConf: s = "Deal Confirmed";
                break;
            case R.id.buttReject: s = "Deal Rejected";
                break;
        }
        Intent in = new Intent();
        in.putExtra("msg",s);
        setResult(999,in);
        finish();
    }

}
