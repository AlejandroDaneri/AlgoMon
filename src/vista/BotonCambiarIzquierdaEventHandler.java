package vista;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;


public class BotonCambiarIzquierdaEventHandler extends BotonHandler {
	private final ListaDeRepresentaciones lista;
    private final ImageView seleccion;
    private final ImageView tabla;

    public BotonCambiarIzquierdaEventHandler(ListaDeRepresentaciones lista, ImageView seleccionJugador, ImageView tabla) {
        this.seleccion = seleccionJugador;
        this.tabla = tabla;
        this.lista = lista;
    }

    @Override
    public void handle(ActionEvent event) {
    	super.handle(event);
    	RepresentacionAlgoMon actual = lista.siguienteALaIzquierda();
    	seleccion.setImage(actual.getImagen());
    	tabla.setImage(actual.getTabla());
    }
}
