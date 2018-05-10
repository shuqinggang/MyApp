package com.example.mayn.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mayn.myapp.NetworkUtils.LogUtil;
import com.mob.tools.MobLog;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class Main2Activity extends BaseActivity {

    @BindView(R.id.et_shj)
    EditText etShj;
    @BindView(R.id.btn_huqu)
    Button btnHuqu;
    @BindView(R.id.btn_yz)
    Button btnYz;
    @BindView(R.id.et_yz)
    EditText etYz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_huqu,R.id.btn_yz})
    public void getCode(View view){
        switch (view.getId()) {
            case R.id.btn_huqu:
                 sendCode("86", etShj.getText().toString().trim());
                 break;
            case R.id.btn_yz:
                submitCode("86",etShj.getText().toString().trim(),etYz.getText().toString().trim());
                break;
        }
    }

    // 请求验证码，其中country表示国家代码，如“86”；phone表示手机号码，如“13800138000”
    public void sendCode(String country, String phone) {
        // 注册一个事件回调，用于处理发送验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理成功得到验证码的结果
                    // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
                } else{
                    // TODO 处理错误的结果
                }

            }
        });
        // 触发操作
        SMSSDK.getVerificationCode(country, phone);
    }

    // 提交验证码，其中的code表示验证码，如“1357”
    public void submitCode(String country, String phone, String code) {
        // 注册一个事件回调，用于处理提交验证码操作的结果
        SMSSDK.registerEventHandler(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // TODO 处理验证成功的结果
                    LogUtil.e("AAAAAAAAAAA","BBBBBBBBBBBBB");
                } else{
                    // TODO 处理错误的结果
                    LogUtil.e("AAAAAAAAAAA","BBBBBBBBBBBBB");
                }

            }
        });
        // 触发操作
        SMSSDK.submitVerificationCode(country, phone, code);
    }

    protected void onDestroy() {
        super.onDestroy();
        //用完回调要注销掉，否则可能会出现内存泄露
        SMSSDK.unregisterAllEventHandler();
    };
}
