package Alunos;
import java.util.Scanner;

import Disciplinas.Disciplina;

import java.util.ArrayList;
/*
 * 
 */
public class SistemaCadastro {
	private Scanner scan = new Scanner(System.in);
	static ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
	
	public void iniciar() {
		int opcao;
		do {
			System.out.println("------------------------CADASTRO ALUNOS------------------------");
			System.out.println("1. Cadastrar Alunos");
			System.out.println("2. Lista de alunos");
			System.out.println("3. Remover aluno");
			System.out.println("4. Adicionar Disciplina");
			System.out.println("5. Procurar Aluno");
			System.out.println(" ");
			
			opcao = scan.nextInt();
			scan.nextLine();	//Limpa o buffer
			
			switch (opcao) {
			case 1: {
				cadastrarAluno();
				//System.out.println("Cadastrando o aluno");
				break;
			}
			case 2:{
				listarAlunos();
				//System.out.println("Li ");
				break;
			}
			case 3: {
				//procurarAluno();
				//System.out.println("Remover Aluno");
				removerAluno();
				break;
			}
			case 4:{
				System.out.println("Adicionar disciplina");
			}
			case 5:{
				System.out.println("Procurando aluno");
				procurarAluno();
				break;
			}
			case 6:{
				System.out.println("Encerrando o sistema");
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		} while (opcao != 6);
		
		scan.close();
	}
	
	private void cadastrarAluno() {
		String nomeConfirmacao;
		
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		
		System.out.println("Idade: ");
		int idade = scan.nextInt();
		scan.nextLine(); //Limpa o buffer
		
		System.out.println("Matrícula: ");
		String matricula = scan.nextLine();
		
		//Cria o aluno para adicionar a lista de alunos
		Aluno novoAluno = new Aluno(nome, idade, matricula);
		listaAlunos.add(novoAluno);
		
		//Mensagem confirmacao
		nomeConfirmacao = novoAluno.nome;
		System.out.println("Aluno "+ nomeConfirmacao + " cadastrado com sucesso!");
		
	}
	
	public void cadastrarAlunoIg(String nome, String matricula, int idade) {
		//Cria o aluno para adicionar a lista de alunos
		Aluno novoAluno = new Aluno(nome, idade, matricula);
		listaAlunos.add(novoAluno);
		
	}
	
	public void removerAlunoIG(String matricula) {
		String matriculaBusca = "None";
		
		for(Aluno aluno: listaAlunos) {
			matricula = aluno.getMatricula();
			
			if(matriculaBusca.equals(matricula)) {
				listaAlunos.remove(aluno);
			}
		}
	}
	
	//Metodo para retornar a lista de alunos
	public ArrayList<Aluno> getListaAlunos(){
		return listaAlunos;
	}
	
	private void listarAlunos() {
		String nomeAluno;
		int posicao = 1;
		
		if (listaAlunos.isEmpty()) { //Se a lista estiver vazia avisa o usuario
			System.out.println("Nenhum usuario cadastrado");
		}
		else {
			System.out.println("************Lista de alunos cadastrados************");
			System.out.print("\n");
			
			for(Aluno aluno: listaAlunos) {
				nomeAluno = aluno.nome;
				posicao++; 
				System.out.println(posicao + " " + nomeAluno);
			}
		}
	}
	
	/*
	private void procurarAluno() {
		if(!listaAlunos.isEmpty()) {
			String matriculaBusca;
			String matricula;
			String nome;
			boolean verificador = false;
			int idade; 
			
			System.out.println("Digite a matricula para a busca: ");
			matricula = scan.nextLine();
			//scan.close();
			
			for(Aluno aluno: listaAlunos) {
				matriculaBusca = aluno.getMatricula();
				
				if(matriculaBusca.equals(matricula)) {
					verificador = true;
					nome = aluno.getNome();
					idade = aluno.getIdade();
					
					System.out.println("Aluno: " + nome);
					System.out.println("Idade: " + idade);
				}
				
			}
			if(verificador == false) {
				System.out.println("Nenhum aluno encontrado com a matricula fornecida");
			}
		}
		else {
			System.out.println("Nao existem alunos listados");
		}
	}
	*/
	private void procurarAluno() {
		System.out.println("Digite a matricula para a busca: ");
		String matriculaBusca = scan.nextLine();
		String nome;
		int idade;
		
		//Realizando a busca
		int indiceAluno = buscarAluno(listaAlunos, matriculaBusca);
		
		if(indiceAluno >0) {
			nome = listaAlunos.get(indiceAluno).getNome();
			idade = listaAlunos.get(indiceAluno).getIdade();
			
			System.out.println("Aluno procurado: " + nome);
			System.out.println("Idade: " + idade);
		}
		else {
			System.out.println("Nenhum aluno encontrado com a matricula fornecida");
		}
	}
	
	private void removerAluno() {
		if(!listaAlunos.isEmpty()) {
			String matricula;
			String matriculaBusca;
			String nome; 
			
			//Matricula para remocao
			System.out.println("Digite a matricula para remocao: ");
			matricula = scan.nextLine();
			
			for(Aluno aluno: listaAlunos) {
				matriculaBusca = aluno.getMatricula();
				
				if(matriculaBusca.equals(matricula)) {
					listaAlunos.remove(aluno);
					nome = aluno.getNome();
					
					System.out.println("Aluno: " + nome + " removido!");
					
				}
			}
		}
	}
	
	private void adicionarDisciplina() {
		Disciplina disciplina = new Disciplina("Programacao Orientada a Objeto", "Julio", 36);
		for(Aluno aluno: listaAlunos) {
			String matricula = aluno.matricula;
			String matriculaBusca = aluno.getMatricula();
			
			if(matriculaBusca.equals(matricula)) {
				String nomeDiscipina = disciplina.getNome();
				String nomeAluno = aluno.getNome();
				aluno.adicionarDisciplina(disciplina);
				System.out.println("A disciplina " + nomeDiscipina + " foi cadastrada para o aluno" + nomeAluno);
				
			}
		}
	}
	
	private int buscarAluno(ArrayList<Aluno> listaAluno, String matricula) {
	    int indice = 0;

	    while (indice < listaAluno.size()) {
	        String matriculaAtual = listaAluno.get(indice).getMatricula();
	        if (matriculaAtual.equals(matricula)) {
	            return indice;
	        }
	        indice++;
	    }

	    return -1; // não encontrado
	}

	 
	
}



