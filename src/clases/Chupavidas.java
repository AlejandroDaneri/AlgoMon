package clases;

public class Chupavidas extends Ataque {

	public Chupavidas() {
		super(15, 8, Tipo.PLANTA, new ChuparVida());
	}
	
	public int cantidadInicial(){
		int cantidadInicial = 8;
		return cantidadInicial;
	}
	
}
