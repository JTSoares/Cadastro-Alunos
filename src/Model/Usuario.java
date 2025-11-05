package Model;

public class Usuario extends Pessoa {
    //*******************ATRIBUTOS*****************
    private String matricula;

    //*****************CONSTRUTOR*****************
    public Usuario(String nome, int idade, String cpf, String matricula) {
        super(nome, idade, cpf);
        this.matricula = matricula;
    }

    //*****************GETTER E SETTER*****************
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
