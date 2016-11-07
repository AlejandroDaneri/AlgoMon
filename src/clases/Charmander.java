package clases;

import java.util.ArrayList;
import java.util.List;

public class Charmander extends AlgoMon {

	public Charmander() {
		super(170, null, Tipo.FUEGO);
		List<Ataque> ataques = new ArrayList<>();
		ataques.add(new Brasas());
		ataques.add(new AtaqueRapido());
		ataques.add(new Fogonazo());
		this.setAtaques(ataques);
	}

}
