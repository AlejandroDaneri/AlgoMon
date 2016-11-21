package vista;

import clases.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

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

		this.setLeft(informacionParaJugador1);
		this.setRight(informacionParaJugador2);
		this.setBottom(panelDeNotificaciones);
		this.setCenter(contenedorDeAlgomones);
		this.setPadding(new Insets(50));
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

		VBox displayAlgomon1 = crearDisplayAlgomon(listaDeRepresentacionesJugador1.getActual());
		VBox displayAlgomon2 = crearDisplayAlgomon(listaDeRepresentacionesJugador2.getActual());
		display.setLeft(displayAlgomon1);
		display.setRight(displayAlgomon2);

		return display;
	}
	
	private VBox crearDisplayAlgomon(RepresentacionAlgoMon representacion) {

		Label nombreDelAlgomon = new Label(representacion.getAlgomon().getClass().getName().substring(7)); // ya no tenemos un metodo que nos devuelva el nombre del algomon, solucion provisoria
		nombreDelAlgomon.setAlignment(Pos.CENTER);
		nombreDelAlgomon.setTextAlignment(TextAlignment.CENTER);
		nombreDelAlgomon.setFont(Font.font("Cambria", 20));

		ProgressBar progressBar = new ProgressBar(establecerProgreso(representacion.getAlgomon().getVida(),
				representacion.getAlgomon().getVidaOriginal()));
		
		String estadosParaVisualizar = /*representacion.getListaDeEstados().get(0)*/ "Estado"+ ": " + representacion.getListaDeEstados().get(0);
		//aca arriba aparecia dos veces lo mismo y empieza como dormido
		Label estados = new Label(estadosParaVisualizar);
		estados.setFont(Font.font("Cambria", 20));
		
		ImageView imagen = new ImageView(representacion.getImagen());
		imagen.setFitWidth(250);
		imagen.setFitHeight(250);
		
		VBox display = new VBox();
		display.setAlignment(Pos.BOTTOM_CENTER);
		display.getChildren().addAll(imagen, nombreDelAlgomon,progressBar, estados);
		
		return display;
	}

	private double establecerProgreso(int vida, int vidaOriginal) {
		return ((double)vida/(double)vidaOriginal); // siempre menor que 1
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