package com.mz.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by MZ on 2017/12/19.
 */

public class PaintView extends View {

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        //        drawStrokeCap(canvas);

        //        drawStrokeJoin(canvas);

        //        drawPathEffect(canvas);

    }

    private void drawPathEffect(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(100, 600);
        path.lineTo(400, 100);
        path.lineTo(700, 900);

        canvas.drawPath(path, paint);

        paint.setColor(Color.RED);
        //圆形拐角效果
        /*设置路径样式;取值类型是所有派生自PathEffect的子类：
        CornerPathEffect圆形拐角效果 , DashPathEffect虚线效果 , DiscretePathEffect离散路径效果,
        PathDashPathEffect印章路径效果 ,
        SumPathEffect，ComposePathEffect 合并两个特效 */
        paint.setPathEffect(new CornerPathEffect(100));
        canvas.drawPath(path, paint);
        paint.setColor(Color.YELLOW);
        paint.setPathEffect(new CornerPathEffect(200));
        canvas.drawPath(path, paint);

        /*那么这条虚线将是由四条子线段循环组成的，
        第一条实线长度为20，第二个空线长度为10，第三个实线长为100，第四条空线长充为100；
        phase：开始绘制的偏移值*/
        paint.setPathEffect(new DashPathEffect(new float[]{20, 10, 100, 100}, 0));
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);


        /*第一个参数segmentLength：表示将原来的路径切成多长的线段。如果值为2，
        那么这个路径就会被切成一段段由长度为2的小线段。所以这个值越小，
        所切成的小线段越多；这个值越大，所切成的小线段越少。
        第二参数deviation：表示被切成的每个小线段的可偏移距离。值越大，
        就表示每个线段的可偏移距离就越大，就显得越凌乱，值越小，
        每个线段的可偏移原位置的距离就越小。*/
        canvas.translate(0, 200);
        paint.setPathEffect(new DiscretePathEffect(2, 5));
        canvas.drawPath(path, paint);

        /*Path shape:表示印章路径，比如我们下面示例中的三角形加右上角一个点；
        float advance：表示两个印章路径间的距离,很容易理解，印章间距离越大，间距就越大。
        float phase：路径绘制偏移距离，与上面DashPathEffect中的float phase参数意义相同
        Style style：表示在遇到转角时，如何操作印章以使转角平滑过渡，
            取值有：Style.ROTATE，Style.MORPH，Style.TRANSLATE;Style.ROTATE表示通过旋转印章来过渡转角；
            Style.MORPH表示通过变形印章来过渡转角；Style.TRANSLATE表示通过位移来过渡转角。
            这三个效果的具体意义，上面会通过具体示例来分别讲解。*/
        //构建印章路径
        Path stampPath = new Path();
        stampPath.moveTo(0, 20);
        stampPath.lineTo(10, 0);
        stampPath.lineTo(20, 20);
        stampPath.close();
        stampPath.addCircle(0, 0, 3, Path.Direction.CCW);
        //使用印章路径效果
        canvas.translate(0, 200);
        paint.setPathEffect(new PathDashPathEffect(stampPath, 35, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawPath(path, paint);
    }

    private void drawStrokeJoin(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(40);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(450, 100);
        path.lineTo(100, 300);
        //设置线段连接处样式，取值有：Join.MITER /'maitə/斜接 （结合处为锐角）、Join.Round(结合处为圆弧)、Join.BEVEL /'bev(ə)l/斜角；斜面  (结合处为直线)
        paint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path, paint);

        path.moveTo(100, 400);
        path.lineTo(450, 400);
        path.lineTo(100, 600);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path, paint);

        path.moveTo(100, 700);
        path.lineTo(450, 700);
        path.lineTo(100, 900);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path, paint);
    }

    private void drawStrokeCap(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(80);  //设置画笔宽度
        paint.setAntiAlias(true);  //设置画笔是否抗锯齿
        paint.setColor(Color.GREEN);  //给画笔设置颜色值

        /*设置画笔样式，取值有
        Paint.Style.FILL :填充内部
        Paint.Style.FILL_AND_STROKE ：填充内部和描边
        Paint.Style.STROKE ：仅描边*/
        paint.setStyle(Paint.Style.STROKE);

        //设置线冒样式，取值有Cap.ROUND(圆形线冒)、Cap.SQUARE(方形线冒)、Paint.Cap.BUTT(无线冒)
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100, 200, 400, 200, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100, 400, 400, 400, paint);

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100, 600, 400, 600, paint);

        //垂直画出x=100这条线
        paint.reset();  //重置画笔
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        canvas.drawLine(100, 50, 100, 750, paint);
    }
}
