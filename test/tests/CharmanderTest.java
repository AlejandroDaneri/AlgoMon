package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Charmander;
import clases.Jigglypuff;
import clases.Rattata;
import clases.Squirtle;
import clases.Tipo;
import excepciones.AtaquesAgotadosException;

public class CharmanderTest {
	@Test
	public void testCrearNoDevuelveNull() {
		Charmander charmander = new Charmander();
		assertNotNull(charmander);
	}


	@Test
	public void testObtenerVidaOriginal() {
		Charmander charmander = new Charmander();
		assertEquals(charmander.obtenerVidaOriginal(),170);
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
	
	@Test
	public void testAlgoMonDormido() {
		
		Charmander charmander = new Charmander();
		Jigglypuff jigglypuff = new Jigglypuff();
		try {
			jigglypuff.atacar(charmander, "Canto");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, charmander.puedeAtacar());
	}
	
	@Test
	public void testAlgoMonQuemado() {
		
		Charmander charmander = new Charmander();
		Rattata rattata = new Rattata();
		try {
			rattata.atacar(charmander, "Fogonazo");
			charmander.nuevoTurno();
			charmander.atacar(rattata, "AtaqueRapido");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(152, charmander.getVida());
	}
	
	@Test
	public void testAlgoMonMuerto() {
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		try {
			squirtle.atacar(charmander, "CanonDeAgua");
			squirtle.atacar(charmander, "CanonDeAgua");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, charmander.estaMuerto());
		
		try {
			for(int i=0; i<3;i++){
				squirtle.atacar(charmander, "CanonDeAgua");
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, charmander.estaMuerto());
	}
}