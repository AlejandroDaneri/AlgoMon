package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modelo.Partida;
import modelo.ataques.Ataque;
import vista.FabricaDeRepresentaciones;
import vista.RepresentacionAlgoMon;

public class BotonAtacarEventHandler extends BotonHandler {
    private Partida partida;
    private VBox opciones;
    

    public BotonAtacarEventHandler(Partida partida, VBox opciones) {
        this.partida = partida;
        this.opciones = opciones;        
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
            opcion.setOnAction(new OpcionEventHandler(partida,ataque));
            ataques.getItems().add(opcion);

        }
        ataques.show();
        //cuando se elige hay que borrar el menuButton del vbox
    }
}
