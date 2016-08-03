package com.iniciantes.java.tutorial;

import java.util.ArrayList;

import junit.framework.TestCase;

public class BibliotecaTest extends TestCase {

	private Livro l1;
	private Livro l2;
	private Pessoa p1;
	private Pessoa p2;
	private Biblioteca b1;

	// Teste do Construtor
	public void testBiblioteca() {
		Biblioteca b1 = new Biblioteca("Nerd Center");

		assertEquals("Nerd Center", b1.nome);

		assertTrue(b1.livros instanceof ArrayList);
		assertTrue(b1.pessoas instanceof ArrayList);

	}

	public void setUp() {
		l1 = new Livro("Livro1");
		l2 = new Livro("Livro2");
		p1 = new Pessoa();
		p2 = new Pessoa();
		p1.setNome("Frederico");
		p2.setNome("Sueli");

		b1 = new Biblioteca("teste");

	}

	public void testAddLivro() {

		// Cria objeto de teste
		setUp();

		// Garantir objetos vazio
		assertEquals(0, b1.getLivros().size());

		b1.addLivro(l1);
		b1.addLivro(l2);

		// Garantir que havera dois livros dentro do array
		assertEquals(2, b1.getLivros().size());

		// Garantir que os livros estão guardados nas referencias corretas
		assertEquals(0, b1.getLivros().indexOf(l1));
		assertEquals(1, b1.getLivros().indexOf(l2));

		// Garantir que foi removido livro do índice 0
		b1.removeLivro(l1);
		assertEquals(1, b1.getLivros().size());

		// Garantir que o segundo livro passou do índice 1 para o 0
		assertEquals(0, b1.getLivros().indexOf(l2));

		// Garantir que foi removido segundo livro
		b1.removeLivro(l2);
		assertEquals(0, b1.getLivros().size());

		// Garantir que sera inserido pessoas no array da bibliteoca e removida
		// a mesma
		b1.addPessoa(p1);
		b1.addPessoa(p2);

		assertEquals(2, b1.getPessoas().size());
		assertEquals(0, b1.getPessoas().indexOf(p1));
		assertEquals(1, b1.getPessoas().indexOf(p2));

		b1.removePessoa(p1);
		assertEquals(1, b1.getPessoas().size());
		assertEquals(0, b1.getPessoas().indexOf(p2));

		b1.removePessoa(p2);
		assertEquals(0, b1.getPessoas().size());
	}
	
	public void testMovimentaLivro() {
		// Adicionar objeto
		setUp();
		
		// Adicionar Livros e Pessoas  à Biblioteca
		addItems();
		
		// Garantir que o metodo emprestimo seja utilizado apenas se possivel
		assertTrue("O Livro não pode ser emprestado!", b1.emprestimo(l1,p1));
		assertEquals("Frederico", l1.getPessoa().getNome());
		assertFalse("O livro emprestado indevidamente", b1.emprestimo(l1,p2));
		
		// Garantir que o metodo Devolução seja utilizado apenas se possivel
		assertTrue("O livro não pode ser devolvido!", b1.devolucao(l1));
		assertFalse("O livro foi devolvido indevidamente! (ja devolvido)", b1.devolucao(l1));
		assertFalse("O livro foi devolvido indevidamente! (nunca emprestado)", b1.devolucao(l2));
		
		// Teste adicional para maximoLivros
		setUp();
		p1.setMaximoLivros(1); // Limite de 1 para facilitar
		addItems();
		
		assertTrue("O livro não pode ser emprestado", b1.emprestimo(l2, p1));
		assertFalse("O livro foi emprestado indevidamente", b1.emprestimo(l1, p1));
		
	}

	private void addItems() {
		b1.addLivro(l1);
		b1.addLivro(l2);
		b1.addPessoa(p1);
		b1.addPessoa(p2);
	}
	
	public void testGetLivrosPorPessoa() {
		setUp();
		addItems();
		assertEquals(0, b1.getLivrosPorPessoa(p1).size());
		
		b1.emprestimo(l1, p1);
		
		
		ArrayList<Livro> testeLivro = b1.getLivrosPorPessoa(p1);
		assertEquals(1, testeLivro.size());
		assertEquals(0, testeLivro.indexOf(l1));
		
		b1.emprestimo(l2, p1);
		testeLivro = b1.getLivrosPorPessoa(p1);
		assertEquals(2, testeLivro.size());
		assertEquals(1, testeLivro.indexOf(l2));
		
	}
	
	public void testGetLivrosDisponiveis() {
		setUp();
		addItems();
		ArrayList<Livro> testeLivro = b1.getLivrosDisponiveis(p1);
		assertEquals(2, testeLivro.size());
		assertEquals(1, testeLivro.indexOf(l2));
		
		b1.emprestimo(l1, p1);
		testeLivro = b1.getLivrosDisponiveis(p1);
		assertEquals(1, testeLivro.size());
		assertEquals(0, testeLivro.indexOf(l2));
		
		b1.emprestimo(l2, p1);
		testeLivro = b1.getLivrosDisponiveis(p1);
		assertEquals(0, testeLivro.size());
		
	}
	
	public void testGetLivrosIndisponiveis() {
		setUp();
		addItems();
		assertEquals(0, b1.getLivrosIndisponiveis().size());
		
		b1.emprestimo(l1, p1);
		
		ArrayList<Livro> testeLivro = b1.getLivrosIndisponiveis();
		assertEquals(1, testeLivro.size());
		assertEquals(0, testeLivro.indexOf(l1));
		
		b1.emprestimo(l2, p2);
		testeLivro = b1.getLivrosIndisponiveis();
		assertEquals(2, testeLivro.size());
		assertEquals(1, testeLivro.indexOf(l2));
		
	}

	public void testToString() {
		setUp();
		addItems();
		assertEquals("teste: 2 Livros; 2 Pessoas.", b1.toString());
	}
}
