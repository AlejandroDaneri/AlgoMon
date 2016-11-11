package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {
    Stage stage;
    Scene escenaActual;

    public BotonEntrarEventHandler(Stage stage, Scene escenaEleccion) {
        this.stage = stage;
        this.escenaActual = escenaEleccion;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setScene(escenaActual);
        stage.setFullScreenExitHint(""); //revisar tamaño de escena anterior
        stage.setFullScreen(true);

    }
}
