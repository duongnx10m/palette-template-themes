package com.duongnx.navigationdrawer.wigets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.com.duongnx.navigationdrawer.R;
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
        paintMain.setColor(ContextCompat.getColor(getContext(), themeType.getColorPrimary()));


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (themeType != null) {
            canvas.drawRect(0, 0, width, height, paintMain);

            drawCircle(canvas, width / 2 - 4 * radius, height / 2, themeType.getColorPrimaryDark());
            drawCircle(canvas, width / 2, height / 2, themeType.getColorPrimary());
            drawCircle(canvas, width / 2 + 4 * radius, height / 2, themeType.getColorAccent());
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        int colorStart = ContextCompat.getColor(getContext(), themeType.getColorPrimaryDark());
        int colorEnd = ContextCompat.getColor(getContext(), themeType.getColorAccent());
        Shader shader = new LinearGradient(0, 0, 0, height, colorStart, colorEnd, Shader.TileMode.CLAMP);
        paintMain.setShader(shader);
    }

    private void drawCircle(Canvas canvas, float x, float y, int color) {
        Paint paint = new Paint();
        //paint.setAlpha();
        paint.setColor(ContextCompat.getColor(getContext(), color));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        canvas.drawCircle(x, y, radius, paint);
    }

    private void drawTriangle(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        //paint.setShadowLayer(10, 0, 0, Color.BLACK);
        paint.setColor(ContextCompat.getColor(getContext(), themeType.getColorPrimaryDark()));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);

        Point a = new Point(0, height / 2);
        Point b = new Point(0, height);
        Point c = new Point(height / 2, height);

        canvas.drawPath(getPath(a, b, c), paint);
    }


    private Path getPath(Point a, Point b, Point c) {
        Path path = new Path();
        path.moveTo(b.x, b.y);
        path.setFillType(Path.FillType.EVEN_ODD);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();
        return path;
    }
}
