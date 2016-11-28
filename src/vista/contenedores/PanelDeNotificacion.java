package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PanelDeNotificacion extends HBox {
	
	TextArea notificaciones;
	ScrollPane panel;
	
    public PanelDeNotificacion() {
    	
    	this.notificaciones = new TextArea();
    	this.notificaciones.setFont(Font.font("Cambria", 15));
    	this.panel = new ScrollPane(notificaciones);
    	this.panel.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        this.notificaciones.setText("Movimiento de Jugadores:\n");
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(panel);
    }
    
    public void agregarMensaje(String mensaje){
    	this.notificaciones.appendText(mensaje);
    }
}
