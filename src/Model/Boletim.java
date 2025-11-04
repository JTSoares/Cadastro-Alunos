package Model;

import java.util.ArrayList;
import java.util.List;

public class Boletim {

    //***********************ATRIBUTOS***********************
    private Disciplina disciplina;
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private boolean situacao;
    private double mediaFinal;

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

    public double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    //***********************METODOS***********************

    /**
     * Método: adicionarAvaliacao()
     * Objetivo: Adicionar uma nova avaliação a lista de avaliações
     * @param avaliacao - Objeto da avaliação deve conter a prova/atividade desejada
     */
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    /**
     * Método: calcularMediaFinal()
     * Objetivo: calcular a media ponderada da disciplina de acordo com as respectivas notas
     */
    public void calcularMediaFinal() {
        if (!avaliacoes.isEmpty()) {
            double somaPonderada = 0;
            double somaPesos = 0;
            double mediaPonderada = 0;

            for (Avaliacao avaliacao : avaliacoes) {       //Acessa a lista de notas para calculas as a media atraves das avaliacoes e seus pesos
                somaPonderada += avaliacao.getNota() *  avaliacao.getPeso();
                somaPesos += avaliacao.getPeso();
            }
            if (somaPesos > 0) {
                mediaPonderada = somaPonderada / somaPesos;
            }
            setMediaFinal(mediaPonderada);  //Atribui a media final ao calculo da media ponderada

        }else{  //Se nao houver avaliações a media final sera 0 automaticamente
            setMediaFinal(0.0);
        }
    }

    @Override
    public String toString() {
        return "Boletim{" +
                "disciplina=" + disciplina +
                ", avaliacoes=" + avaliacoes +
                ", situacao=" + situacao +
                ", mediaFinal=" + mediaFinal +
                '}';
    }
}
