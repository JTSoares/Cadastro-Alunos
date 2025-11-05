package Model;

import java.util.ArrayList;
import java.util.List;
//
public class Aluno extends Usuario {

	//***********************ATRIBUTOS***********************
	private List<Boletim> historico = new ArrayList<>();	//Lista das notas e respectivas disciplinas

	public Aluno(String nome, int idade, String cpf, String matricula) {
		super(nome, idade, cpf, matricula);
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

	public void adicionarAvaliacao(Disciplina disciplina, Avaliacao avaliacao) {
		for (Boletim boletim : this.historico) {
			if (boletim.getDisciplina().equals(disciplina)) {
				boletim.adicionarAvaliacao(avaliacao);
			}
		}
	}

	/**
	 * Metodo: adicionarFaltas
	 * Objetivo: adicionar uma determinada quantidade de faltas para um aluno, de acordo com uma determinada disciplina
	 * @param disciplina
	 * @param qtd
	 */
	public void adicionarFaltas(Disciplina disciplina, int qtd) {
		for (Boletim boletim : historico) {
			if (boletim.getDisciplina().equals(disciplina)) {	//Se existir a disciplina na lista de disciplinas que um aluno possui
				boletim.adicionarFaltas(qtd);
				break;
			}else {
				System.out.println("Disciplina nao encontrada!");
			}
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
				", matricula='" + getMatricula() + '\'' +
				'}';
	}
}

