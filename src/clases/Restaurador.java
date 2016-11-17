package clases;

public class Restaurador extends Elemento {
	
	public Restaurador(){
		this.cantidad = 3;
	}
	
	public void aplicar(AlgoMon algomon){
		algomon.setEstadoPersistente(new EstadoNormal());
		algomon.setEstadoEfimero(new EstadoNormal());
	}
	
}
