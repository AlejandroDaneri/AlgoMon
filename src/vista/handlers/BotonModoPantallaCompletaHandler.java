package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BotonModoPantallaCompletaHandler extends BotonHandler {
	
	private Stage stage;
	private MenuItem menuItem;
	
	public BotonModoPantallaCompletaHandler(Stage primaryStage, MenuItem menuItemPantallaCompleta) {
		super();
		this.stage = primaryStage;
		this.menuItem = menuItemPantallaCompleta;
	}

	public void handle(ActionEvent event) {
		super.handle(event);
		
		if (stage.isFullScreen()) {
			System.out.println("stage IS full screen");
			stage.setFullScreen(false);
			stage.setMaximized(true);
			return;
		}
		if (!stage.isFullScreen()) {
			System.out.println("stage IS NOT full screen");
			stage.setFullScreen(true);
			stage.setMaximized(false);
			return;
		}
	}
}
