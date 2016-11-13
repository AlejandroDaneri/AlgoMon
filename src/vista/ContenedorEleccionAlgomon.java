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

        HBox seleccionados1 = new HBox(); //lista de algomones ya elegidos
        ImageView seleccion1 = new ImageView(algomones.get(0));
        seleccion1.setFitWidth(150);
        seleccion1.setFitHeight(150);
        ImageView seleccion2 = new ImageView(algomones.get(1));
        seleccion2.setFitWidth(150);
        seleccion2.setFitHeight(150);
        ImageView seleccion3 = new ImageView(algomones.get(2));
        seleccion3.setFitWidth(150);
        seleccion3.setFitHeight(150);

        seleccionados1.getChildren().addAll(seleccion1,seleccion2,seleccion3);
        seleccionados1.setAlignment(Pos.CENTER);

        HBox seleccionados2 = new HBox(); //lista de algomones ya elegidos
        ImageView seleccion21 = new ImageView(algomones.get(3));
        seleccion21.setFitWidth(150);
        seleccion21.setFitHeight(150);
        ImageView seleccion22 = new ImageView(algomones.get(4));
        seleccion22.setFitWidth(150);
        seleccion22.setFitHeight(150);
        ImageView seleccion23 = new ImageView(algomones.get(5));
        seleccion23.setFitWidth(150);
        seleccion23.setFitHeight(150);

        seleccionados2.getChildren().addAll(seleccion21,seleccion22,seleccion23);
        seleccionados2.setAlignment(Pos.CENTER);


        ImageView seleccionJugador1 = new ImageView(algomones.get(0));
        seleccionJugador1.setFitWidth(250);
        seleccionJugador1.setFitHeight(250);

        ImageView seleccionJugador2 = new ImageView(algomones.get(1));
        seleccionJugador2.setFitWidth(250);
        seleccionJugador2.setFitHeight(250);

        ImageView flechaIzq1 = crearFlecha("file:src/vista/imagenes/flechaizq.png");
        ImageView flechaDer1 = crearFlecha("file:src/vista/imagenes/flechader.png");
        ImageView flechaIzq2 = crearFlecha("file:src/vista/imagenes/flechaizq.png");
        ImageView flechaDer2 = crearFlecha("file:src/vista/imagenes/flechader.png");

        ImageView tabla1 = new ImageView("file:src/vista/imagenes/TCharmander.png");
        tabla1.setFitHeight(175);
        tabla1.setFitWidth(400);

        ImageView tabla2 = new ImageView("file:src/vista/imagenes/TBulbasaur.png");
        tabla2.setFitHeight(175);
        tabla2.setFitWidth(400);

        Button botonCambiarIzquierda1 = inicializarBotonIzquierdo(flechaIzq1,algomones,seleccionJugador1,tabla1,tablas);
        Button botonCambiarIzquierda2 = inicializarBotonIzquierdo(flechaIzq2,algomones,seleccionJugador2,tabla2,tablas);
        Button botonCambiarDerecha1 = inicializarBotonDerecho(flechaDer1,algomones,seleccionJugador1,tabla1,tablas);
        Button botonCambiarDerecha2 = inicializarBotonDerecho(flechaDer2,algomones,seleccionJugador2,tabla2,tablas);


        BorderPane zonaJugador1 = new BorderPane();
        zonaJugador1.setLeft(botonCambiarIzquierda1);
        zonaJugador1.setRight(botonCambiarDerecha1);
        zonaJugador1.setCenter(seleccionJugador1);
        zonaJugador1.setAlignment(botonCambiarIzquierda1,Pos.CENTER);
        zonaJugador1.setAlignment(botonCambiarDerecha1,Pos.CENTER);
        zonaJugador1.setPadding(new Insets(0,0,0,10));
        zonaJugador1.setMaxWidth(500);


        BorderPane zonaJugador2 = new BorderPane();
        zonaJugador2.setLeft(botonCambiarIzquierda2);
        zonaJugador2.setRight(botonCambiarDerecha2);
        zonaJugador2.setCenter(seleccionJugador2);
        zonaJugador2.setAlignment(botonCambiarIzquierda2,Pos.CENTER);
        zonaJugador2.setAlignment(botonCambiarDerecha2,Pos.CENTER);
        zonaJugador2.setPadding(new Insets(0,0,0,10));


        Button botonSeleccion1 = new Button("Seleccionar");
        botonSeleccion1.setFont(Font.font(20));
        BotonSeleccionarEventHandler botonSeleccionarJugador1EH =new BotonSeleccionarEventHandler();
        botonSeleccion1.setOnAction(botonSeleccionarJugador1EH);

        Button botonSeleccion2 = new Button("Seleccionar");
        botonSeleccion2.setFont(Font.font(20));
        BotonSeleccionarEventHandler botonSeleccionarJugador2EH =new BotonSeleccionarEventHandler();
        botonSeleccion1.setOnAction(botonSeleccionarJugador2EH);

        VBox totalJugador1 = new VBox();
        totalJugador1.setAlignment(Pos.CENTER);
        totalJugador1.setPadding(new Insets(0,0,0,100));
        totalJugador1.getChildren().addAll(seleccionados1,zonaJugador1,tabla1,botonSeleccion1);

        VBox totalJugador2 = new VBox();
        totalJugador2.setAlignment(Pos.CENTER);
        totalJugador2.setPadding(new Insets(0,100,0,500));
        totalJugador2.getChildren().addAll(seleccionados2,zonaJugador2,tabla2,botonSeleccion2);

        this.getChildren().addAll(totalJugador1,totalJugador2);
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

    private Button inicializarBotonIzquierdo(ImageView imagen, ArrayList<Image> algomones, ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
        Button botonCambiarIzquierdo = new Button();
        botonCambiarIzquierdo.setGraphic(imagen);
        botonCambiarIzquierdo.setMaxSize(50,50);
        botonCambiarIzquierdo.setStyle("-fx-background-color: transparent");
        botonCambiarIzquierdaEventHandler botonCambiarIzquierdaHandler = new botonCambiarIzquierdaEventHandler(algomones,seleccionJugador,tabla,tablas);
        botonCambiarIzquierdo.setOnAction(botonCambiarIzquierdaHandler);
        return botonCambiarIzquierdo;
    }

    private Button inicializarBotonDerecho(ImageView imagen, ArrayList<Image> algomones, ImageView seleccionJugador, ImageView tabla, ArrayList<Image> tablas) {
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
