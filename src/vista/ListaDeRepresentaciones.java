package vista;

import java.util.ArrayList;
import java.util.List;

import clases.AlgoMon;
import clases.Bulbasaur;
import clases.Chansey;
import clases.Charmander;
import clases.Jigglypuff;
import clases.Rattata;
import clases.Squirtle;

public class ListaDeRepresentaciones {
	
	private ArrayList<RepresentacionAlgoMon> lista;
	private int indice;
	private FabricaDeRepresentaciones fabrica;
	
	public ListaDeRepresentaciones(){
		fabrica = new FabricaDeRepresentaciones();
		ArrayList<RepresentacionAlgoMon> lista = new ArrayList<RepresentacionAlgoMon>();
    	
    	lista.add(fabrica.crearRepresentacion(new Charmander()));
    	lista.add(fabrica.crearRepresentacion(new Bulbasaur()));
    	lista.add(fabrica.crearRepresentacion(new Squirtle()));
    	lista.add(fabrica.crearRepresentacion(new Chansey()));
    	lista.add(fabrica.crearRepresentacion(new Jigglypuff()));
    	lista.add(fabrica.crearRepresentacion(new Rattata()));
    	
    	setLista(lista);
    	setIndice(0);
	}
	
	public ListaDeRepresentaciones(ArrayList<AlgoMon> listaDeAlgoMon){
		fabrica = new FabricaDeRepresentaciones();
		lista = new ArrayList<RepresentacionAlgoMon>();
		
		for (AlgoMon algomon : listaDeAlgoMon){
			lista.add(fabrica.crearRepresentacion(algomon));
		}
	}
	
	public RepresentacionAlgoMon siguienteALaIzquierda(){
		setIndice(getIndice()-1);
		if(getIndice() < 0) setIndice(getLista().size() - 1);
		return getActual();
	}
	
	public RepresentacionAlgoMon siguienteALaDerecha(){
		setIndice(getIndice()+1);
		if(getIndice() > (getLista().size() - 1)) setIndice(0);
		return getActual();
	}
	
	public RepresentacionAlgoMon getActual(){
		return lista.get(indice);
	}

	private ArrayList<RepresentacionAlgoMon> getLista() {
		return lista;
	}

	private void setLista(ArrayList<RepresentacionAlgoMon> lista) {
		this.lista = lista;
	}

	private int getIndice() {
		return indice;
	}

	private void setIndice(int indice) {
		this.indice = indice;
	}
}
