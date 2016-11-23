package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class BotonReglasEventHandler extends BotonHandler {
	
	private Alert alerta;
	
    public BotonReglasEventHandler() {
    	
    	alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setResizable(true);
        alerta.getDialogPane().setPrefSize(400,270);

    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        this.alerta.setTitle("Reglas del juego:");
        this.alerta.setHeaderText("REGLAS DEL JUEGO:");
        this.alerta.setContentText(
        "Cada jugador debe elegir 3 AlgoMones con los cuales batallara hasta el final de la partida.\n\n" +
        "Turnos: en cada turno el jugador puede: Atacar, Cambiar su AlgoMon o Usar un Elemento.\n\n" +
        "La batalla AlgoMon finaliza cuando los 3 algomones de algun jugador estan muertos.");
        this.alerta.showAndWait();
    }
}
