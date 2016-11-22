package vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public abstract class BotonHandler implements EventHandler<ActionEvent>{
//heredando de BotonHandler y llamando a super.handle ya va a sonar el boton

    @Override
    public void handle(ActionEvent event) {
        AudioClip sonidoSeleccion = new AudioClip("file:src/vista/sonidos/seleccion.mp3");
        sonidoSeleccion.play();
    }

}
