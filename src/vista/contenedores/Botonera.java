package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.Partida;
import vista.handlers.BotonMenuAplicarElemento;
import vista.handlers.BotonMenuAtacar;
import vista.handlers.BotonMenuCambiarAlgomon;
import vista.handlers.BotonMenuEventHandler;

public class Botonera extends VBox {
	
	private MenuButton botonAtacar;
	private MenuButton botonUsarElemento;
	private MenuButton botonCambiarAlgomon;
	
    public Botonera(Partida partida, ContenedorPelea contenedor, Jugador jugador) {

        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        VBox opciones = new VBox();
        opciones.setSpacing(15);
        opciones.setAlignment(Pos.CENTER);

        this.botonAtacar = new BotonMenuAtacar(partida,jugador,opciones,contenedor);
        BotonMenuEventHandler botonMenuAtacarEventHandler = new BotonMenuEventHandler(botonAtacar);
        botonAtacar.setOnAction(botonMenuAtacarEventHandler);

        this.botonUsarElemento = new BotonMenuAplicarElemento(partida,jugador,opciones,contenedor);
        BotonMenuEventHandler botonUsarElementoEventHandler = new BotonMenuEventHandler(botonUsarElemento);
        botonUsarElemento.setOnAction(botonUsarElementoEventHandler);

        this.botonCambiarAlgomon = new BotonMenuCambiarAlgomon(partida,jugador,opciones,contenedor);
        BotonMenuEventHandler botonCambiarAlgomonEventHandler = new BotonMenuEventHandler(botonCambiarAlgomon);
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
