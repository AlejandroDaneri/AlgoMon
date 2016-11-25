package vista.botones;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.Partida;
import modelo.elementos.Elemento;
import vista.contenedores.ContenedorPelea;
import vista.handlers.OpcionAplicarElementoEventHandler;

public class BotonMenuAplicarElemento extends MenuButton {
	private ContenedorPelea contenedor;

    public BotonMenuAplicarElemento(Partida partida, Jugador jugador, VBox opciones,  ContenedorPelea contenedor) {
    	super("Aplicar Elemento");
        this.contenedor = contenedor;
        opciones.getChildren().add(this);
        for(Elemento elemento : jugador.getElementos()) {
            MenuItem opcion = new MenuItem(elemento.getClass().getSimpleName());
            opcion.setOnAction(new OpcionAplicarElementoEventHandler(partida,elemento,this.contenedor,opcion));
            opcion.setText(opcion.getText().concat(" "+ elemento.cantidadElemento()));
            this.getItems().add(opcion);
        }
    }
}