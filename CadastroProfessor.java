package PacoteProfessor;

public class CadastroProfessor {

    private RepositorioProfessores repositorio;

    // A Fachada vai usar este construtor para injetar o repositório correto
    public CadastroProfessor(RepositorioProfessores repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Professor professor) throws ProfessorException {

        if (professor == null || professor.getCpf() == null) {
            throw new ProfessorException("Dados invalidos: Professor nulo ou sem CPF.");
        }

        if (this.repositorio.buscar(professor.getCpf()) != null) {
            throw new ProfessorException("Ja existe um professor com este CPF.");
        }

        this.repositorio.inserir(professor);
        System.out.println("Professor(a) " + professor.getNome() + " cadastrado(a) com sucesso!");
    }

    public void remover(String cpf) throws ProfessorException {
        Professor prof = this.repositorio.buscar(cpf);
        if (prof == null) {
            throw new ProfessorException("Professor de CPF " + cpf + " nao encontrado para remocao.");
        }
        this.repositorio.remover(cpf);
        System.out.println("Professor removido com sucesso.");
    }

    public Professor buscar(String cpf) {
        return this.repositorio.buscar(cpf);
    }

    public void emitirRelatorio() {
        System.out.println(this.repositorio.listar());
    }
}