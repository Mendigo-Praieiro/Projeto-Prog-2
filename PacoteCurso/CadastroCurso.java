package pacoteNegocios;

import pacoteDados.IRepositorio;
import pacoteDados.RepositorioCursosArray;
import pacoteDados.Excecoes.LimiteAtingException;
import pacoteDados.Excecoes.CursoException;
import pacoteEntidades.Curso;

public class CadastroCurso {

    // Usando a interface
    private IRepositorio<Curso, String> repositorio;

    // Construtor vazio acionando o Singleton
    public CadastroCurso() {
        this.repositorio = RepositorioCursosArray.getInstancia();
    }

    // criando o objeto
    public void cadastrar(String nomeCurso, int numeroVagas) throws Exception {
        if (nomeCurso == null || nomeCurso.trim().isEmpty()) {
            throw new CursoException("Erro: Não foi possível cadastrar. Nome do curso inválido.");
        }

        if (this.repositorio.buscar(nomeCurso) != null) {
            throw new CursoException("Erro: Já existe um curso cadastrado com o nome " + nomeCurso + ".");
        }

        // criando o objeto
        Curso novoCurso = new Curso(nomeCurso, numeroVagas);

        this.repositorio.inserir(novoCurso);
    }

    public void remover(String nomeCurso) throws Exception {

        this.repositorio.remover(nomeCurso);
    }

    public Curso buscar(String nomeCurso) {
        return this.repositorio.buscar(nomeCurso);
    }

    // retorna uma String para a interface
    public String emitirRelatorio() {
        int total = this.repositorio.getTotal();

        if (total == 0) {
            return "Nenhum curso cadastrado no momento.\n";
        }

        Curso[] lista = this.repositorio.listar();
        String texto = "======== Relatório de Cursos ========\n";

        for (int i = 0; i < total; i++) {
            texto += "- Curso: " + lista[i].getNomeCurso() + " | Vagas: " + lista[i].getNumeroVagas() + "\n";
        }
        texto += "=====================================\n";

        return texto;
    }
}
