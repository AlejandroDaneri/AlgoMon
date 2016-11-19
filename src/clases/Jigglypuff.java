package clases;

public class Jigglypuff extends AlgoMon {
	
	public Jigglypuff() {
		super(130, Tipo.NORMAL);
		this.agregarAtaque(new Canto());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new Burbuja());
	}

	@Override
	public int getVidaOriginal() {
		return 130;
	}

}
