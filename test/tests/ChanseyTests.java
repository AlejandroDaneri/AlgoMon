package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Chansey;
import clases.Tipo;


public class ChanseyTests {
	
	@Test
	public void testCrearChansey() {
		
		Chansey chansey = new Chansey();
		String ataque1 = "Canto";
		String ataque2 = "AtaqueRapido";
		String ataque3 = "LatigoCepa";
		String ataque4 = "Chupavidas";

		
		assertEquals(chansey.getTipo(), Tipo.NORMAL);
		assertEquals(chansey.getVida(), 130);
		assertEquals(chansey.tieneAtaque(ataque1), true);
		assertEquals(chansey.tieneAtaque(ataque2), true);
		assertEquals(chansey.tieneAtaque(ataque3), true);
		assertEquals(chansey.tieneAtaque(ataque4), false);
	}
}