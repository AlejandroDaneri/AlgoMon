package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Chansey;
import clases.Charmander;
import clases.Jigglypuff;
import clases.Squirtle;
import clases.Tipo;
import excepciones.AtaquesAgotadosException;

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
	
	@Test
	public void testAlgoMonDormido() {
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Chansey chansey = new Chansey();
		try {
			chansey.atacar(jigglypuff, "Canto");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, jigglypuff.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Jigglypuff jigglypuff = new Jigglypuff();
		Charmander charmander = new Charmander();
		try {
			charmander.atacar(jigglypuff, "Fogonazo");
			jigglypuff.nuevoTurno();
			jigglypuff.atacar(charmander, "AtaqueRapido");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(115, jigglypuff.getVida());
	}
	
	@Test
	public void testAlgoMonMuerto() {
		Jigglypuff jigglypuff = new Jigglypuff();
		Squirtle squirtle = new Squirtle();
		try {
			squirtle.atacar(jigglypuff, "AtaqueRapido");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, jigglypuff.estaMuerto());
		
		try {
			for(int i=0; i<6;i++){
				squirtle.atacar(jigglypuff, "AtaqueRapido");
				squirtle.atacar(jigglypuff, "Burbuja");
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, jigglypuff.estaMuerto());
	}

	@Test
	public void testGetNombre() {
		Jigglypuff jigglypuff = new Jigglypuff();
		assertEquals("Jigglypuff",jigglypuff.getNombre());
	}


}