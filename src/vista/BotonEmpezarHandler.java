package vista;

import clases.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// aca hay que agregar la comprobacion de nombre de Jugador != de ""
public class BotonEmpezarHandler extends BotonHandler{
    private Escena escenaSiguiente;
    private Stage stage;
    private Partida partida;
    private TextField nombreJugador1;
    private TextField nombreJugador2;

    public BotonEmpezarHandler(Stage stage, Escena escenaSiguiente,
    		Partida partida, TextField nombreJugador1,
    		TextField nombreJugador2) {
        this.stage =stage;
        this.escenaSiguiente = escenaSiguiente;
        this.partida = partida;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        if (nombreJugador1.getText() != null) 
        	this.partida.jugadorActual().setNombre(nombreJugador1.getText());
//        	nombreJugador1.setOnAction(new EventHandler<ActionEvent>() {
//      		public void handle(ActionEvent e) {
//      			if (nombreJugador1.getText() != null) 
//      				nombreJugador1.setNombre(nombreJugador1.getText());;        	
//      	}
//      });

        if (nombreJugador2.getText() != null)
        	this.partida.jugadorOponente().setNombre(nombreJugador2.getText());
        if (nombreJugador1.getText() == null || nombreJugador2.getText() == null) {
//        	crea un warning avisando que no pueden tener nombre vacio
        }
        
        
        //if (si se elijieron todos los algomones) sigue lo de abajo
        //->
        boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
        stage.hide();
        stage.setScene(escenaSiguiente);
        stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
        stage.show();
        //<-- duplicado pero no se me ocurrio como mejorarlo
    }
}
