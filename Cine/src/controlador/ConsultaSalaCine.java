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
    private enum avaliabe{D, P, F};
    public ArrayList<Object> consultarSalaBean() {

        ArrayList<Object> object = new ArrayList<Object>();
        ArrayList<Integer> fila = new ArrayList<Integer>();
        ArrayList<Integer> columna = new ArrayList<Integer>();
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
        for (int b = 0; b < seatProperty.length; b++) {
            String[] seats = seatProperty[b].split(",");
            Seat seat = new Seat();
            seat.setNroAsiento(Integer.parseInt(seats[0]));
            seat.setRow(Integer.parseInt(seats[1]));
            seat.setColumn(Integer.parseInt(seats[2]));
            switch (seats[3]){
                case "D":
                    seat.setAvaliable(true);
                    break;
                case "F":
                    seat.setAvaliable(false);
                    break;
                case "P":
                    seat.setAvaliable(null);
                    break;
            }
            listaSeat.add(seat);
            System.out.println(seat.toString());
        }
        listaListaSeat.add(listaSeat);
        for(Seat filaTemp:listaSeat){
            fila.add(filaTemp.getRow());
            columna.add(filaTemp.getColumn());
        }
        room.setSeats(listaSeat);
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

    public void setCantidadButacas(int cantidadButacas) {
        this.cantidadButacas = cantidadButacas;
    }
}
