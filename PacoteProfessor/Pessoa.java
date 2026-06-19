package pacoteEntidades;

public class Pessoa {
    protected String nome;
    protected String cpf;

    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(){
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }
}


