package sample;

import java.util.ArrayList;

public class WeatherDay {
    private ArrayList<Weather> weatherList;

    public WeatherDay(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public ArrayList<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}
