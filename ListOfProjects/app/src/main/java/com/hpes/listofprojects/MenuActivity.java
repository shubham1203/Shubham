package com.hpes.listofprojects;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

    String tasks[] = {"PHONE CALL", "SMS", "PHONE BOOK", "WEB SEARCH", "WEB", "MAPS", "EXIT"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_menu);
        ArrayAdapter adapt = new ArrayAdapter(MenuActivity.this,android.R.layout.simple_list_item_1,tasks);
        setListAdapter(adapt);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(tasks[position].equals("EXIT")){
            finish();
        }
        else if(tasks[position].equals("PHONE CALL")){
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7838162596"));
            startActivity(i);
        }
        else if(tasks[position].equals("SMS")){
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("tel:7838162596"));
            i.putExtra("sms_body","This is the text body");
            startActivity(i);
        }
        else if(tasks[position].equals("PHONE BOOK")){
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
            startActivity(i);
        }
        else if(tasks[position].equals("WEB")){
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(i);
        }
        else if(tasks[position].equals("WEB SEARCH")){
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH, Uri.parse("http://www.google.com"));
            i.putExtra(SearchManager.QUERY,"Railways");
            startActivity(i);
        }
        else if(tasks[position].equals("MAPS")){
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:Paytm Noida"));
            startActivity(i);
        }
    }
}
