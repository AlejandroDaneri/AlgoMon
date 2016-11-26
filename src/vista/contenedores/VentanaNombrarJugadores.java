package vista.contenedores;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaNombrarJugadores {
	
	private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Boolean nombresIngresados;
    
    public VentanaNombrarJugadores (){

        nombreJugador1 = new TextField("Jugador 1");
        nombreJugador2 = new TextField("Jugador 2");
        nombresIngresados = false;

    }
    
    public Boolean jugadoresFueronIngresados(){
        return nombresIngresados;

    }
    
    public void mostrar() {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Nombre Jugadores");
        window.setWidth(1000);
        window.setHeight(600);
        window.centerOnScreen();

        Label labelParaJugador1 = crearLabelParaVentanaNombrarJugadores("Ingresar Nombre Jugador 1");
        Label labelParaJugador2 = crearLabelParaVentanaNombrarJugadores("Ingresar Nombre Jugador 2");

        Button aceptar = new Button("Aceptar");
        aceptar.setTextFill(Color.DARKRED);
        aceptar.setFont(Font.font("", 40));
        aceptar.setStyle("-fx-base: rgb(249,219,189)");
        aceptar.setMinSize(180, 40);

        aceptar.setOnAction(e -> {
            nombresIngresados = true;
            window.close();
        });
        
        ArrayList<Node> lista = new ArrayList<Node>();
        lista.add(labelParaJugador1);
        lista.add(nombreJugador1);
        lista.add(labelParaJugador2);
        lista.add(nombreJugador2);
        lista.add(aceptar);
        
		VBox contenedor = crearContenedorVentanaNombrarJugadores(lista);
        VBox.setMargin(aceptar,new Insets(0,0,10,0));
        VBox.setMargin(labelParaJugador1,new Insets(10,0,0,0));

        Scene scene = new Scene(contenedor);
        window.setScene(scene);
        window.showAndWait();
        
    }
    
    private VBox crearContenedorVentanaNombrarJugadores(ArrayList<Node> lista) {
        VBox contenedor = new VBox(20);
        contenedor.getChildren().addAll(lista);
        contenedor.setAlignment(Pos.CENTER);
        
        Image imagen = new Image("file:src/vista/imagenes/fondosVentanaNombrar/pokebordo1.png");
        BackgroundSize tamano = new BackgroundSize(1000, 600, true, true, true, true);
        BackgroundImage imagenDeFondo = 
        		new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, 
        				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        				tamano);
        contenedor.setBackground(new Background(imagenDeFondo)); 
		return contenedor;
	}

	public Label crearLabelParaVentanaNombrarJugadores(String texto) {
        Label labelParaJugador = new Label();
        labelParaJugador.setText(texto);
        labelParaJugador.setStyle("-fx-border-color:red; -fx-background-color: white; -fx-stroke: black;");
        labelParaJugador.setFont(Font.font("", 30));
        return labelParaJugador;

    }
    
    public String getNombreJugador1 (){
        return nombreJugador1.getText();

    }

    public String getNombreJugador2 (){
        return nombreJugador2.getText();

    }
}
