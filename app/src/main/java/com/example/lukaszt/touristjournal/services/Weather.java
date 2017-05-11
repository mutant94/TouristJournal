package com.example.lukaszt.touristjournal.services;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.lukaszt.touristjournal.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lukaszt on 06.04.2017.
 */

public class Weather extends AsyncTask<String, Void, String> {

    public final static String ERROR_STRING = "Error";
    private Activity activity;

    public Weather(Activity activity){
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.w("Weather", "working start");
        //dynamictext = (TextView) findViewById(R.id.dynamictext);
    }

    public String getURL(double latitude, double longitude){
        return "http://api.openweathermap.org/data/2.5/weather?lat="+ latitude +"&lon="+longitude+"&APPID=713a1e959a1e201e656066d227e7e6e5";
    }

    @Override
    protected String doInBackground(String... urls) {
        Log.w("Weather", "get Weather");
        HttpURLConnection connection = null;
        try{
            URL url = new URL(urls[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            return sb.toString();
        }catch (Exception ex){
            ex.printStackTrace();
            return ERROR_STRING;
        }finally {
            if (connection != null) {
                try {
                    connection.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onPostExecute(String resultWeather) {
        super.onPostExecute(resultWeather);
        Log.w("Weather", "working get JSON");
        try {
            JSONObject mainJSONObject = new JSONObject(resultWeather);
            String temperatureName= activity.getResources().getString(R.string.Temperature);
            JSONObject main = mainJSONObject.getJSONObject("main");
            String temperature = main.getString("temp");
            JSONArray array = mainJSONObject.getJSONArray("weather");
            JSONObject object = array.getJSONObject(0);
            String mainWeather = object.getString("main");
            String textWeather = activity.getResources().getString(R.string.Weather);
            String mainWeatherText = "";
            switch (mainWeather){
                case "Thunderstorm":
                    mainWeatherText = activity.getResources().getString(R.string.Thunderstorm);
                    break;
                case "Drizzle":
                    mainWeatherText = activity.getResources().getString(R.string.Drizzle);
                    break;
                case "Rain":
                    mainWeatherText = activity.getResources().getString(R.string.Rain);
                    break;
                case "Snow":
                    mainWeatherText = activity.getResources().getString(R.string.Snow);
                    break;
                case "Atmosphere":
                    mainWeatherText = activity.getResources().getString(R.string.Atmosphere);
                    break;
                case "Clear":
                    mainWeatherText = activity.getResources().getString(R.string.Clear);
                    break;
                case "Clouds":
                    mainWeatherText = activity.getResources().getString(R.string.Clouds);
                    break;
                case "Extreme":
                    mainWeatherText = activity.getResources().getString(R.string.Extreme);
                    break;
            }
            double temperatureValue = Double.valueOf(temperature);
            temperatureValue -= 273.13;
            temperatureValue = Math.round(temperatureValue);
            String weather = mainWeatherText + " " + temperatureName + ": " + temperatureValue + "*C" ;
            TextView textView = (TextView) activity.findViewById(R.id.menu_place_weather_info);
            textView.setText(weather);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
