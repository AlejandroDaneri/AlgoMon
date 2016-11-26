package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.handlers.BotonEntrarEventHandler;
import vista.handlers.BotonReglasEventHandler;
import vista.handlers.BotonSalirEventHandler;

public class ContenedorBienvenida extends VBox{

    public ContenedorBienvenida(Stage primaryStage, AudioClip musicaDeFondo) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        primaryStage.setFullScreen(true);

        Label titulo = new Label("AlgoMon");
        titulo.setFont(Font.font("Courier New",FontWeight.BOLD, 56));
        titulo.setTextFill(Color.DARKGREY);

        Image imagen = new Image("file:src/vista/imagenes/fondosBienvenida/fondonegro.jpg");

        BackgroundImage imagenDeFondo =
                new BackgroundImage(imagen, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("JUGAR");
        botonEntrar.setTextFill(Color.DARKGREY);
        botonEntrar.setMinSize(220, 80);
        botonEntrar.setFont(Font.font("Arial Black", FontWeight.BOLD,30));
        botonEntrar.setStyle("-fx-base: #373441");
      
        BotonEntrarEventHandler botonEntrarHandler =
                new BotonEntrarEventHandler(primaryStage);
        botonEntrar.setOnAction(botonEntrarHandler);

        Button botonReglas = new Button();
        botonReglas.setText("Reglas del juego");
        botonReglas.setTextFill(Color.DARKGREY);
        botonReglas.setFont(Font.font("", 20));
        botonReglas.setStyle("-fx-base: #373441");
        botonReglas.setMinSize(180, 40);

        BotonReglasEventHandler botonReglasHandler =
                new BotonReglasEventHandler();
        botonReglas.setOnAction(botonReglasHandler);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setTextFill(Color.DARKGREY);
        botonSalir.setFont(Font.font("", 20));
        botonSalir.setStyle("-fx-base: #373441");
        botonSalir.setMinSize(180, 40);

        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);

        ContenedorVolumen contenedorVolumen = new ContenedorVolumen(musicaDeFondo);

        this.getChildren().addAll(titulo, botonEntrar,contenedorVolumen, botonReglas, botonSalir);
        this.setPadding(new Insets(30));
        this.setSpacing(20);
    }
}
