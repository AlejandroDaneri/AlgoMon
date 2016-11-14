package clases;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Bulbasaur;
import clases.Charmander;
import clases.Jigglypuff;
import clases.Squirtle;
import clases.Tipo;
import excepciones.AtaquesAgotadosException;

public class SquirtleTest {
    @Test
	public void testCrearNoDevuelveNull() {
		Squirtle squirtle = new Squirtle();
		assertNotNull(squirtle);
	}

	@Test
	public void testObtenerVidaOriginal() {
		Squirtle squirtle = new Squirtle();
		assertEquals(squirtle.obtenerVidaOriginal(),150);
	}
	@Test
	public void testCrearSquirtle() {
		
		Squirtle squirtle = new Squirtle();
		String ataque1 = "Burbuja";
		String ataque2 = "AtaqueRapido";
		String ataque3 = "CanonDeAgua";
		String ataque4 = "LatigoCepa";
		
		assertEquals(squirtle.getTipo(), Tipo.AGUA);
		assertEquals(squirtle.getVida(), 150);
		assertEquals(squirtle.tieneAtaque(ataque1), true);
		assertEquals(squirtle.tieneAtaque(ataque2), true);
		assertEquals(squirtle.tieneAtaque(ataque3), true);
		assertEquals(squirtle.tieneAtaque(ataque4), false);		
	}
	
	@Test
	public void testAlgoMonDormido() {
		
		Squirtle squirtle = new Squirtle();
		Jigglypuff jigglypuff = new Jigglypuff();
		try {
			jigglypuff.atacar(squirtle, "Canto");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, squirtle.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Squirtle squirtle = new Squirtle();
		Charmander charmander = new Charmander();
		try {
			charmander.atacar(squirtle, "Fogonazo");
			squirtle.nuevoTurno();
			squirtle.atacar(charmander, "AtaqueRapido");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(134, squirtle.getVida());
	}
	
	@Test
	public void testAlgoMonMuerto() {
		
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();
		try {
			bulbasaur.atacar(squirtle, "Chupavidas");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, squirtle.estaMuerto());

		try {
			for(int i=0; i<4;i++){
				bulbasaur.atacar(squirtle, "Chupavidas");
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, squirtle.estaMuerto());
	}

	@Test
	public void testGetNombre() {
		Squirtle squirtle = new Squirtle();
		assertEquals("Squirtle",squirtle.getNombre());
	}

}