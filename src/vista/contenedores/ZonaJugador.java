package vista.contenedores;

import javafx.scene.layout.VBox;
import modelo.Jugador;

public class ZonaJugador extends VBox {

	private Botonera botonera;
	private InformacionParaJugador informacionParaJugador;
	
	public ZonaJugador(Botonera botonera, InformacionParaJugador informacionParaJugador){
		this.setBotonera(botonera);
		this.setInformacionParaJugador(informacionParaJugador);
		this.getChildren().addAll(informacionParaJugador,botonera);
	}
	
	public Jugador getJugador(){
		return this.getInformacionParaJugador().getJugador();
	}
	
	public Botonera getBotonera() {
		return botonera;
	}
	public void setBotonera(Botonera botonera) {
		this.botonera = botonera;
	}
	public InformacionParaJugador getInformacionParaJugador() {
		return informacionParaJugador;
	}
	public void setInformacionParaJugador(InformacionParaJugador informacionParaJugador) {
		this.informacionParaJugador = informacionParaJugador;
	}

	public void bloquearBotonera(boolean bloqueo) {
		this.getBotonera().bloquear(bloqueo);		
	}
	
}
