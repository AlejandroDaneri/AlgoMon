package clases;

import org.junit.Test;

import static org.junit.Assert.*;


public class BrasasTest {
    @Test
    public void testCrearNoDevuelveNull() {
        Brasas brasas = new Brasas();
        assertNotNull(brasas);
    }

    @Test
    public void testCantidadInicial() {
        Brasas brasas = new Brasas();
        assertEquals(10,brasas.cantidadInicial());
    }

}