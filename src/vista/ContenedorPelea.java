package vista;

import clases.Partida;
import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorPelea extends BorderPane{
	private Stage stage;
	
	public ContenedorPelea(Stage primaryStage, Partida partida) {
		super();
		this.stage = primaryStage;
		
		Image fondo = new Image("file:src/vista/imagenes/fondopelea.jpg");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeFondo));
		
		VBox informacionParaJugador1 = crearInformacionParaJugador();
		VBox informacionParaJugador2 = crearInformacionParaJugador();
		HBox panelDeNotificaciones = crearPanelDeNotificaciones();

		this.setLeft(informacionParaJugador1);
		this.setRight(informacionParaJugador2);
		this.setBottom(panelDeNotificaciones);
	}


	private VBox crearInformacionParaJugador() {
		
		return null;
	}
	
	

	private HBox crearPanelDeNotificaciones() {
		// TODO Auto-generated method stub
		return null;
	}
	
}