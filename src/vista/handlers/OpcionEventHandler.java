package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Partida;
import modelo.ataques.Ataque;
import modelo.excepciones.AtaquesAgotadosException;
import vista.contenedores.ContenedorPelea;


public class OpcionEventHandler implements EventHandler<ActionEvent> {
    private Partida partida;
    private Ataque ataque;
    private ContenedorPelea contenedor;
    
    public OpcionEventHandler(Partida partida, Ataque ataque, ContenedorPelea contenedor) {
        this.partida = partida;
        this.ataque = ataque;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            partida.jugarTurnoActual(ataque);
            contenedor.actualizar();
    		if (partida.juegoTerminado())
    			contenedor.peleaFinalizada(partida.nombreGanador());
        } catch (AtaquesAgotadosException e) {
            //lanzar aviso
        }
    }
}
