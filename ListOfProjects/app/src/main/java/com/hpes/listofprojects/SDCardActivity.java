package com.hpes.listofprojects;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SDCardActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    EditText et1;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        et1 = (EditText)findViewById(R.id.etConName);
        et2 = (EditText)findViewById(R.id.etConNum);
        b1 = (Button)findViewById(R.id.btnSaveSD);
        b2 = (Button)findViewById(R.id.btnReadSD);
        b1.setOnClickListener(new WriteSDCard());
        b2.setOnClickListener(new ReadSDCard());
    }
    class WriteSDCard implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            File rootpath = Environment.getExternalStorageDirectory();
            File file = new File(rootpath,"ContactSD");
            if(!file.exists()){
                try{
                    file.createNewFile();
                    Toast.makeText(SDCardActivity.this,"File Created",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(SDCardActivity.this,"Cannot Create File",Toast.LENGTH_SHORT).show();
                }
            }
            try{
                String details = et1.getText().toString() + " : " + et2.getText().toString() + "\n";
                FileOutputStream fos = new FileOutputStream(file,true);
                fos.write(details.getBytes());
                Toast.makeText(SDCardActivity.this,"Data Saved",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    class ReadSDCard implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            File rootpath = Environment.getExternalStorageDirectory();
            File file = new File(rootpath,"ContactSD");
            if(file.exists()==true){
                try{
                    FileInputStream fis = new FileInputStream(file);
                    String fd = "";
                    while(true){
                        int a = fis.read();
                        if(a==-1){
                            break;
                        }
                        fd = fd + (char)a;
                    }
                    Toast.makeText(SDCardActivity.this,fd,Toast.LENGTH_SHORT).show();
                }
                catch (Exception e ){
                    e.printStackTrace();
                }
            }
            else {
                Toast.makeText(SDCardActivity.this,"No Data",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
