package vista;

import javafx.scene.control.Button;
import vista.contenedores.Flecha;
import vista.contenedores.ImagenDeAlgomonAElegir;
import vista.contenedores.TablaDeAlgomon;
import vista.handlers.BotonCambiarDerechaEventHandler;
import vista.handlers.BotonSeleccionarEventHandler;

public class BotonDerecho extends Button {
    public BotonDerecho(Flecha imagen, ImagenDeAlgomonAElegir seleccionJugador, TablaDeAlgomon tabla,
                        ListaDeRepresentaciones lista, BotonSeleccionarEventHandler botonSeleccionarEventHandler) {
        this.setGraphic(imagen);
        this.setMaxSize(50,50);
        this.setStyle("-fx-background-color: transparent");
        BotonCambiarDerechaEventHandler botonCambiarDerechaHandler = new BotonCambiarDerechaEventHandler(lista,seleccionJugador,tabla,botonSeleccionarEventHandler);
        this.setOnAction(botonCambiarDerechaHandler);
    }
}
