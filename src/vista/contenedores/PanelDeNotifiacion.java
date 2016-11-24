package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class PanelDeNotifiacion extends HBox {
    public PanelDeNotifiacion() {
        BackgroundFill fondo = new BackgroundFill(Color.web("#89B0AE"),
                new CornerRadii(1), new Insets(0,0,0,0));


        this.setBackground(new Background(fondo));
        this.setMinWidth(400);
        this.setMinHeight(70);


        Label notificaciones = new Label("Panel de notificaciones");
        notificaciones.setFont(Font.font("Cambria", 15));
        notificaciones.setPadding(new Insets(20));
        notificaciones.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(notificaciones);


    }
}
