package clases;

public class Vitamina implements Elemento {
	
	private int cantidadAumentar;
	
	public Vitamina(){
		this.cantidadAumentar = 2;
	}
	
	public void aplicar(AlgoMon algomon){
		for (Ataque ataque: algomon.getAtaques()){
			ataque.aumentarAtaque(cantidadAumentar);
		}
	}
}
