package data;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.Place;
import model.Weather;

public class JSONWeatherParser {
    public static Weather getWeather(String data){
        Weather weather = new Weather();
        //create JsonObject from data
        try {
            JSONObject jsonObject = new JSONObject(data);

            Place place = new Place();

            JSONObject coordObj = Utils.getObject("coord", jsonObject);
            place.setLat(Utils.getFloat("lat", coordObj));
            place.setLat(Utils.getFloat("lon",  coordObj));

            Log.d("myWeather", "coord: " + coordObj);

            //Get the sys obj
            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            place.setCountry(Utils.getString("country",sysObj));
            place.setLastupdate(Utils.getInt("dt", jsonObject));
            place.setSunrise(Utils.getInt("sunrise", sysObj));
            place.setSunset(Utils.getInt("sunset", sysObj));
            place.setCity(Utils.getString("name", jsonObject));
            weather.place = place;

            Log.d("myWeather", "sys: " + sysObj);

            //Get the weather info
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            weather.currentCondition.setWeatherId(Utils.getInt("id", jsonWeather));
            weather.currentCondition.setDescription(Utils.getString("description", jsonWeather));
            weather.currentCondition.setCondition(Utils.getString("main", jsonWeather));
            weather.currentCondition.setIcon(Utils.getString("icon", jsonWeather));

            Log.d("myWeather", "jsonArray: " + jsonArray);

            JSONObject mainObj = Utils.getObject("main", jsonObject);
            weather.currentCondition.setHumid(Utils.getInt("humidity", mainObj));
            weather.currentCondition.setPressure(Utils.getInt("pressure", mainObj));
            weather.currentCondition.setMinTemp(Utils.getFloat("temp_min", mainObj));
            weather.currentCondition.setMaxTemp(Utils.getFloat("temp_max", mainObj));
            weather.currentCondition.setTemperature(Utils.getDouble("temp", mainObj));

            Log.d("myWea", "mainObj: " + mainObj);

            JSONObject windObj = Utils.getObject("wind", jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed", windObj));
            weather.wind.setDeg(Utils.getFloat("deg", windObj));

            Log.d("myWeather", "windObj: " + windObj);

            //Set up clouds
            JSONObject cloudObj = Utils.getObject("clouds", jsonObject);
            weather.clouds.setPrecipitation((Utils.getInt("all", cloudObj)));

            return weather;

        }catch (JSONException e){
            e.printStackTrace();

            return null;
        }
    }
}
