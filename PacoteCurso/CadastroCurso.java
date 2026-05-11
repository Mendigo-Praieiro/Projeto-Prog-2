package PacoteCurso;

import ExceptionsRepositorioCurso.LAException;

public class CadastroCurso {

    private RepositorioCursos repositorio;

    public CadastroCurso(RepositorioCursos repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Curso curso) throws CursoException, LAException {
        if (curso == null) {
            throw new CursoException("Erro: Nao foi possivel cadastrar. Curso invalido (nulo).");
        }
        if (this.repositorio.buscar(curso.getNomeCurso()) != null) {

            throw new CursoException("Erro: Ja existe um curso cadastrado com o nome " + curso.getNomeCurso() + ".");
        }

        this.repositorio.inserir(curso);
        System.out.println("Curso " + curso.getNomeCurso() + " cadastrado com sucesso!");
    }


    public void remover(String nomeCurso) throws CursoException {

        Curso cursoEncontrado = this.repositorio.buscar(nomeCurso);
        if (cursoEncontrado == null) {
            throw new CursoException("Erro: Curso " + nomeCurso + " nao encontrado para remocao.");
        }

        this.repositorio.remover(nomeCurso);
        System.out.println("Curso removido com sucesso.");
    }

    public Curso buscar(String nomeCurso) {
        return this.repositorio.buscar(nomeCurso);
    }

    public void emitirRelatorio() {
        System.out.println(this.repositorio.listar());
    }
    
}
