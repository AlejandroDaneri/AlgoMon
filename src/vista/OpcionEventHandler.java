package vista;

import clases.Ataque;
import clases.Partida;
import excepciones.AtaquesAgotadosException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class OpcionEventHandler implements EventHandler<ActionEvent> {
    private Partida partida;
    private Ataque ataque;


    public OpcionEventHandler(Partida partida, Ataque ataque) {
        this.partida = partida;
        this.ataque = ataque;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            partida.jugarTurnoActual(ataque);
            //funciona pero falta actualizar el cambio en el contenedorPelea
        } catch (AtaquesAgotadosException e) {
            //lanzar aviso
        }
    }
}
