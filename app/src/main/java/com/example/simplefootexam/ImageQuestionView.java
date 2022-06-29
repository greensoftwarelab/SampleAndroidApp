package com.example.simplefootexam;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageQuestionView extends View {
    private View mValue;
    private ImageView mImage;

    public ImageQuestionView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.QuestionV, 0, 0);
        String titleText = a.getString(R.styleable.QuestionV_titleText);
        @SuppressWarnings("ResourceAsColor")
        int valueColor = a.getColor(R.styleable.QuestionV_valueColor,
                android.R.color.holo_blue_light);

        /*
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.questionview, this, true);

        TextView title = (TextView) getChildAt(0);
        title.setText(titleText);

        mValue = getChildAt(1);
        mValue.setBackgroundColor(valueColor);

        mImage = (ImageView) getChildAt(2);*/
    }

    public ImageQuestionView(Context context) {
        this(context, null);
    }

    public void setValueColor(int color) {
        mValue.setBackgroundColor(color);
    }

    public void setImageVisible(boolean visible) {
        mImage.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // TODO add drawallocation issue
        Paint p = new Paint();
        canvas.drawRect(0, 0, 50, 50, p);
    }
}
