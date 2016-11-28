package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import modelo.Jugador;
import vista.DisplayAlgoMon;

public class ContenedorDeAlgomones extends BorderPane {
    private DisplayAlgoMon displayAlgomon1;
    private DisplayAlgoMon displayAlgomon2;
    private PanelDeNotificacion panelNotificaciones;

    public ContenedorDeAlgomones(Jugador jugador1, Jugador jugador2){

        displayAlgomon1 = new DisplayAlgoMon(jugador1);
        displayAlgomon2 = new DisplayAlgoMon(jugador2);
        panelNotificaciones = new PanelDeNotificacion();

		this.setLeft(displayAlgomon1);
		this.setRight(displayAlgomon2);
		this.setCenter(panelNotificaciones);
        setAlignment(panelNotificaciones,Pos.CENTER);
        setMargin(panelNotificaciones,new Insets(0,0,450,0));
    }
    
    public void cambiarAlgomon(Jugador jugadorActual){
    	DisplayAlgoMon displayNuevo = new DisplayAlgoMon(jugadorActual);
    	if(displayAlgomon1.getJugador().equals(jugadorActual)){
            displayAlgomon1 = displayNuevo;
			displayAlgomon1.girarImagen();
    		this.setLeft(displayNuevo);
    	}
    	else{
    		displayAlgomon2 = displayNuevo;
    		this.setRight(displayNuevo);
    	}
    }
    
    public void notificarPanel(String mensaje){
    	this.panelNotificaciones.agregarMensaje(mensaje);
    }
    
    public void actualizar(){
        displayAlgomon1.actualizar();
        displayAlgomon2.actualizar();
    }
}
