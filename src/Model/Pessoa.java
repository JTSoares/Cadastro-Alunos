package Model;

public class Pessoa {
    //**********ATRIBUTOS********
     protected String nome;
     protected String cpf;
     protected int idade;

    //**********CONSTRUTOR********
    public Pessoa(String nome, int idade, String cpf) {
        setNome(nome);
        setIdade(idade);
        setCPF(cpf);
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
            this.cpf = cpf;
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
