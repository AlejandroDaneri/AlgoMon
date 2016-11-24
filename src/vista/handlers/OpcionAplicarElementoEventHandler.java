package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Partida;
import modelo.elementos.Elemento;
import vista.contenedores.ContenedorPelea;

public class OpcionAplicarElementoEventHandler implements EventHandler<ActionEvent> {

	private Partida partida;
    private Elemento elemento;
    private ContenedorPelea contenedor;
    
    public OpcionAplicarElementoEventHandler(Partida partida, Elemento elemento, ContenedorPelea contenedor) {
        this.partida = partida;
        this.elemento = elemento;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {
     partida.jugarTurnoActual(this.elemento);
     contenedor.nuevoTurno();
     if (partida.juegoTerminado())
    	 contenedor.peleaFinalizada(partida.nombreGanador());
    }

}
