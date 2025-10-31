package Disciplinas;
import Alunos.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Boletim {

    //***********************ATRIBUTOS***********************
    private Disciplina disciplina;
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private boolean situacao;

    //***********************CONSTRUTORES***********************
    public Boletim(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    //***********************GETTERS E SETTERS***********************


    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
}
