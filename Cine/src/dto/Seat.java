package dto;

/**
 * Created by Christian on 13-04-2015.
 */
public class Seat {

    private int nroAsiento;
    private int row;
    private int column;
    private boolean avaliable;

    public int getNroAsiento() {
        return nroAsiento;
    }

    public void setNroAsiento(int nroAsiento) {
        this.nroAsiento = nroAsiento;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "nroAsiento=" + nroAsiento +
                ", row=" + row +
                ", column=" + column +
                ", avaliable=" + avaliable +
                '}';
    }
}
