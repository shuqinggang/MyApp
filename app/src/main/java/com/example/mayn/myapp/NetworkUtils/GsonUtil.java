package  com.example.mayn.myapp.NetworkUtils;

import com.google.gson.Gson;

/**
 * Created by mayn on 2018/5/9.
 */

public class GsonUtil {
    //将Json数据解析成相应的映射对象
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }

    //将对象转换成Json数据
    public static String toJsonString(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
