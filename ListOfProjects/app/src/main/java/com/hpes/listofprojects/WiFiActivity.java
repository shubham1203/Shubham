package com.hpes.listofprojects;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class WiFiActivity extends AppCompatActivity {

    WifiManager wifiManager;
    Switch s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        s1 = (Switch)findViewById(R.id.switch2);
        wifiManager = (WifiManager)getSystemService(WIFI_SERVICE);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(s1.isChecked()){
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(WiFiActivity.this, "WiFi On", Toast.LENGTH_SHORT).show();
                    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                    if(wifiInfo.getBSSID()!=null){
                        String name = wifiInfo.getSSID();
                        int signalFrequency = wifiInfo.getRssi();
                        int i = wifiManager.calculateSignalLevel(signalFrequency,10);
                        Toast.makeText(WiFiActivity.this, "Name: "+name, Toast.LENGTH_SHORT).show();
                        Toast.makeText(WiFiActivity.this, "Strength(10): "+i, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(WiFiActivity.this, "WiFi is Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
