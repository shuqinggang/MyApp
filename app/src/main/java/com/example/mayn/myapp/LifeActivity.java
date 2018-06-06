package com.example.mayn.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mayn.myapp.MlogUtils.DialogUtil;

import java.util.List;

public class LifeActivity extends BaseActivity {

    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        List<String> list=bundle.getStringArrayList("lists");
        editText=(EditText)findViewById(R.id.et_phone);
        btn=(Button)findViewById(R.id.btn_phone);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(s.length()==13){

                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s == null || s.length() == 0) return;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (i != 3 && i != 8 && s.charAt(i) == ' ') {
                        continue;
                    } else {
                        sb.append(s.charAt(i));
                        if ((sb.length() == 4 || sb.length() == 9) && sb.charAt(sb.length() - 1) != ' ') {
                            sb.insert(sb.length() - 1, ' ');
                        }
                    }
                }
                if (!sb.toString().equals(s.toString())) {
                    int index = start + 1;
                    if (sb.charAt(start) == ' ') {
                        if (before == 0) {
                            index++;
                        } else {
                            index--;
                        }
                    } else {
                        if (before == 1) {
                            index--;
                        }
                    }
                    editText.setText(sb.toString());
                    editText.setSelection(index);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("phone",editText.getText().toString().trim());
                if(!isMobileNO(editText.getText().toString().trim())){
                    return;
                }
                if(!TextUtils.isEmpty(editText.getText().toString())){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+editText.getText().toString()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else {
                    Toast.makeText(LifeActivity.this,"请输入手机号码",Toast.LENGTH_LONG).show();
                }
            }
        });
        Log.e("LifeActivity",list.toString());
        Log.e("LifeActivity","onCreate");
    }

    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String str= mobiles.replaceAll(" " , "") ;
        String telRegex = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(str)) return false;
        else return str.matches(telRegex);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeActivity","onstart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeActivity","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeActivity","onDestroy");
    }
}
