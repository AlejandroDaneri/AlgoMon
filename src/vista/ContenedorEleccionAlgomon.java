package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorEleccionAlgomon extends BorderPane{
    private Stage stage;
    public ContenedorEleccionAlgomon(Stage primaryStage, Escena escenaPelea) {
        super();
        this.stage = primaryStage;

        Image fondo = new Image("file:src/vista/imagenes/patronfondo.jpg");
        BackgroundImage imagenDeFondo =
                new BackgroundImage(fondo, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        ArrayList<Image> algomones = crearArrayConImagenesDeAlgomones();
        ArrayList<Image> tablas = crearArrayConTablasDeCaracteristicasDeAlgomones();

        VBox espacioParaJugador1 = crearEspacioParaJugador(algomones,tablas);
        VBox espacioParaJugador2 = crearEspacioParaJugador(algomones,tablas);

        /*
        Button botonVolver = new Button();
        BotonVolverHandler botonVolverHandler = new BotonVolverHandler(stage);
        botonVolver.setOnAction(botonVolverHandler);
        queria hacer un boton que vuelva a la pantalla anterior pero no me salio
        */

        Button botonEmpezar = new Button("Empezar Partida");
        BotonEmpezarHandler botonEmpezarHandler = new BotonEmpezarHandler(stage,escenaPelea);
        botonEmpezar.setOnAction(botonEmpezarHandler);


        this.setLeft(espacioParaJugador1);
        this.setRight(espacioParaJugador2);
        this.setBottom(botonEmpezar);
        this.setAlignment(botonEmpezar,Pos.CENTER);
        this.setPadding(new Insets(0,50,50,50));

    }

    private VBox crearEspacioParaJugador(ArrayList<Image> algomones, ArrayList<Image> tablas) {


        Label IngresarNombre = new Label("Ingrese su nombre");
        TextField nombre = new TextField();
        nombre.setPromptText("Debe llenar este campo");

        ImageView seleccionJugador = crearImagenDeAlgomonAElegir(algomones);
        ImageView tabla = crearTablaDeAlgomonSeleccionado();
        
        ImageView flechaIzquierda = crearFlecha("file:src/vista/imagenes/flechaizq.png");
        ImageView flechaDerecha = crearFlecha("file:src/vista/imagenes/flechader.png");

        Button botonCambiarHaciaIzquierda = crearBotonIzquierdo(flechaIzquierda,algomones,seleccionJugador,tabla,tablas);
        Button botonCambiarHaciaDerecha = crearBotonDerecho(flechaDerecha,algomones,seleccionJugador,tabla,tablas);

        BorderPane zonaDeElecccionParaJugador =
                crearZonaDeEleccionParaJugador(botonCambiarHaciaIzquierda,botonCambiarHaciaDerecha,seleccionJugador,tabla);


        VBox espacioParaJugador = new VBox();
        espacioParaJugador.setAlignment(Pos.CENTER);
        espacioParaJugador.getChildren().addAll(IngresarNombre,nombre,zonaDeElecccionParaJugador);

        //-->
        nombre.focusedProperty().addListener((observable,  oldValue,  newValue) -> espacioParaJugador.requestFocus());
        //<-- Saca focus del textField nombre

        return espacioParaJugador;
    }

    private Button crearBotonDeSeleccion(ImageView seleccionJugador, HBox seleccionados) {
        Button botonSeleccion = new Button("Seleccionar");
        botonSeleccion.setFont(Font.font(20));
        BotonSeleccionarEventHandler botonSeleccionarEventHandler =new BotonSeleccionarEventHandler(seleccionJugador,seleccionados,botonSeleccion);
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
        ImageView noSeleccionado = new ImageView("file:src/vista/imagenes/seleccionVacia.png");//puse cualquiera para probar
        noSeleccionado.setFitWidth(150);
        noSeleccionado.setFitHeight(150);
        return noSeleccionado;
    }

    private BorderPane crearZonaDeEleccionParaJugador(Button botonCambiarIzquierda,
                                                      Button botonCambiarDerecha, ImageView seleccionJugador, ImageView tabla) {
        BorderPane zonaJugador = new BorderPane();

        HBox seleccionados = inicializarListaDeElegidos();

        zonaJugador.setTop(seleccionados);
        zonaJugador.setLeft(botonCambiarIzquierda);
        zonaJugador.setRight(botonCambiarDerecha);
        zonaJugador.setCenter(seleccionJugador);
        zonaJugador.setAlignment(botonCambiarIzquierda,Pos.CENTER);
        zonaJugador.setAlignment(botonCambiarDerecha,Pos.CENTER);
        zonaJugador.setPadding(new Insets(0,0,0,10));

        //HBox botonera = new HBox();
        Button botonSeleccion = crearBotonDeSeleccion(seleccionJugador,seleccionados);
        //Button botonDesahcer = crearBotonDeshacer(seleccionados); deshace la eleccion

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
    private ImageView crearTablaDeAlgomonSeleccionado() {
        ImageView tabla = new ImageView("file:src/vista/imagenes/TCharmander.png");
        tabla.setFitHeight(175);
        tabla.setFitWidth(400);
        return tabla;
    }

    private ImageView crearImagenDeAlgomonAElegir(ArrayList<Image> algomones) {
        ImageView seleccionJugador = new ImageView(algomones.get(0));
        seleccionJugador.setFitWidth(250);
        seleccionJugador.setFitHeight(250);
        return seleccionJugador;
    }


    private ArrayList<Image> crearArrayConTablasDeCaracteristicasDeAlgomones() {
        ArrayList<Image> tablas = new ArrayList<Image>();
        agregarImagenALista("file:src/vista/imagenes/TCharmander.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TBulbasaur.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TSquirtle.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TChansey.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TJigglypuff.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TRattata.png",tablas);
        return tablas;
    }

    private ArrayList<Image> crearArrayConImagenesDeAlgomones() {
        ArrayList<Image> algomones = new ArrayList<Image>();
        agregarImagenALista("file:src/vista/imagenes/Charmander.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Bulbasaur.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Squirtle.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Chansey.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Jigglypuff.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Rattata.png",algomones);
        return algomones;
    }

    private Button crearBotonIzquierdo(ImageView imagen, ArrayList<Image> algomones,
                                       ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
        Button botonCambiarIzquierdo = new Button();
        botonCambiarIzquierdo.setGraphic(imagen);
        botonCambiarIzquierdo.setMaxSize(50,50);
        botonCambiarIzquierdo.requestFocus();
        botonCambiarIzquierdo.setStyle("-fx-background-color: transparent");
        BotonCambiarIzquierdaEventHandler botonCambiarIzquierdaHandler =
                new BotonCambiarIzquierdaEventHandler(algomones,seleccionJugador,tabla,tablas);
        botonCambiarIzquierdo.setOnAction(botonCambiarIzquierdaHandler);
        return botonCambiarIzquierdo;
    }

    private Button crearBotonDerecho(ImageView imagen, ArrayList<Image> algomones,
                                     ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
        Button botonCambiarDerecha = new Button();
        botonCambiarDerecha.setGraphic(imagen);
        botonCambiarDerecha.setMaxSize(50,50);
        botonCambiarDerecha.setStyle("-fx-background-color: transparent");
        BotonCambiarDerechaEventHandler botonCambiarDerechaHandler =
                new BotonCambiarDerechaEventHandler(algomones,seleccionJugador,tabla,tablas);
        botonCambiarDerecha.setOnAction(botonCambiarDerechaHandler);
        return botonCambiarDerecha;
    }
    private void agregarImagenALista(String origen, ArrayList<Image> lista) {
        Image imagen = new Image(origen);
        lista.add(imagen);
    }

    private ImageView crearFlecha(String origen) {
        Image flecha = new Image(origen);
        ImageView flechaView = new ImageView(flecha);
        flechaView.setFitHeight(50);
        flechaView.setFitWidth(50);
        return flechaView;
    }

}
