package com.example.mayn.myapp.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by shuqinggang on 2018/7/26.
 */

public class MySurfuceVeiw extends SurfaceView implements SurfaceHolder.Callback,Runnable {
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private boolean isDraw;
    private Paint mPaint;
    Path mPath;
    // 定义一个内存中的图片，该图片将作为缓冲区
    Bitmap cacheBitmap = null;
    // 定义cacheBitmap上的Canvas对象
    Canvas cacheCanvas = null;

    public MySurfuceVeiw(Context context) {
        super(context);
        initeView();
    }

    public MySurfuceVeiw(Context context, AttributeSet attrs) {
        super(context, attrs);
        initeView();
    }

    public MySurfuceVeiw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initeView();
    }
    public void initeView(){
        surfaceHolder=getHolder();
        surfaceHolder.addCallback(this);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        initeBitmaps();
        mPaint.setStrokeWidth(10f);
        mPaint.setColor(Color.parseColor("#FF4081"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPath=new Path();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDraw=true;
        draw();
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//        cacheCanvas=new Canvas();
//        cacheBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        cacheCanvas.setBitmap(cacheBitmap);
        cacheCanvas.drawBitmap(cacheBitmap, 0, 0, mPaint); //
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDraw=false;
    }

    public static final int TIME_IN_FRAME = 30;
    @Override
    public void run() {
//        long startTime = System.currentTimeMillis();
//        while(isDraw){
//            draw();
////             x+=1;
////             y=(int)(100*Math.sin(x*2*Math.PI/180)+400);
////             mPath.lineTo(x,y);
//        }
//
//        /**取得更新结束的时间**/
//        long endTime = System.currentTimeMillis();
//
//        /**计算出一次更新的毫秒数**/
//        int diffTime  = (int)(endTime - startTime);
//
//        /**确保每次更新时间为30帧**/
//        while(diffTime <=TIME_IN_FRAME) {
//            diffTime = (int)(System.currentTimeMillis() - startTime);
//            /**线程等待**/
//            Thread.yield();
//        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        draw();
        return true;//表示此View拦截处理触摸事件
    }

    private void draw() {
        try{
            //SurfaceView背景
            canvas=surfaceHolder.lockCanvas();//获取Canvas对象进行绘制
            canvas.drawColor(Color.WHITE);
            canvas.drawPath(mPath,mPaint);

            cacheCanvas.drawPath(mPath,mPaint);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (canvas!=null){
                surfaceHolder.unlockCanvasAndPost(canvas);//保证绘制的画布内容提交
            }
        }
    }

    public Bitmap getBitmaps(){
        return resizeImage(cacheBitmap,1080,244);
    }

    // 缩放
    public static Bitmap resizeImage(Bitmap bitmap, int width, int height) {
        //获取图片的宽高
        int originWidth = bitmap.getWidth();
        int originHeight = bitmap.getHeight();

        //这里缩放我们的尺寸，缩放多少自己去定义
        float scaleWidth = ((float) width) / originWidth;
        float scaleHeight = ((float) height) / originHeight;

        //进行缩放
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, originWidth,
                originHeight, matrix, true);
        return resizedBitmap;
    }

    public void clearView(){
        cacheBitmap=null;
        initeBitmaps();
        mPath.reset();
        Canvas canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas(null);
            canvas.drawColor(Color.WHITE);
        }catch (Exception e) {
            // TODO: handle exception
        }finally {
            if(canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void initeBitmaps(){
        cacheCanvas=new Canvas();
        cacheBitmap = Bitmap.createBitmap(1080, 1100, Bitmap.Config.ARGB_8888);
        cacheCanvas.setBitmap(cacheBitmap);
    }
}
