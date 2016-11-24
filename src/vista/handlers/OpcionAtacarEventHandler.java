package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Partida;
import modelo.ataques.Ataque;
import modelo.excepciones.AtaquesAgotadosException;
import vista.contenedores.ContenedorPelea;


public class OpcionAtacarEventHandler implements EventHandler<ActionEvent> {
    private Partida partida;
    private Ataque ataque;
    private ContenedorPelea contenedor;
    
    public OpcionAtacarEventHandler(Partida partida, Ataque ataque, ContenedorPelea contenedor) {
        this.partida = partida;
        this.ataque = ataque;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            partida.jugarTurnoActual(ataque);
            contenedor.nuevoTurno();
    		if (partida.juegoTerminado())
    			contenedor.peleaFinalizada(partida.nombreGanador());
        } 
        catch (AtaquesAgotadosException e) {
        	Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Warning");
        	alert.setHeaderText("Ataque Agotado");
        	alert.setContentText("No puede utilizar mas este ataque!");
        	alert.showAndWait();
        }
    }
}
