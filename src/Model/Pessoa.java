package Model;

public class Pessoa {
    //**********ATRIBUTOS********
     private String nome;
     private String cpf;
     private int idade;

    //**********CONSTRUTOR********
    public Pessoa(String nome, int idade, String CPF) {
        setNome(nome);
        setIdade(idade);
        setCPF(CPF);
    }

    //**********GETTER E SETTER********
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isEmpty()) {
            this.nome = nome;
        } else if (nome.equals("")) {
            System.out.println("Nome inválido");
        }
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpf) {
        if ((!cpf.isEmpty()) && (cpf.length() == 11) ) {
            this.cpf = CPF;
        }else {
            System.out.println("CPF INVÁLIDO");
        }

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
            if (idade > 0) {
                this.idade = idade;
            }
    }
}
