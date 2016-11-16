package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorEleccionAlgomon extends HBox{
    private Stage stage;
    public ContenedorEleccionAlgomon(Stage primaryStage) {
        super();
        this.stage = primaryStage;

        Image imagen = new Image("file:src/vista/imagenes/patronfondo.jpg");
        BackgroundImage imagenDeFondo =
                new BackgroundImage(imagen, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        ArrayList<Image> algomones = new ArrayList<Image>(); //lista de imagenes de algomones
        inicializarAlgomones(algomones);

        ArrayList<Image> tablas = new ArrayList<Image>(); //lista de tablas de caracteristicas
        inicializarTablas(tablas);

        VBox espacioParaJugador1 = crearEspacioParaJugador(algomones,tablas);
        VBox espacioParaJugador2 = crearEspacioParaJugador(algomones,tablas);

        this.getChildren().addAll(espacioParaJugador1,espacioParaJugador2);
        this.setSpacing(100);
        this.setAlignment(Pos.CENTER);

    }

    private VBox crearEspacioParaJugador(ArrayList<Image> algomones, ArrayList<Image> tablas) {
        HBox seleccionados1 = inicializarListaDeElegidos();

        ImageView seleccionJugador1 = crearImagenDeAlgomonAElegir(algomones);
        ImageView tabla1 = crearTablaDeAlgomonSeleccionado();

        ImageView flechaIzq1 = crearFlecha("file:src/vista/imagenes/flechaizq.png");
        ImageView flechaDer1 = crearFlecha("file:src/vista/imagenes/flechader.png");

        Button botonCambiarIzquierda1 = crearBotonIzquierdo(flechaIzq1,algomones,seleccionJugador1,tabla1,tablas);
        Button botonCambiarDerecha1 = crearBotonDerecho(flechaDer1,algomones,seleccionJugador1,tabla1,tablas);

        BorderPane zonaDeElecccionParaJugador1 =
                crearZonaDeEleccionParaJugador(botonCambiarIzquierda1,botonCambiarDerecha1,seleccionJugador1);
        Button botonSeleccion1 = crearBotonDeSeleccion();

        VBox espacioParaJugador = new VBox();
        espacioParaJugador.setAlignment(Pos.CENTER);
        espacioParaJugador.getChildren().addAll(seleccionados1,zonaDeElecccionParaJugador1,tabla1,botonSeleccion1);

        return espacioParaJugador;
    }

    private Button crearBotonDeSeleccion() {
        Button botonSeleccion = new Button("Seleccionar");
        botonSeleccion.setFont(Font.font(20));
        BotonSeleccionarEventHandler botonSeleccionarEventHandler =new BotonSeleccionarEventHandler();
        botonSeleccion.setOnAction(botonSeleccionarEventHandler);
        return botonSeleccion;
    }

    private HBox inicializarListaDeElegidos() {
        HBox seleccionados = new HBox(); //lista de algomones ya elegidos
        //inicializarElegidos()
        ImageView seleccion1 = crearImagenDeNoElegido();
        ImageView seleccion2 = crearImagenDeNoElegido();
        ImageView seleccion3 = crearImagenDeNoElegido();

        seleccionados.getChildren().addAll(seleccion1,seleccion2,seleccion3);
        seleccionados.setAlignment(Pos.CENTER);
        return seleccionados;
    }

    private ImageView crearImagenDeNoElegido() {
        ImageView seleccion = new ImageView("file:src/vista/imagenes/seleccionVacia.png");//puse cualquiera para probar
        seleccion.setFitWidth(150);
        seleccion.setFitHeight(150);
        return seleccion;
    }

    private BorderPane crearZonaDeEleccionParaJugador(Button botonCambiarIzquierda,
                                                      Button botonCambiarDerecha, ImageView seleccionJugador) {
        BorderPane zonaJugador = new BorderPane();
        zonaJugador.setLeft(botonCambiarIzquierda);
        zonaJugador.setRight(botonCambiarDerecha);
        zonaJugador.setCenter(seleccionJugador);
        zonaJugador.setAlignment(botonCambiarIzquierda,Pos.CENTER);
        zonaJugador.setAlignment(botonCambiarDerecha,Pos.CENTER);
        zonaJugador.setPadding(new Insets(0,0,0,10));
        return zonaJugador;
    }

    private ImageView crearTablaDeAlgomonSeleccionado() {
        ImageView tabla = new ImageView("file:src/vista/imagenes/TCharmander.png");
        tabla.setFitHeight(175);
        tabla.setFitWidth(400);
        return  tabla;
    }

    private ImageView crearImagenDeAlgomonAElegir(ArrayList<Image> algomones) {
        ImageView seleccionJugador = new ImageView(algomones.get(0));
        seleccionJugador.setFitWidth(250);
        seleccionJugador.setFitHeight(250);
        return seleccionJugador;
    }


    private void inicializarTablas(ArrayList<Image> tablas) {
        agregarImagenALista("file:src/vista/imagenes/TCharmander.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TBulbasaur.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TSquirtle.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TChansey.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TJigglypuff.png",tablas);
        agregarImagenALista("file:src/vista/imagenes/TRattata.png",tablas);
    }

    private void inicializarAlgomones(ArrayList<Image> algomones) {
        agregarImagenALista("file:src/vista/imagenes/Charmander.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Bulbasaur.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Squirtle.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Chansey.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Jigglypuff.png",algomones);
        agregarImagenALista("file:src/vista/imagenes/Rattata.png",algomones);
    }

    private Button crearBotonIzquierdo(ImageView imagen, ArrayList<Image> algomones, ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
        Button botonCambiarIzquierdo = new Button();
        botonCambiarIzquierdo.setGraphic(imagen);
        botonCambiarIzquierdo.setMaxSize(50,50);
        botonCambiarIzquierdo.setStyle("-fx-background-color: transparent");
        botonCambiarIzquierdaEventHandler botonCambiarIzquierdaHandler = new botonCambiarIzquierdaEventHandler(algomones,seleccionJugador,tabla,tablas);
        botonCambiarIzquierdo.setOnAction(botonCambiarIzquierdaHandler);
        return botonCambiarIzquierdo;
    }

    private Button crearBotonDerecho(ImageView imagen, ArrayList<Image> algomones, ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
        Button botonCambiarDerecha = new Button();
        botonCambiarDerecha.setGraphic(imagen);
        botonCambiarDerecha.setMaxSize(50,50);
        botonCambiarDerecha.setStyle("-fx-background-color: transparent");
        botonCambiarDerechaEventHandler botonCambiarDerechaHandler = new botonCambiarDerechaEventHandler(algomones,seleccionJugador,tabla,tablas);
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
