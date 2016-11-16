package vista;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Escena extends Scene{
    public Escena(Pane contenedor, Stage stage, int ancho, int alto) {
        super(contenedor, alto, ancho);
        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F11){
                stage.setFullScreen(!stage.isFullScreen());
            }
            if (event.getCode() == KeyCode.ESCAPE){
                stage.setMaximized(true);
            }
        });
    }
}
