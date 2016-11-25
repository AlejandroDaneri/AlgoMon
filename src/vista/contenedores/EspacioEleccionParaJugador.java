package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Jugador;
import vista.BotonDerecho;
import vista.BotonIzquierdo;
import vista.BotonSeleccionar;
import vista.ListaDeRepresentaciones;
import vista.handlers.BotonSeleccionarEventHandler;

public class EspacioEleccionParaJugador extends VBox{

    public EspacioEleccionParaJugador(String nombreJugador, Jugador jugador) {

        ListaDeRepresentaciones lista = new ListaDeRepresentaciones();
        
        Label EtiquetaNombre = new Label(nombreJugador);
        EtiquetaNombre.setFont(Font.font("Courier New", FontWeight.BOLD, 40));
        EtiquetaNombre.setTextFill(Color.DARKGREY);

        ImagenDeAlgomonAElegir seleccionJugador = new ImagenDeAlgomonAElegir(lista);
        TablaDeAlgomon tabla = new TablaDeAlgomon(lista);

        Flecha flechaIzquierda = new Flecha("file:src/vista/imagenes/flechaizq.png");
        Flecha flechaDerecha = new Flecha("file:src/vista/imagenes/flechader.png");

        HBox seleccionados = new ListaDeElegidos();
        seleccionados.setPadding(new Insets(13,0,30,0));

        BotonSeleccionarEventHandler botonSeleccionarEventHandler = new BotonSeleccionarEventHandler(
                seleccionJugador, seleccionados, jugador, lista.getActual());

        Button botonSeleccion = new BotonSeleccionar(botonSeleccionarEventHandler);

        Button botonCambiarHaciaIzquierda = new BotonIzquierdo(flechaIzquierda,
                seleccionJugador,tabla,lista,botonSeleccionarEventHandler);
        Button botonCambiarHaciaDerecha = new BotonDerecho(flechaDerecha,
                seleccionJugador,tabla,lista,botonSeleccionarEventHandler);

        BorderPane zonaDeElecccionParaJugador =
                new ZonaDeEleccionParaJugador(botonCambiarHaciaIzquierda,botonCambiarHaciaDerecha,
                        botonSeleccion,seleccionados,seleccionJugador, tabla);


        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(EtiquetaNombre, zonaDeElecccionParaJugador);
        this.setPadding(new Insets(0,20,0,0));

    }
}
