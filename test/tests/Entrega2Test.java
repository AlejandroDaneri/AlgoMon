package tests;

import org.junit.Test;

import clases.*;
import excepciones.*;

import static org.junit.Assert.*;

public class Entrega2Test {
	
	@Test
	public void test01JigglypuffAtacaConCanto() throws AtaquesAgotadosException {
		
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon squirtle = new Squirtle();
		
		jigglypuff.atacar(squirtle, "Canto");
		squirtle.atacar(jigglypuff, "AtaqueRapido");
		squirtle.nuevoTurno();
		jigglypuff.atacar(squirtle, "Burbuja");
		squirtle.atacar(jigglypuff, "AtaqueRapido");
		squirtle.nuevoTurno();
		jigglypuff.atacar(squirtle, "Burbuja");
		squirtle.atacar(jigglypuff, "AtaqueRapido");
		squirtle.nuevoTurno();
		
		assertEquals(jigglypuff.getVida(), jigglypuff.obtenerVidaOriginal());

	}
	
	@Test
	public void test02ChanseyAtacaConCanto() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon chansey = new Chansey();
		
		chansey.atacar(squirtle, "Canto");
		squirtle.atacar(chansey, "Burbuja");
		squirtle.nuevoTurno();
		chansey.atacar(squirtle, "AtaqueRapido");
		squirtle.atacar(chansey, "Burbuja");
		squirtle.nuevoTurno();
		chansey.atacar(squirtle, "AtaqueRapido");
		squirtle.atacar(chansey, "Burbuja");
		squirtle.nuevoTurno();
		chansey.atacar(squirtle, "AtaqueRapido");
		squirtle.atacar(chansey, "Burbuja");	// En este si le hace dano
		squirtle.nuevoTurno();
		
		assertEquals(chansey.getVida(), 120); // 130 - 10 (pot. burbuja)
		
	}
	
	@Test
	public void test03BulbasaurAtacaConChupavidasACharmander() throws AtaquesAgotadosException {
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon charmander = new Charmander();
		
		bulbasaur.atacar(charmander, "LatigoCepa");
		charmander.atacar(bulbasaur, "AtaqueRapido");
		
		bulbasaur.atacar(charmander, "Chupavidas");
		charmander.atacar(bulbasaur, "AtaqueRapido");
		
		bulbasaur.atacar(charmander, "AtaqueRapido");
		charmander.atacar(bulbasaur, "AtaqueRapido");
		
		assertEquals(bulbasaur.getVida(), 112); // 140 - 30 = 110 + 2 (Ganancia Chupavidas)

	}
	
	@Test
	public void test04BulbasaurAtacaConChupavidasASquirtle() throws AtaquesAgotadosException {
		AlgoMon bulbasaur2 = new Bulbasaur();
		AlgoMon squirtle = new Squirtle();
		
		bulbasaur2.atacar(squirtle, "LatigoCepa");
		squirtle.atacar(bulbasaur2, "AtaqueRapido");
		
		bulbasaur2.atacar(squirtle, "Chupavidas");
		squirtle.atacar(bulbasaur2, "AtaqueRapido");
		
		bulbasaur2.atacar(squirtle, "AtaqueRapido");
		squirtle.atacar(bulbasaur2, "AtaqueRapido");
		
		assertEquals(bulbasaur2.getVida(), 119); // 140 - 30 = 110 + 9 (Ganancia Chupavidas)
		
	}
	
	@Test
	public void test05BulbasaurAtacaConChupavidasAOtrosAlgomones() throws AtaquesAgotadosException {
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon rattata = new Rattata();
		AlgoMon chansey = new Chansey();
		AlgoMon jiggly = new Jigglypuff();
		
		chansey.atacar(bulbasaur, "AtaqueRapido");
		bulbasaur.atacar(rattata, "Chupavidas");
		
		rattata.atacar(bulbasaur, "Burbuja");
		bulbasaur.atacar(chansey, "Chupavidas");
		
		jiggly.atacar(bulbasaur, "AtaqueRapido");
		bulbasaur.atacar(jiggly, "Chupavidas");
		
		assertEquals(bulbasaur.getVida(), 127); // 140 - 25 = 115 + 4 + 4 + 4 (Ganancia Chupavidas)
	}
	
	@Test
	public void test06CharmanderAtacaConFogonazo() throws AtaquesAgotadosException {
		AlgoMon charmander = new Charmander();
		AlgoMon rattata = new Rattata();
		AlgoMon squirtle = new Squirtle();
		
		charmander.atacar(rattata, "Fogonazo");
		rattata.atacar(charmander, "AtaqueRapido");
		rattata.nuevoTurno();
		
		charmander.atacar(rattata, "AtaqueRapido");
		rattata.atacar(charmander, "AtaqueRapido");
		rattata.nuevoTurno();
		
		charmander.atacar(squirtle, "Fogonazo");
		squirtle.atacar(charmander, "Burbuja");
		squirtle.nuevoTurno();
		
		charmander.atacar(squirtle, "AtaqueRapido");
		squirtle.atacar(charmander, "Burbuja");
		squirtle.nuevoTurno();
		
		assertEquals(rattata.getVida(), 124); // 170 - 2 - 10 = 158 - 17 - 17 (Dos quemados)
		assertEquals(squirtle.getVida(), 109); // 150 - 1 - 10 = 139 - 15 - 15 (Dos quemados)
	}
	
	@Test
	public void test07RattataAtacaConFogonazo() throws AtaquesAgotadosException {
		AlgoMon rattata = new Rattata();
		AlgoMon chansey = new Chansey();
		AlgoMon bulba = new Bulbasaur();
		
		rattata.atacar(chansey, "Fogonazo");
		chansey.atacar(rattata, "LatigoCepa");
		chansey.nuevoTurno();
		
		rattata.atacar(chansey, "AtaqueRapido");
		chansey.atacar(rattata, "AtaqueRapido");
		chansey.nuevoTurno();
		
		rattata.atacar(bulba, "Fogonazo");
		bulba.atacar(rattata, "LatigoCepa");
		bulba.nuevoTurno();
		
		rattata.atacar(bulba, "AtaqueRapido");
		bulba.atacar(rattata, "Chupavidas");
		bulba.nuevoTurno();
		
		assertEquals(chansey.getVida(), 92); // 130 - 2 - 10 = 118 - 13 - 13 (Dos quemados)
		assertEquals(bulba.getVida(), 102); // 140 - 4 - 10 = 126 - 14 - 14 + 4 (Dos quemados + Chupavidas)
	}
}