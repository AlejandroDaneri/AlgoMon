package tests;

import java.util.ArrayList;

import org.junit.Test;

import clases.*;

import static org.junit.Assert.*;

public class Entrega2Tests {
	
	@Test
	public void test01JigglypuffYChanseyAtacanConCanto() throws AlgoMonDormidoException{
		
		Partida partida = new Partida();
		ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>();
		ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>();
		Jigglypuff jigglypuff = new Jigglypuff();
		algomonesJugador1.add(jigglypuff);
		Squirtle squirtle = new Squirtle();
		algomonesJugador2.add(squirtle);
		Chansey chansey = new Chansey();
		algomonesJugador1.add(chansey);
		Charmander charmander = new Charmander();
		algomonesJugador2.add(charmander);
		
		// dependiendo de la implementación capaz haya que crear los dos algomones restantes
		
		partida.recibirAlgomones(algomonesJugador1, algomonesJugador2);
		jigglypuff.atacar(squirtle, "Canto", estadoADormido); 
		squirtle.atacar(chansey, "AtaqueRapido"); // esto lanza la excepcion. turno 1 de squirtle
		chansey.atacar(charmander, "Canto", estadoADormido);
		charmander.atacar(jigglypuff, "AtaqueRapido"); // esto lanza la excepcion. turno 1 de charmander, 2 de squirtle
		jigglypuff.atacar(squirtle, "AtaqueRapido");
		squirtle.atacar(chansey, "AtaqueRapido"); // esto lanza la excepcion. turno 3 de squirtle, 2 de charmander
		chansey.atacar(charmander, "AtaqueRapido");
		squirtle.atacar(chansey, "AtaqueRapido"); // esto se puede. turno 3 de charmander
		assertEquals(120, chansey.getVida());
		jigglypuff.atacar(squirtle, "AtaqueRapido");
		charmander.atacar(jigglypuff, "AtaqueRapido"); // esto se puede.
		assertEquals(120, jigglypuff.getVida());
	}
	
	@Test
	public void test02BulbasaurAtacaConChupavidasACharmander() {
		Partida partida = new Partida();
		ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>();
		ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>();
		Bulbasaur bulbasaur = new Bulbasaur();
		algomonesJugador1.add(bulbasaur);
		Charmander charmander = new Charmander();
		algomonesJugador2.add(charmander);
		
		partida.recibirAlgomones(algomonesJugador1, algomonesJugador2);
		assertEquals(140, bulbasaur.getVida());
		bulbasaur.atacar(charmander, "ChupaVidas");
		assertEquals(140, charmander.getVida());
		assertEquals(149, bulbasaur.getVida());
	}
	
	@Test
	public void test03BulbasaurAtacaConChupavidasASquirtle() {
		Partida partida = new Partida();
		ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>();
		ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>();
		Bulbasaur bulbasaur = new Bulbasaur();
		algomonesJugador1.add(bulbasaur);
		Squirtle squirtle = new Squirtle();
		algomonesJugador2.add(squirtle);

		partida.recibirAlgomones(algomonesJugador1, algomonesJugador2);
		assertEquals(140, bulbasaur.getVida());
		bulbasaur.atacar(squirtle, "ChupaVidas");
		assertEquals(143, squirtle.getVida());
		assertEquals(142, bulbasaur.getVida());
	}
	
	@Test
	public void test04BulbasaurAtacaConChupavidasAOtrosAlgomones() {
		Partida partida = new Partida();
		ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>();
		ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>();
		Bulbasaur bulbasaur = new Bulbasaur();
		algomonesJugador1.add(bulbasaur);
		Jigglypuff jigglypuff = new Jigglypuff();
		algomonesJugador2.add(jigglypuff);
		Chansey chansey = new Chansey();
		algomonesJugador2.add(chansey);
		Rattata rattata = new Rattata();
		algomonesJugador2.add(rattata);
		
		partida.recibirAlgomones(algomonesJugador1, algomonesJugador2);
		assertEquals(140, bulbasaur.getVida());
		bulbasaur.atacar(jigglypuff, "ChupaVidas");
		assertEquals(115, jigglypuff.getVida());
		assertEquals(144, bulbasaur.getVida());
		bulbasaur.atacar(chansey, "ChupaVidas");
		assertEquals(115, chansey.getVida());
		assertEquals(148, bulbasaur.getVida());
		bulbasaur.atacar(rattata, "ChupaVidas");
		assertEquals(155, rattata.getVida());
		assertEquals(152, bulbasaur.getVida());
		bulbasaur.atacar(rattata, "ChupaVidas");
		assertEquals(140, rattata.getVida());
		assertEquals(156, bulbasaur.getVida());		
	}
	
	@Test
	public void test05CharmanderYRattataAtacanConFogonazo() {
		Partida partida = new Partida();
		ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>();
		ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>();
		Rattata rattata = new Rattata();
		algomonesJugador1.add(rattata);
		Jigglypuff jigglypuff = new Jigglypuff();
		algomonesJugador2.add(jigglypuff);
		Charmander charmander1 = new Charmander();
		algomonesJugador1.add(charmander1);
		Bulbasaur bulbasaur = new Bulbasaur();
		algomonesJugador2.add(bulbasaur);
		Squirtle squirtle = new Squirtle();
		algomonesJugador2.add(squirtle);

		// si no les parece feo, meto un cuarto algomon a la lista 2 (de tipo fuego, dado que es el que falta)
		// así probamos con todos los tipos. como no estamos verificando cantidad de Algomones que tiene
		// cada jugador, es posible. Si les parece feo lo borramos
		
		Charmander charmander2 = new Charmander();
		algomonesJugador2.add(charmander2);
		partida.recibirAlgomones(algomonesJugador1, algomonesJugador2);
		charmander1.atacar(bulbasaur, "Fogonazo", estadoAQuemado);
		assertEquals(136, bulbasaur.getVida());
		bulbasaur.atacar(charmander1, "AtaqueRapido");
		assertEquals(160, charmander1.getVida());
		assertEquals(122, bulbasaur.getVida());
		
		rattata.atacar(squirtle, "Fogonazo", estadoAQuemado);
		assertEquals(149, squirtle.getVida());
		squirtle.atacar(charmander1, "AtaqueRapido");
		assertEquals(150, charmander1.getVida());
		assertEquals(122, bulbasaur.getVida()); // no estuvo activo durante este turno
		assertEquals(134, squirtle.getVida()); // pierde el 10 % de su vida original
		
		rattata.atacar(charmander2, "Fogonazo", estadoAQuemado);
		assertEquals(169, charmander2.getVida());
		charmander2.atacar(rattata, "AtaqueRapido");
		assertEquals(160, rattata.getVida());
		assertEquals(122, bulbasaur.getVida()); // no estuvo activo durante este turno
		assertEquals(134, squirtle.getVida()); // no estuvo activo durante este turno
		assertEquals(152, charmander2.getVida());
		
		charmander2.atacar(jigglypuff, "Fogonazo", estadoAQuemado);
		assertEquals(128, jigglypuff.getVida());
		assertEquals(135, charmander2.getVida());
		assertEquals(122, bulbasaur.getVida()); // no estuvo activo durante este turno
		assertEquals(134, squirtle.getVida()); // no estuvo activo durante este turno
	}
	
	
//	Charmander y Rattata atacan con fogonazo y el algomón atacado recibirá un daño del 10%
//	de sus puntos de vida originales en cada turno (DEL PROPIO JUGADOR) en que esté activo (además recibirá el
//	daño correspondiente según su tipo en el momento del ataque fogonazo).
//	Quemado: cada vez que el algomón realice una acción (sea atacar o recibir un elemento)
//	recibirá un daño equivalente al 10% de sus puntos de vida originales.

}