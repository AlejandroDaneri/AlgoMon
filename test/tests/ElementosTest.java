package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.*;
import excepciones.AtaquesAgotadosException;

public class ElementosTest {

	@Test
	public void AplicarPociontest() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		Pocion pocion = new Pocion();
		
		squirtle.atacar(bulbasaur,"Burbuja");
		bulbasaur.atacar(squirtle,"LatigoCepa");
		squirtle.atacar(bulbasaur, "AtaqueRapido");
		bulbasaur.atacar(squirtle, "AtaqueRapido");
		pocion.aplicar(squirtle);
		pocion.aplicar(bulbasaur);
		
		assertEquals(140,bulbasaur.getVida());	// 140 - 5 - 10 + 20 = 145 >> 140
		assertEquals(130,squirtle.getVida());	// 150 - 30 - 10 + 20 = 130
	}
	
	@Test
	public void AplicarSuperPociontest() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		SuperPocion superpocion = new SuperPocion();
		
		squirtle.atacar(bulbasaur,"Burbuja");
		bulbasaur.atacar(squirtle,"LatigoCepa");
		squirtle.atacar(bulbasaur, "AtaqueRapido");
		bulbasaur.atacar(squirtle, "AtaqueRapido");
		squirtle.atacar(bulbasaur, "CanonDeAgua");
		bulbasaur.atacar(squirtle, "LatigoCepa");
		superpocion.aplicar(squirtle);
		superpocion.aplicar(bulbasaur);
		
		assertEquals(140,bulbasaur.getVida());	// 140 - 5 - 10 - 10 + 40 = 155 >> 140
		assertEquals(120,squirtle.getVida());	// 150 - 30 - 10 - 30 + 40 = 120
	}
	
	@Test
	public void AplicarRestauradorConQuemado() throws AtaquesAgotadosException {
		
		AlgoMon charmander = new Charmander();
		AlgoMon bulbasaur = new Bulbasaur();
		Restaurador restaurador = new Restaurador();
		
		charmander.atacar(bulbasaur,"Fogonazo");
		bulbasaur.atacar(charmander,"LatigoCepa");
		bulbasaur.nuevoTurno();
		charmander.atacar(bulbasaur, "AtaqueRapido");
		bulbasaur.atacar(charmander, "AtaqueRapido");
		bulbasaur.nuevoTurno();
		restaurador.aplicar(bulbasaur);
		charmander.atacar(bulbasaur, "Brasas");
		bulbasaur.atacar(charmander, "LatigoCepa");
		bulbasaur.nuevoTurno();
		
		assertEquals(66,bulbasaur.getVida());	// 140 - 4 - 10 - 14 (Quemado) - 14 (Quemado) - 32 = 66
		assertEquals(bulbasaur.getEstadoPersistente() instanceof Quemado, false);
		assertEquals(bulbasaur.getEstadoPersistente() instanceof EstadoNormal, true);
	}

}
