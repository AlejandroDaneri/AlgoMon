package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.algomones.AlgoMon;
import vista.contenedores.ContenedorPelea;

public class BotonCambiarAlgomonEventHandler extends BotonHandler {
    private VBox opciones;
    private Jugador jugadorActual;
    private Jugador oponente;
    private ContenedorPelea contenedor;


    public BotonCambiarAlgomonEventHandler(Jugador jugadorActual, Jugador jugadorContrario, VBox opciones, ContenedorPelea contenedor) {
        this.jugadorActual = jugadorActual;
        this.oponente = jugadorContrario;
        this.opciones = opciones;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        MenuButton algomones = new MenuButton("Elegir algomon");
        opciones.getChildren().add(algomones);
        for(AlgoMon algomon : jugadorActual.getListaDeAlgomones())
            algomones.getItems().add(new MenuItem(/*algomon.nombre*/"nombre algomon"));
        algomones.show();
        //cuando se elige hay que borrar el menuButton del vbox
    }
}
