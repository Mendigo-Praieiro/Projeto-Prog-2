package PacoteCurso;

public class RepositorioCursosArray implements RepositorioCursos {
    private Curso[] cursos;
    private int indice;

    public RepositorioCursosArray(int tamanhoMaximo) {
        this.cursos = new Curso[tamanhoMaximo];
        this.indice = 0;
    }

    @Override
    public void inserir(Curso curso) {
        if (this.indice < this.cursos.length) {
            this.cursos[this.indice]     = curso;
            this.indice++;
        } else {
            System.out.println("Erro, limite máximo de cursos Tá chei.");
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
    public String listar() {
        String texto = "========Relatório de cursos========\n";
        for (int i = 0; i < this.indice; i++) {

            texto += "-" + this.cursos[i].getNomeCurso() + " Vagas: " + this.cursos[i].getNumeroVagas() + "\n";
        }
        return texto;
    }

    @Override
    public void remover(String nomeCurso) {
        for (int i = 0; i < this.indice; i++) {
            if (this.cursos[i].getNomeCurso().equals(nomeCurso)) {
                this.cursos[i] = this.cursos[this.indice - 1];
                this.cursos[this.indice - 1] = null; // Limpa a última posição
                this.indice--;
                return;
            }
        }
        System.out.println("Erro: Curso não encontrado para remoção.");
    }

}