package clases;
import excepciones.AtaquesAgotadosException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AtaqueTest {
	
	@Test
	public void testEquals(){
		Canto canto = new Canto();
		assertEquals(true,canto.equals("Canto"));
		assertEquals(false,canto.equals("LatigoCepa"));
	}
	
	@Test
	public void testAtacar() {
		Squirtle squirtle = new Squirtle();
		Bulbasaur bulbasaur = new Bulbasaur();

		try {
			squirtle.atacar(bulbasaur, "CanonDeAgua");
		} catch (AtaquesAgotadosException e1) {
		}
		
		assertEquals(bulbasaur.getVida(), 130);
		
		Ataque ataque = buscarAtaque(squirtle.getAtaques(), "CanonDeAgua");
		assertEquals(ataque.getCantidad(), 7);
	}
	
	@Test
	public void testDanoDeAtaqueEsUnEntero() {
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		
		try {
			bulbasaur.atacar(charmander, "LatigoCepa");
		} catch (AtaquesAgotadosException e) {
		}
		assertEquals("El dano que hace un ataque es siempre un entero", charmander.getVida(), 163);
		try {
			bulbasaur.atacar(charmander, "LatigoCepa");
			bulbasaur.atacar(charmander, "LatigoCepa");
			bulbasaur.atacar(charmander, "LatigoCepa");
			bulbasaur.atacar(charmander, "LatigoCepa");
		} catch (AtaquesAgotadosException e) {
		}
		
		assertEquals(charmander.getVida(), 135);
		
		Ataque ataque = buscarAtaque(bulbasaur.getAtaques(), "LatigoCepa");
		assertEquals(ataque.getCantidad(), 5);


	}
	
	public Ataque buscarAtaque(List<Ataque> ataques, String nombreDeAtaque) {
		Ataque ataqueDevuelto = null;
		for (Ataque ataque: ataques) {
			if (ataque.equals(nombreDeAtaque)) {
				ataqueDevuelto = ataque;
			}
		}
		return ataqueDevuelto;
	}
}
