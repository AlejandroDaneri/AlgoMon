package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import clases.Bulbasaur;
import clases.Tipo;

public class BulbasaurTests {
	
	@Test
	public void testCrearBalbasaur() {
		
		Bulbasaur bulbasaur = new Bulbasaur();
		String ataque1 = "LatigoCepa";
		String ataque2 = "AtaqueRapido";
		String ataque3 = "Chupavidas";
		String ataque4 = "Canto";

		
		assertEquals(bulbasaur.getTipo(), Tipo.PLANTA);
		assertEquals(bulbasaur.getVida(), 140);
		assertEquals(bulbasaur.tieneAtaque(ataque1), true);
		assertEquals(bulbasaur.tieneAtaque(ataque2), true);
		assertEquals(bulbasaur.tieneAtaque(ataque3), true);
		assertEquals(bulbasaur.tieneAtaque(ataque4), false);

	}
}
