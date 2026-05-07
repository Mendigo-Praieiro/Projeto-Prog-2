package PacoteCurso;

public class CadastroCurso {
    private RepositorioCursos repositorio;


    public CadastroCurso(RepositorioCursos repositorio){
        this.repositorio = repositorio;

    }
    public void cadastrar(Curso curso){
        if (curso == null){
            System.out.println("Erro: N�o foi poss�vel cadastar. Digite um nome v�lido.");
            return;

        }
        if(this.repositorio.buscar(curso.getNomeCurso())!= null){
            System.out.println("Erro: j� existe um curso com esse nome. ");
            return;
        }
        System.out.println("Curso " + curso.getNomeCurso()+ " Cadastrado com sucesso!");
    }
    public void remover(String nomeCurso) {
        //INSERIR REGRA DE N�O REMOVER CURSO COM ALUNOS MATRICULADOOOOOS
        this.repositorio.remover(nomeCurso);
    }

    public Curso buscar(String nomeCurso) {
        return this.repositorio.buscar(nomeCurso);
    }

    public void emitirRelatorio() {
        System.out.println(this.repositorio.listar());
    }
}
