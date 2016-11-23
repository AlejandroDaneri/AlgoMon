package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import modelo.Jugador;
import modelo.elementos.*;

public class InformacionParaJugador extends VBox {

    public InformacionParaJugador(Jugador jugador) {
        Label nombreDelJugador = new Label(jugador.getNombre());
        nombreDelJugador.setAlignment(Pos.CENTER);
        nombreDelJugador.setTextAlignment(TextAlignment.CENTER);
        nombreDelJugador.setFont(Font.font("Cambria", FontWeight.BOLD, 40));

        Elemento pocion = jugador.getElemento(new Pocion());
        Label pociones = new Label("Pociones: "+pocion.cantidadElemento());
        pociones.setTextAlignment(TextAlignment.LEFT);
        pociones.setFont(Font.font("Cambria", 20));
        pociones.setPadding(new Insets(50,0,20,0));

        Elemento superPocion = jugador.getElemento(new SuperPocion());
        Label superPociones = new Label("Super pociones: "+superPocion.cantidadElemento());
        superPociones.setTextAlignment(TextAlignment.LEFT);
        superPociones.setFont(Font.font("Cambria", 20));
        superPociones.setPadding(new Insets(0,0,20,0));

        Elemento vitamina = jugador.getElemento(new Vitamina());
        Label vitaminas = new Label("Vitamina: "+vitamina.cantidadElemento());
        vitaminas.setTextAlignment(TextAlignment.LEFT);
        vitaminas.setFont(Font.font("Cambria", 20));
        vitaminas.setPadding(new Insets(0,0,20,0));

        Elemento restaurador = jugador.getElemento(new Restaurador());
        Label restauradores = new Label("Restaurador: "+restaurador.cantidadElemento());
        restauradores.setTextAlignment(TextAlignment.LEFT);
        restauradores.setFont(Font.font("Cambria", 20));
        restauradores.setPadding(new Insets(0,0,20,0));


        this.setPadding(new Insets(0,20,0,20));
        this.getChildren().addAll(nombreDelJugador, pociones, superPociones,
                vitaminas, restauradores);


    }
}
