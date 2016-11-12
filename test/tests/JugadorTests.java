package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import clases.*;
import excepciones.*;

public class JugadorTests {

	@Test
	public void testCreacionJugador() {
		Jugador jugador = new Jugador(0,"Pedro");
		assertNotNull(jugador);
	}
	
	@Test
	public void testAgregarAlgomones() {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertEquals(jugador.cantidadAlgomones(), 2);
		assertEquals(jugador.cantidadAlgomones() == 3, false);
	}
	
	@Test(expected = CantidadMaximaAlgoMonesException.class)
	public void testAgregaMasDe3AlgoMones() throws CantidadMaximaAlgoMonesException{
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		AlgoMon rata = new Rattata();
		AlgoMon chan = new Chansey();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		jugador.agregarAlgomon(rata);
		jugador.agregarAlgomon(chan);
	}
	
	@Test
	public void testCambiarAlgomonActivo() {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertEquals(jugador.getAlgomonActivo().getNombre(), "Jigglypuff");
		jugador.cambiarDeAlgoMon("Charmander");
		assertEquals(jugador.getAlgomonActivo().getNombre(), "Charmander");
	}
	
	@Test(expected = AlgoMonInexistenteException.class)
	public void testCambiarAlgomonInexistente() throws AlgoMonInexistenteException{
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertEquals(jugador.getAlgomonActivo().getNombre(), "Jigglypuff");
		jugador.cambiarDeAlgoMon("Charmander");
		assertEquals(jugador.getAlgomonActivo().getNombre(), "Charmander");
		jugador.cambiarDeAlgoMon("Squirtle");
	}
	
	@Test
	public void testTieneAlgomon() {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertEquals(jugador.tieneAlgomon("Jigglypuff"), true);
		assertEquals(jugador.tieneAlgomon("Charmander"), true);
		assertEquals(jugador.tieneAlgomon("Bulbasaur"), false);
		assertEquals(jugador.tieneAlgomon("Squirtle"), false);
	}
	
	@Test
	public void testPrimeraEleccion() {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigg = new Jigglypuff();
		AlgoMon charm = new Charmander();
		jugador.agregarAlgomon(jigg);
		jugador.agregarAlgomon(charm);
		assertEquals(jugador.primeraEleccion().getNombre(), "Jigglypuff");
		assertEquals(jugador.primeraEleccion().getNombre() == "Charmander", false);
	}
	
	@Test
	public void testJugadorPerdio() throws AtaquesAgotadosException {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		jugador.agregarAlgomon(jigglypuff);
		jugador.agregarAlgomon(charmander);
		for(int i = 0; i <= 5; i++){
			squirtle.atacar(charmander, "CanonDeAgua");
		}
		for(int i = 0; i <= 13; i++){
			squirtle.atacar(jigglypuff, "Burbuja");
		}
		assertEquals(jugador.perdio(), true);
	}
	
	public void testJugadorNoPerdio() throws AtaquesAgotadosException {
		Jugador jugador = new Jugador(0,"Pedro");
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		jugador.agregarAlgomon(jigglypuff);
		jugador.agregarAlgomon(charmander);
		for(int i = 0; i <= 5; i++){
			squirtle.atacar(charmander, "CanonDeAgua");
		}
		assertEquals(jugador.perdio(), false);
	}
}