package com.mpmcinc.android.starfighter;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created by michel on 13-09-23.
 */
public class SFGame extends Activity {
    private SFGameView gameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new SFGameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.onPause();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Point t = new Point();
        SFEngine.display.getSize(t);
        int height = t.y / 4;
        int playableArea = t.y - height;

        if (y > playableArea) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (x < t.x /2) {
                        SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_LEFT_1;
                    }
                    else {
                        SFEngine.playerFlightAction = SFEngine.PLAYER_BANK_RIGHT_1;
                    }

                    break;
                case MotionEvent.ACTION_UP:
                    SFEngine.playerFlightAction = SFEngine.PLAYER_RELEASE;
                    break;
            }
        }
        return false;
    }
}
