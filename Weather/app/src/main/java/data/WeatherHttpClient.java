package data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.Utils;

public class WeatherHttpClient {
    public String getWeatherData(String place) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            String id = Utils.BASE_URL + place + Utils.BASE_ID_CODE;

            connection = (HttpURLConnection) (new URL(id)).openConnection(); //connect to API link
            //connection = (HttpURLConnection) (new URL("https://api.openweathermap.org/data/2.5/weather?q=Bangkok&appid=0dc2282cddca5c4ae08e93149b576aa4")).openConnection();
            //connection = (HttpURLConnection) (new URL("https://www.google.co.th/")).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoInput(true);
            connection.connect();
            Log.d("myClient", "ID: " + Utils.BASE_ID_CODE);

            //Read the response
            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            Log.d("myClient", Utils.BASE_URL + place + Utils.BASE_ID_CODE);


            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\r\n");
            }

            inputStream.close();
            connection.disconnect();

            return  stringBuffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
