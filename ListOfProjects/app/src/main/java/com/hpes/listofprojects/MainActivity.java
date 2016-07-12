package com.hpes.listofprojects;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {

    String screens[] = {"LoginActivity", "ButtonActivity" , "LifecycleActivity", "MenuActivity", "SpinnerActivity", "RadioActivity",
                        "DealActivity", "CameraActivity", "ImageResourceActivity", "OptionsMenuActivity", "AlertDialogActivity",
                        "SharedPreferencesActivity", "SeekBarActivity", "CustomListActivity", "SDCardActivity",
                        "DatabaseActivity", "DynamicListActivity", "BluetoothActivity", "ProximitySensorActivity",
                        "BroadcastReceiverActivity", "MusicActivity", "ContentProviderActivity", "WiFiActivity",
                        "WallpaperActivity", "Exit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,screens);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(MainActivity.this, screens[position], Toast.LENGTH_SHORT).show();
        if(screens[position].equals("Exit")){
            finish();
        }
        else{
            String str = screens[position];
            str = "com.hpes.listofprojects." + screens[position];
            try{
                Class c = Class.forName(str);
                Intent intent = new Intent(MainActivity.this,c);
                startActivity(intent);
            }
            catch(Exception e){
                Toast.makeText(MainActivity.this,"Activity Not yet Defined", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
