package vista;


import clases.Jugador;
import javafx.event.ActionEvent;

public class BotonUsarElementoEventHandler extends BotonHandler{
    private final Jugador jugadorActual;

    public BotonUsarElementoEventHandler(Jugador jugadorActual, Jugador jugador) {
        this.jugadorActual = jugador;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
    }
}
