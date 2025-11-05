package Controller;
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Professor prof = new Professor("Lisbete", 78, "55041311896", "PROF001");
        Disciplina algoritmos1 = new Disciplina("Desenvolvimento de Algoritmos", "DATL", 36);
        Aluno aluno = new Aluno("Joao Victor", 22, "55041311897", "RA00330701");
        Aluno aluno2 = new Aluno("Maria Beatriz", 22, "55041311892", "ALU0002");

        Boletim boletimAlgoritmo = new Boletim(algoritmos1);
        prof.adicionarDisciplina(algoritmos1);  //Adiciona a disciplina para o professor
        algoritmos1.adicionarAlunos(aluno2);
        algoritmos1.adicionarAlunos(aluno);
        aluno.adicionarBoletim(boletimAlgoritmo);
        prof.lancarFaltas(aluno, algoritmos1, 2);   //Adiciona duas faltas para o aluno na disciplina algortimos

        System.out.println("Boletim de " + aluno.getNome());
        for (Boletim b: aluno.getHistorico()){
            System.out.println(b.getDisciplina().getNome() + " faltas: " + b.getFaltas());
        }

        System.out.println("\nLista de alunos disciplinas: "+ algoritmos1.getNome());
        prof.listarAlunos(algoritmos1);
    }


}
