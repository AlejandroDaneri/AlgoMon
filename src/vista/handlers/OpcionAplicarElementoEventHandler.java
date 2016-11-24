package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Partida;
import modelo.elementos.Elemento;
import modelo.excepciones.CantidadElementoAgotadaException;
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
    	try {
    		partida.jugarTurnoActual(this.elemento);
        	contenedor.nuevoTurno();
        	if (partida.juegoTerminado())
        		contenedor.peleaFinalizada(partida.nombreGanador());
        } 
        catch (CantidadElementoAgotadaException e) {
        	Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Warning");
        	alert.setHeaderText("Elemento Agotado");
        	alert.setContentText("No puede utilizar mas este elemento!");
        	alert.showAndWait();
        }
    }

}
