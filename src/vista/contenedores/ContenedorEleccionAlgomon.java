package vista.contenedores;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Jugador;
import vista.BarraDeMenu;
import vista.handlers.BotonEmpezarEventHandler;

public class ContenedorEleccionAlgomon extends BorderPane{

    public ContenedorEleccionAlgomon(Stage primaryStage, String nombreJugador1, String nombreJugador2) {

        Image fondo = new Image("file:src/vista/imagenes/fondosEleccion/pokefacha.jpg");
        BackgroundImage imagenDeFondo =
                new BackgroundImage(fondo, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        		
        Jugador jugador1 = new Jugador(0,nombreJugador1);
        Jugador jugador2 = new Jugador(1,nombreJugador2);

        VBox espacioParaJugador1 = new EspacioEleccionParaJugador(nombreJugador1,jugador1);
        VBox espacioParaJugador2 = new EspacioEleccionParaJugador(nombreJugador2,jugador2);
        
        /*
        Button botonVolver = new Button();
        BotonVolverHandler botonVolverHandler = new BotonVolverHandler(stage);
        botonVolver.setOnAction(botonVolverHandler);
        queria hacer un boton que vuelva a la pantalla anterior pero no me salio
        */

        Button botonEmpezar = new Button("Empezar Partida");
        BotonEmpezarEventHandler botonEmpezarHandler = new BotonEmpezarEventHandler(
                primaryStage, jugador1, jugador2);
        botonEmpezar.setOnAction(botonEmpezarHandler);
        botonEmpezar.setFont(Font.font("Arial Black", FontWeight.BOLD,20));
        botonEmpezar.setStyle("-fx-base: #373441");


        BarraDeMenu barraDeMenu = new BarraDeMenu(primaryStage);

        this.setTop(barraDeMenu);
        this.setLeft(espacioParaJugador1);
        this.setRight(espacioParaJugador2);
        this.setCenter(botonEmpezar);
        this.setMargin(botonEmpezar,new Insets(300,0,0,0));
        this.setMargin(espacioParaJugador1, new Insets(0,0,0,100));
        this.setMargin(espacioParaJugador2, new Insets(0,100,0,0));
        
    }

    /* una idea a futuro
        private Button crearBotonDeshacer(HBox seleccionados) {
            Button botonDeshacer = new Button("Deshacer");
            botonDeshacer.setFont(Font.font(20));
            BotonDeshacerEventHandler botonDeshacerEventHandler =new BotonDeshacerEventHandler(seleccionados,botonDeshacer);
            botonDeshacer.setOnAction(botonDeshacerEventHandler);
            return botonDeshacer;

        }
    */
}