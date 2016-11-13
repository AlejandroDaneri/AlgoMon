package clases;

import java.util.ArrayList;
import java.util.List;


import excepciones.ElementoInvalidoException;
import excepciones.CantidadElementoAgotadaException;

public class Elementos {
	
	private List<Elemento> elementos;
	
	public Elementos () {
		this.setElementos();
	}
	
	public void setElementos() {
		elementos = new ArrayList<Elemento>();
		elementos.add(new Pocion());
		elementos.add(new SuperPocion());
		elementos.add(new Restaurador());
		elementos.add(new Vitamina());
	}

	public void aplicar(String elemento, AlgoMon algomonActivo) {
		if(!this.tieneElemento(elemento)) throw new ElementoInvalidoException();
		if(this.cantidadElemento(elemento) <= 0) throw new CantidadElementoAgotadaException();
		this.getElemento(elemento).aplicar(algomonActivo);
		this.disminuirCantidad(elemento);
	}
	
	public int cantidadElemento(String elementoName){
		int cantidad = this.getElemento(elementoName).cantidadElemento();
		return cantidad;
	}
	
	public boolean tieneElemento(String elementoName){
		boolean tiene = false;
		if(this.getElemento(elementoName) != null) tiene = true;
		return tiene;
	}
	
	public void disminuirCantidad(String elementoName){
		this.getElemento(elementoName).disminuirCantidad();
	}
	
	public Elemento getElemento(String elementoName) {
		Elemento elementoActual = null;
		for(Elemento elemento: elementos){
			if(elemento.equals(elementoName)) elementoActual = elemento;;
		}
		return elementoActual;
	}
}
