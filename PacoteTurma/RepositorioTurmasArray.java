package pacoteDados;

import pacoteDados.Excecoes.TurmaException;
import pacoteEntidades.Turma;
import pacoteDados.Excecoes.LimiteAtingException;


public class RepositorioTurmasArray implements IRepositorio<Turma, Integer> {


    private static RepositorioTurmasArray instancia;

    private Turma[] turmas;
    private int indice;


    private RepositorioTurmasArray(int tamanhoMaximo) {
        this.turmas = new Turma[tamanhoMaximo];
        this.indice = 0;
    }

    public static RepositorioTurmasArray getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioTurmasArray(50); // Tamanho padrão
        }
        return instancia;
    }

    @Override
    public void inserir(Turma turma) throws Exception {
        if (indice < turmas.length) {
            turmas[indice] = turma;
            indice++;
        } else {

            throw new LimiteAtingException("Erro: Limite máximo de turmas atingido no banco de dados.", indice);
        }
    }

    @Override
    public Turma buscar(Integer idTurma) { // ID alterado para Integer
        for (int i = 0; i < indice; i++) {
            if (turmas[i].getIdTurma() == idTurma) {
                return turmas[i];
            }
        }
        return null;
    }

    @Override
    public void remover(Integer idTurma) throws Exception { // ID alterado para Integer
        for (int i = 0; i < indice; i++) {
            if (turmas[i].getIdTurma() == idTurma) {
                turmas[i] = turmas[indice - 1];
                turmas[indice - 1] = null;
                indice--;
                return;
            }
        }

        throw new TurmaException("Erro: Turma com ID " + idTurma + " não encontrada para remoção.", indice);
    }


    @Override
    public void atualizar(Turma turma) {
        for (int i = 0; i < indice; i++) {
            if (turmas[i].getIdTurma() == turma.getIdTurma()) {
                turmas[i] = turma;
                return;
            }
        }
    }

    @Override
    public Turma[] listar() {
        Turma[] copia = new Turma[indice];
        for (int i = 0; i < indice; i++) {
            copia[i] = turmas[i];
        }
        return copia;
    }


    @Override
    public int getTotal() {
        return this.indice;
    }
}
