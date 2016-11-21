package vista;

import clases.Jugador;
import clases.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// aca hay que agregar la comprobacion de nombre de Jugador != de ""
public class BotonEmpezarHandler extends BotonHandler {
	
	private final int ancho_minimo = 1024;
    private final int alto_minimo = 720;
	
    private Stage stage;
    private String nombreJugador1;
    private String nombreJugador2;
    private Jugador jugador1;
    private Jugador jugador2;

    // La escena la creo en el handler mas abajo
    public BotonEmpezarHandler(Stage stage, String nombreJugador1, String nombreJugador2, 
    		Jugador jugador1, Jugador jugador2) {
        this.stage = stage;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        Partida partida = new Partida(jugador1,jugador2);
        
        partida.jugadorActual().setNombre(nombreJugador1);
        partida.jugadorOponente().setNombre(nombreJugador2);

        //if (si se elijieron todos los algomones) sigue lo de abajo
        //->
        
        ContenedorPelea contenedorPelea = new ContenedorPelea(stage);
        Escena escenaPelea = new Escena(contenedorPelea,stage, alto_minimo, ancho_minimo);
        contenedorPelea.inicializarPelea(partida);
        
        boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
        stage.hide();
        stage.setScene(escenaPelea);
        stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
        stage.show();
        //<-- duplicado pero no se me ocurrio como mejorarlo
    }
}
