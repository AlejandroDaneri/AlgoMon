package vista.contenedores;

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
	private Label pociones;
	private Label superPociones;
	private Label vitaminas;
	private Label restauradores;

    public InformacionParaJugador(Jugador jugador) {
    	
    	this.jugador = jugador;
    	
        Label nombreDelJugador = new Label(jugador.getNombre());
        nombreDelJugador.setAlignment(Pos.CENTER);
        nombreDelJugador.setTextAlignment(TextAlignment.CENTER);
        nombreDelJugador.setFont(Font.font("Cambria", FontWeight.BOLD, 40));
   
        this.pociones = this.setLabelElemento("Pociones: ", new Pocion());
        this.superPociones = this.setLabelElemento("Super pociones: ", new SuperPocion());
        this.vitaminas = this.setLabelElemento("Vitamina: ", new Vitamina());
        this.restauradores = this.setLabelElemento("Restaurador: ", new Restaurador());

        this.setPadding(new Insets(0,20,0,20));
        this.getChildren().addAll(nombreDelJugador, pociones, superPociones, vitaminas, restauradores);

    }

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public void actualizar(){
		
		this.getChildren().removeAll(pociones,superPociones,vitaminas,restauradores);
		
		this.pociones = this.setLabelElemento("Pociones: ", new Pocion());
        this.superPociones = this.setLabelElemento("Super pociones: ", new SuperPocion());
        this.vitaminas = this.setLabelElemento("Vitamina: ", new Vitamina());
        this.restauradores = this.setLabelElemento("Restaurador: ", new Restaurador());
        
        this.getChildren().addAll(pociones, superPociones, vitaminas, restauradores);
	}
	
	private Label setLabelElemento(String stringLabel, Elemento elemento) {
		
		Elemento element = jugador.getElemento(elemento);
        Label label = new Label(stringLabel + element.cantidadElemento());
        label.setTextAlignment(TextAlignment.LEFT);
        label.setFont(Font.font("Cambria", 20));
        label.setPadding(new Insets(0,0,20,0));
        return label;
        
	}
}
