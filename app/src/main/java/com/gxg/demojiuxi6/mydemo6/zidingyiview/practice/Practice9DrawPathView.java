package com.gxg.demojiuxi6.mydemo6.zidingyiview.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint paint;
    private Path path;

    public Practice9DrawPathView(Context context) {
        super(context);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.FILL);

        path = new Path();
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        RectF rectF = new RectF(200, 200, 400, 400);
        RectF rectF1 = new RectF(400, 200, 600, 400);
        path.addArc(rectF, -225, 225);
        path.arcTo(rectF1, -180, 225, false);
        path.lineTo(400, 542);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path,paint);

//        练习内容：使用 canvas.drawPath() 方法画心形
    }
}
