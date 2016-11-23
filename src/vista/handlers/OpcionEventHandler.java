package vista.handlers;

import excepciones.AtaquesAgotadosException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Partida;
import modelo.ataques.Ataque;


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
        } catch (AtaquesAgotadosException e) {
            //lanzar aviso
        }
    }
}