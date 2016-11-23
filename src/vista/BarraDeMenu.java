package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import vista.handlers.BotonModoPantallaCompletaHandler;
import vista.handlers.BotonReglasEventHandler;
import vista.handlers.BotonSalirEventHandler;

public class BarraDeMenu extends MenuBar {

	private Stage stage;
	
	public BarraDeMenu(Stage primaryStage) {
		
		super();
		this.stage = primaryStage;
		
		Menu menuArchivo = new Menu("Archivo");
		Menu menuEdicion = new Menu("Edición");
		Menu menuAyuda = new Menu("Ayuda");
		
		//opciones de "Archivo"
		MenuItem opcionSalir = new MenuItem("Salir");
		BotonSalirEventHandler opcionSalirHandler = new BotonSalirEventHandler();
		opcionSalir.setOnAction(opcionSalirHandler);
		menuArchivo.getItems().addAll(opcionSalir);
		
		//opciones de "Edicion"
		MenuItem modoPantallaCompleta = new MenuItem("Modo pantalla completa");
		BotonModoPantallaCompletaHandler modoPantallaCompletaHandler= new
				BotonModoPantallaCompletaHandler(stage, modoPantallaCompleta);
		modoPantallaCompleta.setOnAction(modoPantallaCompletaHandler);

//		ésta es una idea a futuro
//		MenuItem musicaDeFondo = new MenuItem("Musica de fondo");
//		BotonMusicaDeFondoEventHandler musicaDeFondoHandler = new BotonMusicaDeFondoEventHandler(audioclip);
//		musicaDeFondo.setOnAction(musicaDeFondoHandler);
		
		menuEdicion.getItems().addAll(modoPantallaCompleta);
		
		//opciones de "Ayuda"
		MenuItem reglasDelJuego = new MenuItem("Reglas del juego");
		BotonReglasEventHandler reglasDelJuegoHandler = new BotonReglasEventHandler();
		reglasDelJuego.setOnAction(reglasDelJuegoHandler);
		
		MenuItem acercaDe = new MenuItem("Acerca de...");
		menuAyuda.getItems().addAll(reglasDelJuego, acercaDe);
		
		this.getMenus().addAll(menuArchivo, menuEdicion, menuAyuda);
        this.prefWidthProperty().bind(stage.minWidthProperty());
	}
	
}
