package vista.contenedores;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class PanelDeNotificacion extends ScrollPane {
	
	private TextArea notificaciones;

	
    public PanelDeNotificacion() {

    	this.notificaciones = new TextArea();
    	this.notificaciones.setFont(Font.font("Cambria", 12));
    	this.notificaciones.setEditable(false);

    	this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
    	this.setHbarPolicy(ScrollBarPolicy.NEVER);
    	this.notificaciones.setText("Movimiento de Jugadores:\n");
		notificaciones.setWrapText(true);

		notificaciones.setMinWidth(Double.MAX_VALUE);
		this.setContent(notificaciones);
		this.setWidth(Double.MAX_VALUE);
		this.setMaxHeight(100);


    }
    
    public void agregarMensaje(String mensaje){
    	this.notificaciones.appendText(mensaje);
    }
}
