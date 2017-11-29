package com.bawei.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 闫浩然 on 2017/11/29.
 */

public class TuoDong extends View {
    //定义一只画笔
    Paint paint;
    //设置起点的坐标
    int x = 200;
    int y = 200;
    int pre;
    public TuoDong(Context context) {
        super(context);
    }

    public TuoDong(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //初始化这只画笔
        paint = new Paint();
        //设置画笔的颜色
        paint.setColor(Color.GREEN);
        //设置画笔的粗细
        paint.setStrokeWidth(5);
        //抗锯齿，让边上看起来不那么模糊
        paint.setAntiAlias(true);
        //可以让圆空心或者实心,,,STROKE是空心。
        paint.setStyle(Paint.Style.STROKE);
    }

    public TuoDong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //重写测量的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    //重写绘制的方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画一个实心圆
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x,y,20,paint);

    }

    //监听
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //event.getAction()获取动作
        switch (event.getAction()){
            //三个状态
            case MotionEvent.ACTION_DOWN://按下的时候
                Toast.makeText(getContext(), "请移动", Toast.LENGTH_SHORT).show();
            case MotionEvent.ACTION_MOVE://移动的时候，获取坐标
                //定义坐标
                x = (int) event.getX();
                y = (int) event.getY();
                //然后刷新
                invalidate();
            case MotionEvent.ACTION_UP:
                Toast.makeText(getContext(), "结束", Toast.LENGTH_SHORT).show();

        }

        //return  true放最后
        return true;

    }
}
