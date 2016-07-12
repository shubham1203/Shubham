package com.hpes.listofprojects;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListActivity extends ListActivity {

    String names[] = {"Item 1","Item 2","Item 3","Item 4","Item 5"};
    String subnames[] = {"SubText 1","SubText 2","SubText 3","SubText 4","SubText 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_custom_list);
        ArrayAdapter adapter = null;
        adapter = new MyAdapter(CustomListActivity.this,android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter{
        public MyAdapter(Context context, int resource, Object[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //return super.getView(position, convertView, parent);
            LayoutInflater li = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = li.inflate(R.layout.activity_custom_list,parent,false);
            ImageView iv = (ImageView)row.findViewById(R.id.imgCustList);
            TextView tv1 = (TextView)row.findViewById(R.id.tvCustListMain);
            TextView tv2 = (TextView)row.findViewById(R.id.tvCustListSub);
            tv1.setText(names[position]);
            tv2.setText(subnames[position]);
            return row;
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(CustomListActivity.this, names[position], Toast.LENGTH_SHORT).show();

    }
}
