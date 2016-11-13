package clases;

public class Chupavidas extends Ataque {

	public Chupavidas() {
		super("Chupavidas",15, 8, Tipo.PLANTA, new ChuparVida());
	}
	
	public int cantidadInicial(){
		return 8;
	}
	
}
