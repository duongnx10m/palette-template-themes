package com.duongnx.palettethemes.wigets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.duongnx.configs.GApplication;
import com.duongnx.configs.ThemeType;
import com.duongnx.configs.utils.Utils;

/**
 * Created by duongnx on 11/14/16.
 */

public class NavigationHeaderView extends View {

    private Paint paintMain = new Paint();
    private Point screenSize;
    private int width = 100, height = 100;
    private ThemeType themeType = GApplication.getInstance().getThemeType();
    private int radius = 50;
    private int[] themeColors;

    public NavigationHeaderView(Context context) {
        super(context);
        init(context);
    }

    public NavigationHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public NavigationHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        screenSize = Utils.getScreenSize(context);
        paintMain.setAntiAlias(true);
        //paintMain.setColor(ContextCompat.getColor(context, color));
        paintMain.setStyle(Paint.Style.FILL);
        //paintMain.setShadowLayer(10, 0, 0, Color.BLACK);
        themeColors = Utils.getColorsFromTheme(getContext(), themeType.getThemeId());
        Log.d("duongnx", themeType.name() + ";"+Integer.toHexString(themeColors[0]) + "===" + Integer.toHexString(themeColors[1]));
        paintMain.setColor(themeColors[1]);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (themeType != null) {
            canvas.drawRect(0, 0, width, height, paintMain);

//            drawCircle(canvas, width / 2 - 4 * radius, height / 2, themeColors[2]);
//            drawCircle(canvas, width / 2, height / 2, themeColors[1]);
//            drawCircle(canvas, width / 2 + 4 * radius, height / 2, themeColors[0]);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        int colorStart = themeColors[2];
        int colorEnd = themeColors[0];
        Shader shader = new LinearGradient(0, 0, 0, height, colorStart, colorEnd, Shader.TileMode.CLAMP);
        paintMain.setShader(shader);
    }

    private void drawCircle(Canvas canvas, float x, float y, int color) {
        Paint paint = new Paint();
        //paint.setAlpha();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawCircle(x, y, radius, paint);
    }


}
