package com.app.weather;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import Util.Utils;
import data.CityPreference;
import data.JSONWeatherParser;
import data.WeatherHttpClient;
import model.Weather;

public class MainActivity extends AppCompatActivity {

    private TextView cityName;
    private TextView temp;
    private ImageView iconView;
    private TextView description;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;
    private TextView sunrise;
    private TextView sunset;
    private TextView updated;

    Weather weather = new Weather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (TextView) findViewById(R.id.cityText);
        iconView = (ImageView) findViewById(R.id.thumbnailIcon);
        temp = (TextView) findViewById(R.id.tempText);
        description = (TextView) findViewById(R.id.cloudText);
        humidity = (TextView) findViewById(R.id.humidText);
        pressure = (TextView) findViewById(R.id.pressureText);
        wind = (TextView) findViewById(R.id.windText);
        sunrise = (TextView) findViewById(R.id.riseText);
        sunset = (TextView) findViewById(R.id.setText);
        updated = (TextView) findViewById(R.id.updateText);

        CityPreference cityPreference = new CityPreference(MainActivity.this);

        Log.d("my", "cityPreference.getCity(): " + cityPreference.getCity());
        renderWeatherData("Bangkok");
        //renderWeatherData(cityPreference.getCity());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    public void renderWeatherData( String city ){
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(new String[]{city + "&appid="});
    }

/*
    private class DownloadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            iconView.setImageBitmap(bitmap);
            //super.onPostExecute(bitmap);
        }


        @Override
        protected Bitmap doInBackground(String... params) {
            return downloadImage(params[0]);
        }



        private Bitmap downloadImage(String code) {
            final DefaultHttpClient client = new DefaultHttpClient();

            final HttpGet getRequest = new HttpGet(Utils.ICON_URL + code + ".png");
            //final HttpGet getRequest = new HttpGet("https")

            try {
                HttpResponse response = client.execute(getRequest);
                final int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode != HttpStatus.SC_OK) {
                    Log.e("DownloadImage", "Error" + statusCode);
                    return null;
            }
                final HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream inputStream = null;
                    inputStream = entity.getContent();

                    //decent contents from the stream
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }




    }

     */


    private class WeatherTask extends AsyncTask<String, Void, Weather>{

        @Override
        protected Weather doInBackground(String... params) {

            Log.d("my", params[0]);
            String data = ((new WeatherHttpClient()).getWeatherData(params[0]));

            //Log.d("my", "weather.iconData: " + weather.iconData);
            Log.d("my", "text: " + data);

            if (data != null) {
                weather = JSONWeatherParser.getWeather(data);
                Log.v("Data: ", weather.place.getCity());
            }


            //new DownloadImageAsyncTask().execute(weather.iconData);
            return weather;

        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            /*
            DateFormat df = DateFormat.getDateInstance();

            String sunriseDate = df.format(new Date(weather.place.getSunrise()));
            String sunsetDate = df.format(new Date(weather.place.getSunset()));
            String updateDate = df.format(new Date(weather.place.getLastupdate()));

             */

            //weather.currentCondition.setIcon("50n");

            weather.iconData = weather.currentCondition.getIcon();
            Log.d("my", "icon: " + weather.iconData);

            switch (weather.iconData) {
                case "01d" :
                    iconView.setImageResource(R.drawable.icon01d_2x);
                    break;
                case "02d" :
                    iconView.setImageResource(R.drawable.icon02d_2x);
                    break;
                case "03d" :
                    iconView.setImageResource(R.drawable.icon03d_2x);
                    break;
                case "04d" :
                    iconView.setImageResource(R.drawable.icon04d_2x);
                    break;
                case "09d" :
                    iconView.setImageResource(R.drawable.icon09d_2x);
                    break;
                case "10d" :
                    iconView.setImageResource(R.drawable.icon10d_2x);
                    break;
                case "11d" :
                    iconView.setImageResource(R.drawable.icon11d_2x);
                    break;
                case "13d" :
                    iconView.setImageResource(R.drawable.icon13d_2x);
                    break;
                case "50d" :
                    iconView.setImageResource(R.drawable.icon50d_2x);
                    break;

                case "01n" :
                    iconView.setImageResource(R.drawable.icon01n_2x);
                    break;
                case "02n" :
                    iconView.setImageResource(R.drawable.icon02n_2x);
                    break;
                case "03n" :
                    iconView.setImageResource(R.drawable.icon03n_2x);
                    break;
                case "04n" :
                    iconView.setImageResource(R.drawable.icon04n_2x);
                    break;
                case "09n" :
                    iconView.setImageResource(R.drawable.icon09n_2x);
                    break;
                case "10n" :
                    iconView.setImageResource(R.drawable.icon10n_2x);
                    break;
                case "11n" :
                    iconView.setImageResource(R.drawable.icon11n_2x);
                    break;
                case "13n" :
                    iconView.setImageResource(R.drawable.icon13n_2x);
                    break;
                case "50n" :
                    iconView.setImageResource(R.drawable.icon50n_2x);
                    break;
            }



            Date sunriseDf = new java.util.Date(weather.place.getSunrise() * 1000);
            String sunriseDate = new SimpleDateFormat("dd MMMM, yyyy - hh:mm a").format(sunriseDf);
            Date sunsetDf = new java.util.Date(weather.place.getSunset() * 1000);
            String sunsetDate = new SimpleDateFormat("dd MMMM, yyyy - hh:mm a").format(sunsetDf);
            Date updateDf = new java.util.Date(weather.place.getLastupdate() * 1000);
            String updateDate = new SimpleDateFormat("hh:mm a").format(updateDf);

            DecimalFormat decimalFormat  = new DecimalFormat("#.#");

            String tempFormat  = decimalFormat.format(weather.currentCondition.getTemperature() - 273);
            Log.d("my", "temp: " + temp.getText());

            cityName.setText(weather.place.getCity() + ", " +  weather.place.getCountry());
            temp.setText("" + tempFormat + " °C");
            humidity.setText("Humidity\t\t: \t" + weather.currentCondition.getHumid() + "%");
            pressure.setText("Pressure\t\t: \t" + weather.currentCondition.getPressure() + " hPa" );
            wind.setText("Wind\t\t\t\t\t\t: \t" + weather.wind.getSpeed() + " mps" );
            sunrise.setText("Sunrise\t\t\t\t: \t" + sunriseDate );
            sunset.setText("Sunset\t\t\t\t: \t" + sunsetDate );
            updated.setText("Last Updated\t: \t" + updateDate);
            description.setText("Condition\t\t: \t" + weather.currentCondition.getCondition() + " (" + weather.currentCondition.getDescription() +")");

            //renderWeatherData("Bangkok");
        }
    }

    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Change City");

        final EditText cityInput = new EditText(MainActivity.this);
        cityInput.setInputType((InputType.TYPE_CLASS_TEXT));
        cityInput.setHint("Bangkok");
        builder.setView(cityInput);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CityPreference cityPreference = new CityPreference(MainActivity.this);
                cityPreference.setCity(cityInput.getText().toString());

                String newCity = cityPreference.getCity();

                renderWeatherData(newCity);
            }
        });
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            showInputDialog();
        }

        return super.onOptionsItemSelected(item);
    }
}
