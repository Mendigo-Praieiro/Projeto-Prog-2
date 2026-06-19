package pacoteDados;

import pacoteDados.Excecoes.LimiteAtingException;
import pacoteDados.Excecoes.CursoException;
import pacoteEntidades.Curso;


public class RepositorioCursosArray implements IRepositorio<Curso, String> {


    private static RepositorioCursosArray instancia;

    private Curso[] cursos;
    private int indice;


    public RepositorioCursosArray(int tamanhoMaximo) {
        this.cursos = new Curso[tamanhoMaximo];
        this.indice = 0;
    }


    public static RepositorioCursosArray getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCursosArray(50);
        }
        return instancia;
    }

    @Override
    public void inserir(Curso curso) throws LimiteAtingException {
        if (this.indice < this.cursos.length) {
            this.cursos[this.indice] = curso;
            this.indice++;
        } else {

            throw new LimiteAtingException("Erro: Limite máximo de cursos cadastrados foi atingido!", indice);
        }
    }

    @Override
    public Curso buscar(String nomeCurso) {
        for (int i = 0; i < this.indice; i++) {
            if (this.cursos[i].getNomeCurso().equals(nomeCurso)) {
                return this.cursos[i];
            }
        }
        return null; // Se o loop acabar e não achar nada
    }

    @Override
    public void remover(String nomeCurso) throws Exception {
        for (int i = 0; i < this.indice; i++) {
            if (this.cursos[i].getNomeCurso().equals(nomeCurso)) {
                this.cursos[i] = this.cursos[this.indice - 1];
                this.cursos[this.indice - 1] = null; // Limpa a última posição
                this.indice--;
                return;
            }
        }

        throw new CursoException("Erro: Curso '" + nomeCurso + "' não encontrado para remoção.");
    }


    @Override
    public void atualizar(Curso curso) {
        for (int i = 0; i < this.indice; i++) {
            if (this.cursos[i].getNomeCurso().equals(curso.getNomeCurso())) {
                this.cursos[i] = curso;
                return;
            }
        }
    }


    @Override
    public Curso[] listar() {
        Curso[] copia = new Curso[indice];
        for (int i = 0; i < indice; i++) {
            copia[i] = this.cursos[i];
        }
        return copia;
    }


    @Override
    public int getTotal() {
        return this.indice;
    }
}
