package clases;

import java.util.ArrayList;
import java.util.List;

public class Rattata extends AlgoMon {

	public Rattata() {
		super(170, null, Tipo.NORMAL);
		List<Ataque> ataques = new ArrayList<Ataque>();
		ataques.add(new Fogonazo());
		ataques.add(new AtaqueRapido());
		ataques.add(new Burbuja());
		this.setAtaques(ataques);
	}
}
