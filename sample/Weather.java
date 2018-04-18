package sample;

import java.util.Calendar;
import java.util.Date;

public class Weather {
    private float temp;
    private float temp_min;
    private float temp_max;
    private float humidity;
    private float pressure;
    private String city;
    private Wind wind;
    private Sky sky;
    private Date date;
    private Calendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Weather(){
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sky getSky() {
        return sky;
    }

    public void setSky(Sky sky) {
        this.sky = sky;
    }




   /* @Override
    public String toString() {
        return
                "Температура = " + temp + "\n" +
                "Мин. темп. = " + temp_mim +"\n" +
                "Макс. темп. = " + temp_max +"\n" +
                "Влажность = " + humidity + "%" +"\n" +
                "Давление = " + pressure
                ;
    }*/


}
