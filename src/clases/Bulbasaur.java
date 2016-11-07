package clases;

import java.util.ArrayList;
import java.util.List;

public class Bulbasaur extends AlgoMon {
	
	public Bulbasaur() {
		super(140, null, Tipo.PLANTA);
		List<Ataque> ataques = new ArrayList<>();
		ataques.add(new LatigoCepa());
		ataques.add(new AtaqueRapido());
		ataques.add(new ChupaVidas());
		this.setAtaques(ataques);
	}
}
