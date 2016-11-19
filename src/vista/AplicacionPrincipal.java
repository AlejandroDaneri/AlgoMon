package vista;

import java.util.ArrayList;

import clases.AlgoMon;
import clases.Partida;
import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class AplicacionPrincipal extends Application{
    private final int ancho_minimo = 1024;
    private final int alto_minimo = 720;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        AudioClip musicaDeFondo = new AudioClip("file:src/vista/sonidos/Pokemonentrada.mp3");
        musicaDeFondo.setCycleCount(2); //
        musicaDeFondo.play();

        stagePrincipal.setTitle("AlgoMon");

        Partida partida = new Partida();
        ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>();
        ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>();

        ContenedorPelea contenedorPelea = new ContenedorPelea(stagePrincipal, partida,
        		algomonesJugador1, algomonesJugador2);
        Escena escenaPelea = new Escena(contenedorPelea,stagePrincipal, alto_minimo, ancho_minimo);

        ContenedorEleccionAlgomon contenedorEleccion =
                new ContenedorEleccionAlgomon(stagePrincipal, escenaPelea, partida, 
                		algomonesJugador1, algomonesJugador2);
        Escena escenaEleccion = new Escena(contenedorEleccion, stagePrincipal, alto_minimo, ancho_minimo);

        ContenedorBienvenida contenedorBienvenidos =
                new ContenedorBienvenida(stagePrincipal, musicaDeFondo, escenaEleccion);
        Escena escenaBienvenidos = new Escena(contenedorBienvenidos, stagePrincipal, alto_minimo, ancho_minimo);

        stagePrincipal.setScene(escenaBienvenidos);

        stagePrincipal.setFullScreenExitHint("Presione F11 para entrar o salir de la pantalla completa");
        stagePrincipal.setMinHeight(alto_minimo);
        stagePrincipal.setMinWidth(ancho_minimo);
        stagePrincipal.show();

        AlertaHandler alerta = new AlertaHandler();
        stagePrincipal.setOnCloseRequest(alerta);

    }
}
