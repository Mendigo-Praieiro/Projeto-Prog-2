package PacoteSala;

public class RepositorioSalasArray implements RepositorioSalas {

    private Sala[] salas;
    private int total;

    public RepositorioSalasArray() {
        salas = new Sala[10];
        total = 0;
    }

    @Override
    public void salvar(Sala sala) {
        if (sala == null) {
            return;
        }
        if (total == salas.length) {
            aumentarArray();
        }
        salas[total] = sala;
        total++;
    }

    @Override
    public Sala buscar(int numero) {
        for (int i = 0; i < total; i++) {
            if (salas[i].getNumero() == numero) {
                return salas[i];
            }
        }
        return null;
    }



    @Override
    public boolean remover(int numero) {
        for (int i = 0; i < total; i++) {
            if (salas[i].getNumero() == numero) {
                for (int j = i; j < total - 1; j++) {
                    salas[j] = salas[j + 1];
                }
                salas[total - 1] = null;
                total--;
                return true;
            }
        }
        return false;
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
