package com.mpmcinc.android.starfighter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by michel on 13-09-12.
 */
public class SFMainMenu extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SFEngine.musicThread = new Thread() {
            public void run() {
                Intent bgmusic = new Intent(getApplicationContext(), SFMusic.class);
                startService(bgmusic);
                SFEngine.context= getApplicationContext();
            }
        };
        SFEngine.musicThread.start();
        final SFEngine engine = SFEngine.getInstance();

        ImageButton start = (ImageButton)findViewById(R.id.btnStart);
        ImageButton exit = (ImageButton)findViewById(R.id.btnEnd);

        start.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
        start.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);

        exit.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
        exit.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start GAME !
                Intent game = new Intent(getApplicationContext(),SFGame.class);
                SFMainMenu.this.startActivity(game);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean clean = false;
                clean=engine.onExit(v);
                if (clean)
                {
                    int pid = android.os.Process.myPid();
                    android.os.Process.killProcess(pid);
                }
            }
        });
    }
}
