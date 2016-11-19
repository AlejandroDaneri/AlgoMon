package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import clases.AlgoMon;
import clases.Jugador;
import clases.Partida;

public class ContenedorEleccionAlgomon extends BorderPane{
    private Stage stage;
//    private ArrayList<AlgoMon> algomonesEnUso
    public ContenedorEleccionAlgomon(Stage primaryStage, Escena escenaPelea, Partida partida,
    		ArrayList<AlgoMon> algomonesJugador1, ArrayList<AlgoMon> algomonesJugador2) {
    	
        super();
        this.stage = primaryStage;

        Image fondo = new Image("file:src/vista/imagenes/patronfondo.jpg");
        BackgroundImage imagenDeFondo =
                new BackgroundImage(fondo, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        TextField nombreJugador1 = new TextField();
        TextField nombreJugador2 = new TextField();

        VBox espacioParaJugador1 = crearEspacioParaJugador(nombreJugador1, algomonesJugador1);
        VBox espacioParaJugador2 = crearEspacioParaJugador(nombreJugador2, algomonesJugador2);
        /*
        Button botonVolver = new Button();
        BotonVolverHandler botonVolverHandler = new BotonVolverHandler(stage);
        botonVolver.setOnAction(botonVolverHandler);
        queria hacer un boton que vuelva a la pantalla anterior pero no me salio
        */

        Button botonEmpezar = new Button("Empezar Partida");
        BotonEmpezarHandler botonEmpezarHandler = new BotonEmpezarHandler(
        		stage ,escenaPelea, partida, nombreJugador1, nombreJugador2);
        botonEmpezar.setOnAction(botonEmpezarHandler);


        this.setLeft(espacioParaJugador1);
        this.setRight(espacioParaJugador2);
        this.setBottom(botonEmpezar);
        BorderPane.setAlignment(botonEmpezar,Pos.CENTER);
        this.setPadding(new Insets(0,50,50,50));

    }

    private VBox crearEspacioParaJugador(TextField nombreJugador, ArrayList<AlgoMon> algomonesSeleccionados) {

    	ListaDeRepresentaciones lista = new ListaDeRepresentaciones();
    	List<AlgoMon> elegidosJugador = new ArrayList<AlgoMon>();
    	
        Label IngresarNombre = new Label("Ingrese su nombre");
        IngresarNombre.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.ITALIC , 20));
        IngresarNombre.setPadding(new Insets(20,0,20,0));
        nombreJugador.setPromptText("Debe llenar este campo");
        
//        nombre.setPadding(new Insets(20,0,20,0)); esto no sirve para alejarlo de los demas elementos de la interfaz
//        nombre.setOnAction(new EventHandler<ActionEvent>() {
//        		public void handle(ActionEvent e) {
//        			if (nombre.getText() != null) 
//        				jugador.setNombre(nombre.getText());;        	
//        	}
//        });
        
        // en el event handler manejamos que si lo ingresado es ""
        // deje algun comentario visualizable
        
        ImageView seleccionJugador = crearImagenDeAlgomonAElegir(lista);
        ImageView tabla = crearTablaDeAlgomonSeleccionado(lista);
        
        ImageView flechaIzquierda = crearFlecha("file:src/vista/imagenes/flechaizq.png");
        ImageView flechaDerecha = crearFlecha("file:src/vista/imagenes/flechader.png");
        
        HBox seleccionados = inicializarListaDeElegidos();
        seleccionados.setPadding(new Insets(30,0,30,0));
        
        BotonSeleccionarEventHandler botonSeleccionarEventHandler = new BotonSeleccionarEventHandler(
        		seleccionJugador, seleccionados, algomonesSeleccionados, lista.getActual());
        
        Button botonSeleccion = crearBotonDeSeleccion(botonSeleccionarEventHandler);
//        botonSeleccion.setPadding(new Insets(20,0,20,0)); lo mismo que con nombre.setPadding
        Button botonCambiarHaciaIzquierda = crearBotonIzquierdo(flechaIzquierda,
        		seleccionJugador,tabla,lista,botonSeleccionarEventHandler);
        Button botonCambiarHaciaDerecha = crearBotonDerecho(flechaDerecha,
        		seleccionJugador,tabla,lista,botonSeleccionarEventHandler);

        BorderPane zonaDeElecccionParaJugador =
                crearZonaDeEleccionParaJugador(botonCambiarHaciaIzquierda,botonCambiarHaciaDerecha,
                		botonSeleccion,seleccionados,seleccionJugador, tabla, lista.getActual(),
                		elegidosJugador);


        VBox espacioParaJugador = new VBox();
        espacioParaJugador.setAlignment(Pos.CENTER);
        espacioParaJugador.getChildren().addAll(IngresarNombre, nombreJugador, zonaDeElecccionParaJugador);

        //-->
//        nombre.focusedProperty().addListener((observable,  oldValue,  newValue) -> espacioParaJugador.requestFocus());
        //<-- Saca focus del textField nombre

        return espacioParaJugador;
    }

    private Button crearBotonDeSeleccion(BotonSeleccionarEventHandler botonSeleccionarEventHandler) {
        Button botonSeleccion = new Button("Seleccionar");
        botonSeleccion.setFont(Font.font(20));
        botonSeleccionarEventHandler.setBotonSeleccion(botonSeleccion);
        botonSeleccion.setOnAction(botonSeleccionarEventHandler);
        return botonSeleccion;
    }

    private HBox inicializarListaDeElegidos() {
        HBox seleccionados = new HBox();

        ImageView primerSeleccion = crearImagenDeNoElegido();
        ImageView segundaSeleccion = crearImagenDeNoElegido();
        ImageView terceraSeleccion = crearImagenDeNoElegido();

        seleccionados.getChildren().addAll(primerSeleccion,segundaSeleccion,terceraSeleccion);
        seleccionados.setAlignment(Pos.CENTER);
        return seleccionados;
    }

    private ImageView crearImagenDeNoElegido() {
        ImageView noSeleccionado = new ImageView("file:src/vista/imagenes/seleccionVacia.png");
        noSeleccionado.setFitWidth(150);
        noSeleccionado.setFitHeight(150);
        return noSeleccionado;
    }

    private BorderPane crearZonaDeEleccionParaJugador(Button botonCambiarIzquierda,
    		Button botonCambiarDerecha, Button botonSeleccion, HBox seleccionados,
    		ImageView seleccionJugador, ImageView tabla, RepresentacionAlgoMon representacionActual,
    		List<AlgoMon> algomonesSeleccionados) {
    	
        BorderPane zonaJugador = new BorderPane();

        zonaJugador.setTop(seleccionados);
        zonaJugador.setLeft(botonCambiarIzquierda);
        zonaJugador.setRight(botonCambiarDerecha);
        zonaJugador.setCenter(seleccionJugador);
        BorderPane.setAlignment(botonCambiarIzquierda,Pos.CENTER);
        BorderPane.setAlignment(botonCambiarDerecha,Pos.CENTER);
        zonaJugador.setPadding(new Insets(0,0,0,10));

        VBox zonaInferior = new VBox();
        zonaInferior.getChildren().addAll(tabla,botonSeleccion);//aca iria botonera
        zonaInferior.setAlignment(Pos.CENTER);

        zonaJugador.setBottom(zonaInferior);
        return zonaJugador;
    }
/*
    private Button crearBotonDeshacer(HBox seleccionados) {
        Button botonDeshacer = new Button("Deshacer");
        botonDeshacer.setFont(Font.font(20));
        BotonDeshacerEventHandler botonDeshacerEventHandler =new BotonDeshacerEventHandler(seleccionados,botonDeshacer);
        botonDeshacer.setOnAction(botonDeshacerEventHandler);
        return botonDeshacer;

    }
*/
    private ImageView crearTablaDeAlgomonSeleccionado(ListaDeRepresentaciones lista) {
        ImageView tabla = new ImageView(lista.getActual().getTabla());
        tabla.setFitHeight(175);
        tabla.setFitWidth(400);
        return tabla;
    }

    private ImageView crearImagenDeAlgomonAElegir(ListaDeRepresentaciones algomones) {
        ImageView seleccionJugador = new ImageView(algomones.getActual().getImagen());
        seleccionJugador.setFitWidth(250);
        seleccionJugador.setFitHeight(250);
        return seleccionJugador;
    }

    private Button crearBotonIzquierdo(ImageView imagen, ImageView seleccionJugador,
    		ImageView tabla, ListaDeRepresentaciones lista, BotonSeleccionarEventHandler botonSeleccion) {
        Button botonCambiarIzquierdo = new Button();
        botonCambiarIzquierdo.setGraphic(imagen);
        botonCambiarIzquierdo.setMaxSize(50,50);
        botonCambiarIzquierdo.requestFocus();
        botonCambiarIzquierdo.setStyle("-fx-background-color: transparent");
        BotonCambiarIzquierdaEventHandler botonCambiarIzquierdaHandler = new BotonCambiarIzquierdaEventHandler(lista,seleccionJugador,tabla,botonSeleccion);
        botonCambiarIzquierdo.setOnAction(botonCambiarIzquierdaHandler);
        return botonCambiarIzquierdo;
    }

    private Button crearBotonDerecho(ImageView imagen, ImageView seleccionJugador, ImageView tabla,
    		ListaDeRepresentaciones lista, BotonSeleccionarEventHandler botonSelecion) {
        Button botonCambiarDerecha = new Button();
        botonCambiarDerecha.setGraphic(imagen);
        botonCambiarDerecha.setMaxSize(50,50);
        botonCambiarDerecha.setStyle("-fx-background-color: transparent");
        BotonCambiarDerechaEventHandler botonCambiarDerechaHandler = new BotonCambiarDerechaEventHandler(lista,seleccionJugador,tabla,botonSelecion);
        botonCambiarDerecha.setOnAction(botonCambiarDerechaHandler);
        return botonCambiarDerecha;
    }
    
    private ImageView crearFlecha(String origen) {
        Image flecha = new Image(origen);
        ImageView flechaView = new ImageView(flecha);
        flechaView.setFitHeight(50);
        flechaView.setFitWidth(50);
        return flechaView;
    }

}
