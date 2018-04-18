package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.JSONObject;
import sample.Translator.TransMain;

public class ChangeCityController {

    public static String rusCity;

    public String getRusCity(){
        return rusCity;
    }

    public  String getCity() {
        return city;
    }

    public static String city;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonShow;

    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField textField;



    @FXML
    void initialize() {
        buttonShow.setOnAction(event -> {
            buttonShow.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();

            JSONObject jsonObject1 = new JSONObject(new TransMain("en", textField.getCharacters().toString()).getTranslatedString());
            rusCity = textField.getCharacters().toString();
            JSONPackParser jsonPackParser = new JSONPackParser(jsonObject1);


            this.city = jsonPackParser.translatedString();


            loader.setLocation(getClass().getResource("sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root1 = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 490, 165));
            stage.setResizable(false);
            stage.showAndWait();


        });

    }
}
