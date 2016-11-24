package vista.contenedores;

import javafx.geometry.Pos;
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

        Image fondo = new Image("file:src/vista/imagenes/patronfondo.jpg");
        BackgroundImage imagenDeFondo =
                new BackgroundImage(fondo, BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        		
        Jugador jugador1 = new Jugador(0,nombreJugador1);//cambiar jugador?
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
                primaryStage, nombreJugador1, nombreJugador2, jugador1, jugador2);
        botonEmpezar.setOnAction(botonEmpezarHandler);
        botonEmpezar.setFont(Font.font("Arial Black", FontWeight.BOLD,20));

        BarraDeMenu barraDeMenu = new BarraDeMenu(primaryStage);

        this.setTop(barraDeMenu);
        this.setLeft(espacioParaJugador1);
        this.setRight(espacioParaJugador2);
        this.setBottom(botonEmpezar);
        BorderPane.setAlignment(botonEmpezar,Pos.CENTER);

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