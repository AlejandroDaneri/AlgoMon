package tests;

import org.junit.Test;

import clases.AlgoMon;

import static org.junit.Assert.*;

public class Entrega1Tests {
	
	@Test
	public void test01SquirtleAtacaACharmander(){
		AlgoMon squirtle = new Squirtle();
		AlgoMon charmander = new Charmander();
		squirtle.atacar(charmander,"burbuja");
		assertEquals(150,charmander.getVida());
		squirtle.atacar(charmander,"cañonDeAgua");
		assertEquals(110,charmander.getVida());
	}
	
	@Test
	public void test02SquirtleAtacaABulbasaur(){
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		squirtle.atacar(bulbasaur,"burbuja");
		assertEquals(135,bulbasaur.getVida());
		squirtle.atacar(bulbasaur,"cañonDeAgua");
		assertEquals(125,bulbasaur.getVida());
	}
	
	@Test
	public void test03SquirtleAtacaAlResto(){
		AlgoMon squirtle = new Squirtle();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		squirtle.atacar(jigglypuff,"burbuja");
		assertEquals(120,jigglypuff.getVida());
		squirtle.atacar(jigglypuff,"cañonDeAgua");
		assertEquals(100,jigglypuff.getVida());
		squirtle.atacar(chansey,"burbuja");
		assertEquals(120,chansey.getVida());
		squirtle.atacar(chansey,"cañonDeAgua");
		assertEquals(100,chansey.getVida());
		squirtle.atacar(rattata,"burbuja");
		assertEquals(160,rattata.getVida());
		squirtle.atacar(rattata,"cañonDeAgua");
		assertEquals(140,rattata.getVida());
	}
	
	@Test
	public void test04BulbasaurYChanseyAtacanASquirtleConLatigoCepa(){
		AlgoMon squirtle = new Squirtle();
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon chansey = new Chansey();
		bulbasaur.atacar(squirtle,"latigoCepa");
		assertEquals(120,squirtle.getVida());
		chansey.atacar(squirtle,"latigoCepa");
		assertEquals(90,squirtle.getVida());
	}
	
	@Test
	public void test05BulbasaurYChanseyAtacanACharmanderConLatigoCepa(){
		AlgoMon charmander = new Charmander();
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon chansey = new Chansey();
		bulbasaur.atacar(charmander,"latigoCepa");
		assertEquals(163,charmander.getVida());
		chansey.atacar(charmander,"latigoCepa");
		assertEquals(156,charmander.getVida());
	}
	
	@Test
	public void test06BulbasaurYChanseyAtacanAlRestoConLatigoCepa(){
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		bulbasaur.atacar(jigglypuff,"latigoCepa");
		assertEquals(115,jigglypuff.getVida());
		chansey.atacar(jigglypuff,"latigoCepa");
		assertEquals(100,jigglypuff.getVida());
		bulbasaur.atacar(rattata,"latigoCepa");
		assertEquals(155,rattata.getVida());
		chansey.atacar(rattata,"latigoCepa");
		assertEquals(140,rattata.getVida());
	}
	
	@Test
	public void test07CharmanderAtacaABulbasaurConBrasas(){
		AlgoMon charmander = new Charmander();
		AlgoMon bulbasaur = new Bulbasaur();
		charmander.atacar(bulbasaur,"brasas");
		assertEquals(108,bulbasaur.getVida());
	}
	
	@Test
	public void test08CharmanderAtacaASquirtleConBrasas(){
		AlgoMon charmander = new Charmander();
		AlgoMon squirtle = new Squirtle();
		charmander.atacar(squirtle,"brasas");
		assertEquals(142,squirtle.getVida());
	}
	
	@Test
	public void test09CharmanderAtacaAlRestoConBrasas(){
		AlgoMon charmander = new Charmander();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		charmander.atacar(jigglypuff,"brasas");
		assertEquals(114,jigglypuff.getVida());
		charmander.atacar(chansey,"brasas");
		assertEquals(114,chansey.getVida());
		charmander.atacar(rattata,"brasas");
		assertEquals(154,rattata.getVida());
	}
	
	@Test
	public void test10AtaqueRapidoSinImportarTipo(){
		AlgoMon bulbasaur = new Bulbasaur();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		bulbasaur.atacar(jigglypuff,"ataqueRapido");
		assertEquals(120,jigglypuff.getVida());
		chansey.atacar(rattata,"ataqueRapido");
		assertEquals(160,rattata.getVida());
		rattata.atacar(bulbasaur,"ataqueRapido");
		assertEquals(115,bulbasaur.getVida());
		jigglypuff.atacar(chansey,"ataqueRapido");
		assertEquals(120,chansey.getVida());
	}
	
	@Test(expected = AtaquesAgotadosException.class)
	public void test11AgotarCantidadDeAtaques(){
		AlgoMon squirtle = new Squirtle();
		AlgoMon jigglypuff = new Jigglypuff();
		AlgoMon chansey = new Chansey();
		AlgoMon rattata = new Rattata();
		for(int i=0; i<4;i++){
			squirtle.atacar(jigglypuff,"cañonDeAgua");
			squirtle.atacar(chansey,"cañonDeAgua");
		}
		squirtle.atacar(rattata,"cañonDeAgua");
	}
}
