package clases;

import java.util.ArrayList;
import java.util.List;

public class Squirtle extends AlgoMon {
	
	public Squirtle() {
		super(150, null, Tipo.AGUA);
		List<Ataque> ataques = new ArrayList<Ataque>();
		ataques.add(new Burbuja());
		ataques.add(new AtaqueRapido());
		ataques.add(new CañonDeAgua());
		this.setAtaques(ataques);
	}
}
