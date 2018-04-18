package sample;

import org.json.JSONObject;

import java.util.ArrayList;

public class WeatherForecast {
    private WeatherCurrent current;
    private ArrayList<WeatherDay> weatherDays;
    private String forecastType;
    private String city;
    private JSONObject jsonObject;
    private JSONObject jsonObjectForecast;


    public ArrayList<WeatherDay> getWeatherDays() {
        return weatherDays;
    }

    public void setWeatherDays(ArrayList<WeatherDay> weatherDays) {
        this.weatherDays = weatherDays;
    }

    public WeatherCurrent getCurrent() {
        return current;
    }

    public void setCurrent(WeatherCurrent current) {
        this.current = current;
    }

    public WeatherForecast(String city) {

        this.city = city;
        this.jsonObject = new JSONObject(new WeatherString(this.city, "weather").getWeatherString());
        this.jsonObjectForecast = new JSONObject(new WeatherString(this.city, "forecast").getWeatherString());


        JSONPackParser jsonPackParser = new JSONPackParser(jsonObject);
        this.current = jsonPackParser.weatherCurrent();

       JSONPackParser jsonPackParserForecast = new JSONPackParser(jsonObjectForecast);
        this.weatherDays = jsonPackParserForecast.weatherForecast();

    }
}
