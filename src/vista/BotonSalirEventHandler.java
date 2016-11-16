package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSalirEventHandler extends Boton {
    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        System.exit(0);
    }
}
