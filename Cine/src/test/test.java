/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import dto.Room;
import dto.Seat;
import java.util.ArrayList;

/**
 *
 * @author felix
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        prueba();
        
    }
    
    public static void prueba (){
        Gson gson = new Gson();
        Room room = new Room();
        room.setFrom(1);
        room.setTo(100);
        ArrayList<Seat> arrayList = new ArrayList<Seat>();
        int asiento = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
            Seat seat = new Seat();
            seat.setAvaliable(Boolean.TRUE);
            seat.setColumn(i);
            seat.setRow(j);
            seat.setNroAsiento(asiento);
            asiento++;
            arrayList.add(seat);
            }
        }
        room.setSeats(arrayList);
        System.out.println(gson.toJson(room));
        System.out.println("hola");
    }
}
