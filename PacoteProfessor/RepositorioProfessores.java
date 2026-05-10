package PacoteProfessor;

public interface RepositorioProfessores {
    void inserir(Professor professor);
    Professor buscar(String cpf);
    void remover(String cpf);
    String listar();
}