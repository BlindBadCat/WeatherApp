package sample;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JSONPackParser {
    private JSONObject jsonObject;



    public JSONPackParser(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        //if (forecastType == 0) weatherCurrent();
        //else weatherForecast();
    }

    /**
     * Парсит переданный JSON пакет прогноза на текущий момент времени.
     * @return заполненный объект Weather на текущий момент времени.
     */
    public WeatherCurrent weatherCurrent(){
        WeatherCurrent weather = new WeatherCurrent();
        weather.setDate(new Date(Long.parseLong(jsonObject.get("dt").toString())*1000));
        weather.setCity(jsonObject.getString("name"));

        JSONObject jsonObjectMain = jsonObject.getJSONObject("main");


        weather.setTemp(Float.parseFloat(jsonObjectMain.get("temp").toString()));
        weather.setTemp_max(Float.parseFloat(jsonObjectMain.get("temp_max").toString()));
        weather.setTemp_min(Float.parseFloat(jsonObjectMain.get("temp_min").toString()));
        weather.setHumidity(Float.parseFloat(jsonObjectMain.get("humidity").toString()));
        weather.setPressure(Float.parseFloat(jsonObjectMain.get("pressure").toString()));

        JSONObject jsonObjectSys = jsonObject.getJSONObject("sys");
        weather.setSunrise(new Date(Long.parseLong(jsonObjectSys.get("sunrise").toString())*1000));
        weather.setSunset(new Date(Long.parseLong(jsonObjectSys.get("sunset").toString())*1000));

        JSONObject jsonObjectWeather = jsonObject.getJSONArray("weather").getJSONObject(0);
        weather.setSky(new Sky(jsonObjectWeather.get("description").toString(), jsonObjectWeather.getString("icon")));

        JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");

        weather.setWind(new Wind(Float.parseFloat(jsonObjectWind.get("speed").toString()), Float.parseFloat(jsonObjectWind.get("deg").toString())));







        return weather;
    }
    /**
     * Парсит переданный JSON пакет прогноза на 5 дней.
     * @return заполненный ArrayList<WeatherDay> массив в котором содержаться 5 дней с прогноззами.
     */
    public ArrayList<WeatherDay> weatherForecast() {

        ArrayList<Weather> aListDay1 = new ArrayList<>();
        ArrayList<Weather> aListDay2 = new ArrayList<>();
        ArrayList<Weather> aListDay3 = new ArrayList<>();
        ArrayList<Weather> aListDay4 = new ArrayList<>();
        ArrayList<Weather> aListDay5 = new ArrayList<>();



        JSONArray jsonArray = jsonObject.getJSONArray("list");
        for (int i = 0; i < jsonArray.length(); i++) {
            Weather weather = new Weather();

            JSONObject jsonObjectCurrent = (JSONObject) jsonArray.get(i);
            weather.setCalendar(getCalendarFromDTTXT(jsonObjectCurrent.get("dt_txt").toString()));


            JSONObject jsonObjectWeather = jsonObjectCurrent.getJSONArray("weather").getJSONObject(0);
            weather.setSky(new Sky(jsonObjectWeather.get("description").toString(), jsonObjectWeather.getString("icon")));

            JSONObject jsonObjectMain = jsonObjectCurrent.getJSONObject("main");


            weather.setTemp(Float.parseFloat(jsonObjectMain.get("temp").toString()));
            weather.setTemp_max(Float.parseFloat(jsonObjectMain.get("temp_max").toString()));
            weather.setTemp_min(Float.parseFloat(jsonObjectMain.get("temp_min").toString()));
            weather.setHumidity(Float.parseFloat(jsonObjectMain.get("humidity").toString()));
            weather.setPressure(Float.parseFloat(jsonObjectMain.get("pressure").toString()));

            JSONObject jsonObjectWind = jsonObjectCurrent.getJSONObject("wind");
            weather.setWind(new Wind(Float.parseFloat(jsonObjectWind.get("speed").toString()), Float.parseFloat(jsonObjectWind.get("deg").toString())));
            //System.out.println(weather);
            if (weather.getCalendar().get(Calendar.DAY_OF_MONTH) == new GregorianCalendar().get(Calendar.DATE))
                aListDay1.add(weather);
            if (weather.getCalendar().get(Calendar.DAY_OF_MONTH) == new GregorianCalendar().get(Calendar.DATE) + 1)
                aListDay2.add(weather);
            if (weather.getCalendar().get(Calendar.DAY_OF_MONTH) == new GregorianCalendar().get(Calendar.DATE) + 2)
                aListDay3.add(weather);
            if (weather.getCalendar().get(Calendar.DAY_OF_MONTH) == new GregorianCalendar().get(Calendar.DATE) + 3)
                aListDay4.add(weather);
            if (weather.getCalendar().get(Calendar.DAY_OF_MONTH) == new GregorianCalendar().get(Calendar.DATE) + 4)
                aListDay5.add(weather);



        }
        ArrayList<WeatherDay> wdList = new ArrayList<>();
        wdList.add(new WeatherDay(aListDay1));
        wdList.add(new WeatherDay(aListDay2));
        wdList.add(new WeatherDay(aListDay3));
        wdList.add(new WeatherDay(aListDay4));
        wdList.add(new WeatherDay(aListDay5));
        return wdList;
    }

        public static Calendar getCalendarFromDTTXT(String str){

            int year;
            int day;
            int month;
            int hour;
            int minute;
            int sec;
            Calendar calendar = new GregorianCalendar();
            year = Integer.parseInt(str.substring(0,4));
            month =  Integer.parseInt(str.substring(5,7)) - 1;
            day =  Integer.parseInt(str.substring(8,10));
            hour =  Integer.parseInt(str.substring(11,13));
            minute =  Integer.parseInt(str.substring(14,16));
            sec =  Integer.parseInt(str.substring(17,19));
            calendar.set(year, month, day, hour, minute, sec);
            //System.out.println(year +" "+ month +" "+ day +" "+ hour +" "+ minute+sec);
            //System.out.println(calendar.getTime());


            return calendar;
        }

        public String translatedString(){
        String s = null;

            String x = jsonObject.getJSONArray("text").toString();
            s = x.replaceAll("[\\[|\"|\\]]", "");


        return s;
        }
}
