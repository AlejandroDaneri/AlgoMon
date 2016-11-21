package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaNombrarJugadores {
	
	private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Boolean nombresIngresados;
    
    public VentanaNombrarJugadores (){

        nombreJugador1 = new TextField("Jugador 1");
        nombreJugador2 = new TextField("Jugador 2");
        nombresIngresados = false;

    }
    
    public Boolean jugadoresFueronIngresados(){
        return nombresIngresados;

    }
    
    public void display () {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Nombre Jugadores");
        window.setMinWidth(500);

        Label label = new Label();
        label.setText("Ingresar Nombre Jugador 1");

        Label label2 = new Label();
        label2.setText("Ingresar Nombre Jugador 2");


        Button cerrar = new Button();
        cerrar.setText("Aceptar");
        cerrar.setOnAction(e -> {
            nombresIngresados = true;
            window.close();
        });

        VBox box = new VBox(20);
        box.getChildren().addAll(label, nombreJugador1, label2, nombreJugador2, cerrar);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box);
        window.setScene(scene);
        window.showAndWait();

    }
    
    public String getNombreJugador1 (){
        return nombreJugador1.getText();

    }

    public String getNombreJugador2 (){
        return nombreJugador2.getText();

    }
}
