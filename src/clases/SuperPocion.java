package clases;

public class SuperPocion implements Elemento {
	
	private int valorCuracion;
	
	public SuperPocion(){
		this.valorCuracion = 40;
	}
	
	public void aplicar(AlgoMon algomon){
		algomon.aumentarVida(valorCuracion);
	}
}
