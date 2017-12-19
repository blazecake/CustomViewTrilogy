package com.mz.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by MZ on 2017/12/19.
 */

public class ColorMatricsView extends View {
    public ColorMatricsView(Context context) {
        super(context);
    }

    public ColorMatricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorMatricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setARGB(255, 200, 100, 100);
        canvas.drawRect(0, 0, 500, 600, paint);

        canvas.translate(550, 0);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 0.5f, 0,
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawRect(0, 0, 500, 600, paint);

    }
}
