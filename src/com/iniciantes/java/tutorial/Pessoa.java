package com.iniciantes.java.tutorial;

public class Pessoa {

	private String nome;
	private int maximoLivros;

	public Pessoa() {
		nome = "Nome Deconhecido";
		maximoLivros = 3;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMaximoLivros() {
		return maximoLivros;
	}

	public void setMaximoLivros(int maximoLivros) {
		this.maximoLivros = maximoLivros;
	}

	public String toString() {
		return this.getNome() + " (" + this.getMaximoLivros() + " livros)";
	}
}
