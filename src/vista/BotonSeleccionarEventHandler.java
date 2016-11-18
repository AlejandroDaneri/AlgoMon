package vista;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.List;

import clases.AlgoMon;


public class BotonSeleccionarEventHandler extends BotonHandler {
    private ImageView seleccion;
    private HBox seleccionados;
    private List<AlgoMon> algomonesSeleccionados;
    private RepresentacionAlgoMon representacionActual;
    private Button botonSeleccion; //prueba
    private int contador = 0; //prueba

    public BotonSeleccionarEventHandler(ImageView seleccionJugador, HBox seleccionados, Button botonSeleccion,  List<AlgoMon> algomonesSeleccionados, RepresentacionAlgoMon representacionActual) {
        this.botonSeleccion = botonSeleccion;
        this.seleccion = seleccionJugador;
        this.seleccionados = seleccionados;
        this.algomonesSeleccionados = algomonesSeleccionados;
        this.representacionActual = representacionActual;
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
        algomonesSeleccionados.add(representacionActual.getAlgomon());
        if (contador==3) botonSeleccion.setDisable(true);


    }
}
