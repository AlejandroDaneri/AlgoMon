package vista;

import clases.Ataque;
import clases.Jugador;
import excepciones.AtaquesAgotadosException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class OpcionEventHandler implements EventHandler<ActionEvent> {
    private final Jugador jugadorActual;
    private final Ataque ataque;
    private final Jugador oponente;

    public OpcionEventHandler(Jugador jugadorActual, Jugador oponente, Ataque ataque) {
        this.jugadorActual = jugadorActual;
        this.ataque = ataque;
        this.oponente = oponente;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            jugadorActual.atacar(oponente.getAlgomonActivo(),ataque);
            oponente.getAlgomonActivo().getVida();
            //funciona pero falta actualizar el cambio en el contenedorPelea
        } catch (AtaquesAgotadosException e) {
            //lanzar aviso
        }
    }
}
