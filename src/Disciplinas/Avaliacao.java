package Disciplinas;

public class Avaliacao {
    //**************************ATRIBUTOS**************************
    private String tipo;
    private Double nota;
    private Double peso;

    //**************************CONSTRUTOR**************************
    public Avaliacao(String tipo, Double nota, Double peso) {
        this.setTipo(tipo);
        this.setNota(nota);
        this.setPeso(peso);
    }

    //**************************GET E SET**************************
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (!tipo.isEmpty()) {
            this.tipo = tipo;
        }
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        if (nota >= 0) {
            this.nota = nota;
        }
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        if (peso >= 0) {
            this.peso = peso;
        }
    }

}
