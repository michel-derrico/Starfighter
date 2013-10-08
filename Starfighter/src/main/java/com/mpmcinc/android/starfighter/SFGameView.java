package com.mpmcinc.android.starfighter;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by michel on 13-09-23.
 */
public class SFGameView extends GLSurfaceView {
    private SFGameRenderer renderer;

    public SFGameView(Context context) {
        super(context);

        renderer = new SFGameRenderer();
        this.setRenderer(renderer);
    }
}
