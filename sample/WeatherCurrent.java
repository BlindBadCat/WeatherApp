package sample;

import java.util.Date;

public class WeatherCurrent extends Weather {
    private Date sunset;
    private Date sunrise;

    public Date getSunset() {
        return sunset;
    }

    public void setSunset(Date sunset) {
        this.sunset = sunset;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }
}
