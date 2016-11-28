package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import modelo.Partida;
import modelo.ataques.Ataque;
import modelo.excepciones.AtaquesAgotadosException;
import vista.contenedores.ContenedorPelea;


public class OpcionAtacarEventHandler implements EventHandler<ActionEvent> {
    private final MenuItem opcion;
    private Partida partida;
    private Ataque ataque;
    private ContenedorPelea contenedor;
    
    public OpcionAtacarEventHandler(Partida partida, Ataque ataque, ContenedorPelea contenedor, MenuItem opcion) {
        this.partida = partida;
        this.ataque = ataque;
        this.contenedor = contenedor;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            partida.jugarTurnoActual(ataque);
            contenedor.notificarPanel(this.notificacionAtaque());
            contenedor.nuevoTurno();
    		if (partida.juegoTerminado())
    			contenedor.peleaFinalizada(partida.nombreGanador());
            this.actualizarOpcionAtaque();
        } 
        catch (AtaquesAgotadosException e) {
        	Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Warning");
        	alert.setHeaderText("Ataque Agotado");
        	alert.setContentText("No puede utilizar mas este ataque!");
        	alert.showAndWait();
        }
    }
    
    public String notificacionAtaque(){
    	return this.partida.jugadorActual().getNombre() + " ha atacado con " 
    			+ this.partida.jugadorActual().getAlgomonActivo().getClass().getSimpleName() + " con "
                + this.ataque.getClass().getSimpleName() + " sacando " + Integer.toString(this.ataque.getPotencia()) 
                + " de vida al rival." + "\n";
    }
    
    public void actualizarOpcionAtaque(){
    	opcion.setText(ataque.getClass().getSimpleName() + " (" + ataque.getCantidad() + "/" + ataque.cantidadInicial() + ")");
    }
}
