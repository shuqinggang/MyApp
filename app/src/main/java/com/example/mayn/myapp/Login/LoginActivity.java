package com.example.mayn.myapp.Login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayn.myapp.MainActivity;
import com.example.mayn.myapp.MlogUtils.AlertDialogUtil;
import com.example.mayn.myapp.MlogUtils.DialogUtil;
import com.example.mayn.myapp.MyApp;
import com.example.mayn.myapp.NetworkUtils.SharePrefreUtils;
import com.example.mayn.myapp.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class LoginActivity extends Activity{

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tx_forget)
    TextView txForget;
    @BindView(R.id.tx_regist)
    TextView txRegist;
    @BindView(R.id.tx_protocol)
    TextView txProtocol;
    DialogUtil dialogUtil;
    AlertDialogUtil alertDialogUtil;
    Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        mcontext=this;
        ButterKnife.bind(this);
        dialogUtil=new DialogUtil(this);
        dialogUtil.creatDialog("正在登陆，请稍后");
        alertDialogUtil=new AlertDialogUtil(this);
        inite();
    }

    public void inite(){
        if(!TextUtils.isEmpty(SharePrefreUtils.getAccount()) && !TextUtils.isEmpty(SharePrefreUtils.getPassword())){
            etUsername.setText(SharePrefreUtils.getAccount());
            etPassword.setText(SharePrefreUtils.getPassword());
        }
        String protocolText = getResources().getString(R.string.login_condition);
        SpannableStringBuilder style=new SpannableStringBuilder(protocolText);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#00BFFF")),10,14, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);     //设置指定位置textview的背景颜色
      //  style.setSpan(new ForegroundColorSpan(Color.RED),0,2,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);     //设置指定位置文字的颜色
        txProtocol.setText(style);

        if(SharePrefreUtils.getAccount().equals("baobao") && SharePrefreUtils.getPassword().equals("521")){
            dialogUtil.showDialog();
            btnLogin.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialogUtil.closeDialog();
                    startActivity(new Intent(mcontext, MainActivity.class));
                }
            },3000);
        }
    }

    @OnClick({R.id.btn_login,R.id.tx_regist})
    public void btnLogin(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
            if(TextUtils.isEmpty(etUsername.getText().toString().trim()) &&TextUtils.isEmpty(etPassword.getText().toString().trim())) {
                Toast.makeText(this, getResources().getString(R.string.username_password_null), Toast.LENGTH_SHORT).show();
                return;
            }
            dialogUtil.showDialog();
            if (etUsername.getText().toString().trim().equals("baobao") && etPassword.getText().toString().trim().equals("521")) {
                btnLogin.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialogUtil.closeDialog();
                        SharePrefreUtils.savaUserInfor(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
                        startActivity(new Intent(mcontext, MainActivity.class));
                    }
                },3000);

            } else {
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        alertDialogUtil.setPositiveInterface(new AlertDialogUtil.PositiveInterface() {
                            @Override
                            public void setDialogPositiveButtonListener() {

                            }

                            @Override
                            public void setDialogNegetiveButtonListener() {

                            }
                        });
                        alertDialogUtil.showAlert(getResources().getString(R.string.login_username_password));
                        dialogUtil.closeDialog();
                    }
                }, 3000);
            }
            break;
            case R.id.tx_regist:
                sendCode(this);
                break;
        }
    }

    public void sendCode(Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country"); // 国家代码，如“86”
                    String phone = (String) phoneMap.get("phone"); // 手机号码，如“13800138000”
                    alertDialogUtil.setPositiveInterface(new AlertDialogUtil.PositiveInterface() {
                        @Override
                        public void setDialogPositiveButtonListener() {

                        }

                        @Override
                        public void setDialogNegetiveButtonListener() {

                        }
                    });
                    alertDialogUtil.showAlert(getResources().getString(R.string.regist_suceess));
                    // TODO 利用国家代码和手机号码进行后续的操作
                } else{
                    // TODO 处理错误的结果
                    alertDialogUtil.setPositiveInterface(new AlertDialogUtil.PositiveInterface() {
                        @Override
                        public void setDialogPositiveButtonListener() {

                        }

                        @Override
                        public void setDialogNegetiveButtonListener() {

                        }
                    });
                    alertDialogUtil.showAlert(getResources().getString(R.string.login_forgit));
                }
            }
        });
        page.show(context);
    }

}
