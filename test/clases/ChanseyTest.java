package clases;
import excepciones.AtaquesAgotadosException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ChanseyTest {
	@Test
	public void testCrearNoDevuelveNull() {
		Chansey chansey = new Chansey();
		assertNotNull(chansey);
	}

	@Test
	public void testObtenerVidaOriginal() {
		Chansey chansey = new Chansey();
		assertEquals(chansey.obtenerVidaOriginal(),130);
	}

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
	
	@Test
	public void testAlgoMonDormido() {
		
		Chansey chansey = new Chansey();
		Jigglypuff jigglypuff = new Jigglypuff();
		try {
			jigglypuff.atacar(chansey, "Canto");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, chansey.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Chansey chansey = new Chansey();
		Charmander charmander = new Charmander();
		try {
			charmander.atacar(chansey, "Fogonazo");
			chansey.nuevoTurno();
			chansey.atacar(charmander, "AtaqueRapido");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(115, chansey.getVida());
	}

	@Test
	public void testAlgoMonMuerto() {
		Chansey chansey = new Chansey();
		Charmander charmander = new Charmander();
		try {
			charmander.atacar(chansey, "Brasas");
			charmander.atacar(chansey, "Brasas");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, chansey.estaMuerto());

		try {
			for(int i=0; i<7;i++){
				charmander.atacar(chansey, "Brasas");
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, chansey.estaMuerto());
	}
	@Test
	public void testGetNombre() {
		Chansey chansey = new Chansey();
		assertEquals("Chansey",chansey.getNombre());
	}


}