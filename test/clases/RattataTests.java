package clases;
import org.junit.Test;

import static org.junit.Assert.*;

public class RattataTests {
	@Test
	public void testCrearNoDevuelveNull() {
		Rattata rattata = new Rattata();
		assertNotNull(rattata);
	}

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