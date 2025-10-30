package Disciplinas;

public class Disciplina {
	
	//Atributos da classe
	private String nome;
	private int cargaHoraria; 
	private Double nota;
	private String professor;
	
	//Construtor da Classe
	public Disciplina(String nome, String professor, int carga) {
		this.nome = nome;
		this.professor = professor;
		this.cargaHoraria = carga;
		
	}
	
	//Metodos
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public int getCarga() {
		return this.cargaHoraria;
	}
	
	public void setCarga(int novaCarga) {
		
	}
	
	public String getProfessor() {
		return this.professor;
	}
	
	public void setProfessor(String nomeProfessor) {
		this.professor = nomeProfessor;
	}
	
	private boolean notaValida(double nota) {
		return nota >=0 && nota <= 10;
	}
	
	private double calcularNota(double atividade1, double atividade2, double p1, double p2) {
		double n1;
		double n2;
		double mediaFinal = 0;
		
		if(notaValida(atividade2) && notaValida(atividade2)&& notaValida(p1)&& notaValida(p2)) {
			n1 = (2*(atividade1) + 3*(p1))/5;
			n2 = (2*(atividade2) + 3*(p2))/5;
			mediaFinal = (n1 + n2) / 2; 
		}
		
		return mediaFinal;
	}
	
}
