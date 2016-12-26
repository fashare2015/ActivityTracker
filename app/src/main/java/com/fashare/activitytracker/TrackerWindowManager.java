package com.fashare.activitytracker;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by jinliangshan on 16/12/26.
 */
public class TrackerWindowManager {
    private final Context mContext;
    private final WindowManager mWindowManager;

    public TrackerWindowManager(Context context) {
        mContext = context;
        mWindowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
    }

    private View mFloatingView;
    private static final WindowManager.LayoutParams LAYOUT_PARAMS;

    static {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.x = 0;
        params.y = 0;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.type = WindowManager.LayoutParams.TYPE_PHONE;
        params.format = PixelFormat.RGBA_8888;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

        LAYOUT_PARAMS = params;
    }

    public void addView() {
        if(mFloatingView == null){
            mFloatingView = new FloatingView(mContext);
            mFloatingView.setLayoutParams(LAYOUT_PARAMS);

            mWindowManager.addView(mFloatingView, LAYOUT_PARAMS);
        }
    }

    public void removeView(){
        if(mFloatingView != null){
            mWindowManager.removeView(mFloatingView);
            mFloatingView = null;
        }
    }
}
