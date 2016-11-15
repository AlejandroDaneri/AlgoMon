package clases;

public class Fogonazo extends Ataque {

	public Fogonazo() {
		super(2,4,Tipo.FUEGO, new Quemar());
	}
	
	public int cantidadInicial(){
		int cantidadInicial = 4;
		return cantidadInicial;
	}
}
