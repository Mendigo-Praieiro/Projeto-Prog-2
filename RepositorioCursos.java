package PacoteCurso;

public interface RepositorioCursos {
    void inserir(Curso curso);
    Curso buscar(String nomeCurso);
    void remover(String nomeCurso);
    public String listar();

}

