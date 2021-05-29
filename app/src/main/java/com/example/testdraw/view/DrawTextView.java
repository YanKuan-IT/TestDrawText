package com.example.testdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class DrawTextView extends AppCompatTextView {

    public DrawTextView(@NonNull Context context) {
        super(context);
    }
    public DrawTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public DrawTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawCenterLineX(canvas);
        drawCenterLineY(canvas);

        ///////////////////////
        canvas.save();

        String text = "绘制文本";
        Paint paint = new Paint();
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.LEFT); // 默认值LEFT
        paint.setColor(Color.RED);
        paint.setAntiAlias(true); // 防锯齿
        float x = 0;
        float baseLine = 100;
        canvas.drawText(text, x, baseLine, paint);

        canvas.restore();
        ///////////////////////


        // 绘制文本 - 文本对齐 - 左
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.LEFT); // 默认值LEFT
        x = getWidth() / 2;
        baseLine = 100 + paint.getFontSpacing();
        canvas.drawText(text, x, baseLine, paint);

        // 绘制文本 - 文本对齐 - 中
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.CENTER); // 默认值LEFT
        x = getWidth() / 2;
        baseLine = 100 + paint.getFontSpacing() * 2;
        canvas.drawText(text, x, baseLine, paint);

        // 绘制文本 - 文本对齐 - 右
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.RIGHT); // 默认值LEFT
        x = getWidth() / 2;
        baseLine = 100 + paint.getFontSpacing() * 3;
        canvas.drawText(text, x, baseLine, paint);




        // 绘制文本 - 上下左右居中
        paint.setTextSize(100);
        paint.setColor(Color.RED);
        paint.setTextAlign(Paint.Align.LEFT);

        x = getWidth()/2 - paint.measureText(text)/2;

        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        baseLine = getHeight()/2 - (fontMetrics.descent + fontMetrics.ascent)/2;

        canvas.drawText(text, x, baseLine, paint);

    }

    /**
     * 绘制x轴的中间竖线
     */
    private void drawCenterLineX(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        canvas.drawLine(getWidth()/2, 0, getWidth()/2, getHeight(), paint);
    }

    /**
     * 绘制y轴的中间横线
     */
    private void drawCenterLineY(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        canvas.drawLine(0, getHeight()/2, getWidth(), getHeight()/2, paint);
    }

}
