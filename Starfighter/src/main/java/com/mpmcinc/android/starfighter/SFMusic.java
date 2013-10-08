package com.mpmcinc.android.starfighter;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by michel on 13-09-15.
 */
public class SFMusic extends Service {

    public static boolean isRunning = false;
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setMusicOptions(this,SFEngine.LOOP_BACKGROUND_MUSIC,SFEngine.R_VOLUME,SFEngine.L_VOLUME, SFEngine.SPLASH_SCREEN_MUSIC);
    }

    public void setMusicOptions(Context context, boolean isLooped, int rVolume, int lVolume, int soundFile) {
        player = MediaPlayer.create(context,soundFile);
        player.setLooping(isLooped);
        player.setVolume(rVolume,lVolume);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
         player.start();
            isRunning = true;
        }
        catch (Exception e) {
            isRunning = false;
            player.stop();
        }
        return 1;
    }

    public void onStart(Intent intent, int startId){

    }

    public void onStop() {
        isRunning = false;
    }

    public void onPause() {

    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {
        player.stop();
    }
}
