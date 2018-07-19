package com.example.mayn.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mayn.myapp.UI.PureVerticalSeekBar;

public class MyLineVeiwActivity extends BaseActivity {

    PureVerticalSeekBar pureVerticalSeekBar;
    Button btn,btns;
    float sum=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_line_veiw);
        btn=findViewById(R.id.mybtn);
        btns=findViewById(R.id.mybtns);
        pureVerticalSeekBar=findViewById(R.id.myLineView);
        pureVerticalSeekBar.setDragable(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               countProgress(20);
            }
        });


        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countProgress(35);
            }
        });

    }

    public void countProgress(float num){
        if(pureVerticalSeekBar.getProgress()<=100) {
            pureVerticalSeekBar.setProgress(pureVerticalSeekBar.getProgress() + (num / sum) * 100);
        }else {
            pureVerticalSeekBar.setVisibility(View.GONE);
        }
    }
}
