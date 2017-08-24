package com.gxg.demojiuxi6.mydemo6.zidingyiview.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint paint;

    public Practice8DrawArcView(Context context) {
        super(context);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5f);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         *  drawArc() 是使用一个椭圆来描述弧形的
         *  left, top, right, bottom 描述的是这个弧形所在的椭圆；
         *  startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
         *  sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。    *
         */
        RectF rectF = new RectF(100,100,600,500);
        canvas.drawArc(rectF,-100,100,true,paint);

        canvas.drawArc(rectF,20,140,false,paint);

        paint.setStyle(Paint.Style.STROKE);

        canvas.drawArc(rectF,180,60,false,paint);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
    }
}
