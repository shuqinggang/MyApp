package com.example.mayn.myapp.NetworkUtils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by shuqinggang on 2018/7/23.
 */

public class BitmapUtil {
    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
                 // 源图片的高度和宽度
                 final int height = options.outHeight;
                 final int width = options.outWidth;
                 int inSampleSize = 1;
                 if (height > reqHeight || width > reqWidth) {
                      final int halfHeight = height / 2;
                         final int halfWidth = width / 2;
                         // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                        // height and width larger than the requested height and width.
                         while ((halfHeight / inSampleSize) > reqHeight
                                 && (halfWidth / inSampleSize) > reqWidth) {
                                 inSampleSize *= 2;
                             }
                    }


        //获取原始图片
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pic);
//        Log.d("AchillesL","origin width: " + bitmap.getWidth() + " origin height: " + bitmap.getHeight());
//
//        Matrix matrix = new Matrix();
////将图片宽度缩放到150像素
//        float scale = (float) (150.0 / bitmap.getWidth());
////宽高等比例缩放
//        matrix.postScale(scale,scale);
//        Bitmap resultBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
//        Log.d("AchillesL","width: " + resultBitmap.getWidth() + " height: " + resultBitmap.getHeight());

                 return inSampleSize;
             }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
                 final BitmapFactory.Options options = new BitmapFactory.Options();
                 options.inJustDecodeBounds = true; // 设置成了true,不占用内存，只获取bitmap宽高
                 BitmapFactory.decodeResource(res, resId, options); // 读取图片长款
                 options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight); // 调用上面定义的方法计算inSampleSize值
                 // 使用获取到的inSampleSize值再次解析图片
                 options.inJustDecodeBounds = false;
                 Bitmap src = BitmapFactory.decodeResource(res, resId, options); // 载入一个稍大的缩略图
                 Log.e("AAAAAAAAAAA",src.getByteCount()+"");

                 return createScaleBitmap(src, reqWidth, reqHeight, options.inSampleSize); // 进一步得到目标大小的缩略图

             }

    private static Bitmap createScaleBitmap(Bitmap src, int dstWidth, int dstHeight, int inSampleSize) {
                 //如果inSampleSize是2的倍数，也就说这个src已经是我们想要的缩略图了，直接返回即可。
                 if (inSampleSize % 2 == 0) {
                         return src;
                     }
                 // 如果是放大图片，filter决定是否平滑，如果是缩小图片，filter无影响，我们这里是缩小图片，所以直接设置为false
                 Bitmap dst = Bitmap.createScaledBitmap(src, dstWidth, dstHeight, false);
                 if (src != dst) { // 如果没有缩放，那么不回收
                         src.recycle(); // 释放Bitmap的native像素数组
                     }
                 Log.e("AAAAAAAAAAA",dst.getByteCount()+"");
                 return dst;
             }

     public static Bitmap decodeSampledBitmapFromFile(String pathName, int reqWidth, int reqHeight) {
                 final BitmapFactory.Options options = new BitmapFactory.Options();
                 options.inJustDecodeBounds = true;
                 BitmapFactory.decodeFile(pathName, options);
                 options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
                 options.inJustDecodeBounds = false;
                 Bitmap src = BitmapFactory.decodeFile(pathName, options);
                 return createScaleBitmap(src, reqWidth, reqHeight, options.inSampleSize);
             }


}
