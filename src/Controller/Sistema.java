package Controller;
import Model.*;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        Disciplina algoritmo = new Disciplina("Algoritmos", "DATL", 36);    //Criação da Disciplina
        Boletim boletim = new Boletim(algoritmo);

        Avaliacao prova1 = new Avaliacao("Prova1", 5.0, 3.0);
        Avaliacao prova2 = new Avaliacao("Prova2", 9.5, 3.0);
        Avaliacao atividade1 = new Avaliacao("Atividade1", 8.0, 2.0);
        Avaliacao atividade2 = new Avaliacao("Atividade2", 6.0, 2.0);


        System.out.println(algoritmo.toString());
        boletim.adicionarAvaliacao(prova1);
        boletim.adicionarAvaliacao(prova2);
        boletim.adicionarAvaliacao(atividade1);
        boletim.adicionarAvaliacao(atividade2);

        boletim.calcularMediaFinal();
        System.out.println(boletim.toString());

    }

    /**
     *
     * @param boletim
     * @return
     */
    public List<Boletim> adicionarBoletim(Boletim boletim) {
       List<Boletim> boletims = new ArrayList<>();
       
       return boletims;
    }
}
