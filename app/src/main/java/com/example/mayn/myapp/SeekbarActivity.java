package com.example.mayn.myapp;

import android.content.Context;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.mayn.myapp.NetworkUtils.VerticalSeekBar;


public class SeekbarActivity extends BaseActivity {

    public static final String TAG=SeekbarActivity.class.getName();
    Context mContext;
    VerticalSeekBar verticalSeekBars;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        mContext=this;
        btnAdd=findViewById(R.id.btn_add);





        verticalSeekBars=findViewById(R.id.verticalSeekBars);
        verticalSeekBars.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e(TAG,verticalSeekBars.getProgress()+"");
                if(progress==100){
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verticalSeekBars.getProgress()<100) {
                    verticalSeekBars.setThumb(mContext.getResources().getDrawable(R.drawable.wo));
                    verticalSeekBars.setProgressAndThumb(verticalSeekBars.getProgress() + 10);
                }
            }
        });
        verticalSeekBars.setEnabled(false);
    }
}
