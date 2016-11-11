package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


public class botonCambiarIzquierdaHandler implements EventHandler<ActionEvent> {
    private final ArrayList<Image> algomones;
    private final ImageView seleccion;

    public botonCambiarIzquierdaHandler(ArrayList<Image> algomones, ImageView seleccionJugador) {
        this.algomones = algomones;
        this.seleccion = seleccionJugador;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            int indice= algomones.indexOf(seleccion.getImage());
            seleccion.setImage(algomones.get(indice-1));
        }
        catch (IndexOutOfBoundsException excepcion){
            seleccion.setImage(algomones.get(algomones.size()-1));
        }
    }
}
