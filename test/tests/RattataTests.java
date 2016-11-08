package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import clases.Rattata;
import clases.Tipo;

public class RattataTests {
	
	@Test
	public void testCrearRattata() {
		
		Rattata rattata = new Rattata();
		String ataque1 = "Fogonazo";
		String ataque2 = "AtaqueRapido";
		String ataque3 = "Burbuja";
		String ataque4 = "CañonDeAgua";
		
		assertEquals(rattata.getTipo(), Tipo.NORMAL);
		assertEquals(rattata.getVida(), 170);
		assertEquals(rattata.tieneAtaque(ataque1), true);
		assertEquals(rattata.tieneAtaque(ataque2), true);
		assertEquals(rattata.tieneAtaque(ataque3), true);
		assertEquals(rattata.tieneAtaque(ataque4), false);
	}
	
	
}