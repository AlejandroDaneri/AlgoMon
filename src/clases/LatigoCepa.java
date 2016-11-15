package clases;

public class LatigoCepa extends Ataque {

	public LatigoCepa() {
		super(15,10,Tipo.PLANTA);
	}
	
	public int cantidadInicial(){
		int cantidadInicial = 10;
		return cantidadInicial;
	}

}
