package vista.handlers;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import vista.Escena;
import vista.contenedores.ContenedorEleccionAlgomon;
import vista.contenedores.VentanaNombrarJugadores;

public class BotonEntrarEventHandler extends BotonHandler {

    private Stage stage;
    private VentanaNombrarJugadores ventanaNombres;

    public BotonEntrarEventHandler(Stage stage) {
        this.stage = stage;
        this.ventanaNombres = new VentanaNombrarJugadores();
        
    }

    @Override
    public void handle(ActionEvent event) {
    	super.handle(event);
    	
    	if (!ventanaNombres.jugadoresFueronIngresados()) {
    		ventanaNombres.mostrar(event);
        }
    	
    	if (ventanaNombres.jugadoresFueronIngresados()) { //esto evita que se empiece la eleccion si no se puso aceptar
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




}
