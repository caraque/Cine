package dto;

import java.util.ArrayList;

/**
 * Created by Christian on 13-04-2015.
 */
public class Room {

    private int from;
    private int to;
    private ArrayList<Seat> seats;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Room{" +
                "from=" + from +
                ", to=" + to +
                ", seats=" + seats +
                '}';
    }
}
