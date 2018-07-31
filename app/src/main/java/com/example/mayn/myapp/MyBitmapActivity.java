package com.example.mayn.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mayn.myapp.NetworkUtils.BitmapUtil;
import com.example.mayn.myapp.UI.MySurfuceVeiw;

public class MyBitmapActivity extends BaseActivity {

  //  String url="http://img5.imgtn.bdimg.com/it/u=2813352773,2584685692&fm=27&gp=0.jpg";
    MySurfuceVeiw mySurfuceVeiw;
    ImageView img;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bitmap);
        img=findViewById(R.id.imgBitmap);
        mySurfuceVeiw=findViewById(R.id.mySurfuce);
        btn1=findViewById(R.id.again);
        btn2=findViewById(R.id.sava);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySurfuceVeiw.clearView();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageBitmap(mySurfuceVeiw.getBitmaps());
            }
        });
     //   Glide.with(this).load(url).into(img);


}


}
