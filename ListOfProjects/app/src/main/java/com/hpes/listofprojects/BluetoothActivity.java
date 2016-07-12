package com.hpes.listofprojects;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {
    Switch s1;
    BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice>bluetoothDeviceSet;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        lv = (ListView)findViewById(R.id.listView);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        s1 = (Switch)findViewById(R.id.switch1);
        s1.setChecked(false);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(s1.isChecked()){
                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i,0);
                    Toast.makeText(BluetoothActivity.this, "Bluetooth On", Toast.LENGTH_SHORT).show();

                }
                else {
                    bluetoothAdapter.disable();
                    Toast.makeText(BluetoothActivity.this, "Bluetooth Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void discover(View v){
        Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(i,0);
    }
    public void listPaired(View v){
        Toast.makeText(BluetoothActivity.this, "Discovery Started", Toast.LENGTH_SHORT).show();
        bluetoothAdapter.startDiscovery();
        Toast.makeText(BluetoothActivity.this, "Discovery Complete", Toast.LENGTH_SHORT).show();
        bluetoothDeviceSet = bluetoothAdapter.getBondedDevices();
        ArrayList al = new ArrayList();
        for(BluetoothDevice bdevice : bluetoothDeviceSet){
            String device = bdevice.getName();
            al.add(device);
        }
        ArrayAdapter ar = new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(ar);
    }

}
