package Controller;
import Model.*;
import View.*; 


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
	private static List<Aluno> listaAlunos = new ArrayList<Aluno>(); 
	private static List<Professor> listaProfessores = new ArrayList<Professor>(); 
	private static List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>(); 
	
	public static void inicializarDados() {
        // 1. Criando Professores (Senha: 11111111111)
        Professor prof1 = new Professor("Lisbete", 45, "11111111111", "PROF001");
        listaProfessores.add(prof1);

        // 2. Criando Alunos (Senha: 222... e 333...)
        Aluno aluno1 = new Aluno("Joao Victor", 22, "22222222222", "ALU001");
        Aluno aluno2 = new Aluno("Maria Beatriz", 21, "33333333333", "ALU002");
        
        listaAlunos.add(aluno1);
        listaAlunos.add(aluno2);

        // 3. Criando uma Disciplina para testes futuros
        Disciplina algoritmos = new Disciplina("Desenvolvimento de Algoritmos", "DATL", 36);
        prof1.adicionarDisciplina(algoritmos);
        algoritmos.adicionarAlunos(aluno1);
        
        listaDisciplinas.add(algoritmos);
        
        Boletim boletimAlgoritmos = new Boletim(algoritmos); // Cria boletim da matéria
        aluno1.adicionarBoletim(boletimAlgoritmos); // Entrega boletim pro João Victor

        // Professor lançando nota (Prova 1 vale 10, ele tirou 8.5)
        Avaliacao prova1 = new Avaliacao("Prova 1", 8.5, 1.0); 
        prof1.lancarAvaliacao(prova1, aluno1, algoritmos);
        prof1.lancarFaltas(aluno1, algoritmos,"02/01/2026", 2);
        
        System.out.println("Dados de teste carregados com sucesso!");
    }
	
	public static Usuario autenticar(String matricula, String cpf) {
		for (Aluno a : listaAlunos) {
	        if (a.getMatricula().equals(matricula) && a.getCPF().equals(cpf)) {
	            return a;
	        }
	    }
	    // Procurar nos professores
	    for (Professor p : listaProfessores) {
	        if (p.getMatricula().equals(matricula) && p.getCPF().equals(cpf)) {
	            return p;
	        }
	    }
		
		return null; 
	}
	
    public static void main(String[] args) {
    	Sistema.inicializarDados();
    	
    	TelaLogin login = new TelaLogin();
    	login.setVisible(true);

    }


}
