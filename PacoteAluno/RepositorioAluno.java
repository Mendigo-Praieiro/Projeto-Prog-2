package PacoteAluno;

public interface RepositorioAluno {
    void inserir(Aluno aluno);
    Aluno buscar(String cpf);
    void remover(String cpf);
    void atualizar(Aluno aluno);
    Aluno[] listar();
    int getTotal();
}