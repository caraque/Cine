package interfaz;

import controlador.ConsultaSalaCine;
import dto.Room;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Christian on 13-04-2015.
 */
public class Cine extends Application {

    VBox vbox = new VBox(5);
    HBox hbox = new HBox(5);
    ConsultaSalaCine cs;

    Room room;

    public Cine() {
        cs = new ConsultaSalaCine();
        ArrayList<Object> arrayObject = cs.consultarSalaBean();
        room = (Room) arrayObject.get(0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ArrayList<Label> array = new ArrayList<Label>();
        for (int a = 0; a < cs.getCantidadButacas(); a++) {
            Label label = new Label(String.valueOf(room.getSeats().get(a).getNroAsiento()));
            label.setStyle(room.getSeats().get(a).isAvaliable() == true ? "-fx-background-color: #09df00":"-fx-background-color: #ae060b");
            array.add(label);
        }


        hbox.getChildren().addAll(array);
        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(hbox);
        vbox.setStyle("-fx-background-color: #00677f;");
        Scene scene = new Scene(vbox, 500, 500);
        stage.setTitle("Principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
