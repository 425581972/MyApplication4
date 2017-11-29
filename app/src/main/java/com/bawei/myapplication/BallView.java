package com.bawei.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 闫浩然 on 2017/11/29.
 */

public class BallView extends View {
    //定义一只画笔
    Paint paint;
    //设置起点的坐标
    int x = 200;
    int y = 200;
    int pre;

    public BallView(Context context) {
        super(context);
    }

    public BallView(Context context, @Nullable AttributeSet attrs) {
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

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        //画一个圆,起点坐标，半径，画笔
        canvas.drawCircle(50,50,20,paint);
        //画一个实心圆
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(150,150,20,paint);
        //画一个直线,起点x坐标，y坐标，终点x坐标，y坐标，
        canvas.drawLine(0,10,100,10,paint);
        //画一条斜线
        canvas.drawLine(100,100,200,200,paint);
        //画一个矩形,
        canvas.drawRect(300, 80, 400, 160, paint);
        //画一个圆角矩形
        RectF rectrf = new RectF(10, 180, 110, 250);
//        canvas.drawRoundRect(rectrf, 10, 10, paint);

        canvas.drawArc(rectrf,-90,270,false,paint);

        //画一个弧
        int p = 300;
        RectF rectF = new RectF(x+300,y+300,x+300,y+300);
        canvas.drawArc(rectF,y,0,false,paint);
    }

    //监听
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //event.getAction()获取动作
        switch (event.getAction()){
            //三个状态
            case MotionEvent.ACTION_POINTER_DOWN://按下的时候
                Toast.makeText(getContext(), "请移动", Toast.LENGTH_SHORT).show();
            case MotionEvent.ACTION_HOVER_MOVE://移动的时候，获取坐标
                //定义坐标
                x = (int) event.getX();
                y = (int) event.getY();
                //然后刷新
                invalidate();
            case MotionEvent.ACTION_POINTER_UP:
                Toast.makeText(getContext(), "结束", Toast.LENGTH_SHORT).show();

        }

        //return放最后
        return super.onTouchEvent(event);

    }
}
