import static org.junit.Assert.*;

import org.junit.Test;

import com.ipartek.formacion.supermercado.utils.Utilidades;

public class UtilidadesTest {

	@Test
	public void testObtenerId() throws Exception{
		
		assertEquals(-1, Utilidades.obtenerId(null));
		assertEquals(-1, Utilidades.obtenerId("/"));
		assertEquals(-1, Utilidades.obtenerId("/pepe"));
		assertEquals(-1, Utilidades.obtenerId("/pepe/"));
		assertEquals(2, Utilidades.obtenerId("/2"));
		assertEquals(2, Utilidades.obtenerId("/2/"));
		assertEquals(99, Utilidades.obtenerId("/99/"));
		
		try {
			assertEquals(99, Utilidades.obtenerId("/99/333/hola"));
			fail("Debería haber lanzado Excepción");
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void contarPalabras(){
		
		assertEquals(0, Utilidades.contarPalabras(null));
		assertEquals(0, Utilidades.contarPalabras(""));
		assertEquals(0, Utilidades.contarPalabras("   "));
		assertEquals(2, Utilidades.contarPalabras("hola caracola"));
		assertEquals(2, Utilidades.contarPalabras("hola   mundo"));
		assertEquals(2, Utilidades.contarPalabras(" hola mundo  "));

	}
	
//	@Test
//	public void contarPalabrasLevel2(){
//		
//		assertEquals(2, Utilidades.contarPalabras("hola, mundo"));
//		assertEquals(2, Utilidades.contarPalabras("hola...? mundo  "));
//
//	}

}
