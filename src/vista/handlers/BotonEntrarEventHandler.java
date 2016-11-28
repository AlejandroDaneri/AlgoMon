package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import vista.contenedores.ContenedorEleccionAlgomon;
import vista.contenedores.Escena;
import vista.contenedores.VentanaNombrarJugadores;

public class BotonEntrarEventHandler extends BotonHandler {

    private final AudioClip musicaDeFondo;
    private Stage stage;
    private VentanaNombrarJugadores ventanaNombres;

    public BotonEntrarEventHandler(Stage stage, AudioClip musicaDeFondo) {
        this.stage = stage;
        this.ventanaNombres = new VentanaNombrarJugadores();
        this.musicaDeFondo = musicaDeFondo;
        
    }

    @Override
    public void handle(ActionEvent event) {
    	super.handle(event);
    	
    	if (!ventanaNombres.jugadoresFueronIngresados()) {
    		ventanaNombres.mostrar();
        }
    	
    	if (ventanaNombres.jugadoresFueronIngresados()) { //esto evita que se empiece la eleccion si no se puso aceptar
            String nombreJugador1 = ventanaNombres.getNombreJugador1();
            String nombreJugador2 = ventanaNombres.getNombreJugador2();

            ContenedorEleccionAlgomon contenedorEleccion = new ContenedorEleccionAlgomon(stage, nombreJugador1, nombreJugador2,musicaDeFondo);
            Escena escenaEleccion = new Escena(contenedorEleccion, stage);

            stage.setFullScreenExitHint("");
            boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
            stage.hide();
            stage.setScene(escenaEleccion);
            stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
            stage.show();
        }
    }




}
