package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import clases.Jigglypuff;
import clases.Tipo;

public class JigglypuffTest {
	@Test
	public void testCrearNoDevuelveNull() {
		Jigglypuff jigglypuff = new Jigglypuff();
		assertNotNull(jigglypuff);
	}


	@Test
	public void testObtenerVidaOriginal() {
		Jigglypuff jigglypuff = new Jigglypuff();
		assertEquals(jigglypuff.obtenerVidaOriginal(),130);
	}
	@Test
	public void testCrearJigglypuff() {
		
		Jigglypuff jigglypuff = new Jigglypuff();
		String ataque1 = "Canto";
		String ataque2 = "AtaqueRapido";
		String ataque3 = "Burbuja";
		String ataque4 = "Brasas";
		
		assertEquals(jigglypuff.getTipo(), Tipo.NORMAL);
		assertEquals(jigglypuff.getVida(), 130);
		assertEquals(jigglypuff.tieneAtaque(ataque1), true);
		assertEquals(jigglypuff.tieneAtaque(ataque2), true);
		assertEquals(jigglypuff.tieneAtaque(ataque3), true);
		assertEquals(jigglypuff.tieneAtaque(ataque4), false);
	}
}