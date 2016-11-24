package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.Partida;
import vista.handlers.BotonCambiarAlgomonEventHandler;
import vista.handlers.BotonMenuAtacar;
import vista.handlers.BotonMenuAtacarEventHandler;
import vista.handlers.BotonUsarElementoEventHandler;

public class Botonera extends VBox {
	
	private MenuButton botonAtacar;
	private Button botonUsarElemento;
	private Button botonCambiarAlgomon;
	
    public Botonera(Partida partida, ContenedorPelea contenedor, Jugador jugador) {

        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        VBox opciones = new VBox();
        opciones.setSpacing(15);
        opciones.setAlignment(Pos.CENTER);

        this.botonAtacar = new BotonMenuAtacar(partida,jugador,opciones,contenedor);
        BotonMenuAtacarEventHandler botonMenuAtacarEventHandler = new BotonMenuAtacarEventHandler(botonAtacar);
        botonAtacar.setOnAction(botonMenuAtacarEventHandler);

        this.botonUsarElemento = new Button("Usar elemento");
        BotonUsarElementoEventHandler botonUsarElementoEventHandler = new BotonUsarElementoEventHandler(partida.jugadorActual(),partida.jugadorOponente(),opciones,contenedor);
        botonUsarElemento.setOnAction(botonUsarElementoEventHandler);

        this.botonCambiarAlgomon = new Button("Cambiar Algomon");
        BotonCambiarAlgomonEventHandler botonCambiarAlgomonEventHandler = new BotonCambiarAlgomonEventHandler(partida.jugadorActual(),partida.jugadorOponente(),opciones, contenedor);
        botonCambiarAlgomon.setOnAction(botonCambiarAlgomonEventHandler);


        this.getChildren().addAll(botonAtacar,botonUsarElemento,botonCambiarAlgomon,opciones);
        this.setAlignment(Pos.CENTER);

    }

	public void bloquear(boolean bloqueo) {
		this.botonAtacar.setDisable(bloqueo);
		this.botonCambiarAlgomon.setDisable(bloqueo);
		this.botonUsarElemento.setDisable(bloqueo);
		
	}
}
