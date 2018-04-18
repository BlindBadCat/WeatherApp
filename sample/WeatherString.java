package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class WeatherString{
    private String adr;
    private URL url = null;
    private HttpURLConnection conn = null;
    private BufferedReader br = null;
    private String str;
    private StringBuilder s = new StringBuilder("");
    private String api = "d64eeb5b7d9844df04f273277e16f849";
    private String city;
    private String forecastType;


    public WeatherString(String city, String forecastType) {
        this.city = city;
        this.forecastType = forecastType;
        this.adr = "http://api.openweathermap.org/data/2.5/" + forecastType +"?q=" + city + "&units=metric&APPID=" + api;
        try {
            getJSONPack();
        } catch (IOException e) {
            System.out.println("Город не найден");
        }
    }

    public void getJSONPack() throws IOException {
        url = new URL(adr); //создаем URL
        conn = (HttpURLConnection)url.openConnection(); //открываем соединение
        br = new BufferedReader(new InputStreamReader(
                conn.getInputStream())
        ); // используем объект класса BufferedReader для работы со строками
        while((str = br.readLine()) != null){ // пока не достигнут конец, считываем страницу построчно

            s.append(str);

        }
        br.close(); //закрываем поток
    }

    public String getWeatherString(){
        return s.toString();
    }
}