package vista;

import clases.AlgoMon;
import clases.Elemento;
import clases.Jugador;
import clases.Partida;
import clases.Pocion;
import clases.Restaurador;
import clases.SuperPocion;
import clases.Vitamina;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
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
		
		VBox informacionParaJugador1 = crearInformacionParaJugador(partida.jugadorActual());
		informacionParaJugador1.setPadding(new Insets(0,20,0,20));
		VBox informacionParaJugador2 = crearInformacionParaJugador(partida.jugadorOponente());
		informacionParaJugador2.setPadding(new Insets(0,20,0,20));
		HBox panelDeNotificaciones = crearPanelDeNotificaciones();
		panelDeNotificaciones.setAlignment(Pos.CENTER);
//		VBox displayAlgomon1 = crearDisplayAlgomon(AlgoMon algomon1);
//		VBox displayAlgomon2 = crearDisplayAlgomon(AlgoMon algomon2);
		HBox contenedorDeAlgomones = crearContenedorDeAlgomones();

		this.setLeft(informacionParaJugador1);
		this.setRight(informacionParaJugador2);
		this.setBottom(panelDeNotificaciones);
		this.setCenter(contenedorDeAlgomones);
        this.setPadding(new Insets(50));
	}

	private VBox crearDisplayAlgomon() {
		Label nombreDelAlgomon = new Label("AlgoMon1");
		nombreDelAlgomon.setAlignment(Pos.CENTER);
		nombreDelAlgomon.setTextAlignment(TextAlignment.CENTER);
		nombreDelAlgomon.setFont(Font.font("Cambria", 20));
		
//		ProgressBar progressBar = new ProgressBar(algomon.getVida());
		
		VBox display = new VBox();
		display.setAlignment(Pos.TOP_CENTER);
		display.getChildren().addAll(nombreDelAlgomon);
		
		return display;
		
	}

	private HBox crearContenedorDeAlgomones() {
		
		Image fondo = new Image("file:src/vista/imagenes/displayalgomonfondo.png");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		
		HBox display = new HBox();
		display.setBackground(new Background(imagenDeFondo));
		display.setPadding(new Insets(10));
//		esto no salió
		Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
				new CornerRadii(0), BorderWidths.FULL));
		display.setBorder(border);
		return display;
	}


	private VBox crearInformacionParaJugador(Jugador jugador) {
		
		Label nombreDelJugador = new Label(jugador.getNombre());
		nombreDelJugador.setAlignment(Pos.CENTER);
		nombreDelJugador.setTextAlignment(TextAlignment.CENTER);
		nombreDelJugador.setFont(Font.font("Cambria", FontWeight.BOLD, 40));
		
		Elemento pocion = jugador.getElemento(new Pocion());
		Label pociones = new Label("Pociones: "+pocion.cantidadElemento());
		pociones.setTextAlignment(TextAlignment.LEFT);
		pociones.setFont(Font.font("Cambria", 20));
		pociones.setPadding(new Insets(50,0,20,0));
		
		Elemento superPocion = jugador.getElemento(new SuperPocion());
		Label superPociones = new Label("Super pociones: "+superPocion.cantidadElemento());
		superPociones.setTextAlignment(TextAlignment.LEFT);
		superPociones.setFont(Font.font("Cambria", 20));
		superPociones.setPadding(new Insets(0,0,20,0));
		
		Elemento vitamina = jugador.getElemento(new Vitamina());
		Label vitaminas = new Label("Vitamina: "+vitamina.cantidadElemento());
		vitaminas.setTextAlignment(TextAlignment.LEFT);
		vitaminas.setFont(Font.font("Cambria", 20));
		vitaminas.setPadding(new Insets(0,0,20,0));

		Elemento restaurador = jugador.getElemento(new Restaurador());
		Label restauradores = new Label("Restaurador: "+restaurador.cantidadElemento());
		restauradores.setTextAlignment(TextAlignment.LEFT);
		restauradores.setFont(Font.font("Cambria", 20));
		restauradores.setPadding(new Insets(0,0,20,0));

		
		VBox informacionParaJugador = new VBox();
		informacionParaJugador.getChildren().addAll(nombreDelJugador, pociones, superPociones,
				vitaminas, restauradores);
		
		return informacionParaJugador;
	}
	
	

	private HBox crearPanelDeNotificaciones() {
		
		BackgroundFill fondo = new BackgroundFill(Color.web("#89B0AE"),
				new CornerRadii(1), new Insets(0.0,0.0,0.0,0.0));
		
		HBox panel = new HBox();
		panel.setBackground(new Background(fondo));
		panel.setMinWidth(400);
		panel.setMinHeight(70);
		
		Label notificaciones = new Label("Panel de notificaciones");
		notificaciones.setFont(Font.font("Cambria", 15));
		notificaciones.setPadding(new Insets(20));
		notificaciones.setAlignment(Pos.CENTER);
		
		
		panel.getChildren().add(notificaciones);
		
		return panel;
	}
	
}