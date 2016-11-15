package clases;

public class Squirtle extends AlgoMon {
	
	public Squirtle() {
		super(150, Tipo.AGUA);
		this.agregarAtaque(new Burbuja());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new CanonDeAgua());
	}

	@Override
	public int obtenerVidaOriginal() {
		return 150;
	}

}
