package vista.botones;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import vista.handlers.BotonSeleccionarEventHandler;

public class BotonSeleccionar extends Button{
    public BotonSeleccionar(BotonSeleccionarEventHandler botonSeleccionarEventHandler) {
       this.setText("Seleccionar");
        this.setFont(Font.font(20));
        botonSeleccionarEventHandler.setBotonSeleccion(this);
        this.setOnAction(botonSeleccionarEventHandler);
    }
}
