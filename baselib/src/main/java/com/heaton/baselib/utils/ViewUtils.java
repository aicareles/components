package com.heaton.baselib.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;


public class ViewUtils {


    /**
     * 动态设置控件的Margin
     *
     * @param view   控件
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public static void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }

    public static Bitmap convertViewToBitmap(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    /**
     * 过滤重复点击   true代表连续点击
     */
    private static long lastClickTime = 0;
    public static boolean filter(long duration){
        long time = System.currentTimeMillis();
        if (time - lastClickTime < duration){
            return true;
        }
        lastClickTime = time;
        return false;
    }
}


