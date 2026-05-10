package PacoteDepartamento;

public interface RepositorioDepartamento {
    void inserir(Departamento departamento);
    Departamento buscar(String nomeDepartamento);
    void remover(String nomeDepartamento);
    public String listar();
}
