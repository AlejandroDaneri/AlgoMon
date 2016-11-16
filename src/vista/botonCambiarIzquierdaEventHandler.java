package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class botonCambiarIzquierdaEventHandler extends Boton {
    private final ArrayList<Image> algomones;
    private final ImageView seleccion;
    private final ImageView tabla;
    private final ArrayList<Image> tablas;

    public botonCambiarIzquierdaEventHandler(ArrayList<Image> algomones, ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
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
            seleccion.setImage(algomones.get(indice-1));
            tabla.setImage(tablas.get(indice-1));

        }
        catch (IndexOutOfBoundsException excepcion){
            seleccion.setImage(algomones.get(algomones.size()-1));
            tabla.setImage(tablas.get(tablas.size()-1));

        }
    }
}
