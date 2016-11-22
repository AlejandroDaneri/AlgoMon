package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import modelo.Jugador;

public class BotonUsarElementoEventHandler extends BotonHandler{
    private VBox opciones;
    private Jugador jugadorActual;
    private Jugador oponente;

    public BotonUsarElementoEventHandler(Jugador jugadorActual, Jugador jugadorContrario, VBox opciones) {
        this.jugadorActual = jugadorActual;
        this.oponente = jugadorContrario;
        this.opciones = opciones;

    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
       /* MenuButton elementos = new MenuButton("Elegir elemento");
        opciones.getChildren().add(elementos);
        for(Elemento elemento : jugadorActual.getlistaElemento())
            elementos.getItems().add(new MenuItem(/*elemento.nombre"nombre elemento"));
        elementos.show();
        //cuando se elige hay que borrar el menuButton del vbox

        */
    }
}
