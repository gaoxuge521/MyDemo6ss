package com.gxg.demojiuxi6.mydemo6.zidingyiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.text.DecimalFormat;

/**
 * Created by gateway on 2017/7/17.
 */
public class LoadingProgerssView extends View {

    private int mHeight;
    private int mWidth;
    private Paint bgPaint;
    private Paint progressPaint;
    private Paint tipPaint;
    private Paint textPaint;
    private int bgColor = 0xFFe1e5e8;
    private int tipHeight;
    private int tipWidth;//百分比提示框的宽度
    private  int tipPaintHeight;
    private  int tipPaintWidth;//百分比提示框画笔的宽度
    private int triangleHeight;// 三角形的高
    private int roundRectRadius;//圆角矩形的圆角半径
    private int textPaintSize;//百分比文字字体大小
    private int progressMarginTop;//进度条距离提示框的高度
    private int mViewHeight;
    private int progressPaintWidth;
    public LoadingProgerssView(Context context) {
        super(context);
    }

    public LoadingProgerssView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initPaint();
    }
    public LoadingProgerssView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMode);
        int height = MeasureSpec.getSize(heightMode);

        setMeasuredDimension(measureHeight(widthMode,width),measureHeight(heightMode,height));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(getPaddingStart(),tipHeight+progressMarginTop,getWidth(),tipHeight+progressMarginTop,bgPaint);

    }

    /**
     * 测量高度
     *
     * @param mode
     * @param height
     * @return
     */
    private int measureHeight(int mode, int height) {
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                mHeight = mViewHeight;
                break;
            case MeasureSpec.EXACTLY:
                mHeight = height;
                break;
        }
        return mHeight;
    }
    public int measureWidth(int mode,int width){
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                mWidth = width;
                break;
        }
        return mHeight;
    }

    private void initPaint() {
        bgPaint = getPaint(progressPaintWidth,bgColor, Paint.Style.STROKE);
        initTextPaint();
    }

    private void initTextPaint() {
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(textPaintSize);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
    }
    private void init() {
        progressPaintWidth = dp2px(4);
        tipHeight = dp2px(15);
        tipWidth = dp2px(30);
        tipPaintWidth = dp2px(1);
        triangleHeight = dp2px(3);
        roundRectRadius = dp2px(2);
        textPaintSize = sp2px(10);
        progressMarginTop = dp2px(8);

        //view真实的高度
        mViewHeight = tipHeight + tipPaintWidth + triangleHeight + progressPaintWidth + progressMarginTop;

    }


    public Paint getPaint(int strokeWidth ,int color,Paint.Style style){
        Paint paint = new Paint();
        paint.setStyle(style);
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        return paint;
    };

    /**
     * 格式化数字(保留两位小数)
     *
     * @param money
     * @return
     */
    public static String formatNumTwo(double money) {
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(money);
    }

    /**
     * 格式化数字(保留一位小数)
     *
     * @param money
     * @return
     */
    public static String formatNum(int money) {
        DecimalFormat format = new DecimalFormat("0");
        return format.format(money);
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

    /**
     * sp 2 px
     *
     * @param spVal
     * @return
     */
    protected int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, getResources().getDisplayMetrics());

    }

    public static int format2Int(double i) {
        return (int) i;
    }
}
