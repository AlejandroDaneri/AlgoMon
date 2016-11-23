package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Partida;
import vista.ListaDeRepresentaciones;

public class ContenedorPelea extends BorderPane{
	private Stage stage;
	private ContenedorDeAlgomones contenedorDeAlgomones;

	public ContenedorPelea(Stage primaryStage) {
		stage = primaryStage;
		
		Image fondo = new Image("file:src/vista/imagenes/fondopelea.jpg");
		BackgroundImage imagenDeFondo =
				new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						BackgroundSize.DEFAULT);
		setBackground(new Background(imagenDeFondo));
		this.setPadding(new Insets(50));

	}

	public void inicializarPelea(Partida partida){
		VBox informacionParaJugador1 = new InformacionParaJugador(partida.jugadorActual());
		VBox informacionParaJugador2 = new InformacionParaJugador(partida.jugadorOponente());

		ListaDeRepresentaciones representacionesJugador1 = new ListaDeRepresentaciones(partida.jugadorActual().getListaDeAlgomones());
		ListaDeRepresentaciones representacionesJugador2 = new ListaDeRepresentaciones(partida.jugadorOponente().getListaDeAlgomones());
		
		HBox panelDeNotificaciones = new PanelDeNotifiacion();

		ContenedorDeAlgomones contenedorDeAlgomones = new ContenedorDeAlgomones(representacionesJugador1, representacionesJugador2);

		VBox botoneraJugador1 = new Botonera(partida,this);
		VBox botoneraJugador2 = new Botonera(partida,this);

		VBox zonaJugador1 = new VBox();
		zonaJugador1.getChildren().addAll(informacionParaJugador1,botoneraJugador1);

		VBox zonaJugador2 = new VBox();
		zonaJugador2.getChildren().addAll(informacionParaJugador2,botoneraJugador2);

		this.setLeft(zonaJugador1);
		this.setRight(zonaJugador2);
		this.setBottom(panelDeNotificaciones);

		this.contenedorDeAlgomones = contenedorDeAlgomones;
		this.setCenter(contenedorDeAlgomones);
	}

	public void actualizar(){
		contenedorDeAlgomones.actualizar();
	}

	public void peleaFinalizada(String ganador) {
		VBox contenedor = new VBox(20);

		Label jugadorGanador = new Label("Gano"+ ganador);
		contenedor.getChildren().add(jugadorGanador);
		contenedor.setAlignment(Pos.CENTER);

		Scene scene = new Scene(contenedor);
		stage.setScene(scene);
		stage.show();
	}
}