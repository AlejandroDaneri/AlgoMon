package clases;

public class Bulbasaur extends AlgoMon {
	
	public Bulbasaur() {
		super(140, Tipo.PLANTA);
		this.agregarAtaque(new LatigoCepa());
		this.agregarAtaque(new AtaqueRapido());
		this.agregarAtaque(new Chupavidas());
	}

	@Override
	public int getVidaOriginal() {
		return 140;
	}

}
