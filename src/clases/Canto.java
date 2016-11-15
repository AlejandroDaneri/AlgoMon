package clases;

public class Canto extends Ataque {
	
	public Canto() {
		super(0, 6, Tipo.NORMAL, new Dormir());
	}
	
	public int cantidadInicial(){
		int cantidadInicial = 6;
		return cantidadInicial;
	}
}
