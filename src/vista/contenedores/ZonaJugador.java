package vista.contenedores;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import modelo.Jugador;

public class ZonaJugador extends VBox {

	private Botonera botonera;
	private InformacionParaJugador informacionParaJugador;
	
	public ZonaJugador(Botonera botonera, InformacionParaJugador informacionParaJugador){
		this.botonera = botonera;
		this.setInformacionParaJugador(informacionParaJugador);
		this.getChildren().addAll(informacionParaJugador,botonera);
		this.setPadding(new Insets(50));
	}
	
	public Jugador getJugador(){
		return this.getInformacionParaJugador().getJugador();
	}
	
	private Botonera getBotonera() {
		return botonera;
	}
	
	void setBotonera(Botonera botonera) {
		this.getChildren().remove(this.botonera);
		this.botonera = botonera;
		this.getChildren().add(this.botonera);
		
	}
	private InformacionParaJugador getInformacionParaJugador() {
		return informacionParaJugador;
	}
	private void setInformacionParaJugador(InformacionParaJugador informacionParaJugador) {
		this.informacionParaJugador = informacionParaJugador;
	}

	public void bloquearBotonera(boolean bloqueo) {
		this.getBotonera().bloquear(bloqueo);		
	}
	
	public void habilitarSoloCambiarAlgoMon(){
		this.botonera.habilitarSoloCambiarAlgoMon();
	}
	
	public void actualizar(){
		informacionParaJugador.actualizar();
	}
	
}
