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

        this.getChildren().addAll(espacioParaJugador1,espacioParaJugador2);
        this.setSpacing(100);
        this.setAlignment(Pos.CENTER);

        /*
        Cuando se termina de elegir
        stage.setScene(escenaBatalla)

         */
    }

    private VBox crearEspacioParaJugador(ArrayList<Image> algomones, ArrayList<Image> tablas) {
        HBox seleccionados = inicializarListaDeElegidos();

        ImageView seleccionJugador = crearImagenDeAlgomonAElegir(algomones);
        ImageView tabla = crearTablaDeAlgomonSeleccionado();

        ImageView flechaIzquierda = crearFlecha("file:src/vista/imagenes/flechaizq.png");
        ImageView flechaDerecha = crearFlecha("file:src/vista/imagenes/flechader.png");

        Button botonCambiarHaciaIzquierda = crearBotonIzquierdo(flechaIzquierda,algomones,seleccionJugador,tabla,tablas);
        Button botonCambiarHaciaDerecha = crearBotonDerecho(flechaDerecha,algomones,seleccionJugador,tabla,tablas);

        BorderPane zonaDeElecccionParaJugador =
                crearZonaDeEleccionParaJugador(botonCambiarHaciaIzquierda,botonCambiarHaciaDerecha,seleccionJugador);
        Button botonSeleccion = crearBotonDeSeleccion();

        VBox espacioParaJugador = new VBox();
        espacioParaJugador.setAlignment(Pos.CENTER);
        espacioParaJugador.getChildren().addAll(seleccionados,zonaDeElecccionParaJugador,tabla,botonSeleccion);

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
        botonCambiarIzquierdo.setStyle("-fx-background-color: transparent");
        botonCambiarIzquierdaEventHandler botonCambiarIzquierdaHandler =
                new botonCambiarIzquierdaEventHandler(algomones,seleccionJugador,tabla,tablas);
        botonCambiarIzquierdo.setOnAction(botonCambiarIzquierdaHandler);
        return botonCambiarIzquierdo;
    }

    private Button crearBotonDerecho(ImageView imagen, ArrayList<Image> algomones,
                                     ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
        Button botonCambiarDerecha = new Button();
        botonCambiarDerecha.setGraphic(imagen);
        botonCambiarDerecha.setMaxSize(50,50);
        botonCambiarDerecha.setStyle("-fx-background-color: transparent");
        botonCambiarDerechaEventHandler botonCambiarDerechaHandler =
                new botonCambiarDerechaEventHandler(algomones,seleccionJugador,tabla,tablas);
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
