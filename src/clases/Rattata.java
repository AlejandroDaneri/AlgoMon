package clases;

public class Rattata extends AlgoMon {

	public Rattata() {
		super(170, Tipo.NORMAL);
		this.agregarAtaque(new Fogonazo());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new Burbuja());
	}

	@Override
	public int getVidaOriginal() {
		return 170;
	}
}
