package vista.botones;

import javafx.scene.control.Button;
import vista.ListaDeRepresentaciones;
import vista.contenedores.Flecha;
import vista.contenedores.ImagenDeAlgomonAElegir;
import vista.contenedores.TablaDeAlgomon;
import vista.handlers.BotonCambiarIzquierdaEventHandler;
import vista.handlers.BotonSeleccionarEventHandler;

public class BotonIzquierdo extends Button {
    public BotonIzquierdo(Flecha imagen, ImagenDeAlgomonAElegir seleccionJugador, TablaDeAlgomon tabla,
                          ListaDeRepresentaciones lista, BotonSeleccionarEventHandler botonSeleccionarEventHandler) {
        this.setGraphic(imagen);
        this.setMaxSize(50,50);
        this.requestFocus();
        this.setStyle("-fx-background-color: transparent");
        BotonCambiarIzquierdaEventHandler botonCambiarIzquierdaHandler = new BotonCambiarIzquierdaEventHandler(lista,seleccionJugador,tabla,botonSeleccionarEventHandler);
        this.setOnAction(botonCambiarIzquierdaHandler);
    }
}
