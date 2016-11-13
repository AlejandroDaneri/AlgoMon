package clases;

public class Pocion implements Elemento {
	
	private int valorCuracion;
	
	public Pocion(){
		this.valorCuracion = 20;
	}
	
	public void aplicar(AlgoMon algomon){
		algomon.aumentarVida(valorCuracion);
	}
}
