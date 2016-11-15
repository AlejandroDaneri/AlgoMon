package clases;

public class Charmander extends AlgoMon {

	public Charmander() {
		super(170, Tipo.FUEGO);
		this.agregarAtaque(new Brasas());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new Fogonazo());
	}

	@Override
	public int obtenerVidaOriginal() {
		return 170;
	}

}
