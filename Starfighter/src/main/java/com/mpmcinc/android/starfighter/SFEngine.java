package com.mpmcinc.android.starfighter;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.View;

/**
 * Created by michel on 13-09-15.
 */
public class SFEngine {
    private static SFEngine ourInstance = new SFEngine();


    public static final int GAME_THREAD_DELAY = 4000;
    public static final int MENU_BUTTON_ALPHA = 0;
    public static final boolean HAPTIC_BUTTON_FEEDBACK = true;
    public static final int SPLASH_SCREEN_MUSIC = R.raw.warfieldedit;
    public static final int R_VOLUME = 100;
    public static final int L_VOLUME = 100;
    public static final boolean LOOP_BACKGROUND_MUSIC = true;
    public static Context context;
    public static Thread musicThread;
    public static final int BACKGROUND_LAYER_ONE = R.drawable.backgroundstars;
    public static float SCROLL_BACKGROUND_1 = 0.002f;
    public static final int BACKGROUND_LAYER_TWO = R.drawable.debris;
    public static float SCROLL_BACKGROUND_2 = 0.007f;
    public static final int GAME_THREAD_FPS_SLEEP = (1000/60);
    public static Display display;
    public static int playerFlightAction = 0;
    public static final int PLAYER_SHIP = R.drawable.good_sprite;
    public static final int PLAYER_BANK_LEFT_1 = 1;
    public static final int PLAYER_RELEASE = 3;
    public static final int PLAYER_BANK_RIGHT_1 = 4;

    public static final int PLAYER_FRAMES_BETWEEN_ANI = 9;
    public static final float PLAYER_BANK_SPEED = 0.1f;
    public static float playerBankPosX = 1.75f;

    public static SFEngine getInstance() {
        return ourInstance;
    }

    private SFEngine() {
    }

    public boolean onExit(View v)
    {
        try {
            Intent bgmusic = new Intent(context,SFMusic.class);
            context.stopService(bgmusic);
//            musicThread.stop();

            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
