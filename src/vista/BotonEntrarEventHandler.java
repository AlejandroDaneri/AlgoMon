package vista;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonEntrarEventHandler extends BotonHandler {
	
	private final int ancho_minimo = 1024;
    private final int alto_minimo = 720;
	
    Stage stage;
    boolean stageEstaEnPantallaCompleta;
    VentanaNombrarJugadores ventanaNombres;

    public BotonEntrarEventHandler(Stage stage, boolean stageEstaEnPantallaCompleta) {
        this.stage = stage;
        this.stageEstaEnPantallaCompleta = stageEstaEnPantallaCompleta;
        this.ventanaNombres = new VentanaNombrarJugadores();
        
    }

    @Override
    public void handle(ActionEvent event) {
    	super.handle(event);
    	
    	if (!ventanaNombres.jugadoresFueronIngresados()) {
    		ventanaNombres.display();
        }
    	
    	String nombreJugador1 = ventanaNombres.getNombreJugador1();
    	String nombreJugador2 = ventanaNombres.getNombreJugador2();
    	
    	ContenedorEleccionAlgomon contenedorEleccion = new ContenedorEleccionAlgomon(stage, nombreJugador1, nombreJugador2);
        Escena escenaEleccion = new Escena(contenedorEleccion, stage);
        
        stage.setFullScreenExitHint("");
        boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
        stage.hide();
        stage.setScene(escenaEleccion);
        stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
        stage.show();
    }




}
