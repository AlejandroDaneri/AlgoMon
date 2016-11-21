package vista;

import clases.Jugador;
import javafx.event.ActionEvent;

public class BotonCambiarAlgomonEventHandler extends BotonHandler {
    private final Jugador jugadorActual;

    public BotonCambiarAlgomonEventHandler(Jugador jugadorActual, Jugador jugador) {
        this.jugadorActual = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
    }
}
