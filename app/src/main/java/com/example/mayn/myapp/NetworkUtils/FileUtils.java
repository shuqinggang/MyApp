package  com.example.mayn.myapp.NetworkUtils;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mayn on 2018/5/3.
 */

public class FileUtils {
    public static String fileName="DB.txt";
    public static String filePath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/BaseTools/";

    /**
     * 将str存放到文件中
     * @param filePath 文件地址
     * @param fileName 文件名
     * @param content  输入字符串
     */
    public static void savaFile(String filePath,String fileName,String content){
        File dir=new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        FileOutputStream fileOutputStream=null;
        File file=new File(filePath+fileName);
        try {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                fileOutputStream = new FileOutputStream(file);
                byte[] bytes = content.getBytes();
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将str存放到文件中
     * @param filePath 文件地址
     * @param fileName 文件名
     * @param content  输入字符串
     */
    public static void savaFile1(String filePath,String fileName,String content){
        BufferedWriter bufferedWriter=null;
        File dir=new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file=new File(filePath+fileName);
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            try {
                bufferedWriter=new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
               if(bufferedWriter!=null){
                   try {
                       bufferedWriter.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
            }

        }
    }

    /**
     *
     * @param filePath 文件地址
     * @return 获取文本中的内容
     */
    public static String getStringFromFile(String filePath){
        StringBuilder content=new StringBuilder();
        BufferedReader bufferedReader=null;
        File file=new File(filePath);
        if(!file.exists()){
            return  null;
        }
        String line;
        try {
            bufferedReader =new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null) {
                   content=content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
    public static String getFilePath(){
       return null;
    }
}
