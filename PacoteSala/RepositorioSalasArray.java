package pacoteDados;

import pacoteEntidades.Sala;
import pacoteDados.Excecoes.SalaException;

// O ID da sala é o número (int), então utilizamos o Integer
public class RepositorioSalasArray implements IRepositorio<Sala, Integer> {


    private static RepositorioSalasArray instancia;

    private Sala[] salas;
    private int total;


    private RepositorioSalasArray() {
        this.salas = new Sala[10];
        this.total = 0;
    }


    public static RepositorioSalasArray getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioSalasArray();
        }
        return instancia;
    }

    @Override
    public void inserir(Sala sala) throws SalaException {
        if (sala == null) {
            throw new SalaException("Erro: Sala inválida (nula).");
        }
        if (total == salas.length) {
            aumentarArray();
        }
        salas[total] = sala;
        total++;
    }

    @Override
    public Sala buscar(Integer numero) {
        for (int i = 0; i < total; i++) {
            if (salas[i].getNumero() == numero) {
                return salas[i];
            }
        }
        return null;
    }

    @Override
    public void remover(Integer numero) throws SalaException { // Agora lança a exceção de Sala
        for (int i = 0; i < total; i++) {
            if (salas[i].getNumero() == numero) {
                for (int j = i; j < total - 1; j++) {
                    salas[j] = salas[j + 1];
                }
                salas[total - 1] = null;
                total--;
                return;
            }
        }
        throw new SalaException("Erro: Sala número " + numero + " não encontrada para remoção.");
    }


    @Override
    public void atualizar(Sala sala) {
        for (int i = 0; i < total; i++) {
            if (salas[i].getNumero() == sala.getNumero()) {
                salas[i] = sala;
                return;
            }
        }
    }

    @Override
    public Sala[] listar() {
        Sala[] arrayRetorno = new Sala[total];
        for (int i = 0; i < total; i++) {
            arrayRetorno[i] = salas[i];
        }
        return arrayRetorno;
    }

    @Override
    public int getTotal() {
        return total;
    }

    private void aumentarArray() {
        Sala[] novoArray = new Sala[salas.length + 10];
        for (int i = 0; i < salas.length; i++) {
            novoArray[i] = salas[i];
        }
        this.salas = novoArray;
    }
}
