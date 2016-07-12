package com.hpes.listofprojects;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiverActivity extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String str = intent.getAction();
        if(str.equals("android.intent.action.ACTION_POWER_CONNECTED")){
            Toast.makeText(context,"Start Charging",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Discharging", Toast.LENGTH_SHORT).show();
        }
      //  throw new UnsupportedOperationException("Not yet implemented");
    }
}
