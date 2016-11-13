package clases;

public class SuperPocion extends Elemento {
	
	private int valorCuracion;
	
	public SuperPocion(){
		this.valorCuracion = 40;
		this.cantidad = 2;
	}
	
	public void aplicar(AlgoMon algomon){
		algomon.aumentarVida(valorCuracion);
	}
	
	public String nombre(){
		return "SuperPocion";
	}
}
