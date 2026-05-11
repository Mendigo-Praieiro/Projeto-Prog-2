package PacoteTurma;

public class RepositorioTurmasArray implements RepositorioTurma {
    private Turma[] turmas;
    private int indice;

    public RepositorioTurmasArray(int tamanhoMaximo) {
        this.turmas = new Turma[tamanhoMaximo];
        this.indice = 0;
    }

    @Override
    public void inserir(Turma turma) throws Exception {
        if (indice < turmas.length) {
            turmas[indice] = turma;
            indice++;
        } else {
            
            throw new Exception("Erro: Limite máximo de turmas atingido no banco de dados.");
        }
    }

    @Override
    public Turma buscar(int idTurma) {
        for (int i = 0; i < indice; i++) {
            if (turmas[i].getIdTurma() == idTurma) {
                return turmas[i];
            }
        }
        return null;
    }

    @Override
    public void remover(int idTurma) throws Exception {
        for (int i = 0; i < indice; i++) {
            if (turmas[i].getIdTurma() == idTurma) {
                turmas[i] = turmas[indice - 1];
                turmas[indice - 1] = null;
                indice--;
                return;
            }
        }

        throw new Exception("Erro: Turma com ID " + idTurma + " não encontrada para remoção.");
    }

    @Override
    public Turma[] listar() {
        Turma[] copia = new Turma[indice];
        for (int i = 0; i < indice; i++) {
            copia[i] = turmas[i];
        }
        return copia;
    }
}
