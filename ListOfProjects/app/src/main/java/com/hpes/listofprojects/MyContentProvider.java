package com.hpes.listofprojects;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

public class MyContentProvider extends ContentProvider{
    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Context c = getContext();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("hp_db",null);
        int i = db.delete("EMP",selection,null);
        return i;
        // Implement this to handle requests to delete one or more rows.
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Context c = getContext();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("hp_db",null);
        db.insert("EMP",null,values);
        return uri;
        // TODO: Implement this to handle requests to insert a new row.
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Context c = getContext();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("hp_db",null);
        // TODO: Implement this to handle query requests from clients.
        String q = "Select * from EMP";
        Cursor cur = db.rawQuery(q,null);
        return (cur);
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Context c = getContext();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("hp_db",null);
        int status = db.update("EMP",values,selection,null);
        return status;
        // TODO: Implement this to handle requests to update one or more rows.
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
