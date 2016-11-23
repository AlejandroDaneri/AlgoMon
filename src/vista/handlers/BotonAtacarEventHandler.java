package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modelo.Partida;
import modelo.ataques.Ataque;
import vista.FabricaDeRepresentaciones;
import vista.RepresentacionAlgoMon;
import vista.contenedores.ContenedorPelea;

public class BotonAtacarEventHandler extends BotonHandler {
    private Partida partida;
    private VBox opciones;
    private ContenedorPelea contenedor;

    public BotonAtacarEventHandler(Partida partida, VBox opciones,  ContenedorPelea contenedor) {
        this.partida = partida;
        this.opciones = opciones;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        MenuButton ataques = new MenuButton("Elegir ataque");
        opciones.getChildren().add(ataques);
        FabricaDeRepresentaciones fabrica = new FabricaDeRepresentaciones();
        RepresentacionAlgoMon representacion = fabrica.crearRepresentacion(partida.jugadorActual().getAlgomonActivo());
        for(Ataque ataque : partida.jugadorActual().getAlgomonActivo().getAtaques()) {
            MenuItem opcion = new MenuItem(representacion.getNombreDeAtaque(ataque));
            opcion.setOnAction(new OpcionEventHandler(partida,ataque,this.contenedor));
            ataques.getItems().add(opcion);

        }
        ataques.show();
        //cuando se elige hay que borrar el menuButton del vbox
    }
}
