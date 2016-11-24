package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Partida;
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
		this.setPadding(new Insets(50));

	}

	public void inicializarPelea(Partida partida){
		this.partida = partida;
		
		ListaDeRepresentaciones representacionesJugador1 = new ListaDeRepresentaciones(partida.jugadorActual().getListaDeAlgomones());
		ListaDeRepresentaciones representacionesJugador2 = new ListaDeRepresentaciones(partida.jugadorOponente().getListaDeAlgomones());
		
		HBox panelDeNotificaciones = new PanelDeNotifiacion();

		ContenedorDeAlgomones contenedorDeAlgomones = new ContenedorDeAlgomones(representacionesJugador1, representacionesJugador2);

		this.zonaJugador1 = new ZonaJugador(new Botonera(partida,this), new InformacionParaJugador(partida.jugadorActual()));
		this.zonaJugador2 = new ZonaJugador(new Botonera(partida,this), new InformacionParaJugador(partida.jugadorOponente()));

		this.setLeft(zonaJugador1);
		this.setRight(zonaJugador2);
		this.setBottom(panelDeNotificaciones);

		this.contenedorDeAlgomones = contenedorDeAlgomones;
		this.setCenter(contenedorDeAlgomones);
		
		//this.nuevoTurno();
	}

	public void actualizar(){
		contenedorDeAlgomones.actualizar();
	}
	
	public void nuevoTurno(){
		this.actualizar();
		this.zonaJugador2.bloquearBotonera(this.zonaJugador1.getJugador() == this.partida.jugadorActual());
		this.zonaJugador1.bloquearBotonera(!(this.zonaJugador1.getJugador() == this.partida.jugadorActual()));
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