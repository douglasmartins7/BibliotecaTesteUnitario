package com.iniciantes.java.tutorial;

public class Livro {

    String titulo;
	String autor;
	Pessoa pessoa;

	public Livro(String string) {
		this.titulo = string;
		this.autor = "Autor Desconhecido";
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setPessoa(Pessoa p2) {
		this.pessoa = p2;
		
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public String toString() {
		String situacao;
		if(this.getPessoa() == null) {
			situacao = "Disponível";
		} else {
			situacao = "Emprestado para " + this.getPessoa().getNome();
		  }
		return this.getTitulo() + " por " + this.getAutor() + "; " + situacao;
	}
}
 