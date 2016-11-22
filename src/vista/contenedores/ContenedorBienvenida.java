package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.handlers.BotonEntrarEventHandler;
import vista.handlers.BotonReglasEventHandler;
import vista.handlers.BotonSalirEventHandler;

public class ContenedorBienvenida extends VBox{

    private Stage stage;

    public ContenedorBienvenida(Stage primaryStage, AudioClip musicaDeFondo) {
        super();
        this.stage = primaryStage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        stage.setFullScreen(true);

        Label titulo = new Label("Algomon"); // Si el titulo esta en la imagen de fondo esto no va mas
        titulo.setFont(Font.font("Courier New",FontWeight.BOLD, 56));

        Image imagen = new Image("file:src/vista/imagenes/patronfondo.jpg");
        BackgroundImage imagenDeFondo =
                new BackgroundImage(imagen, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("JUGAR");
        botonEntrar.setMinSize(220, 80);
        botonEntrar.setFont(Font.font("Arial Black", FontWeight.BOLD,30));
        botonEntrar.setStyle("-fx-base: #373441");
      
        BotonEntrarEventHandler botonEntrarHandler =
                new BotonEntrarEventHandler(stage,stage.isFullScreen());
        botonEntrar.setOnAction(botonEntrarHandler);

        Button botonReglas = new Button();
        botonReglas.setText("Reglas del juego");
        botonReglas.setFont(Font.font("", 20));
        botonReglas.setStyle("-fx-base: #373441");
        botonReglas.setMinSize(180, 40);

        BotonReglasEventHandler botonReglasHandler =
                new BotonReglasEventHandler(stage);
        botonReglas.setOnAction(botonReglasHandler);

        Button botonSalir = new Button();
        botonSalir.setText("Salir ");
        botonSalir.setFont(Font.font("", 20));
        botonSalir.setStyle("-fx-base: #373441");
        botonSalir.setMinSize(180, 40);

        BotonSalirEventHandler botonSalirHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);

        HBox contenedorVolumen = new HBox();
        inicializarControladorDeVolumen(contenedorVolumen,musicaDeFondo);

        this.getChildren().addAll(titulo, botonEntrar,contenedorVolumen, botonReglas, botonSalir);
        this.setPadding(new Insets(30));
        this.setSpacing(20);


    }

    private void inicializarControladorDeVolumen(HBox contenedorVolumen, AudioClip musicaDeFondo) {
        Slider volumen = new Slider(0,1,1);
        volumen.setMaxWidth(225);
        volumen.setStyle("-fx-base: #373441");

        Image musicaEncendida = new Image("file:src/vista/imagenes/1.png");
        Image musicaApagada = new Image("file:src/vista/imagenes/2.png");
        ImageView imagenVolumen = new ImageView(musicaEncendida);
        imagenVolumen.setFitWidth(50);
        imagenVolumen.setFitHeight(50);
        contenedorVolumen.getChildren().addAll(imagenVolumen,volumen);
        contenedorVolumen.setAlignment(Pos.CENTER);


        volumen.valueProperty().addListener((observadorDeValor, valorAnterior, valorActual) -> {
            if (volumen.getValue() == 0.0) {
                imagenVolumen.setImage(musicaApagada);
                // musicaEstaReproduciendo(false);
            } else {
                imagenVolumen.setImage(musicaEncendida);
                // musicaEstaReproduciendo(true);
            }
            musicaDeFondo.stop();
            musicaDeFondo.play(valorActual.doubleValue());
        });
    }
}
