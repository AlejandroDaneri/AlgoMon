package clases;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Charmander;
import clases.Jigglypuff;
import clases.Rattata;
import clases.Squirtle;
import clases.Tipo;
import excepciones.AtaquesAgotadosException;

public class RattataTest {
	@Test
	public void testCrearNoDevuelveNull() {
		Rattata rattata = new Rattata();
		assertNotNull(rattata);
	}


	@Test
	public void testObtenerVidaOriginal() {
		Rattata rattata = new Rattata();
		assertEquals(rattata.obtenerVidaOriginal(),170);
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
	
	@Test
	public void testAlgoMonDormido() {
		
		Rattata rattata = new Rattata();
		Jigglypuff jigglypuff = new Jigglypuff();
		try {
			jigglypuff.atacar(rattata, "Canto");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, rattata.puedeAtacar());
	}

	@Test
	public void testAlgoMonQuemado() {
		
		Rattata rattata = new Rattata();
		Charmander charmander = new Charmander();
		try {
			charmander.atacar(rattata, "Fogonazo");
			rattata.nuevoTurno();
			rattata.atacar(charmander, "AtaqueRapido");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(151, rattata.getVida());
	}

	@Test
	public void testAlgoMonMuerto() {
		
		Rattata rattata = new Rattata();
		Squirtle squirtle = new Squirtle();
		try {
			squirtle.atacar(rattata, "CanonDeAgua");
			squirtle.atacar(rattata, "CanonDeAgua");
		} catch (AtaquesAgotadosException e) { }
		assertEquals(false, rattata.estaMuerto());
		
		try {
			for(int i=0; i<5;i++){
				squirtle.atacar(rattata, "CanonDeAgua");
				squirtle.atacar(rattata, "Burbuja");
			}
		} catch (AtaquesAgotadosException e) { }
		assertEquals(true, rattata.estaMuerto());
	}

	@Test
	public void testGetNombre() {
		Rattata rattata = new Rattata();
		assertEquals("Rattata",rattata.getNombre());
	}

}