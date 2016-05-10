package com.kimeeo.kAndroidDemos.greedo;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by bpa001 on 4/4/16.
 */
public class MeasUtils {
    public static int pxToDp(int px, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px,
                context.getResources().getDisplayMetrics());
    }

    public static int dpToPx(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
