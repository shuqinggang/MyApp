package com.example.mayn.myapp.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by shuqinggang on 2018/7/30.
 * 自定义相机
 */

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private final static String TAG=CameraSurfaceView.class.getName();
    private SurfaceHolder surfaceHolder;
    public CameraSurfaceView(Context context) {
        super(context);
        inite();
    }

    public CameraSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inite();
    }

    public CameraSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inite();
    }

    public void inite(){
        surfaceHolder=getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        CameraUtils.openFrontalCamera(CameraUtils.DESIRED_PREVIEW_FPS);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        CameraUtils.startPreviewDisplay(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        CameraUtils.releaseCamera();
    }
}
