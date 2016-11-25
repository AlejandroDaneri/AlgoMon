package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import modelo.Partida;
import modelo.elementos.Elemento;
import modelo.excepciones.CantidadElementoAgotadaException;
import vista.contenedores.ContenedorPelea;

public class OpcionAplicarElementoEventHandler implements EventHandler<ActionEvent> {

    private final MenuItem opcion;
    private Partida partida;
    private Elemento elemento;
    private ContenedorPelea contenedor;
    
    public OpcionAplicarElementoEventHandler(Partida partida, Elemento elemento, ContenedorPelea contenedor, MenuItem opcion) {
        this.partida = partida;
        this.elemento = elemento;
        this.contenedor = contenedor;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent event) {
    	try {
    		partida.jugarTurnoActual(this.elemento);
        	contenedor.nuevoTurno();
        	if (partida.juegoTerminado())
        		contenedor.peleaFinalizada(partida.nombreGanador());
            opcion.setText(elemento.getClass().getSimpleName() + " " + elemento.cantidadElemento() + " / " + elemento.cantidadInicial());
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
