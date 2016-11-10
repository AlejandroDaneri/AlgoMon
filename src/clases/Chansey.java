package clases;

import java.util.ArrayList;
import java.util.List;

public class Chansey extends AlgoMon {
	
	public Chansey() {
		super(130, null, Tipo.NORMAL);
		List<Ataque> ataques = new ArrayList<Ataque>();
		ataques.add(new Canto());
		ataques.add(new AtaqueRapido());
		ataques.add(new LatigoCepa());
		this.setAtaques(ataques);
	}

	@Override
	public int obtenerVidaOriginal() {
		return 130;
	}
}
