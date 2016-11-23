package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.Partida;
import vista.handlers.BotonAtacarEventHandler;
import vista.handlers.BotonCambiarAlgomonEventHandler;
import vista.handlers.BotonUsarElementoEventHandler;

public class Botonera extends VBox {
    public Botonera(Partida partida) {

        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        VBox opciones = new VBox();
        opciones.setSpacing(15);
        opciones.setAlignment(Pos.CENTER);

        Button botonAtacar = new Button("Atacar");
        BotonAtacarEventHandler botonAtacarEventHandler = new BotonAtacarEventHandler(partida,opciones);
        botonAtacar.setOnAction(botonAtacarEventHandler);

        Button botonUsarElemento = new Button("Usar elemento");
        BotonUsarElementoEventHandler botonUsarElementoEventHandler = new BotonUsarElementoEventHandler(partida.jugadorActual(),partida.jugadorOponente(),opciones);
        botonUsarElemento.setOnAction(botonUsarElementoEventHandler);

        Button botonCambiarAlgomon = new Button("Cambiar Algomon");
        BotonCambiarAlgomonEventHandler botonCambiarAlgomonEventHandler = new BotonCambiarAlgomonEventHandler(partida.jugadorActual(),partida.jugadorOponente(),opciones);
        botonCambiarAlgomon.setOnAction(botonCambiarAlgomonEventHandler);


        this.getChildren().addAll(botonAtacar,botonUsarElemento,botonCambiarAlgomon,opciones);
        this.setAlignment(Pos.CENTER);

    }
}
