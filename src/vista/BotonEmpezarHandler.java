package vista;

import clases.Jugador;
import clases.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// aca hay que agregar la comprobacion de nombre de Jugador != de ""
public class BotonEmpezarHandler extends BotonHandler{
    private Escena escenaSiguiente;
    private Stage stage;
    private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Jugador jugador1;
    private Jugador jugador2;

    public BotonEmpezarHandler(Stage stage, Escena escenaSiguiente,
                               TextField nombreJugador1,
                               TextField nombreJugador2, Jugador jugador1, Jugador jugador2) {
        this.stage = stage;
        this.escenaSiguiente = escenaSiguiente;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        Partida partida = new Partida(jugador1,jugador2);
        if (nombreJugador1.getText() != null) 
        	partida.jugadorActual().setNombre(nombreJugador1.getText());

//        	nombreJugador1.setOnAction(new EventHandler<ActionEvent>() {
//      		public void handle(ActionEvent e) {
//      			if (nombreJugador1.getText() != null) 
//      				nombreJugador1.setNombre(nombreJugador1.getText());;        	
//      	}
//      });

        if (nombreJugador2.getText() != null)
        	partida.jugadorOponente().setNombre(nombreJugador2.getText());
        if (nombreJugador1.getText() == null || nombreJugador2.getText() == null) {
//        	crea un warning avisando que no pueden tener nombre vacio
        }
        
        
        //if (si se elijieron todos los algomones) sigue lo de abajo
        //->

        boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
        ((ContenedorPelea)escenaSiguiente.getRoot()).inicializarPelea(partida);
        stage.hide();
        stage.setScene(escenaSiguiente);
        stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
        stage.show();
        //<-- duplicado pero no se me ocurrio como mejorarlo
    }
}
