package PacoteSala;

public interface RepositorioSalas {

    void salvar(Sala sala);

    Sala buscar(int numero);

    boolean remover(int numero);

    Sala[] listar();

    int getTotal();
}