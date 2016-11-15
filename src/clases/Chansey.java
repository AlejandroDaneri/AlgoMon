package clases;

public class Chansey extends AlgoMon {
	
	public Chansey() {
		super(130, Tipo.NORMAL);
		this.agregarAtaque(new Canto());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new LatigoCepa());
	}

	@Override
	public int obtenerVidaOriginal() {
		return 130;
	}
	
}
