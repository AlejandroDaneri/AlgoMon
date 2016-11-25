package vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Partida;
import modelo.algomones.AlgoMon;
import vista.BarraDeMenu;
import vista.ListaDeRepresentaciones;

public class ContenedorPelea extends BorderPane{
	private Stage stage;
	private ContenedorDeAlgomones contenedorDeAlgomones;
	private Partida partida;
	private ZonaJugador zonaJugador1;
	private ZonaJugador zonaJugador2;

	public ContenedorPelea(Stage primaryStage) {
		stage = primaryStage;
		
		Image fondo = new Image("file:src/vista/imagenes/fondopelea.jpg");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		setBackground(new Background(imagenDeFondo));
//		this.setPadding(new Insets(50, 0, 50, 0));

		BarraDeMenu menu = new BarraDeMenu(stage);
		this.setTop(menu);
	}

	public void inicializarPelea(Partida partida){
		this.partida = partida;
		
		ListaDeRepresentaciones representacionesJugador1 = new ListaDeRepresentaciones(partida.jugadorActual().getListaDeAlgomones());
		ListaDeRepresentaciones representacionesJugador2 = new ListaDeRepresentaciones(partida.jugadorOponente().getListaDeAlgomones());
		
		HBox panelDeNotificaciones = new PanelDeNotificacion();

		ContenedorDeAlgomones contenedorDeAlgomones = new ContenedorDeAlgomones(representacionesJugador1, representacionesJugador2,
				partida.jugadorActual(),partida.jugadorOponente());

		this.zonaJugador1 = new ZonaJugador(new Botonera(partida,this,partida.jugadorActual()),
				new InformacionParaJugador(partida.jugadorActual()));
		this.zonaJugador2 = new ZonaJugador(new Botonera(partida,this,partida.jugadorOponente()),
				new InformacionParaJugador(partida.jugadorOponente()));

		this.setLeft(zonaJugador1);
		this.setRight(zonaJugador2);
		this.setBottom(panelDeNotificaciones);

		this.contenedorDeAlgomones = contenedorDeAlgomones;
		this.setCenter(contenedorDeAlgomones);
	}

	private void actualizar(){
		contenedorDeAlgomones.actualizar();
		if(this.zonaJugador1.getJugador() == this.partida.jugadorActual()) zonaJugador2.actualizar();
		else zonaJugador1.actualizar();
		
	}
	
	public void cambiarAlgomon(AlgoMon actual){
		contenedorDeAlgomones.cambiarAlgomon(actual,partida.jugadorOponente());
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
		this.zonaJugadorActual().habilitarSoloCambiarAlgoMon();
	}
	
	public void peleaFinalizada(String ganador) {
		VBox contenedor = new VBox(20);

		Label jugadorGanador = new Label("Gano"+ ganador);
		contenedor.getChildren().add(jugadorGanador);
		contenedor.setAlignment(Pos.CENTER);

		Scene scene = new Scene(contenedor);
		stage.setScene(scene);
		stage.show();
	}
}