package PacoteCadeira;

public interface RepositorioCadeira {
    void inserir(Cadeira cadeira);
    Cadeira buscar(int codigo);
    boolean remover(int codigo);
    Cadeira[] listar();
    int getTotal();
}