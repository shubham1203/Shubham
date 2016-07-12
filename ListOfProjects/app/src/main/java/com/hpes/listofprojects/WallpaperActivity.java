package com.hpes.listofprojects;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        ImageView imageView = (ImageView)findViewById(R.id.imgWallp);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        Drawable d = imageView.getDrawable();
        BitmapDrawable bmd = (BitmapDrawable)d;
        Bitmap b = bmd.getBitmap();
        try{
            wallpaperManager.setBitmap(b);
        } catch (IOException e) {
            Toast.makeText(WallpaperActivity.this, "Cannot Set", Toast.LENGTH_SHORT).show();
        }
    }
}
