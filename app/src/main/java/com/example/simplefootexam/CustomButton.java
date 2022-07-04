package com.example.simplefootexam;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.hunter.library.debug.HunterDebug;
import android.content.Context;

public class CustomButton extends AppCompatButton {

    private boolean isWrong = false;

    private int color_wrong;

    public CustomButton(Context context) {
        super(context);
    }

    @HunterDebug
    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomButton, 0, 0);
        color_wrong = a.getColor(R.styleable.CustomButton_valueColor, Color.RED);
    }

    @Override
    @HunterDebug
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isWrong) {
            Paint p = new Paint();
            p.setColor(color_wrong);
            p.setStrokeWidth(10);
            canvas.drawLine(0, this.getY(), this.getWidth(), this.getHeight(), p);
            canvas.drawLine(0, this.getHeight(), this.getWidth(), this.getY(), p);
        }
    }

    public void setWrong(boolean wrong) {
        isWrong = wrong;
    }
}
