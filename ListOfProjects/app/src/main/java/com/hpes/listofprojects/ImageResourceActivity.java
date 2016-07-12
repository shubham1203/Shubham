package com.hpes.listofprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageResourceActivity extends AppCompatActivity {

    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_resource);
        iv = (ImageView)findViewById(R.id.imgResc);

    }

    public void imgResc(View v){
        iv.setImageResource(R.drawable.bathman);
    }

}
