package vista.handlers;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.Partida;
import modelo.ataques.Ataque;
import vista.FabricaDeRepresentaciones;
import vista.RepresentacionAlgoMon;
import vista.contenedores.ContenedorPelea;

public class BotonMenuAtacar extends MenuButton {
    private ContenedorPelea contenedor;

    public BotonMenuAtacar(Partida partida, Jugador jugador, VBox opciones,  ContenedorPelea contenedor) {
    	super("Atacar");
        this.contenedor = contenedor;
        opciones.getChildren().add(this);
        FabricaDeRepresentaciones fabrica = new FabricaDeRepresentaciones();
        RepresentacionAlgoMon representacion = fabrica.crearRepresentacion(jugador.getAlgomonActivo());
        for(Ataque ataque : jugador.getAlgomonActivo().getAtaques()) {
            MenuItem opcion = new MenuItem(representacion.getNombreDeAtaque(ataque));
            opcion.setOnAction(new OpcionAtacarEventHandler(partida,ataque,this.contenedor));
            this.getItems().add(opcion);
        }
    }
}
