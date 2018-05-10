package  com.example.mayn.myapp.NetworkUtils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mayn on 2018/5/9.
 */

public class SharePrefreUtils {
    public static final int TYPE_NO = 0;
    public static final int TYPE_ACCOUNT = 1;
    public static final int TYPE_FACEBOOK = 2;
    private static final String NAME = "BaseTool_p";
    private static final String ACCOUNT = "account";
    private static final String PASSWORD = "password";
    private static SharedPreferences sharedPreferences;

    public static void inite(Context mCon){
        if(sharedPreferences==null){
            sharedPreferences=mCon.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        }
    }

    public static void savaUserInfor(String username,String password){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(ACCOUNT,username);
        editor.putString(PASSWORD,password);
        editor.commit();
    }

    public static void clearUserInfor(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(ACCOUNT,"");
        editor.putString(PASSWORD,"");
        editor.commit();
    }

    public static String getAccount(){
        return sharedPreferences.getString(ACCOUNT,"");
    }

    public static String getPassword(){
        return sharedPreferences.getString(PASSWORD,"");
    }


}
