package Model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    //****************ATRIBUTOS****************
    private String matricula;
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    //****************CONSTRUTOR****************
    public Professor(String nome, int idade, String cpf, String matricula) {
        super(nome, idade, cpf);
        this.matricula = matricula;
    }

    //****************GETTER/SETTER****************
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    //****************METODOS****************
    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }   //Sera para o coordenador

    /**
     * Metodo: litarAlunos
     * Objetivo: Permitir que um professor liste os seus alunos da Disciplina em específico
     * @param disciplina    Disciplina que deseja-se fazer as listagens
     */
    public void listarAlunos(Disciplina disciplina) {
        System.out.println("Disciplina: " + disciplina.getNome() + "\n");
         for (Aluno aluno : disciplina.getAlunos()) {
             System.out.println(aluno.getNome());
         }
    }

    /**
     * Metodo: lancarFaltas
     * Objetivo: Permitir que um professor lance faltas para um determinado aluno em uma disciplina específica
     * @param aluno //Que deve ser feito as faltas
     * @param disciplina    //Disciplina que devera lancar as faltas
     * @param qtd           //Quantidade de faltas que o professor dsejea lançar
     */
    public void lancarFaltas(Aluno aluno,  Disciplina disciplina, int qtd) {
        if (disciplina.getAlunos().contains(aluno)) {
            aluno.adicionarFaltas(disciplina, qtd);     //Adiciona a falta para o aluno na determinada disciplina
        }
        else {
            System.out.println("Aluno "+ aluno.getNome() + " não encontrado para a disciplina "+ disciplina.getNome());
        }
    }

}
