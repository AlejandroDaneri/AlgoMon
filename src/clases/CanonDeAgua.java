package clases;

public class CanonDeAgua extends Ataque {

	public CanonDeAgua() {
		super(20,8,Tipo.AGUA);
	}
	
	public int cantidadInicial(){
		int cantidadInicial = 8;
		return cantidadInicial;
	}

}
