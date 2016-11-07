package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Squirtle;
import clases.Tipo;

public class SquirtleTests {

	@Test
	public void testCrearNoDevuelveNull() {
		Squirtle squirtle = new Squirtle();
		assertNotNull(squirtle);
	}
	@Test
	public void testCrearSquirtle() {
		
		Squirtle squirtle = new Squirtle();
		String ataque1 = "Burbuja";
		String ataque2 = "AtaqueRapido";
		String ataque3 = "CañonDeAgua";
		String ataque4 = "LatigoCepa";
		
		assertEquals(squirtle.getTipo(), Tipo.AGUA);
		assertEquals(squirtle.getVida(), 150);
		assertEquals(squirtle.tieneAtaque(ataque1), true);
		assertEquals(squirtle.tieneAtaque(ataque2), true);
		assertEquals(squirtle.tieneAtaque(ataque3), true);
		assertEquals(squirtle.tieneAtaque(ataque4), false);		
	}
}