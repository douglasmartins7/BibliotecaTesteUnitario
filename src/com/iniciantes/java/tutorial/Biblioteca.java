package com.iniciantes.java.tutorial;

import java.util.ArrayList;

public class Biblioteca {

	String nome;
	ArrayList<Livro> livros;
	ArrayList<Pessoa> pessoas;

	public Biblioteca(String name) {
		this.nome = name;
		livros = new ArrayList<Livro>();
		pessoas = new ArrayList<Pessoa>();
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void addLivro(Livro l1) {
		this.livros.add(l1);

	}

	public void removeLivro(Livro l1) {
		this.livros.remove(l1);

	}

	public void addPessoa(Pessoa p1) {
		this.pessoas.add(p1);
	}

	public void removePessoa(Pessoa p1) {
		this.pessoas.remove(p1);

	}

	public boolean emprestimo(Livro l1, Pessoa p1) {
		int livrosEmprestados = this.getLivrosPorPessoa(p1).size();
		if ((l1.getPessoa() == null) && (livrosEmprestados < p1.getMaximoLivros())){
			l1.setPessoa(p1);
			return true;
		} else {
			return false;
		}
	}

	public boolean devolucao(Livro l1) {
		if (l1.getPessoa() != null) {
			l1.setPessoa(null);
			return true;
		} else {
			return false;

		}
	}

	// Retorna a quantidade de livros que a pessoa tem
	public ArrayList<Livro> getLivrosPorPessoa(Pessoa p1) {
		ArrayList<Livro> resultado = new ArrayList<Livro>(); //Define o ArrayList resultado que vai armazenar a Lista que o método deve retornar.
		for(Livro umLivro : this.getLivros()) { //Um laço do tipo "foreach", que vai percorrer a lista de Livros.
			if((umLivro.getPessoa() != null) && (umLivro.getPessoa().getNome().equals(p1.getNome()))) { //O "if" que define as condições que vão eleger um elemento para a nossa Lista.
				//O Livro deve estar emprestado a uma Pessoa.
				//O nome da Pessoa a qual o Livro foi emprestado, deve ser igual ao da Pessoa passada como parâmetro
				resultado.add(umLivro);//O elemento eleito é adicionado na Lista.
			}
		}
		return resultado;//O ArrayList "resultado" é retornado.
	}

	public ArrayList<Livro> getLivrosDisponiveis(Pessoa p1) {
		ArrayList<Livro> resultado = new ArrayList<Livro>(); //Define o ArrayList resultado que vai armazenar a Lista que o método deve retornar.
		for(Livro umLivro : this.getLivros()) { //Um laço do tipo "foreach", que vai percorrer a lista de Livros.
			if((umLivro.getPessoa() == null)) {
				//O Livro deve estar emprestado a uma Pessoa.
				//O nome da Pessoa a qual o Livro foi emprestado, deve ser igual ao da Pessoa passada como parâmetro
				resultado.add(umLivro);//O elemento eleito é adicionado na Lista.
			}
		}
		return resultado;//O ArrayList "resultado" é retornado.
	}

	public ArrayList<Livro> getLivrosIndisponiveis() {
		ArrayList<Livro> resultado = new ArrayList<Livro>(); 
		for(Livro umLivro : this.getLivros()) { 
			if((umLivro.getPessoa() != null)) {
				resultado.add(umLivro);
			}
		}
		return resultado;
	}
	
	public String toString() {
		return this.getNome() + ": " + this.getLivros().size() + " Livros; " + this.getPessoas().size() + " Pessoas.";
	}
	
	public static void main(String[] args) {
		// Criar uma nova biblioteca
		Biblioteca testeBiblioteca = new Biblioteca("Central");
		
		// Criar Livros
		Livro l1 = new Livro("O principe e o pobre");
		l1.setAutor("Mark Twain");
		Livro l2 = new Livro("O livro dos cinco elementos");
		l2.setAutor("Myamoto Musachi");
		
		// Criar Pessoas
		Pessoa p1 = new Pessoa();
		p1.setNome("Lisa Simpson");
		Pessoa p2 = new Pessoa();
		p2.setNome("Bart Simpson");
		
		// Associa Livros e Pessoas à Biblioteca
		testeBiblioteca.addLivro(l1);
		testeBiblioteca.addLivro(l2);
		testeBiblioteca.addPessoa(p1);
		testeBiblioteca.addPessoa(p2);
		
		// Exibe status na criação
		System.out.println("Criada a nova Biblioteca");
		testeBiblioteca.imprimeStatus();
		
		
		// Exibe o status do empréstimo
		System.out.println("Empresta o príncipe e o pobre para Lisa Simpson");
		testeBiblioteca.emprestimo(l1, p1);
		testeBiblioteca.imprimeStatus();
		
		// Exibe o status depois de algumas ações
		System.out.println("Faz mais algumas manutenções");
		testeBiblioteca.devolucao(l1);
		testeBiblioteca.emprestimo(l2, p2);
		testeBiblioteca.imprimeStatus();
	}

	private void imprimeStatus() {
		System.out.println("Status da Biblioteca:\n" + toString());
		
		for(Livro umLivro : getLivros()) {
			System.out.println(umLivro);
		}
		
		for(Pessoa umaPessoa : getPessoas()) {
			int contador = getLivrosPorPessoa(umaPessoa).size();
			System.out.println(umaPessoa + " tem " + contador + " dos meus livros");
		}
		
		System.out.println("Livros disponíveis " + getLivrosIndisponiveis().size() + ".");
		System.out.println(" --- Fim do Relatório de Status ---");
		
	}
}
