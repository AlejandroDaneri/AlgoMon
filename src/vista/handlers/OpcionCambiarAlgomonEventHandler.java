package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Partida;
import modelo.algomones.AlgoMon;
import modelo.excepciones.AlgoMonMuertoException;
import vista.contenedores.ContenedorPelea;

public class OpcionCambiarAlgomonEventHandler implements EventHandler<ActionEvent> {
	private ContenedorPelea contenedor;
	private Partida partida;
    private AlgoMon algomon;

	public OpcionCambiarAlgomonEventHandler(Partida partida, AlgoMon algomon, 
			 ContenedorPelea contenedor){
		this.contenedor = contenedor;
		this.partida = partida;
        this.algomon = algomon;
	}
	
	@Override
	public void handle(ActionEvent event) {
		 try {
			 	partida.jugarTurnoActual(algomon);
			    contenedor.cambiarAlgomon(algomon);
	            contenedor.nuevoTurno();
	    		if (partida.juegoTerminado())
	    			contenedor.peleaFinalizada(partida.nombreGanador());
	        }
		 	catch (AlgoMonMuertoException e) {
			 Alert alert = new Alert(AlertType.WARNING);
	        	alert.setTitle("Warning");
	        	alert.setHeaderText("No es posible realizar la accion");
	        	alert.setContentText("El algomon que escogio esta muerto!");
	        	alert.showAndWait();
		 }
	}

}
