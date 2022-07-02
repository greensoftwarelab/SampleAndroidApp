package com.example.simplefootexam;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

public class CustomButton extends AppCompatButton {

    private boolean isWrong =false;
    private int color;

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.CustomButton, 0, 0);

        color  = a.getColor(R.styleable.CustomButton_valueColor,
                Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(isWrong) {
            Paint p = new Paint();
            p.setColor(color);
            p.setStrokeWidth(10);
            canvas.drawLine(0, (this.getHeight() / 2), this.getWidth(), (this.getHeight() / 2), p);
        }
    }

    public boolean isWrong() {
        return isWrong;
    }

    public void setWrong(boolean wrong) {
        isWrong = wrong;
    }
}