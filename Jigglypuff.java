package clases;

import java.util.ArrayList;
import java.util.List;

public class Jigglypuff extends AlgoMon {
	
	public Jigglypuff() {
		super(130, null, Tipo.NORMAL);
		List<Ataque> ataques = new ArrayList<Ataque>();
		ataques.add(new Canto());
		ataques.add(new AtaqueRapido());
		ataques.add(new Burbuja());
		this.setAtaques(ataques);
	}

	@Override
	public int obtenerVidaOriginal() {
		return 130;
	}
	
	public String getNombre(){
		return "Jigglypuff";
	}
}
