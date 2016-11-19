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
	
	private List<RepresentacionAlgoMon> lista;
	private int indice;
	private FabricaDeRepresentaciones fabrica;
	
	public ListaDeRepresentaciones(){
		
		// supuesto: el algomon actual es el primero elegido, por eso seteamos el indice en 0
		
		this.fabrica = new FabricaDeRepresentaciones();
		List<RepresentacionAlgoMon> lista = new ArrayList<RepresentacionAlgoMon>();
    	
    	lista.add(fabrica.crearRepresentacion(new Charmander()));
    	lista.add(fabrica.crearRepresentacion(new Bulbasaur()));
    	lista.add(fabrica.crearRepresentacion(new Squirtle()));
    	lista.add(fabrica.crearRepresentacion(new Chansey()));
    	lista.add(fabrica.crearRepresentacion(new Jigglypuff()));
    	lista.add(fabrica.crearRepresentacion(new Rattata()));
    	
    	this.setLista(lista);
    	this.setIndice(0);
	}
	
	public ListaDeRepresentaciones(List<AlgoMon> listaDeAlgoMon){
		this.fabrica = new FabricaDeRepresentaciones();
		List<RepresentacionAlgoMon> lista = new ArrayList<RepresentacionAlgoMon>();
		
		for (AlgoMon algomon : listaDeAlgoMon){
			lista.add(fabrica.crearRepresentacion(algomon));
		}
	}
	
	public RepresentacionAlgoMon siguienteALaIzquierda(){
		this.setIndice(this.getIndice()-1);
		if(this.getIndice() < 0) this.setIndice(this.getLista().size() - 1);
		return this.getActual();
	}
	
	public RepresentacionAlgoMon siguienteALaDerecha(){
		this.setIndice(this.getIndice()+1);
		if(this.getIndice() > (this.getLista().size() - 1)) this.setIndice(0);
		return this.getActual();
	}
	
	public RepresentacionAlgoMon getActual(){
		return this.getLista().get(this.getIndice());
	}

	public List<RepresentacionAlgoMon> getLista() {
		return lista;
	}

	public void setLista(List<RepresentacionAlgoMon> lista) {
		this.lista = lista;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
}
