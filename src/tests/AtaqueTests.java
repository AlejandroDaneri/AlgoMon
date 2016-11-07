package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Canto;

import static org.junit.Assert.*;

public class AtaqueTests {
	
	@Test
	public void testTieneAtaque(){
		Canto canto = new Canto();
		assertEquals(true,canto.tieneAtaque("Canto"));
		assertEquals(false,canto.tieneAtaque("LatigoCepa"));
	}
	
}
