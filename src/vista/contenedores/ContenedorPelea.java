package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Partida;
import vista.BarraDeMenu;

public class ContenedorPelea extends BorderPane{
	private Stage stage;
	private ContenedorDeAlgomones contenedorDeAlgomones;
	private Partida partida;
	private ZonaJugador zonaJugador1;
	private ZonaJugador zonaJugador2;

	public ContenedorPelea(Stage primaryStage) {
		stage = primaryStage;
		
		Image fondo = new Image("file:src/vista/imagenes/fondosPelea/estadiopoke.jpg");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		setBackground(new Background(imagenDeFondo));

		BarraDeMenu menu = new BarraDeMenu(stage);
		this.setTop(menu);
	}

	public void inicializarPelea(Partida partida){
		this.partida = partida;

		ContenedorDeAlgomones contenedorDeAlgomones = new ContenedorDeAlgomones(partida.jugadorActual(),partida.jugadorOponente());
		
		this.zonaJugador1 = new ZonaJugador(new Botonera(partida,this,partida.jugadorActual()),
				new InformacionParaJugador(partida.jugadorActual(),Color.DARKRED));
		this.zonaJugador2 = new ZonaJugador(new Botonera(partida,this,partida.jugadorOponente()),
				new InformacionParaJugador(partida.jugadorOponente(),Color.AQUA));

		this.setLeft(zonaJugador1);
		this.setRight(zonaJugador2);

		this.contenedorDeAlgomones = contenedorDeAlgomones;
		this.setCenter(contenedorDeAlgomones);
	}

	private void actualizar(){
		contenedorDeAlgomones.actualizar();
		if(this.zonaJugador1.getJugador() == this.partida.jugadorActual()) zonaJugador2.actualizar();
		else zonaJugador1.actualizar();	
	}
	
	public void notificarPanel(String mensaje){
		this.contenedorDeAlgomones.notificarPanel(mensaje);
	}
	
	public void cambiarAlgomon(){
		contenedorDeAlgomones.cambiarAlgomon(partida.jugadorOponente());
		Botonera botoneraNueva = new Botonera(partida,this,partida.jugadorOponente());
		if(this.zonaJugador1.getJugador() == this.partida.jugadorOponente()) zonaJugador1.setBotonera(botoneraNueva);
		else zonaJugador2.setBotonera(botoneraNueva);
		
	}
	
	public void nuevoTurno(){
		this.actualizar();
		this.zonaJugador2.bloquearBotonera(this.zonaJugador1.getJugador() == this.partida.jugadorActual());
		this.zonaJugador1.bloquearBotonera(!(this.zonaJugador1.getJugador() == this.partida.jugadorActual()));
		if(this.zonaJugadorActual().getJugador().getAlgomonActivo().estaMuerto()) this.manejarCasoAlgoMonActivoMuerto();
	}
	
	private ZonaJugador zonaJugadorActual(){
		if(this.zonaJugador1.getJugador() == this.partida.jugadorActual()) return zonaJugador1;
		return zonaJugador2;
	}
	
	private void manejarCasoAlgoMonActivoMuerto(){
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Atencion!");
    	alert.setHeaderText("Su AlgoMon ha muerto " + this.zonaJugadorActual().getNombreJugador());
    	alert.setContentText("Escoja el Algomon a utilizar!");
    	alert.showAndWait();
		this.zonaJugadorActual().habilitarSoloCambiarAlgoMon();
	}
	
	public void peleaFinalizada(String ganador) {
		VBox contenedor = new VBox(20);

		Label jugadorGanador = new Label("Gano"+ ganador);
		contenedor.getChildren().add(jugadorGanador);
		contenedor.setAlignment(Pos.CENTER);

		Scene scene = new Scene(contenedor);
		stage.setScene(scene);
		AudioClip musica = new AudioClip("file:src/vista/sonidos/victoria.mp3");
		musica.play();
		stage.show();
	}
}