package vista.contenedores;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import modelo.Jugador;
import modelo.elementos.*;

public class InformacionParaJugador extends VBox {
	
	private Jugador jugador;
	
    public InformacionParaJugador(Jugador jugador) {
    	
    	this.jugador = jugador;
    	
    	this.setPadding(new Insets(0,20,0,20));
    	
    	this.actualizar();
    }

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void actualizar(){
		
		this.getChildren().clear();
		
		List<Label> lista = new ArrayList<Label>();
		
		Label nombreDelJugador = new Label(this.jugador.getNombre());
        nombreDelJugador.setAlignment(Pos.CENTER);
        nombreDelJugador.setTextAlignment(TextAlignment.CENTER);
        nombreDelJugador.setFont(Font.font("Cambria", FontWeight.BOLD, 40));
        
        lista.add(nombreDelJugador);
    	
    	for(Elemento elemento : jugador.getElementos()){
    		Label label = new Label(elemento.getClass().getSimpleName() + ": "+ elemento.cantidadElemento());
            label.setTextAlignment(TextAlignment.LEFT);
            label.setFont(Font.font("Cambria", 20));
            label.setPadding(new Insets(0,0,20,0));
            lista.add(label);
    	}
    	
    	this.getChildren().addAll(lista);   
	}
}
