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

public class ImageQuestionView extends LinearLayout {
    private ImageView mImage;
    private TextView mTextViewTitle;


    public ImageQuestionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.QuestionV, 0, 0);

        int valueColor = ta.getColor(R.styleable.QuestionV_valueColor, getResources().getColor(R.color.black));

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.questionview, this, true);

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        mTextViewTitle = (TextView) getChildAt(0);
        mTextViewTitle.setBackgroundColor(valueColor);
        mTextViewTitle.setText("Question");
        mImage = (ImageView) getChildAt(1);
    }

    public ImageQuestionView(Context context) {
        this(context, null);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // TODO add drawallocation issue
        Paint p = new Paint();
        canvas.drawRect(0, 0, 50, 50, p);
    }
}
