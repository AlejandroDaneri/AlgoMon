package vista;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class BotonSeleccionarEventHandler extends BotonHandler {
    private ImageView seleccion;
    private HBox seleccionados;
    private Button botonSeleccion; //prueba
    private int contador = 0; //prueba

    public BotonSeleccionarEventHandler(ImageView seleccionJugador, HBox seleccionados, Button botonSeleccion) {
        this.botonSeleccion = botonSeleccion;
        this.seleccion = seleccionJugador;
        this.seleccionados = seleccionados ;
    }

    @Override
    public void handle(ActionEvent event) {

        //falta que no deje elegir al mismo
        //iria como supuesto si no dice en el informe
        super.handle(event);
        ImageView seleccionActual= new ImageView(seleccion.getImage());
        seleccionActual.setFitHeight(150);
        seleccionActual.setFitWidth(150);
        try {
            seleccionados.getChildren().set(contador++,seleccionActual);
        }catch (IndexOutOfBoundsException e) {} //nunca alcanzado
        if (contador==3) botonSeleccion.setDisable(true);


    }
}
