package com.duongnx.configs.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

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

}
