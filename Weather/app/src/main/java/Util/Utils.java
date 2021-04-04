package Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.jar.JarException;

public class Utils {
    //public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=London&appid=0dc2282cddca5c4ae08e93149b576aa4";
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    //public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=0dc2282cddca5c4ae08e93149b576aa4";
    //public static final String BASE_ID_CODE = "0dc2282cddca5c4ae08e93149b576aa4";
    public static final String BASE_ID_CODE = "e9cac954e22f3ededfdbd28559d0ca0a";
    //public static final String ICON_URL = "https://openweathermap.org/img/w/";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return jObj;
    }

    public static String getString(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getString(tagName);
    }

    public static float getFloat(String tagName, JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    public static double getDouble(String tagName, JSONObject jsonObject) throws JSONException{
        return (float) jsonObject.getDouble(tagName);
    }

    public static int getInt(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getInt(tagName);
    }
}
