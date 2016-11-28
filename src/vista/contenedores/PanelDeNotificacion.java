package vista.contenedores;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PanelDeNotificacion extends Label {
	
    public PanelDeNotificacion() {
    	
    	this.setFont(Font.font("Cambria", 18));
        this.setTextFill(Color.WHITE);
        this.setText("Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores:Movimiento de Jugadores: ");
        this.setWrapText(true);
        this.setStyle("-fx-background-color: transparent;");
        this.toBack();

        this.setMaxSize(400,250);
        this.setMinSize(this.getMaxWidth(),this.getMaxHeight());

    }
    
    public void agregarMensaje(String mensaje){
    	//this.notificaciones.appendText(mensaje);
    }
}
