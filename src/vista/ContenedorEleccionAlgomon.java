package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ContenedorEleccionAlgomon extends BorderPane{
    private Stage stage;
    public ContenedorEleccionAlgomon(Stage primaryStage) {
        super();
        this.stage = primaryStage;

        ArrayList<Image> algomones = new ArrayList<Image>();

        agregarAlgomon("file:src/vista/imagenes/charmander.png",algomones);
        agregarAlgomon("file:src/vista/imagenes/Bulbasaur.png",algomones);
        agregarAlgomon("file:src/vista/imagenes/Squirtle.png",algomones);
        agregarAlgomon("file:src/vista/imagenes/Chansey.png",algomones);
        agregarAlgomon("file:src/vista/imagenes/Jigglypuff.png",algomones);
        agregarAlgomon("file:src/vista/imagenes/Rattata.png",algomones);

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

        Button botonCambiarIzquierda1 = inicializarBotonIzquierdo(flechaIzq1,algomones,seleccionJugador1);
        Button botonCambiarIzquierda2 = inicializarBotonIzquierdo(flechaIzq2,algomones,seleccionJugador2);

        Button botonCambiarDerecha1 = inicializarBotonDerecho(flechaDer1,algomones,seleccionJugador1);
        Button botonCambiarDerecha2 = inicializarBotonDerecho(flechaDer2,algomones,seleccionJugador2);

        Label nombreIzquierda = new Label("Nombre");//La idea es que aparecezca justo debajo del elegido
        nombreIzquierda.setFont(Font.font(25));

        Label nombreDerecha = new Label("Nombre");//La idea es que aparecezca justo debajo del elegido
        nombreDerecha.setFont(Font.font(25));

        /*
        Todo :Aparte de que aparezca el nombre que aparezcan las caracteristicas, tipo la tabla que ponen en el informe
         */

        BorderPane zonaJugador1 = new BorderPane();
        zonaJugador1.setLeft(botonCambiarIzquierda1);
        zonaJugador1.setRight(botonCambiarDerecha1);
        zonaJugador1.setCenter(seleccionJugador1);
        setAlignment(botonCambiarIzquierda1,Pos.CENTER);
        setAlignment(botonCambiarDerecha1,Pos.CENTER);
        zonaJugador1.setPadding(new Insets(0,0,0,150));
        zonaJugador1.setBottom(nombreIzquierda);

        BorderPane zonaJugador2 = new BorderPane();
        zonaJugador2.setLeft(botonCambiarIzquierda2);
        zonaJugador2.setRight(botonCambiarDerecha2);
        zonaJugador2.setCenter(seleccionJugador2);
        setAlignment(botonCambiarIzquierda2,Pos.CENTER);
        setAlignment(botonCambiarDerecha2,Pos.CENTER);
        zonaJugador2.setPadding(new Insets(0,150,0,0));
        zonaJugador2.setBottom(nombreDerecha);

        setLeft(zonaJugador1);
        setRight(zonaJugador2);

    }

    private Button inicializarBotonIzquierdo(ImageView imagen, ArrayList<Image> algomones, ImageView seleccionJugador) {
        Button botonCambiarIzquierdo = new Button();
        botonCambiarIzquierdo.setGraphic(imagen);
        botonCambiarIzquierdo.setMaxSize(50,50);
        botonCambiarIzquierdo.setStyle("-fx-background-color: transparent");
        botonCambiarIzquierdaEventHandler botonCambiarIzquierdaHandler = new botonCambiarIzquierdaEventHandler(algomones,seleccionJugador);
        botonCambiarIzquierdo.setOnAction(botonCambiarIzquierdaHandler);
        return botonCambiarIzquierdo;
    }

    private Button inicializarBotonDerecho(ImageView imagen, ArrayList<Image> algomones, ImageView seleccionJugador) {
        Button botonCambiarDerecha = new Button();
        botonCambiarDerecha.setGraphic(imagen);
        botonCambiarDerecha.setMaxSize(50,50);
        botonCambiarDerecha.setStyle("-fx-background-color: transparent");
        botonCambiarDerechaEventHandler botonCambiarDerechaHandler = new botonCambiarDerechaEventHandler(algomones,seleccionJugador);
        botonCambiarDerecha.setOnAction(botonCambiarDerechaHandler);
        return botonCambiarDerecha;
    }
    private void agregarAlgomon(String origen, ArrayList<Image> algomones) {
        Image algomon = new Image(origen);
        algomones.add(algomon);
    }

    private ImageView crearFlecha(String origen) {
        Image flecha = new Image(origen);
        ImageView flechaView = new ImageView(flecha);
        flechaView.setFitHeight(50);
        flechaView.setFitWidth(50);
        return flechaView;
    }
}
