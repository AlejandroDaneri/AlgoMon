package clases;
import excepciones.AtaquesAgotadosException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BulbasaurTest {

	@Test
	public void testCrearNoDevuelveNull() {
		Bulbasaur bulbasaur = new Bulbasaur();
		assertNotNull(bulbasaur);
	}

	@Test
	public void testObtenerVidaOriginal() {
		Bulbasaur bulbasaur = new Bulbasaur();
		assertEquals(bulbasaur.obtenerVidaOriginal(),140);
	}
	
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
	
	@Test
	public void testAlgoMonDormido() {
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Jigglypuff jigglypuff = new Jigglypuff();
		try {
			jigglypuff.atacar(bulbasaur, "Canto");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, bulbasaur.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		try {
			charmander.atacar(bulbasaur, "Fogonazo");
			bulbasaur.nuevoTurno();
			bulbasaur.atacar(charmander, "AtaqueRapido");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(122, bulbasaur.getVida());
	}
	
	@Test
	public void testAlgoMonMuerto() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		try {
			charmander.atacar(bulbasaur, "Brasas");
			charmander.atacar(bulbasaur, "Brasas");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, bulbasaur.estaMuerto());

		try {
			charmander.atacar(bulbasaur, "Brasas");
			charmander.atacar(bulbasaur, "Brasas");
			charmander.atacar(bulbasaur, "Brasas");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, bulbasaur.estaMuerto());
	}

}
