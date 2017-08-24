package com.gxg.demojiuxi6.mydemo6.zidingyiview.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice1DrawColorView extends View {

    private Paint paint;

    public Practice1DrawColorView(Context context) {
        super(context);
        init();
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }



    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private void init() {

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL); //设置绘制模式
        paint.setStrokeWidth(10);// 设置线条宽度
        paint.setColor(Color.RED);// 设置颜色
        paint.setAntiAlias(true);// 设置抗锯齿开关

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);

        canvas.drawCircle(300,300,200,paint);
//        练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
//        黄色： Color.YELLOW
    }
}
