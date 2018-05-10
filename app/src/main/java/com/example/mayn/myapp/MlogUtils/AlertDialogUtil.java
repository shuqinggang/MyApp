package  com.example.mayn.myapp.MlogUtils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


/**
 * Created by mayn on 2018/5/2.
 */

public class AlertDialogUtil {
    Context mContext;
    PositiveInterface positiveInterface;
    public AlertDialogUtil(Context mContext) {
        this.mContext = mContext;
    }

    public void setPositiveInterface(PositiveInterface positiveInterface) {
        this.positiveInterface = positiveInterface;
    }

    public void showAlert(String message){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(mContext);
        alertDialog.setTitle("提示");
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                positiveInterface.setDialogPositiveButtonListener();
               // LogUtil.e("AlertDialogUtil","setPositiveButton");
            }
        });
       alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               positiveInterface.setDialogNegetiveButtonListener();
             //  LogUtil.e("AlertDialogUtil","setNegativeButton");
           }
       });
       alertDialog.show();
    }

    public interface PositiveInterface{
        void setDialogPositiveButtonListener();
        void setDialogNegetiveButtonListener();
    }
}
