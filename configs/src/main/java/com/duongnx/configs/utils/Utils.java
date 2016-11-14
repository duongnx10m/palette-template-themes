package com.duongnx.configs.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.duongnx.configs.GApplication;

/**
 * Created by duongnx on 11/14/16.
 */

public class Utils {
    public static Point getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        final DisplayMetrics metrics = new DisplayMetrics();
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);

        // since SDK_INT = 1;
        Point size = new Point();
        size.x = metrics.widthPixels;
        size.y = metrics.heightPixels;
        try {
            // used when 17 > SDK_INT >= 14; includes window decorations
            // (statusbar bar/menu bar)
            size.x = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
            size.y = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
        } catch (Exception ignored) {
            // Do nothing
        }
        try {
            // used when SDK_INT >= 17; includes window decorations (statusbar
            // bar/menu bar)
            Point realSize = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
            size.x = realSize.x;
            size.y = realSize.y;
        } catch (Exception ignored) {
        }
        return size;
    }

    public static int[] getColorsFromTheme(Context context, int themeId) {
        int[] results = new int[3];
        int[] attrs = {android.R.attr.colorAccent, android.R.attr.colorPrimary, android.R.attr.colorPrimaryDark};
        if (context != null) {
            TypedArray typedArray = context.obtainStyledAttributes(themeId, attrs);
            if (typedArray != null) {
                results[0] = typedArray.getColor(0, Color.BLACK);
                results[1] = typedArray.getColor(1, Color.BLACK);
                results[2] = typedArray.getColor(2, Color.BLACK);
                typedArray.recycle();
            }
        }
        return results;
    }
}
