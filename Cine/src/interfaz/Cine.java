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

    VBox vbox = new VBox(5);
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

        ArrayList<Label> array = new ArrayList<Label>();
        hbox = new HBox[cs.getCantidadButacas()];
        for (int a = 0; a < cs.getCantidadButacas(); a++) {
            int c=0;
            hbox[a] = new HBox();
            Label label = new Label(String.valueOf(room.getSeats().get(a).getNroAsiento()));
            label.setStyle(room.getSeats().get(a).isAvaliable() == true ? "-fx-background-color: #09df00" : "-fx-background-color: #ae060b");
            label.setMinSize(30,30);
            //label.setTextAlignment(TextAlignment.CENTER);
            for (int b = 0; b < fila.size(); b++) {
                if (b == fila.get(a)) {
                    if (hbox[c] != null) {
                        hbox[c].getChildren().add(label);
                    } else {
                        hbox[c] = new HBox();
                        hbox[c].getChildren().add(label);
                    }
                }
                c++;
            }

            array.add(label);
           // hbox[a].getChildren().addAll(array);
           //  hbox[a].setAlignment(Pos.CENTER);

            vbox.getChildren().add(hbox[a]);
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
