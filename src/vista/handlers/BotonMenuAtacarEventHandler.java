package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import vista.handlers.BotonHandler;

public class BotonMenuAtacarEventHandler extends BotonHandler {
	
	private MenuButton boton;
	
	public BotonMenuAtacarEventHandler(MenuButton boton){
		this.boton = boton;
	}
	
	@Override
    public void handle(ActionEvent event) {
       super.handle(event);
       this.boton.show();
    }
}
