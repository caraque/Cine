package bean;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;

/**
 * Created by Christian on 13-04-2015.
 */
public class SalaCineBean {

    public String consultarSala() {
       String archivo = null;
        try {

            JsonParser parser = new JsonParser();
            FileReader fr = new FileReader("C:\\Sala.json");
            JsonElement datos = parser.parse(fr);
            archivo = String.valueOf(datos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("linea = " + archivo);
        return archivo;
    }
}
