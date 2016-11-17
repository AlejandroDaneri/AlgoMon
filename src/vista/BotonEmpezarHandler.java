package vista;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class BotonEmpezarHandler extends BotonHandler{
    private Escena escenaSiguiente;
    private Stage stage;

    public BotonEmpezarHandler(Stage stage, Escena escenaSiguiente) {
        this.stage =stage;
        this.escenaSiguiente = escenaSiguiente;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        //if (si se elijeron todos los algomones) sigue lo de abajo
        //->
        boolean enPantallaCompletaAntesDeCambiarEscena = stage.isFullScreen();
        stage.hide();
        stage.setScene(escenaSiguiente);
        stage.setFullScreen(enPantallaCompletaAntesDeCambiarEscena);
        stage.show();
        //<-- duplicado pero no se me ocurrio como mejorarlo
    }
}
