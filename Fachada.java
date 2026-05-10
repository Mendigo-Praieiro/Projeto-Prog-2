package PacoteControle;

import PacoteAluno.*;
import PacoteProfessor.*;
import PacoteCurso.*;
import PacoteDepartamento.*;
import PacoteTurma.*;
// importa PacoteCadeira.* e PacoteSala.*!

public class Fachada {
    private static Fachada instance;
    
    private CadastroAluno cadastroAluno;
    private CadastroProfessor cadastroProfessor;
    private CadastroCurso cadastroCurso;
    private CadastroDepartamento cadastroDepartamento;
    private CadastroTurma cadastroTurma;

    private Fachada() {
        // Inicializa todos os módulos com seus respectivos repositórios e tamanhos
        this.cadastroAluno = new CadastroAluno(new RepositorioAlunoArray(100));
        this.cadastroProfessor = new CadastroProfessor(new RepositorioProfessoresArray(50));
        this.cadastroCurso = new CadastroCurso(new RepositorioCursosArray(50));
        this.cadastroDepartamento = new CadastroDepartamento(new RepositorioDepartamentoArray(10));
        this.cadastroTurma = new CadastroTurma(new RepositorioTurmasArray(50));
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    // =========================================================
    // MÉTODOS DELEGADOS (A Fachada repassa a ordem pro Cadastro)
    // =========================================================

    // --- ALUNO ---
    public void cadastrarAluno(Aluno a) throws Exception { cadastroAluno.cadastrar(a); }
    public void trancarMatricula(String cpf) throws Exception { cadastroAluno.trancarMatricula(cpf); }
    public void gerarRelatorioAluno(String cpf) { cadastroAluno.gerarRelatorioHistorico(cpf); }

    // --- PROFESSOR ---
    public void cadastrarProfessor(Professor p) { cadastroProfessor.cadastrar(p); }
    public void emitirRelatorioProfessores() { cadastroProfessor.emitirRelatorio(); }

    // --- CURSO E DEPARTAMENTO ---
    public void cadastrarCurso(Curso c) { cadastroCurso.cadastrar(c); }
    public void cadastrarDepartamento(Departamento d) { cadastroDepartamento.cadastrar(d); }

    // --- TURMA (SUA PARTE) ---
    public void cadastrarTurma(Turma t) throws Exception { cadastroTurma.cadastrar(t); }
    public void matricularAlunoNaTurma(int idTurma, Aluno a) throws Exception { cadastroTurma.matricularAlunoNaTurma(idTurma, a); }
    public String obterRelatorioTurma(int idTurma) throws Exception { return cadastroTurma.obterRelatorioTurma(idTurma); }
}