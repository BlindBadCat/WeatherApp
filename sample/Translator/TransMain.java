package sample.Translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TransMain {

    private String adr;
    private URL url = null;
    private HttpURLConnection conn = null;
    private BufferedReader br = null;
    private String str;
    private StringBuilder s = new StringBuilder("");
    private String api = "trnsl.1.1.20180417T162835Z.ee57ccfdbed47d72.ef77b2b2453e01bab04ca5afd326dd0d3f0bccd9";
    private String string;
    private String language;

    //https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + api + "&text=" + string +"lang="+ language"

    public TransMain(String language, String string) {
        this.string = string;
        this.language = language;
        this.adr = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + api + "&text=" + string +"&lang="+ language;
        System.out.println(adr);
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

    public String getTranslatedString(){
        return s.toString();
    }
}