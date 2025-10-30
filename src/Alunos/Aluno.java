package Alunos;

import java.util.ArrayList;

import Disciplinas.Disciplina;

public class Aluno {
	
	//Atributos
	private String nome;
	private	int idade;
	public String matricula;
	private ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	
	//Construtor
	public Aluno(String nome, int idade, String matricula) {
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula; 
	}
	
	public String getNome() {
		return nome;
		
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int novaIdade) {
		if(novaIdade <=0 ) {
			System.out.println("Idade Invalida");
		}
		else {
			this.idade = novaIdade;	
		}
		
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String novaMatricula) {
		this.matricula = novaMatricula; 
	}
	
	public void adicionarDisciplina(Disciplina disciplina) {
		listaDisciplinas.add(disciplina);
	}
	
	@Override
	public String toString() {
	    return "Nome: " + nome + ", Matrícula: " + matricula + ", Idade: " + idade;
	}

	
}
