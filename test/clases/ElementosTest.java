package clases;

import excepciones.AtaquesAgotadosException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementosTest {

	@Test
	public void testAplicarPocion() throws AtaquesAgotadosException {
		
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
	public void testAplicarSuperPocion() throws AtaquesAgotadosException {
		
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
	public void testAplicarRestauradorConEstadoQuemado() throws AtaquesAgotadosException {
		
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
		
		assertEquals(66,bulbasaur.getVida());	// 140 - 4 - 10 - 14 (Quemado) - 14 (Quemado) - 32 = 66
		assertEquals(bulbasaur.getEstadoPersistente() instanceof Quemado, false);
		assertEquals(bulbasaur.getEstadoPersistente() instanceof EstadoNormal, true);
	}
	
	@Test
	public void testAplicarRestauradorConEstadoDormido() throws AtaquesAgotadosException {
		
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon bulbasaur = new Bulbasaur();
		Restaurador restaurador = new Restaurador();
		
		jigglypuff.atacar(bulbasaur,"Canto");
		bulbasaur.atacar(jigglypuff,"LatigoCepa");
		bulbasaur.nuevoTurno();
		
		jigglypuff.atacar(bulbasaur, "Burbuja");
		bulbasaur.atacar(jigglypuff, "AtaqueRapido");
		bulbasaur.nuevoTurno();
		
		restaurador.aplicar(bulbasaur);
		jigglypuff.atacar(bulbasaur, "AtaqueRapido");
		bulbasaur.atacar(jigglypuff, "LatigoCepa");
		
		assertEquals(115,jigglypuff.getVida());	// 130 - 15 = 115
		assertEquals(bulbasaur.getEstadoPersistente() instanceof Dormido, false);
		assertEquals(bulbasaur.getEstadoPersistente() instanceof EstadoNormal, true);
	}
	
	@Test
	public void testAplicarVitaminaNoExcedeCantidadInicial() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		Vitamina vitamina = new Vitamina();
		
		squirtle.atacar(bulbasaur,"CanonDeAgua");
		bulbasaur.atacar(squirtle,"LatigoCepa");
		
		vitamina.aplicar(squirtle);
		vitamina.aplicar(bulbasaur);
		
		for(Ataque ataque: squirtle.getAtaques()){
			assertEquals(ataque.getCantidad() <= ataque.cantidadInicial(),true);
		}
		for(Ataque ataque: bulbasaur.getAtaques()){
			assertEquals(ataque.getCantidad() <= ataque.cantidadInicial(),true);
		}
		
	}
	
	@Test
	public void testAplicarVitaminaConAtaquesEnBajasCantidades() throws AtaquesAgotadosException {
		
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		Vitamina vitamina = new Vitamina();
		
		for(int x=0; x<8; x++){
			squirtle.atacar(bulbasaur,"CanonDeAgua");
		}
		
		for(int x=0; x<15; x++){
			squirtle.atacar(bulbasaur,"Burbuja");
		}
		
		for(int x=0; x<16; x++){
			squirtle.atacar(bulbasaur,"AtaqueRapido");
		}
		
		vitamina.aplicar(squirtle);
		
		for(Ataque ataque: squirtle.getAtaques()){
			assertEquals(ataque.getCantidad() == 2, true);
		}
		assertEquals(bulbasaur.estaMuerto(), true);
	}
}
