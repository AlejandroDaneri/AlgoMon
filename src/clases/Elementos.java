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

	public void aplicar(Elemento elemento, AlgoMon algomonActivo) {
		if(!this.tieneElemento(elemento)) throw new ElementoInvalidoException();
		if(this.cantidadElemento(elemento) <= 0) throw new CantidadElementoAgotadaException();
		this.getElemento(elemento).aplicar(algomonActivo);
		this.disminuirCantidad(elemento);
	}
	
	public int cantidadElemento(Elemento elemento){
		int cantidad = this.getElemento(elemento).cantidadElemento();
		return cantidad;
	}
	
	public boolean tieneElemento(Elemento elemento){
		boolean tiene = false;
		if(this.getElemento(elemento) != null) tiene = true;
		return tiene;
	}
	
	public void disminuirCantidad(Elemento elemento){
		this.getElemento(elemento).disminuirCantidad();
	}
	
	public Elemento getElemento(Elemento elemento) {
		Elemento elementoActual = null;
		for(Elemento unElemento: elementos){
			if(unElemento.equals(elemento)) elementoActual = unElemento;;
		}
		return elementoActual;
	}
}
