package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Charmander;
import clases.Tipo;

public class CharmanderTests {
	@Test
	public void testCrearNoDevuelveNull() {
		Charmander charmander = new Charmander();
		assertNotNull(charmander);
	}

	@Test
	public void testCrearCharmander() {
		
		Charmander charmander = new Charmander();
		String ataque1 = "Brasas";
		String ataque2 = "AtaqueRapido";
		String ataque3 = "Fogonazo";
		String ataque4 = "LatigoCepa";
		
		assertEquals(charmander.getTipo(), Tipo.FUEGO);
		assertEquals(charmander.getVida(), 170);
		assertEquals(charmander.tieneAtaque(ataque1), true);
		assertEquals(charmander.tieneAtaque(ataque2), true);
		assertEquals(charmander.tieneAtaque(ataque3), true);
		assertEquals(charmander.tieneAtaque(ataque4), false);
	}
}