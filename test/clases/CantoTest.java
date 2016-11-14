package clases;

import org.junit.Test;

import static org.junit.Assert.*;


public class CantoTest {
    @Test
    public void testCrearNoDevuelveNull() {
        Canto canto = new Canto();
        assertNotNull(canto);
    }

    @Test
    public void testCantidadInicial() {
        Canto canto = new Canto();
        assertEquals(6,canto.cantidadInicial());
    }

}