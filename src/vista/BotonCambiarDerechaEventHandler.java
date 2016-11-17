package vista;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class BotonCambiarDerechaEventHandler extends BotonHandler {
    private final ArrayList<Image> algomones;
    private final ImageView seleccion;
    private final ImageView tabla;
    private final ArrayList<Image> tablas;

    public BotonCambiarDerechaEventHandler(ArrayList<Image> algomones, ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
        this.algomones = algomones;
        this.seleccion = seleccionJugador;
        this.tabla = tabla;
        this.tablas = tablas;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            super.handle(event);
            int indice= algomones.indexOf(seleccion.getImage());
            seleccion.setImage(algomones.get(indice+1));
            tabla.setImage(tablas.get(indice+1));

        }
        catch (IndexOutOfBoundsException excepcion){
            seleccion.setImage(algomones.get(0));
            tabla.setImage(tablas.get(0));
        }
    }
}
