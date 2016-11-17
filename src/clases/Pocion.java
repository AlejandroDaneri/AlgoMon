package clases;

public class Pocion extends Elemento {
	
	private int valorCuracion;
	
	public Pocion(){
		this.valorCuracion = 20;
		this.cantidad = 4;
	}
	
	public void aplicar(AlgoMon algomon){
		algomon.aumentarVida(valorCuracion);
	}
}
