package PacoteTurma;

import PacoteAluno.Aluno;

public class CadastroTurma {
    private RepositorioTurma repositorio;

    public CadastroTurma(RepositorioTurma repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Turma turma) throws Exception {
        if (turma == null) {
            throw new Exception("Turma inválida.");
        }
        if (repositorio.buscar(turma.getIdTurma()) != null) {
            throw new Exception("Já existe uma turma cadastrada com este ID: " + turma.getIdTurma());
        }
        repositorio.inserir(turma);
    }

    public void matricularAlunoNaTurma(int idTurma, Aluno aluno) throws Exception {
        Turma turma = repositorio.buscar(idTurma);
        if (turma == null) {
            throw new Exception("Turma não encontrada para matrícula.");
        }

        // Se a turma estiver lotada, o método matricularAluno vai estourar a exceção que fizemos acima!
        turma.matricularAluno(aluno);
    }

    // Retorna a String do relatório para ser printada SOMENTE na classe Main
    public String obterRelatorioTurma(int idTurma) throws Exception {
        Turma turma = repositorio.buscar(idTurma);
        if (turma != null) {
            return turma.gerarDiarioDeClasse();
        } else {
            throw new Exception("Turma " + idTurma + " não encontrada para gerar relatório.");
        }
    }
}