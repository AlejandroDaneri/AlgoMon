package vista;

import clases.Ataque;
import clases.Jugador;
import clases.Partida;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class BotonAtacarEventHandler extends BotonHandler {
    private Partida partida;
    private VBox opciones;

    public BotonAtacarEventHandler(Partida partida, VBox opciones) {
        this.partida = partida;
        this.opciones = opciones;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        MenuButton ataques = new MenuButton("Elegir ataque");
        opciones.getChildren().add(ataques);
        for(Ataque ataque : partida.jugadorActual().getAlgomonActivo().getAtaques()) {
            MenuItem opcion = new MenuItem(/*ataque.nombre*/"nombre ataque");
            opcion.setOnAction(new OpcionEventHandler(partida,ataque));
            ataques.getItems().add(opcion);

        }
        ataques.show();
        //cuando se elige hay que borrar el menuButton del vbox
    }
}
