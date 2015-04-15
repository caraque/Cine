package controlador;

import bean.SalaCineBean;
import com.google.gson.Gson;
import dto.Room;
import dto.Seat;

import java.util.ArrayList;

/**
 * Created by Christian on 13-04-2015.
 */
public class ConsultaSalaCine {

    private int cantidadButacas;
    //private enum avaliabe{D, P, F};
    public ArrayList<Object> consultarSalaBean() {

        Gson gson = new Gson();
        ArrayList<Object> object = new ArrayList<Object>();
        ArrayList<Integer> fila = new ArrayList<Integer>();
        ArrayList<Integer> columna = new ArrayList<Integer>();
        SalaCineBean salaCineBean = new SalaCineBean();
        String archivoSalas = salaCineBean.consultarSala();
        Room room= gson.fromJson(archivoSalas,Room.class);
        System.out.println("room.getFrom() = " + room.getFrom());
        for(Seat filaTemp:room.getSeats()){
            fila.add(filaTemp.getRow());
            columna.add(filaTemp.getColumn());
        }
        System.out.println(room.toString());
        object.add(room);
        object.add(fila);
        object.add(columna);
        System.out.println("fila = " + fila);
        System.out.println("columna = " + columna);
        cantidadButacas = room.getTo() > 1 ? room.getTo() - room.getFrom() + 1 : room.getTo() - room.getFrom();

        return object;
    }

    public int getCantidadButacas() {
        return cantidadButacas;
    }

}
