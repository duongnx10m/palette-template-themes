package com.duongnx.configs.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

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

    public static void setTextWithLinks(TextView textView, CharSequence html) {
        textView.setText(html);
        // TODO https://code.google.com/p/android/issues/detail?id=191430
        //noinspection Convert2Lambda
        textView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_UP ||
                        action == MotionEvent.ACTION_DOWN) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();

                    TextView widget = (TextView) v;
                    x -= widget.getTotalPaddingLeft();
                    y -= widget.getTotalPaddingTop();

                    x += widget.getScrollX();
                    y += widget.getScrollY();

                    Layout layout = widget.getLayout();
                    int line = layout.getLineForVertical(y);
                    int off = layout.getOffsetForHorizontal(line, x);

                    ClickableSpan[] link = Spannable.Factory.getInstance()
                            .newSpannable(widget.getText())
                            .getSpans(off, off, ClickableSpan.class);

                    if (link.length != 0) {
                        if (action == MotionEvent.ACTION_UP) {
                            link[0].onClick(widget);
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public static CharSequence fromHtml(String htmlText) {
        return fromHtml(htmlText, false);
    }

    public static CharSequence fromHtml(String htmlText, boolean compact) {
        if (TextUtils.isEmpty(htmlText)) {
            return null;
        }
        CharSequence spanned;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //noinspection InlinedApi
            spanned = Html.fromHtml(htmlText, compact ?
                    Html.FROM_HTML_MODE_COMPACT : Html.FROM_HTML_MODE_LEGACY);
        } else {
            //noinspection deprecation
            spanned = Html.fromHtml(htmlText);
        }
        return trim(spanned);
    }

    private static CharSequence trim(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        int end = charSequence.length() - 1;
        while (Character.isWhitespace(charSequence.charAt(end))) {
            end--;
        }
        return charSequence.subSequence(0, end + 1);
    }


    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // do nothing
        }
        return versionName;
    }

    public static void openEmail(Context context, String email) {
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{email});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "NDK Examples");
        context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }
}
