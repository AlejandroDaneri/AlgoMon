package tests;

import java.util.ArrayList;

import org.junit.Test;

import clases.*;
import excepciones.AlgoMonDormidoException;
import excepciones.AtaquesAgotadosException;

import static org.junit.Assert.*;

public class Entrega2Test {
	
	@Test
	public void test01JigglypuffYChanseyAtacanConCanto() throws AlgoMonDormidoException, AtaquesAgotadosException {
		
		Partida partida = new Partida("Jugador1", "Jugador2");
		ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>(); // este es el primero que elige
		ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>(); // este es el segundo que elige
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
		jigglypuff.atacar(squirtle, "Canto");
		partida.nuevoTurno();
		squirtle.atacar(chansey, "AtaqueRapido"); // esto lanza la excepcion. turno 1 de squirtle
		partida.nuevoTurno();
		chansey.atacar(charmander, "Canto");
		partida.nuevoTurno();
		charmander.atacar(jigglypuff, "AtaqueRapido"); // esto lanza la excepcion. turno 1 de charmander, 2 de squirtle
		partida.nuevoTurno();
		jigglypuff.atacar(squirtle, "AtaqueRapido");
		partida.nuevoTurno();
		squirtle.atacar(chansey, "AtaqueRapido"); // esto lanza la excepcion. turno 3 de squirtle, 2 de charmander
		partida.nuevoTurno();
		chansey.atacar(charmander, "AtaqueRapido");
		partida.nuevoTurno();
		squirtle.atacar(chansey, "AtaqueRapido"); // esto se puede. turno 3 de charmander
		partida.nuevoTurno();
		assertEquals(120, chansey.getVida());
		jigglypuff.atacar(squirtle, "AtaqueRapido");
		partida.nuevoTurno();
		charmander.atacar(jigglypuff, "AtaqueRapido"); // esto se puede.
		assertEquals(120, jigglypuff.getVida());
	}
	
	@Test
	public void test02BulbasaurAtacaConChupavidasACharmander() throws AtaquesAgotadosException {
		Partida partida = new Partida("Jugador1", "Jugador2");
		ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>();
		ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>();
		Bulbasaur bulbasaur = new Bulbasaur();
		algomonesJugador1.add(bulbasaur);
		Charmander charmander = new Charmander();
		algomonesJugador2.add(charmander);
		
		partida.recibirAlgomones(algomonesJugador1, algomonesJugador2);
		assertEquals(140, bulbasaur.getVida());
		bulbasaur.atacar(charmander, "Chupavidas");
		partida.nuevoTurno();
		assertEquals(163, charmander.getVida());
		assertEquals(142, bulbasaur.getVida());
	}
	
	@Test
	public void test03BulbasaurAtacaConChupavidasASquirtle() throws AtaquesAgotadosException {
		Partida partida = new Partida("Jugador1", "Jugador2");
		ArrayList<AlgoMon> algomonesJugador1 = new ArrayList<AlgoMon>();
		ArrayList<AlgoMon> algomonesJugador2 = new ArrayList<AlgoMon>();
		Bulbasaur bulbasaur = new Bulbasaur();
		algomonesJugador1.add(bulbasaur);
		Squirtle squirtle = new Squirtle();
		algomonesJugador2.add(squirtle);

		partida.recibirAlgomones(algomonesJugador1, algomonesJugador2);
		assertEquals(140, bulbasaur.getVida());
		bulbasaur.atacar(squirtle, "Chupavidas");
		partida.nuevoTurno();
		assertEquals(120, squirtle.getVida());
		assertEquals(149, bulbasaur.getVida());
	}
	
	@Test
	public void test04BulbasaurAtacaConChupavidasAOtrosAlgomones() throws AtaquesAgotadosException {
		Partida partida = new Partida("Jugador1", "Jugador2");
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
		bulbasaur.atacar(jigglypuff, "Chupavidas");
		partida.nuevoTurno();
		assertEquals(115, jigglypuff.getVida());
		assertEquals(144, bulbasaur.getVida());
		bulbasaur.atacar(chansey, "Chupavidas");
		partida.nuevoTurno();
		assertEquals(115, chansey.getVida());
		assertEquals(148, bulbasaur.getVida());
		bulbasaur.atacar(rattata, "Chupavidas");
		partida.nuevoTurno();
		assertEquals(155, rattata.getVida());
		assertEquals(152, bulbasaur.getVida());
		bulbasaur.atacar(rattata, "Chupavidas");
		partida.nuevoTurno();
		assertEquals(140, rattata.getVida());
		assertEquals(156, bulbasaur.getVida());		
	}
	
	@Test
	public void test05CharmanderYRattataAtacanConFogonazo() throws AtaquesAgotadosException {
		Partida partida = new Partida("Jugador1", "Jugador2");
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
		charmander1.atacar(bulbasaur, "Fogonazo");
		partida.nuevoTurno();
		assertEquals(136, bulbasaur.getVida());
		bulbasaur.atacar(charmander1, "AtaqueRapido");
		partida.nuevoTurno();
		assertEquals(160, charmander1.getVida());
		assertEquals(122, bulbasaur.getVida());
		
		rattata.atacar(squirtle, "Fogonazo");
		partida.nuevoTurno();
		assertEquals(149, squirtle.getVida());
		squirtle.atacar(charmander1, "AtaqueRapido");
		partida.nuevoTurno();
		assertEquals(150, charmander1.getVida());
		assertEquals(122, bulbasaur.getVida()); // no estuvo activo durante este turno
		assertEquals(134, squirtle.getVida()); // pierde el 10 % de su vida original
		
		rattata.atacar(charmander2, "Fogonazo");
		partida.nuevoTurno();
		assertEquals(169, charmander2.getVida());
		charmander2.atacar(rattata, "AtaqueRapido");
		partida.nuevoTurno();
		assertEquals(160, rattata.getVida());
		assertEquals(122, bulbasaur.getVida()); // no estuvo activo durante este turno
		assertEquals(134, squirtle.getVida()); // no estuvo activo durante este turno
		assertEquals(152, charmander2.getVida());
		
		charmander2.atacar(jigglypuff, "Fogonazo");
		partida.nuevoTurno();
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