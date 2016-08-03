package com.iniciantes.java.tutorial;

import junit.framework.TestCase;

public class TestPessoa extends TestCase {

	public void testPessoa() {
		Pessoa p1 = new Pessoa();
		assertEquals("Nome Deconhecido", p1.getNome());
		assertEquals(3, p1.getMaximoLivros());

	}
	
	public void testToString() {
		Pessoa p4 = new Pessoa();
		p4.setNome("Romer Simpson");
		p4.setMaximoLivros(9);
		String resultado = "Romer Simpson (9 livros)";
		assertEquals(resultado, p4.toString());
	}
	
	public void testSetNome() {
		Pessoa p2 = new Pessoa();
		p2.setNome("Frederico");
		assertEquals("Frederico", p2.getNome());

	}

	public void testSetMaximoLivros() {
		Pessoa p3 = new Pessoa();
		p3.setMaximoLivros(10);
		assertEquals(10, p3.getMaximoLivros());
	}

}
