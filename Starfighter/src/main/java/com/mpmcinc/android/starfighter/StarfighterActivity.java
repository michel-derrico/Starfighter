package com.mpmcinc.android.starfighter;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.os.Handler;
import android.content.Intent;
import android.view.WindowManager;

public class StarfighterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SFEngine.display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed(new Thread() {
            @Override
            public void run() {
                Intent mainMenu = new Intent(StarfighterActivity.this,SFMainMenu.class);
                StarfighterActivity.this.startActivity(mainMenu);
                StarfighterActivity.this.finish();
                overridePendingTransition(R.layout.fadein,R.layout.fadeout);
            }
        },SFEngine.GAME_THREAD_DELAY);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.starfighter, menu);
        return true;
    }
    
}
