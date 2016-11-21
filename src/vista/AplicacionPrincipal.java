package vista;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class AplicacionPrincipal extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        AudioClip musicaDeFondo = new AudioClip("file:src/vista/sonidos/Pokemonentrada.mp3");
        musicaDeFondo.setCycleCount(2); //
        musicaDeFondo.play();

        stagePrincipal.setTitle("AlgoMon");

        ContenedorPelea contenedorPelea = new ContenedorPelea(stagePrincipal);
       //Escena escenaPelea = new Escena(contenedorPelea,stagePrincipal, alto_minimo, ancho_minimo);

        ContenedorBienvenida contenedorBienvenidos =
                new ContenedorBienvenida(stagePrincipal, musicaDeFondo);
        Escena escenaBienvenidos = new Escena(contenedorBienvenidos, stagePrincipal);
       
        stagePrincipal.setScene(escenaBienvenidos);

        stagePrincipal.setFullScreenExitHint("Presione F11 para entrar o salir de la pantalla completa");
        stagePrincipal.setMinHeight(escenaBienvenidos.getAlto_minimo());
        stagePrincipal.setMinWidth(escenaBienvenidos.getAnchoMinimo());
        stagePrincipal.show();

        AlertaHandler alerta = new AlertaHandler();
        stagePrincipal.setOnCloseRequest(alerta);

    }
}
