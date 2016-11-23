package vista.contenedores;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import vista.DisplayAlgoMon;
import vista.ListaDeRepresentaciones;

public class ContenedorDeAlgomones extends BorderPane {
    private DisplayAlgoMon displayAlgomon1;
    private DisplayAlgoMon displayAlgomon2;

    public ContenedorDeAlgomones(ListaDeRepresentaciones representacionesJugador1, ListaDeRepresentaciones representacionJugador2){
        Image fondo = new Image("file:src/vista/imagenes/displayalgomonfondo.png");
        BackgroundImage imagenDeFondo =
            new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);

		this.setBackground(new Background(imagenDeFondo));
		this.setPadding(new Insets(30));

        displayAlgomon1 = new DisplayAlgoMon(representacionesJugador1.getActual());
		displayAlgomon1.setPadding(new Insets(0,0,20,0));

        displayAlgomon2 = new DisplayAlgoMon(representacionJugador2.getActual());
		displayAlgomon2.setPadding(new Insets(0,0,20,0));

		this.setLeft(displayAlgomon1);
		this.setRight(displayAlgomon2);
    }

    public void actualizar(){
        displayAlgomon1.actualizar();
        displayAlgomon2.actualizar();
    }
}
