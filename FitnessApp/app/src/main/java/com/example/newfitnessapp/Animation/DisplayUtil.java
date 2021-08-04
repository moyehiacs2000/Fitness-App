package com.example.newfitnessapp.Animation;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DisplayUtil {
    private float mScaleFactor;
    private static DisplayUtil mDisplayUtil;
    private DisplayUtil() {
        DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
        mScaleFactor = dm.density;
    }
    private static void getInstance() {
        if (mDisplayUtil == null) {
            synchronized (DisplayUtil.class) {
                if (mDisplayUtil == null) {
                    mDisplayUtil = new DisplayUtil();
                }
            }
        }
    }
    public static int dp2px(float dpValue) {
        if (mDisplayUtil == null) {
            getInstance();
        }
        return (int) (mDisplayUtil.mScaleFactor * dpValue + 0.5f);
    }
}

