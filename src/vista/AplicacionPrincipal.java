package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class AplicacionPrincipal extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AudioClip musicaDeFondo = new AudioClip("file:src/vista/sonidos/prueba.mp3");
        musicaDeFondo.setCycleCount(2); //
        musicaDeFondo.play();

       // Juego juego = new Juego();
        primaryStage.setTitle("AlgoMon");

        ContenedorEleccionAlgomon contenedorEleccion =
                new ContenedorEleccionAlgomon(primaryStage);
        Scene escenaEleccion = new Scene(contenedorEleccion, 1024, 720);

        ContenedorBienvenida contenedorBienvenidos =
                new ContenedorBienvenida(primaryStage, musicaDeFondo,escenaEleccion);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 1024, 720);

        primaryStage.setScene(escenaBienvenidos);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");

        primaryStage.show();


    }
}
