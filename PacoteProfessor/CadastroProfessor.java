package pacoteNegocios;

import pacoteDados.IRepositorio;
import pacoteDados.RepositorioProfessoresArray;
import pacoteDados.Excecoes.ProfessorException;
import pacoteEntidades.Professor;

public class CadastroProfessor {

    // Usando a interface
    private IRepositorio<Professor, String> repositorio;

    public CadastroProfessor() {
        this.repositorio = RepositorioProfessoresArray.getInstancia();
    }

    // Ajustando parametros de cadastro
    public void cadastrar(String nome, String cpf, String departamento) throws Exception {

        if (nome == null || cpf == null || cpf.trim().isEmpty()) {
            throw new ProfessorException("Erro: Dados inválidos. Professor com nome ou CPF nulo.");
        }

        if (this.repositorio.buscar(cpf) != null) {
            throw new ProfessorException("Erro: Já existe um professor cadastrado com o CPF " + cpf);
        }

        // Criando o objeto
        Professor novoProfessor = new Professor(nome, cpf, departamento);

        this.repositorio.inserir(novoProfessor);
    }

    public void remover(String cpf) throws Exception {
        // A checagem de existência já é feita pelo Repositório, que lança a exceção caso não ache.
        this.repositorio.remover(cpf);
    }

    public Professor buscar(String cpf) {
        return this.repositorio.buscar(cpf);
    }

    // Retorna string para a interface
    public String emitirRelatorio() {
        int total = this.repositorio.getTotal();

        if (total == 0) {
            return "Nenhum professor cadastrado no momento.\n";
        }

        Professor[] lista = this.repositorio.listar();
        String texto = "======== Relatório de Professores ========\n";

        for (int i = 0; i < total; i++) {
            // Puxando os dados da classe Pessoa
            texto += "- Nome: " + lista[i].getNome() + " | CPF: " + lista[i].getCpf() + "\n";
        }
        texto += "==========================================\n";

        return texto;
    }
}
