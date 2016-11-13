package clases;

public class AtaqueRapido extends Ataque {
	public AtaqueRapido(){
		super("AtaqueRapido",10,16,Tipo.NORMAL);
	}
	
	public int cantidadInicial(){
		return 16;
	}
}
