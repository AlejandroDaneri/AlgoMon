package vista;

import clases.Ataque;
import clases.Jugador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class BotonAtacarEventHandler extends BotonHandler {
    private VBox opciones;
    private Jugador jugadorActual;
    private Jugador oponente;



    public BotonAtacarEventHandler(Jugador jugadorActual, Jugador jugadorContrario, VBox opciones) {
        this.jugadorActual = jugadorActual;
        this.oponente = jugadorContrario;
        this.opciones = opciones;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        MenuButton ataques = new MenuButton("Elegir ataque");
        opciones.getChildren().add(ataques);
        for(Ataque ataque : jugadorActual.getAlgomonActivo().getAtaques()) {
            MenuItem opcion = new MenuItem(/*ataque.nombre*/"nombre ataque");
            opcion.setOnAction(new OpcionEventHandler(jugadorActual,oponente,ataque));
            ataques.getItems().add(opcion);

        }
        ataques.show();
        //cuando se elige hay que borrar el menuButton del vbox
    }
}
