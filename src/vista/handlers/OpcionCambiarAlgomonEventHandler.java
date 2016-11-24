package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Partida;
import modelo.algomones.AlgoMon;
import modelo.ataques.Ataque;
import modelo.excepciones.AlgoMonACambiarEsElActualException;
import modelo.excepciones.AlgoMonMuertoException;
import modelo.excepciones.AtaquesAgotadosException;
import vista.RepresentacionAlgoMon;
import vista.contenedores.ContenedorPelea;

public class OpcionCambiarAlgomonEventHandler implements EventHandler<ActionEvent> {
	private ContenedorPelea contenedor;
	private Partida partida;
    private AlgoMon algomon;
    private RepresentacionAlgoMon representacion;
	
	public OpcionCambiarAlgomonEventHandler(Partida partida, AlgoMon algomon, 
			RepresentacionAlgoMon representacion, ContenedorPelea contenedor){
		this.contenedor = contenedor;
		this.partida = partida;
        this.algomon = algomon;
        this.representacion = representacion;
	}
	
	@Override
	public void handle(ActionEvent event) {
		 try {
	            partida.jugarTurnoActual(algomon);
	            contenedor.nuevoTurno();
	    		if (partida.juegoTerminado())
	    			contenedor.peleaFinalizada(partida.nombreGanador());
	        } 
	        catch (AlgoMonACambiarEsElActualException e) {
	        	Alert alert = new Alert(AlertType.WARNING);
	        	alert.setTitle("Warning");
	        	alert.setHeaderText("No es posible realizar la accion");
	        	alert.setContentText("El algomon que escogio es el actual!");
	        	alert.showAndWait();
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
