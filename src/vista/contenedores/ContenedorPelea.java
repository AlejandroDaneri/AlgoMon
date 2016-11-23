package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Partida;
import modelo.elementos.*;
import vista.DisplayAlgoMon;
import vista.ListaDeRepresentaciones;
import vista.handlers.BotonAtacarEventHandler;
import vista.handlers.BotonCambiarAlgomonEventHandler;
import vista.handlers.BotonUsarElementoEventHandler;

public class ContenedorPelea extends BorderPane{
	private Stage stage;
	private ListaDeRepresentaciones listaDeRepresentacionesJugador1;
	private ListaDeRepresentaciones listaDeRepresentacionesJugador2;
	
	public ContenedorPelea(Stage primaryStage) {
		stage = primaryStage;
		
		Image fondo = new Image("file:src/vista/imagenes/fondopelea.jpg");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		setBackground(new Background(imagenDeFondo));

	}

	public void inicializarPelea(Partida partida){
		VBox informacionParaJugador1 = crearInformacionParaJugador(partida.jugadorActual());
		informacionParaJugador1.setPadding(new Insets(0,20,0,20));
		VBox informacionParaJugador2 = crearInformacionParaJugador(partida.jugadorOponente());
		informacionParaJugador2.setPadding(new Insets(0,20,0,20));

		listaDeRepresentacionesJugador1 = new ListaDeRepresentaciones(partida.jugadorActual().getListaDeAlgomones());
		listaDeRepresentacionesJugador2 = new ListaDeRepresentaciones(partida.jugadorOponente().getListaDeAlgomones());
		
		HBox panelDeNotificaciones = crearPanelDeNotificaciones();
		panelDeNotificaciones.setAlignment(Pos.CENTER);

		BorderPane contenedorDeAlgomones = crearContenedorDeAlgomones();

		VBox botoneraJugador1 = crearBotonera(partida);
		VBox botoneraJugador2 = crearBotonera(partida);

		VBox zonaJugador1 = new VBox();
		zonaJugador1.getChildren().addAll(informacionParaJugador1,botoneraJugador1);

		VBox zonaJugador2 = new VBox();
		zonaJugador2.getChildren().addAll(informacionParaJugador2,botoneraJugador2);


		this.setLeft(zonaJugador1);
		this.setRight(zonaJugador2);
		this.setBottom(panelDeNotificaciones);
		this.setCenter(contenedorDeAlgomones);
		this.setPadding(new Insets(50));
	}

	private VBox crearBotonera(Partida partida) {
		VBox botonera = new VBox();
		botonera.setSpacing(15);
		botonera.setAlignment(Pos.CENTER);

		VBox opciones = new VBox();
		opciones.setSpacing(15);
		opciones.setAlignment(Pos.CENTER);

		Button botonAtacar = new Button("Atacar");
		BotonAtacarEventHandler botonAtacarEventHandler = new BotonAtacarEventHandler(partida,opciones);
		botonAtacar.setOnAction(botonAtacarEventHandler);

		Button botonUsarElemento = new Button("Usar elemento");
		BotonUsarElementoEventHandler botonUsarElementoEventHandler = new BotonUsarElementoEventHandler(partida.jugadorActual(),partida.jugadorOponente(),opciones);
		botonUsarElemento.setOnAction(botonUsarElementoEventHandler);

		Button botonCambiarAlgomon = new Button("Cambiar Algomon");
		BotonCambiarAlgomonEventHandler botonCambiarAlgomonEventHandler = new BotonCambiarAlgomonEventHandler(partida.jugadorActual(),partida.jugadorOponente(),opciones);
		botonCambiarAlgomon.setOnAction(botonCambiarAlgomonEventHandler);


		botonera.getChildren().addAll(botonAtacar,botonUsarElemento,botonCambiarAlgomon,opciones);
		botonera.setAlignment(Pos.CENTER);
		return botonera;
	}

	private BorderPane crearContenedorDeAlgomones() {
		
		Image fondo = new Image("file:src/vista/imagenes/displayalgomonfondo.png");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		
		BorderPane display = new BorderPane();
		display.setBackground(new Background(imagenDeFondo));
		display.setPadding(new Insets(30));

		VBox displayAlgomon1 = new DisplayAlgoMon(listaDeRepresentacionesJugador1.getActual());
		displayAlgomon1.setPadding(new Insets(0,0,20,0));
		VBox displayAlgomon2 = new DisplayAlgoMon(listaDeRepresentacionesJugador2.getActual());
		displayAlgomon2.setPadding(new Insets(0,0,20,0));
		display.setLeft(displayAlgomon1);
		display.setRight(displayAlgomon2);

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