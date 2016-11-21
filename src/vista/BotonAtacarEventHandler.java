package vista;


import clases.Jugador;
import javafx.event.ActionEvent;

public class BotonAtacarEventHandler extends BotonHandler {
    private Jugador jugadorActual;

    public BotonAtacarEventHandler(Jugador jugadorActual, Jugador jugador) {
        this.jugadorActual = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);

    }
}
