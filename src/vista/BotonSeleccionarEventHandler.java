package vista;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

import clases.AlgoMon;


public class BotonSeleccionarEventHandler extends BotonHandler {
    private ImageView seleccion;
    private HBox seleccionados;
    private List<AlgoMon> algomonesSeleccionados;
    private RepresentacionAlgoMon representacionActual;
    private Button botonSeleccion; //prueba
    private int contador = 0; //prueba
    private static List<AlgoMon> algomonesEnUso = new ArrayList<AlgoMon>();

    public BotonSeleccionarEventHandler(ImageView seleccionJugador, HBox seleccionados, List<AlgoMon> algomonesSeleccionados, RepresentacionAlgoMon representacionActual) {
        this.seleccion = seleccionJugador;
        this.seleccionados = seleccionados;
        this.algomonesSeleccionados = algomonesSeleccionados;
        this.representacionActual = representacionActual;
    }
    
    public void setRepresentacionActual(RepresentacionAlgoMon representacionActual){
    	this.representacionActual = representacionActual;
    }
    
    public void setBotonSeleccion(Button botonSeleccion){
    	this.botonSeleccion = botonSeleccion;
    }
    
    public static List<AlgoMon> getAlgomonesEnUso() {
    	return algomonesEnUso;
    }

    @Override
    public void handle(ActionEvent event) {

        // Agregar el supuesto de que no se puede elegir dos veces al mismo algomon
    	
        super.handle(event);
        
        if (algomonDisponible(representacionActual.getAlgomon())) {
            algomonesSeleccionados.add(representacionActual.getAlgomon());
            this.algomonElegido(representacionActual.getAlgomon());
            if (algomonesSeleccionados.size() == 3) botonSeleccion.setDisable(true);
        }
        else {
        	return;
//        	acá metemos un warning avisando que no se puede.
        }

        ImageView seleccionActual= new ImageView(seleccion.getImage());
        seleccionActual.setFitHeight(150);
        seleccionActual.setFitWidth(150);
        try {
            seleccionados.getChildren().set(contador++,seleccionActual);
        }catch (IndexOutOfBoundsException e) {} //nunca alcanzado
    }

	private void algomonElegido(AlgoMon algomon) {
		BotonSeleccionarEventHandler.getAlgomonesEnUso().add(algomon);
	}

	private boolean algomonDisponible(AlgoMon algomonDeseado) {
		boolean disponible = true;
		for (AlgoMon algomon : BotonSeleccionarEventHandler.getAlgomonesEnUso()) {
			if (algomon.equals(algomonDeseado)) disponible = false;
		}
		return disponible;
	}
}
