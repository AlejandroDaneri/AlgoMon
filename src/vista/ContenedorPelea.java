package vista;

import clases.Partida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
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
		VBox panelDeNotificaciones = crearPanelDeNotificaciones();

		this.setLeft(informacionParaJugador1);
		this.setRight(informacionParaJugador2);
		this.setBottom(panelDeNotificaciones);
        this.setPadding(new Insets(50));
	}


	private VBox crearInformacionParaJugador(/*clases.Jugador jugador*/) {
		
		Label nombreDelJugador = new Label("Marcelo Niembro");
		nombreDelJugador.setAlignment(Pos.CENTER);
		nombreDelJugador.setTextAlignment(TextAlignment.CENTER);
		nombreDelJugador.setFont(Font.font("Cambria", FontWeight.BOLD, 40));
		
		
		VBox informacionParaJugador = new VBox();
		informacionParaJugador .setAlignment(Pos.TOP_LEFT);
		informacionParaJugador.getChildren().addAll(nombreDelJugador);
//        informacionParaJugador.setSpacing(20);
		
		return informacionParaJugador;
	}
	
	

	private VBox crearPanelDeNotificaciones() {
		
		BackgroundFill fondo = new BackgroundFill(Color.BLUEVIOLET,
				new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		
		VBox panel = new VBox();
		panel.setBackground(new Background(fondo));
		return panel;
	}
	
}