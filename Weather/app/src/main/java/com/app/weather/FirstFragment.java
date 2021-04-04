package com.app.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

import model.Weather;

public class FirstFragment extends Fragment {
/*
    private TextView temp;
    private ImageView iconView;
    private TextView description;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;
    private TextView sunrise;
    private TextView sunset;
*/
    /*
    @Override
    public void onActivityCreated(){
        super.onActivityCreated();
        ((MainActivity)this.getActivity()).getWeather();
    }*/


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    /*
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        Weather weather = ((MainActivity)this.getActivity()).getWeather();

        iconView = (ImageView) getView().findViewById(R.id.thumbnailIcon);
        temp = (TextView) getView().findViewById(R.id.tempText);
        description = (TextView) getView().findViewById(R.id.cloudText);
        humidity = (TextView) getView().findViewById(R.id.humidText);
        pressure = (TextView) getView().findViewById(R.id.pressureText);
        wind = (TextView) getView().findViewById(R.id.windText);
        sunrise = (TextView) getView().findViewById(R.id.riseText);
        sunset = (TextView) getView().findViewById(R.id.setText);


        DateFormat df = DateFormat.getDateInstance();
        String sunriseDate = df.format(new Date(weather.place.getSunrise()));
        String sunsetDate = df.format(new Date(weather.place.getSunset()));

        DecimalFormat decimalFormat  = new DecimalFormat("#.#");
        String tempFormat  = decimalFormat.format(weather.currentCondition.getTemperature());

        temp.setText("" + tempFormat + "C");
        humidity.setText("Humidity: " + weather.currentCondition.getHumid() + "%");
        pressure.setText("Pressure: " + weather.currentCondition.getPressure() + "hPa" );
        wind.setText("Wind : " + weather.wind.getSpeed() + "mps" );
        sunrise.setText("Sunrise: " + sunriseDate );
        sunset.setText("Sunset: " + sunsetDate );
        description.setText("Condition: " + weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescription() +")");

    }

 */

/*
    private class WeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            DateFormat df = DateFormat.getDateInstance();
            String sunriseDate = df.format(new Date(weather.place.getSunrise()));
            String sunsetDate = df.format(new Date(weather.place.getSunset()));

            DecimalFormat decimalFormat  = new DecimalFormat("#.#");
            String tempFormat  = decimalFormat.format(weather.currentCondition.getTemperature());



            temp.setText("" + tempFormat + "C");
            humidity.setText("Humidity: " + weather.currentCondition.getHumid() + "%");
            pressure.setText("Pressure: " + weather.currentCondition.getPressure() + "hPa" );
            wind.setText("Wind : " + weather.wind.getSpeed() + "mps" );
            sunrise.setText("Sunrise: " + sunriseDate );
            sunset.setText("Sunset: " + sunsetDate );
            description.setText("Condition: " + weather.currentCondition.getCondition() + "(" + weather.currentCondition.getDescription() +")");
        }
    }
*/

}
