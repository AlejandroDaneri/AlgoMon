package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import clases.Canto;

public class AtaqueTests {
	
	@Test
	public void testEquals(){
		Canto canto = new Canto();
		assertEquals(true,canto.equals("Canto"));
		assertEquals(false,canto.equals("LatigoCepa"));
	}
	
}
