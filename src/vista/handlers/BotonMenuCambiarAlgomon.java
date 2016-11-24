package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.Partida;
import modelo.algomones.AlgoMon;
import modelo.ataques.Ataque;
import vista.FabricaDeRepresentaciones;
import vista.RepresentacionAlgoMon;
import vista.contenedores.ContenedorPelea;

public class BotonMenuCambiarAlgomon extends MenuButton {
    private ContenedorPelea contenedor;

    public BotonMenuCambiarAlgomon(Partida partida, Jugador jugador, VBox opciones, ContenedorPelea contenedor) {
    	super("Cambiar Algomon");
        this.contenedor = contenedor;
        opciones.getChildren().add(this);
        FabricaDeRepresentaciones fabrica = new FabricaDeRepresentaciones();
        for(AlgoMon algomon : jugador.getListaDeAlgomones()) {
        	RepresentacionAlgoMon representacion = fabrica.crearRepresentacion(algomon);
        	MenuItem opcion = new MenuItem(representacion.getNombre());
        	opcion.setOnAction(new OpcionCambiarAlgomonEventHandler(partida,algomon,representacion,this.contenedor));
        	this.getItems().add(opcion);
        }
    }
}