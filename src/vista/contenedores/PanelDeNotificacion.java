package vista.contenedores;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class PanelDeNotificacion extends HBox {
	
	TextArea notificaciones;
	ScrollPane panel;
	
    public PanelDeNotificacion() {
    	
    	this.notificaciones = new TextArea();
    	this.notificaciones.setFont(Font.font("Cambria", 12));
    	this.panel = new ScrollPane(notificaciones);
    	this.panel.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
    	this.panel.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
    	this.notificaciones.setText("Movimiento de Jugadores:\n");
    	this.getChildren().addAll(panel);

    }
    
    public void agregarMensaje(String mensaje){
    	this.notificaciones.appendText(mensaje);
    }
}
