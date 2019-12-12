package com.ipartek.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.Test;

public class SetTest {

	@Test
	public void test() {
		fail("Not yet implemented");

		assertTrue(4 > 2);
		assertEquals(2, 2);
		assertNull(null);

		HashSet<String> paises = new HashSet<String>();
		assertNotNull(paises);

		paises.add("eh");
		paises.add("ct");
		paises.add("es");
		paises.add("fr");

		assertEquals("mensaje personalizado por si falla", 4, paises.size());

		paises.add("eh");
		paises.add("ct");
		paises.add("es");
		paises.add("fr");

		assertEquals("no deberia haber duplicados", 4, paises.size());
	}

}
