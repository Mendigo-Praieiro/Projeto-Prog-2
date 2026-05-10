package PacoteControle;

import PacoteAluno.Aluno;
import PacoteAluno.CadastroAluno;
import PacoteAluno.RepositorioAlunoArray;
// Importe os outros cadastros quando seus colegas terminarem (Professor, Curso, etc.)

public class Fachada {
    private static Fachada instance;
    private CadastroAluno cadastroAluno;
    // private CadastroProfessor cadastroProfessor; (Exemplo para o futuro)

    private Fachada() {
        // Inicializa o seu módulo de Alunos
        this.cadastroAluno = new CadastroAluno(new RepositorioAlunoArray(100));
    }

    // Padrão Singleton: garante que só existe uma Fachada no sistema todo
    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    // --- MÉTODOS DO ALUNO (Repassando a bola para o seu CadastroAluno) ---
    public void cadastrarAluno(Aluno a) throws Exception {
        cadastroAluno.cadastrar(a);
    }

    public void trancarMatricula(String cpf) throws Exception {
        cadastroAluno.trancarMatricula(cpf);
    }

    public void gerarRelatorioAluno(String cpf) {
        cadastroAluno.gerarRelatorioHistorico(cpf);
    }
}