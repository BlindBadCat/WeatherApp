package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import sample.Translator.TransMain;

//

public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("changeCity.fxml"));
        primaryStage.setTitle("Погода");
        primaryStage.setScene(new Scene(root, 336, 166));

        primaryStage.show();
        primaryStage.setResizable(false);



    }


    public static void main(String[] args) {
        launch(args);




    }

}
