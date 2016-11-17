package vista;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler extends BotonHandler {
    Stage stage;
    Scene siguienteEscena;
    boolean stageEstaEnPantallaCompleta;

    public BotonEntrarEventHandler(Stage stage, Scene escenaEleccion, boolean stageEstaEnPantallaCompleta) {
        this.stage = stage;
        this.siguienteEscena = escenaEleccion;
        this.stageEstaEnPantallaCompleta = stageEstaEnPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        stage.setFullScreenExitHint("");
        boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
        stage.hide();
        stage.setScene(siguienteEscena);
        stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
        stage.show();
    }




}
