package com.iniciantes.java.tutorial;

import junit.framework.TestCase;

public class LivroTest extends TestCase {

	public void testlivro() {
		Livro l7 = new Livro("Nos passos de JESUS");
		l7.setAutor("Bispo Macedo");
		assertEquals("Nos passos de JESUS", l7.titulo);
		assertEquals("Bispo Macedo", l7.autor);

	}

	public void testGetPessoa() {
		Livro l2 = new Livro("A Grande Virada");
		Pessoa p2 = new Pessoa();
		p2.setNome("Roberto Rangel");

		// método para indicar que o livro foi emprestado para esta pessoa
		l2.setPessoa(p2);

//		Pessoa donoLivro = l2.getPessoa();
//		String donoNome = donoLivro.getNome();
//		assertEquals("Roberto Rangel", donoNome);

		String quemPegouLivro = l2.getPessoa().getNome();
		assertEquals("Roberto Rangel", quemPegouLivro);
	}
	
	public void testToString() {
		Livro l2 = new Livro("BigBang");
		Pessoa p2 = new Pessoa();
		p2.setNome("Mariana");
		
		assertEquals("BigBang por Autor Desconhecido; Disponível", l2.toString());
		
		l2.setPessoa(p2);
		assertEquals("BigBang por Autor Desconhecido; Emprestado para Mariana", l2.toString());
	}
}
