package clases;

import excepciones.AtaquesAgotadosException;
import org.junit.Test;

import static org.junit.Assert.*;

public class Entrega1Tests {
	
	@Test
	public void test01SquirtleAtacaACharmander() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon charmander = new Charmander();
		squirtle.atacar(charmander,"Burbuja");
		assertEquals(150,charmander.getVida());
		squirtle.atacar(charmander,"CañonDeAgua");
		assertEquals(110,charmander.getVida());
	}
	
	@Test
	public void test02SquirtleAtacaABulbasaur() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		squirtle.atacar(bulbasaur,"Burbuja");
		assertEquals(135,bulbasaur.getVida());
		squirtle.atacar(bulbasaur,"CañonDeAgua");
		assertEquals(125,bulbasaur.getVida());
	}
	
	@Test
	public void test03SquirtleAtacaAlResto() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		squirtle.atacar(jigglypuff,"Burbuja");
		assertEquals(120,jigglypuff.getVida());
		squirtle.atacar(jigglypuff,"CañonDeAgua");
		assertEquals(100,jigglypuff.getVida());
		squirtle.atacar(chansey,"Burbuja");
		assertEquals(120,chansey.getVida());
		squirtle.atacar(chansey,"CañonDeAgua");
		assertEquals(100,chansey.getVida());
		squirtle.atacar(rattata,"Burbuja");
		assertEquals(160,rattata.getVida());
		squirtle.atacar(rattata,"CañonDeAgua");
		assertEquals(140,rattata.getVida());
	}
	
	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon chansey = new Chansey();
		bulbasaur.atacar(squirtle,"LatigoCepa");
		assertEquals(120,squirtle.getVida());
		chansey.atacar(squirtle,"LatigoCepa");
		assertEquals(90,squirtle.getVida());
	}
	
	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa() throws AtaquesAgotadosException{
		AlgoMon charmander = new Charmander();
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon chansey = new Chansey();
		bulbasaur.atacar(charmander,"LatigoCepa");
		assertEquals(163,charmander.getVida());
		chansey.atacar(charmander,"LatigoCepa");
		assertEquals(156,charmander.getVida());
	}
	
	@Test
	public void test06BulbasaurYChanseyAtacanAlRestoConLatigoCepa() throws AtaquesAgotadosException{
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		bulbasaur.atacar(jigglypuff,"LatigoCepa");
		assertEquals(115,jigglypuff.getVida());
		chansey.atacar(jigglypuff,"LatigoCepa");
		assertEquals(100,jigglypuff.getVida());
		bulbasaur.atacar(rattata,"LatigoCepa");
		assertEquals(155,rattata.getVida());
		chansey.atacar(rattata,"LatigoCepa");
		assertEquals(140,rattata.getVida());
	}
	
	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas() throws AtaquesAgotadosException{
		AlgoMon charmander = new Charmander();
		AlgoMon bulbasaur = new Bulbasaur();
		charmander.atacar(bulbasaur,"Brasas");
		assertEquals(108,bulbasaur.getVida());
	}
	
	@Test
	public void test08CharmanderAtacaASquirtleConBrasas() throws AtaquesAgotadosException{
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		charmander.atacar(squirtle,"Brasas");
		assertEquals(142,squirtle.getVida());
	}
	
	@Test
	public void test09CharmanderAtacaAlRestoConBrasas() throws AtaquesAgotadosException{
		AlgoMon charmander = new Charmander();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		charmander.atacar(jigglypuff,"Brasas");
		assertEquals(114,jigglypuff.getVida());
		charmander.atacar(chansey,"Brasas");
		assertEquals(114,chansey.getVida());
		charmander.atacar(rattata,"Brasas");
		assertEquals(154,rattata.getVida());
	}
	
	@Test
	public void test10AtaqueRapidoSinImportarTipo() throws AtaquesAgotadosException{
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		bulbasaur.atacar(jigglypuff,"AtaqueRapido");
		assertEquals(120,jigglypuff.getVida());
		chansey.atacar(rattata,"AtaqueRapido");
		assertEquals(160,rattata.getVida());
		rattata.atacar(bulbasaur,"AtaqueRapido");
		assertEquals(130,bulbasaur.getVida());
		jigglypuff.atacar(chansey,"AtaqueRapido");
		assertEquals(120,chansey.getVida());
	}
	
	@Test(expected = AtaquesAgotadosException.class)
	public void test11AgotarCantidadDeAtaques() throws AtaquesAgotadosException{
		AlgoMon squirtle = new Squirtle();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		for(int i=0; i<4;i++){
			squirtle.atacar(jigglypuff,"CañonDeAgua");
			squirtle.atacar(chansey,"CañonDeAgua");
		}
		squirtle.atacar(rattata,"CañonDeAgua");
	}
}
