package PacoteCurso;
import ExceptionsRepositorioCurso.LAException;

public interface RepositorioCursos {
    Curso buscar(String nomeCurso);
    void remover(String nomeCurso);
    public String listar();
    void inserir(Curso curso) throws LAException;

}

