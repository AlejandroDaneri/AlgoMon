package clases;

public class Restaurador implements Elemento {
	
	public void aplicar(AlgoMon algomon){
		algomon.setEstadoPersistente(new EstadoNormal());
		algomon.setEstadoEfimero(new EstadoNormal());
	}
}
