package Alunos;

import java.util.ArrayList;

import Disciplinas.Disciplina;

public class Aluno {

	//***********************ATRIBUTOS***********************
	private String nome;
	private int idade;
	private String matricula;


	public Aluno(String nome, int idade, String matricula) {
		this.setNome(nome);
		this.setIdade(idade);
		this.setMatricula(matricula);
	}

	//***********************GETTERS E SETTERS***********************
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade >= 0 && idade <= 100) {
			this.idade = idade;
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if ((matricula != null) && (!matricula.isEmpty())) {
			this.matricula = matricula;
		}
	}
}

