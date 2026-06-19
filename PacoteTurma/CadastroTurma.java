package pacoteNegocios;

import pacoteDados.IRepositorio;
import pacoteDados.RepositorioTurmasArray;
import pacoteEntidades.Aluno;
import pacoteEntidades.Turma;

public class CadastroTurma {

    // Usando interface generica
    private IRepositorio<Turma, Integer> repositorio;

    // Ligando ao construtor vazio
    public CadastroTurma() {
        this.repositorio = RepositorioTurmasArray.getInstancia();
    }

    // Verificiação de parametros de cadastro
    public void cadastrar(int idTurma, int capacidade) throws Exception {

        if (this.repositorio.buscar(idTurma) != null) {
            // Se você quiser criar uma TurmaException depois, pode substituir aqui!
            throw new Exception("Erro: Já existe uma turma cadastrada com este ID: " + idTurma);
        }

        // Criação de Obj
        Turma novaTurma = new Turma(idTurma, capacidade);

        this.repositorio.inserir(novaTurma);
    }

    // Lógica de matricula
    public void matricularAlunoNaTurma(int idTurma, Aluno aluno) throws Exception {
        Turma turma = this.repositorio.buscar(idTurma);

        if (turma == null) {
            throw new Exception("Erro: Turma não encontrada para matrícula.");
        }

        turma.matricularAluno(aluno);
    }

    // Retorna string para a interface
    public String obterRelatorioTurma(int idTurma) throws Exception {
        Turma turma = this.repositorio.buscar(idTurma);

        if (turma != null) {
            return turma.gerarDiarioDeClasse();
        } else {
            throw new Exception("Erro: Turma " + idTurma + " não encontrada para gerar relatório.");
        }
    }
}
