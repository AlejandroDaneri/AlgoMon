package clases;

import java.util.ArrayList;
import java.util.List;

public class Bulbasaur extends AlgoMon {
	
	public Bulbasaur() {
		super(140, null, Tipo.PLANTA);
		List<Ataque> ataques = new ArrayList<Ataque>();
		ataques.add(new LatigoCepa());
		ataques.add(new AtaqueRapido());
		ataques.add(new Chupavidas());
		this.setAtaques(ataques);
	}

	@Override
	public int obtenerVidaOriginal() {
		return 140;
	}
	
	public String getNombre(){
		return "Bulbasaur";
	}
}
