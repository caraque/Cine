package controlador;

import bean.SalaCineBean;
import dto.Room;
import dto.Seat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 13-04-2015.
 */
public class ConsultaSalaCine {

    private int cantidadButacas;

    public ArrayList<Object> consultarSalaBean() {

        ArrayList<Object> object = new ArrayList<Object>();
        SalaCineBean salaCineBean = new SalaCineBean();

        ArrayList<Seat> listaSeat = new ArrayList<Seat>();
        ArrayList<List<Seat>> listaListaSeat = new ArrayList<List<Seat>>();
        String archivoSalas = salaCineBean.consultarSala();
        String salaProperty[] = archivoSalas.split(";");
        Room room = new Room();
        room.setFrom(Integer.parseInt(salaProperty[0]));
        room.setTo(Integer.parseInt(salaProperty[1]));
        String[] seatProperty = salaProperty[2].split("\\.");
        System.out.println("Tamaño " + seatProperty.length);
        for (int a = 0; a < seatProperty.length; a++) {
            for (int b = 0; b < seatProperty[a].length(); b++) {
                String[] seats = seatProperty[b].split(",");
                Seat seat = new Seat();
                seat.setNroAsiento(Integer.parseInt(seats[0]));
                seat.setRow(Integer.parseInt(seats[1]));
                seat.setColumn(Integer.parseInt(seats[2]));
                seat.setAvaliable(seats[3].equals("D") ? true : false);
                listaSeat.add(seat);
                System.out.println(seat.toString());
            }
            listaListaSeat.add(listaSeat);
        }




        room.setSeats(listaSeat);

        System.out.println(room.toString());

        object.add(room);
        cantidadButacas = room.getTo() > 1 ? room.getTo() - room.getFrom() + 1 : room.getTo() - room.getFrom();

        return object;
    }

    public int getCantidadButacas() {
        return cantidadButacas;
    }

    public void setCantidadButacas(int cantidadButacas) {
        this.cantidadButacas = cantidadButacas;
    }
}
