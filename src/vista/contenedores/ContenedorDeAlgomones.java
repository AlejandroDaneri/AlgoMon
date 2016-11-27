package vista.contenedores;

import javafx.scene.layout.BorderPane;
import modelo.Jugador;
import modelo.algomones.AlgoMon;
import vista.DisplayAlgoMon;
import vista.FabricaDeRepresentaciones;
import vista.ListaDeRepresentaciones;
import vista.RepresentacionAlgoMon;

public class ContenedorDeAlgomones extends BorderPane {
    private DisplayAlgoMon displayAlgomon1;
    private DisplayAlgoMon displayAlgomon2;

    public ContenedorDeAlgomones(ListaDeRepresentaciones representacionesJugador1, ListaDeRepresentaciones representacionJugador2
    		,Jugador jugador1, Jugador jugador2){

        displayAlgomon1 = new DisplayAlgoMon(representacionesJugador1.getActual(),jugador1);
        displayAlgomon2 = new DisplayAlgoMon(representacionJugador2.getActual(),jugador2);

		this.setLeft(displayAlgomon1);
		this.setRight(displayAlgomon2);
    }
    
    public void cambiarAlgomon(AlgoMon algomon, Jugador jugadorActual){
    	FabricaDeRepresentaciones fabrica = new FabricaDeRepresentaciones();
		RepresentacionAlgoMon representacion = fabrica.crearRepresentacion(algomon);
		DisplayAlgoMon displayNuevo = new DisplayAlgoMon(representacion,jugadorActual);
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
    
    public void actualizar(){
        displayAlgomon1.actualizar();
        displayAlgomon2.actualizar();
    }
}
