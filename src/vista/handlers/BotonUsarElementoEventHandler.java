package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import vista.contenedores.ContenedorPelea;

public class BotonUsarElementoEventHandler extends BotonHandler{
    private VBox opciones;
    private Jugador jugadorActual;
    private Jugador oponente;
    private ContenedorPelea contenedor;

    public BotonUsarElementoEventHandler(Jugador jugadorActual, Jugador jugadorContrario, VBox opciones, ContenedorPelea contenedor) {
        this.jugadorActual = jugadorActual;
        this.oponente = jugadorContrario;
        this.opciones = opciones;
        this.contenedor =  contenedor;

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
