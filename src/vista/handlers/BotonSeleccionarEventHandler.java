package vista.handlers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import modelo.Jugador;
import modelo.algomones.AlgoMon;
import vista.RepresentacionAlgoMon;

import java.util.ArrayList;
import java.util.List;


public class BotonSeleccionarEventHandler extends BotonHandler {
    private ImageView seleccion;
    private HBox seleccionados;
    private Jugador jugador;
    private RepresentacionAlgoMon representacionActual;
    private Button botonSeleccion; //prueba
    private int contador = 0; //prueba
    private List<AlgoMon> algomonesEnUso = new ArrayList<AlgoMon>();

    public BotonSeleccionarEventHandler(ImageView seleccionJugador, HBox seleccionados, Jugador jugador, RepresentacionAlgoMon representacionActual) {
        this.seleccion = seleccionJugador;
        this.seleccionados = seleccionados;
        this.jugador = jugador;
        this.representacionActual = representacionActual;
    }
    
    public void setRepresentacionActual(RepresentacionAlgoMon representacionActual){
    	this.representacionActual = representacionActual;
    }
    
    public void setBotonSeleccion(Button botonSeleccion){
    	this.botonSeleccion = botonSeleccion;
    }
    

    @Override
    public void handle(ActionEvent event) {

        // Agregar el supuesto de que no se puede elegir dos veces al mismo algomon
    	
        super.handle(event);
        
        if (algomonDisponible(representacionActual.getAlgomon())) {
            jugador.agregarAlgomon(representacionActual.getAlgomon());
            this.algomonElegido(representacionActual.getAlgomon());
            if (jugador.cantidadAlgomones() == 3) botonSeleccion.setDisable(true);
        }
        else {
        	return;
//        	acá metemos un warning avisando que no se puede.
        }

        ImageView seleccionActual= new ImageView(seleccion.getImage());
        seleccionActual.setFitHeight(120);
        seleccionActual.setFitWidth(120);
        try {
            seleccionados.getChildren().set(contador++,seleccionActual);
        }catch (IndexOutOfBoundsException e) {} //nunca alcanzado
    }

	private void algomonElegido(AlgoMon algomon) {
		algomonesEnUso.add(algomon);
	}

	private boolean algomonDisponible(AlgoMon algomonDeseado) {
		boolean disponible = true;
		for (AlgoMon algomon : algomonesEnUso) {
			if (algomon.equals(algomonDeseado)) disponible = false;
		}
		return disponible;
	}
}
