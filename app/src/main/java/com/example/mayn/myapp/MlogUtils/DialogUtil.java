package  com.example.mayn.myapp.MlogUtils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by mayn on 2018/5/2.
 */

public class DialogUtil {
    Context mContext;
    ProgressDialog progressDialog;

    public DialogUtil(Context mContext) {
        this.mContext = mContext;
    }

    public  void creatDialog(String message){
        if(progressDialog==null) {
            progressDialog = new ProgressDialog(mContext);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
        }
    }
    public void showDialog(){
        if(progressDialog!=null){
            progressDialog.show();
        }
    }

    public  void closeDialog(){
        if(progressDialog!=null){
            progressDialog.cancel();
        }
    }

}
