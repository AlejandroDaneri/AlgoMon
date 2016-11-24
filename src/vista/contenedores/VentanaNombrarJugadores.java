package vista.contenedores;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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
    
    public void mostrar(ActionEvent event) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Nombre Jugadores");
        window.setMinWidth(500);
        window.centerOnScreen();

        Label labelParaJugador1 = new Label();
        labelParaJugador1.setText("Ingresar Nombre Jugador 1");

        Label labelParaJugador2 = new Label();
        labelParaJugador2.setText("Ingresar Nombre Jugador 2");


        Button aceptar = new Button("Aceptar");
        aceptar.setOnAction(e -> {
            nombresIngresados = true;
            window.close();
        });

        VBox contenedor = new VBox(20);
        contenedor.getChildren().addAll(labelParaJugador1, nombreJugador1, labelParaJugador2, nombreJugador2, aceptar);
        VBox.setMargin(aceptar,new Insets(0,0,10,0));
        VBox.setMargin(labelParaJugador1,new Insets(10,0,0,0));
        contenedor.setAlignment(Pos.CENTER);

        Scene scene = new Scene(contenedor);
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
