package com.gxg.demojiuxi6.mydemo6.zidingyiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.FloatRange;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.gxg.demojiuxi6.mydemo6.R;

/**
 * Created by gateway on 2017/7/24.
 */
public class LeiDaView extends View {
    //扩散圆宽度取控件的长度最小值
    private float minRadius;
    //中心画笔
    private Paint mCenterPaint;
    //中心画笔颜色
    private int mCenterPaintColor = getResources().getColor(R.color.colorPrimary);
    //透明度
    private int mAlpha = 255;
    //扩散圆画笔
    private Paint mPaint;
    //扩散圆画笔颜色
    private int mPaintColor = getResources().getColor(R.color.colorAccent);
    //圆心X
    private float mCenterX;
    //圆心Y
    private float mCenterY;
    //中心圆扩散半径
    private float mInnerCircleRadius = 25;
    //扩散圆扩散宽度
    private float mDiffesWidth = 0;
    //是否开始扫描
    private boolean startDiffseBoolean = true;


    public LeiDaView(Context context) {
        super(context);
        init();
    }

    public LeiDaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LeiDaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mPaintColor);
        mPaint.setStrokeWidth(4);
        mPaint.setDither(true);

        mCenterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCenterPaint.setStyle(Paint.Style.FILL);
        mCenterPaint.setDither(true);
        mCenterPaint.setColor(mCenterPaintColor);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCenterX = w / 2;
        mCenterY = h / 2;
        minRadius = Math.min(mCenterX, mCenterY);
//        Log.e("sss", "onSizeChanged: "+mCenterX+"   "+mCenterY+"   "+minRadius );
    }


    private float progress = 0f;

    private float getValueByProgress(float start, float end, @FloatRange(from = 0.0f, to = 1.0f) float progress) {
        return start + (end - start) * progress;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setAlpha(mAlpha);
//        mAlpha = mAlpha-1;
//        mDiffesWidth = mDiffesWidth+2;

        progress += 0.05;
        mAlpha = (int) getValueByProgress(255, 0, progress);
        mDiffesWidth = getValueByProgress(mInnerCircleRadius, minRadius, progress);

        if (progress >= 1.0f) {
            progress = 0f;

        }

//        Log.e("sss", "onDraw: "+mAlpha+"   "+mDiffesWidth );
//        if(mAlpha<=0  || mDiffesWidth>=minRadius){
//            mAlpha = 255;
//            mDiffesWidth = mInnerCircleRadius;
//        }

        //画扩散圆
        canvas.drawCircle(mCenterX, mCenterY, mDiffesWidth, mPaint);

        //画中心圆
        canvas.drawCircle(mCenterX, mCenterY, mInnerCircleRadius, mCenterPaint);

        if (startDiffseBoolean) {
            postInvalidateDelayed(50);
        }
    }

    @Override
    public void postInvalidateDelayed(long delayMilliseconds) {
        if (hasWindowFocus()) {
            super.postInvalidateDelayed(delayMilliseconds);
        }
    }

    @Override
    public void postInvalidate() {
        if (hasWindowFocus()) {
            super.postInvalidate();
        }
    }

    /**
     * dp 2 px
     *
     * @param dpVal
     */
    protected int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, getResources().getDisplayMetrics());
    }

}
