package PacoteCadeira;

public class RepositorioCadeirasArray implements RepositorioCadeira {

    private Cadeira[] cadeiras;
    private int totalCadeiras;

    public RepositorioCadeirasArray() {
        this.cadeiras = new Cadeira[10];
        this.totalCadeiras = 0;
    }

    @Override
    public void inserir(Cadeira cadeira) {
        if (cadeira == null) {
            return;
        }
        if (totalCadeiras == cadeiras.length) {
            aumentarTamanho();
        }
        cadeiras[totalCadeiras] = cadeira;
        totalCadeiras++;
    }

    @Override
    public Cadeira buscar(int codigo) {
        for (int i = 0; i < totalCadeiras; i++) {
            if (cadeiras[i].getCodigoCadeira() == codigo) {
                return cadeiras[i];
            }
        }
        return null;
    }

    @Override
    public boolean remover(int codigo) {
        for (int i = 0; i < totalCadeiras; i++) {
            if (cadeiras[i].getCodigoCadeira() == codigo) {
                for (int j = i; j < totalCadeiras - 1; j++) {
                    cadeiras[j] = cadeiras[j + 1];
                }
                cadeiras[totalCadeiras - 1] = null;
                totalCadeiras--;
                return true;
            }
        }
        return false;
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