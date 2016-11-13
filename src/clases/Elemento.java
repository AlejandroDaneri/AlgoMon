package clases;

public abstract class Elemento {
	
	protected int cantidad;
	
	public abstract void aplicar(AlgoMon algomon);
	
	public abstract String nombre();
	
	public void disminuirCantidad(){
		this.cantidad --;
	}
	
	public int cantidadElemento(){
		return cantidad;
	}
	
	public boolean equals(String nombre){
		return this.nombre().equals(nombre);
	}
}
