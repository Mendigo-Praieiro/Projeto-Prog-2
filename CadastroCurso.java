package PacoteCurso;

public class CadastroCurso {
    private RepositorioCursos repositorio;


    public CadastroCurso(RepositorioCursos repositorio){
        this.repositorio = repositorio;

    }
    public void cadastrar(Curso curso){
        if (curso == null){
            System.out.println("Erro: Não foi possível cadastar. Digite um nome válido.");
            return;
        }
        if(this.repositorio.buscar(curso.getNomeCurso())!= null){
            System.out.println("Erro: já existe um curso com esse nome. ");
            return;
        }
        System.out.println("Curso " + curso.getNomeCurso()+ " Cadastrado com sucesso!");
    }
    public void remover(String nomeCurso) {
        //INSERIR REGRA DE NÃO REMOVER CURSO COM ALUNOS MATRICULADOOOOOS
        this.repositorio.remover(nomeCurso);
    }

    public Curso buscar(String nomeCurso) {
        return this.repositorio.buscar(nomeCurso);
    }

    public void emitirRelatorio() {
        System.out.println(this.repositorio.listar());
    }
}
