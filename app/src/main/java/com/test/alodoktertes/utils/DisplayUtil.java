package com.test.alodoktertes.utils;

import android.content.Context;
import android.util.DisplayMetrics;


public class DisplayUtil {
    public static int ConvertPixelToDp(int pixels, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (pixels / displayMetrics.density));
    }

    public static int ConvertPxToDp(int px, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int ConvertDpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int ConvertDpToPixel(int dp, Context context) {
        return Math.round(dp * context.getResources().getDisplayMetrics().density);
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
