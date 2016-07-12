package com.hpes.listofprojects;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MusicService extends Service implements MediaPlayer.OnCompletionListener {
    public MusicService() {
    }
    MediaPlayer mplayer;

//    @Override
//    public IBinder onBind(Intent intent) {
//        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

    @Override
    public void onCreate() {
        mplayer = MediaPlayer.create(this,R.raw.middle);
        mplayer.setOnCompletionListener(this);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mplayer.isPlaying()){
            mplayer.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mplayer.isPlaying()){
            mplayer.stop();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
       stopSelf();
    }
}
