package PacoteTurma;

public interface RepositorioTurma {
    void inserir(Turma turma) throws Exception;
    Turma buscar(int idTurma);
    void remover(int idTurma) throws Exception;
    Turma[] listar();
}