package interfaz;

import controlador.ConsultaSalaCine;
import dto.Room;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Christian on 13-04-2015.
 */
public class Cine extends Application {

    VBox vbox = new VBox();
    HBox[] hbox;
    ConsultaSalaCine cs;
    ArrayList<Integer> fila;
    ArrayList<Integer> columna;

    Room room;

    public Cine() {
        cs = new ConsultaSalaCine();
        ArrayList<Object> arrayObject = cs.consultarSalaBean();
        room = (Room) arrayObject.get(0);
        fila = (ArrayList<Integer>) arrayObject.get(1);
        columna = (ArrayList<Integer>) arrayObject.get(2);
    }

    @Override
    public void start(Stage stage) throws Exception {

        hbox = new HBox[cs.getCantidadButacas()];
        for (int a = 0; a < cs.getCantidadButacas(); a++) {
            hbox[a] = new HBox();
            Label label = new Label();
            if (room.getSeats().get(a).isAvaliable() == null) {
                label.setStyle("-fx-background-color: #003b4e;");
            } else if (room.getSeats().get(a).isAvaliable() == false) {
                label.setText(String.valueOf(room.getSeats().get(a).getNroAsiento()));
                label.setStyle("-fx-background-color: #ae060b");
            } else if (room.getSeats().get(a).isAvaliable() == true) {
                label.setText(String.valueOf(room.getSeats().get(a).getNroAsiento()));
                label.setStyle("-fx-background-color: #09df00");
            }
            label.setMinSize(30, 30);
            for (int b = 0; b < fila.size(); b++) {
                if (b == fila.get(a)) {
                    for (int d = 0; d < columna.size(); d++) {
                        if (d == columna.get(a)) {
                            if (hbox[columna.get(a)] == null) {
                                hbox[columna.get(a)] = new HBox();
                                hbox[columna.get(a)].getChildren().add(label);
                                break;
                            } else {
                                hbox[columna.get(a)].getChildren().add(label);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            vbox.getChildren().addAll(hbox[a]);
        }
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #003b4e;");
        vbox.setLayoutX(66);
        vbox.setLayoutY(66);
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #00677f;");
        pane.getChildren().add(vbox);
        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
