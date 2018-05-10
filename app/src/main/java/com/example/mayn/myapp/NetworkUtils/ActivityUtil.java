package  com.example.mayn.myapp.NetworkUtils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayn on 2018/5/2.
 */

public class ActivityUtil {

    public static final int PERMISSION_CODE = 31110;
    public static final int PERMISSION_CODE_OTHER = 31111;
    public static final int PERMISSION_CODE_SMS = 31112;

    public static final String[] permissions = new String[]{Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
    };

    public static final String[] SMSPermissions = new String[]{
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.SEND_SMS};

    /**
     * 必要权限
     * 获取读取手机状态权限
     * 获取写入权限
     * 获取摄像头和录音权限
     */
    public static boolean hasPermissions(Activity activity) {
        List<String> needList = findDeniedPermissions(activity);
        if (needList.size() > 0) {
            ActivityCompat.requestPermissions(activity, needList.toArray(new String[needList.size()]), PERMISSION_CODE);
            return false;
        } else {
            return true;
        }
    }

    public static List<String> findDeniedPermissions(Activity activity) {
        List<String> denyPermissions = new ArrayList<>();
        for (String value : permissions) {
            if (ContextCompat.checkSelfPermission(activity, value) != PackageManager.PERMISSION_GRANTED) {
                denyPermissions.add(value);

            }
        }
        return denyPermissions;
    }

    public static boolean hasSMSPermissions(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, SMSPermissions, PERMISSION_CODE_SMS);
        //    Mlog.e("没有通讯录权限");
            return false;
        } else if (ContextCompat.checkSelfPermission(activity, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, SMSPermissions, PERMISSION_CODE_SMS);
      //      Mlog.e("没有SMS权限");
            return false;
        } else {
            return true;
        }
    }

    /**
     * 其他权限
     *
     * @param activity
     * @param permission
     * @return
     */
    public static boolean hasPermissions(Activity activity, String permission) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{permission}, PERMISSION_CODE_OTHER);
            return false;
        } else {
            return true;
        }
    }
}
