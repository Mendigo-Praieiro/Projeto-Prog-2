package PacoteProfessor;

public class CadastroProfessor {

    private RepositorioProfessores repositorio;

    // A Fachada vai usar este construtor para injetar o repositório correto
    public CadastroProfessor(RepositorioProfessores repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Professor professor) {
        if (professor == null || professor.getCpf() == null) {
            System.out.println("Erro: Dados inválidos do professor.");
            return;
        }

        // Verifica se já não existe alguém cadastrado com esse CPF
        if (this.repositorio.buscar(professor.getCpf()) != null) {
            System.out.println("Erro: Já existe um professor com este CPF.");
            return;
        }

        this.repositorio.inserir(professor);
        System.out.println("Professor(a) " + professor.getNome() + " cadastrado(a) com sucesso!");
    }

    public void remover(String cpf) {
        this.repositorio.remover(cpf);
    }

    public Professor buscar(String cpf) {
        return this.repositorio.buscar(cpf);
    }

    public void emitirRelatorio() {
        System.out.println(this.repositorio.listar());
    }
}