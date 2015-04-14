package bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Christian on 13-04-2015.
 */
public class SalaCineBean {

    public String consultarSala() {
       String archivo = null;
        try {
            File file = new File("C:\\Sala.txt");
            FileReader archivoSalas = new FileReader(file);
            BufferedReader bf = new BufferedReader(archivoSalas);
            archivo = bf.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("linea = " + archivo);
        return archivo;
    }

}
