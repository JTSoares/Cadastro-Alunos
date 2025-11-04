package Model;

import java.util.ArrayList;
import java.util.List;
//
public class Aluno {

	//***********************ATRIBUTOS***********************
	private String nome;
	private int idade;
	private String matricula;
	private List<Boletim> historico = new ArrayList<>();	//Lista das notas e respectivas disciplinas

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

	public List<Boletim> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Boletim> historico) {
		if (!historico.isEmpty()) {
			this.historico = historico;
		}
	}

	/**
	 * Método: adicionarBoletim
	 * Objetivo: Atribuir ha um aluno um boletim com a sua disciplina relativa
	 * @param boletim
	 */
	public void adicionarBoletim(Boletim boletim) {
		if (!historico.contains(boletim)) {
			this.historico.add(boletim);
		}
	}

	/**
	 * Método: mostrarBoletim
	 * Objetivo: Mostrar o boletim do referido aluno
	 */
	public void mostrarBoletim() {
		if (!historico.isEmpty()) {
			for (Boletim boletim : historico) {
				System.out.println("Discipina: " + boletim.getDisciplina().getNome() + '\'' +
				"Media: " + boletim.getMediaFinal());
			}
		}else {
			System.out.println("Não há boletim para o aluno");
		}
	}

	@Override
	public String toString() {
		return "Aluno{" +
				"nome='" + nome + '\'' +
				", idade=" + idade +
				", matricula='" + matricula + '\'' +
				'}';
	}
}

