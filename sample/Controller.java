package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import javafx.scene.control.*;




public class Controller {
    private static WeatherForecast weatherForecast;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text dayRD;

    @FXML
    private Text sunrise;

    @FXML
    private Text humTorday;

    @FXML
    private ImageView weatherIcon;

    @FXML
    private Text mornigTMR;

    @FXML
    private Text morningRD;

    @FXML
    private Text evRD;

    @FXML
    private Button changeButton;

    @FXML
    private Text dayTMR;

    @FXML
    private Text header;

    @FXML
    private Text evTMR;

    @FXML
    private Text tempTorday;

    @FXML
    private Text pressTorday;

    @FXML
    private Text sunset;

    @FXML
    private Text wind;

    @FXML
    void initialize() {
        weatherForecast =  new WeatherForecast(ChangeCityController.city);


        header.setText("Погода в городе " + ChangeCityController.rusCity);


        if (weatherForecast.getCurrent().getTemp()>0)
            tempTorday.setText(String.format( "%s%.0f" ,"+", weatherForecast.getCurrent().getTemp()) + "\u00B0");
        else if (weatherForecast.getCurrent().getTemp()==0)
            tempTorday.setText(String.format( "%.0f" , weatherForecast.getCurrent().getTemp()) + "\u00B0");
        else tempTorday.setText(String.format( "%s%.0f" ,"-", weatherForecast.getCurrent().getTemp()) + "\u00B0");


        System.out.println(weatherForecast.getCurrent().getSky().getDesck());
        System.out.println(weatherForecast.getCurrent().getSky().getIconType());

        humTorday.setText(String.format("%.0f", weatherForecast.getCurrent().getHumidity())+"%");
        double press =  weatherForecast.getCurrent().getPressure() / 1.33;
        pressTorday.setText((String.format("%.0f", press)) + " мм рт. ст." );
        wind.setText(String.format("%.1f", weatherForecast.getCurrent().getWind().getSpeed()) + " м/с");

        mornigTMR.setText(String.format( "%.0f" , weatherForecast.getWeatherDays().get(2).getWeatherList().get(3).getTemp())+ "\u00B0");
        dayTMR.setText(String.format( "%.0f" , weatherForecast.getWeatherDays().get(2).getWeatherList().get(5).getTemp())+ "\u00B0");
        evTMR.setText(String.format( "%.0f" , weatherForecast.getWeatherDays().get(2).getWeatherList().get(7).getTemp())+ "\u00B0");

       morningRD.setText(String.format( "%.0f" , weatherForecast.getWeatherDays().get(3).getWeatherList().get(3).getTemp())+ "\u00B0");
       dayRD.setText(String.format( "%.0f" , weatherForecast.getWeatherDays().get(3).getWeatherList().get(5).getTemp())+ "\u00B0");
       evRD.setText(String.format( "%.0f" , weatherForecast.getWeatherDays().get(3).getWeatherList().get(7).getTemp())+ "\u00B0");
       Image image = null;
        try(InputStream reader = new FileInputStream("C:\\Users\\Плотва\\IdeaProjects\\Weather\\src\\sample\\img\\" + weatherForecast.getCurrent().getSky().getIconType() + ".png")){
            image = new Image(reader);
        }
        catch (IOException e ){
            e.printStackTrace();
        }
        System.out.println();

       weatherIcon.setImage(image);

    }

//  "@img/" + String.format("%s", weatherForecast.getCurrent().getSky().getIconType())+ ".png"


}
