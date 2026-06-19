package pacoteDados;

import pacoteDados.Excecoes.CadeiraException;
import pacoteEntidades.Cadeira;
import pacoteDados.Excecoes.CadeiraException;

public class RepositorioCadeirasArray implements IRepositorio<Cadeira, Integer> {


    private static RepositorioCadeirasArray instancia;

    private Cadeira[] cadeiras;
    private int totalCadeiras;


    private RepositorioCadeirasArray() {
        this.cadeiras = new Cadeira[10];
        this.totalCadeiras = 0;
    }


    public static RepositorioCadeirasArray getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCadeirasArray();
        }
        return instancia;
    }

    @Override
    public void inserir(Cadeira cadeira) throws Exception {
        if (cadeira == null) {
            throw new CadeiraException("Erro: Cadeira inválida (nula).");
        }
        if (totalCadeiras == cadeiras.length) {
            aumentarTamanho();
        }
        cadeiras[totalCadeiras] = cadeira;
        totalCadeiras++;
    }

    @Override
    public Cadeira buscar(Integer codigo) {
        for (int i = 0; i < totalCadeiras; i++) {

            if (cadeiras[i].getCodigoCadeira() == codigo) {
                return cadeiras[i];
            }
        }
        return null;
    }

    @Override
    public void remover(Integer codigo) throws Exception {
        for (int i = 0; i < totalCadeiras; i++) {
            if (cadeiras[i].getCodigoCadeira() == codigo) {
                for (int j = i; j < totalCadeiras - 1; j++) {
                    cadeiras[j] = cadeiras[j + 1];
                }
                cadeiras[totalCadeiras - 1] = null;
                totalCadeiras--;
                return;
            }
        }

        throw new CadeiraException("Erro: Cadeira com código " + codigo + " não encontrada para remoção.");
    }


    @Override
    public void atualizar(Cadeira cadeira) {
        for (int i = 0; i < totalCadeiras; i++) {
            if (cadeiras[i].getCodigoCadeira() == cadeira.getCodigoCadeira()) {
                cadeiras[i] = cadeira;
                return;
            }
        }
    }

    @Override
    public Cadeira[] listar() {
        Cadeira[] copia = new Cadeira[totalCadeiras];
        for (int i = 0; i < totalCadeiras; i++) {
            copia[i] = cadeiras[i];
        }
        return copia;
    }

    @Override
    public int getTotal() {
        return totalCadeiras;
    }

    private void aumentarTamanho() {
        Cadeira[] novoArray = new Cadeira[cadeiras.length + 10];
        for (int i = 0; i < cadeiras.length; i++) {
            novoArray[i] = cadeiras[i];
        }
        this.cadeiras = novoArray;
    }
}
