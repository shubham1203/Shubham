package com.hpes.listofprojects;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DynamicListActivity extends ListActivity {

    ArrayList names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dynamic_list);
        SQLiteDatabase db = openOrCreateDatabase("DemoDB",MODE_APPEND,null);
        String q = "Select * from Student";
        Cursor c = db.rawQuery(q,null);
        names = new ArrayList();
        while (c.moveToNext()){
            String name = c.getString(0);
            names.add(name);
        }
        db.close();
        ArrayAdapter ar = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        setListAdapter(ar);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(DynamicListActivity.this, names.get(position).toString() , Toast.LENGTH_SHORT).show();
        SQLiteDatabase db = openOrCreateDatabase("DemoDB",MODE_APPEND,null);
        String q = "Select * from Student where name ='"+ names.get(position) + "'";
        String phone = null;
        Cursor c = db.rawQuery(q,null);
        while (c.moveToNext()){
            phone = c.getString(1);
        }
        Toast.makeText(DynamicListActivity.this, phone, Toast.LENGTH_SHORT).show();

    }
}
