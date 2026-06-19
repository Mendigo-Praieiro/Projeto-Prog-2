package pacoteNegocios;

import pacoteDados.Excecoes.*;
import pacoteDados.*;
import pacoteEntidades.*;

public class Fachada {
    private static Fachada instance;

    // Todos os Gerentes (Cadastros) do sistema
    private CadastroAluno cadastroAluno;
    private CadastroProfessor cadastroProfessor;
    private CadastroCurso cadastroCurso;
    private CadastroDepartamento cadastroDepartamento;
    private CadastroTurma cadastroTurma;
    private CadastroSala cadastroSala;
    private CadastroCadeira cadastroCadeira;

    private Fachada() {
        // Inicializa o sistema alocando os arrays puros atualizados
        this.cadastroAluno = new CadastroAluno();
        this.cadastroProfessor = new CadastroProfessor();
        this.cadastroCurso = new CadastroCurso();
        this.cadastroDepartamento = new CadastroDepartamento();
        this.cadastroTurma = new CadastroTurma();
        this.cadastroSala = new CadastroSala();
        this.cadastroCadeira = new CadastroCadeira();
    }

    // Padrão Singleton
    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    // ================= MÉTODOS DE ALUNO =================
    // Recebe as Strings e joga pro CadastroAluno criar o new Aluno()
    public void cadastrarAluno(String nome, String cpf, int matricula) throws Exception {
        cadastroAluno.cadastrar(nome, cpf, matricula);
    }

    public void trancarMatricula(String cpf) throws Exception {
        cadastroAluno.trancarMatricula(cpf);
    }

    public Aluno buscarAluno(String cpf) {
        return this.cadastroAluno.buscar(cpf);
    }

    // ================= MÉTODOS DE PROFESSOR =================
    public void cadastrarProfessor(String nome, String cpf, String departamento) throws Exception {
        cadastroProfessor.cadastrar(nome, cpf, departamento);
    }

    public Professor buscarProfessor(String cpf) {
        return cadastroProfessor.buscar(cpf);
    }

    // ================= MÉTODOS DE DEPARTAMENTO =================
    public void cadastrarDepartamento(String nomeDepartamento, String area) throws Exception {
        cadastroDepartamento.cadastrar(nomeDepartamento, area);
    }

    // ================= MÉTODOS DE CURSO =================
    public void cadastrarCurso(String nomeCurso, int numeroVagas) throws Exception {
        cadastroCurso.cadastrar(nomeCurso, numeroVagas);
    }

    // ================= MÉTODOS DE SALA =================
    public void cadastrarSala(int numero, String bloco, int capacidadeMaxima) throws Exception {
        cadastroSala.cadastrar(numero, bloco, capacidadeMaxima);
    }

    public Sala buscarSala(int numero) {
        return cadastroSala.buscar(numero);
    }

    // ================= MÉTODOS DE CADEIRA =================
    public void cadastrarCadeira(int codigo, String nome, String ementa, int cargaHoraria, String tipo) throws Exception {
        cadastroCadeira.cadastrar(codigo, nome, ementa, cargaHoraria, tipo);
    }

    public Cadeira buscarCadeira(int codigo) {
        return cadastroCadeira.buscar(codigo);
    }

    // ================= MÉTODOS DE TURMA =================
    public void cadastrarTurma(int idTurma, int capacidade) throws Exception {
        cadastroTurma.cadastrar(idTurma, capacidade);
    }

    public void matricularAlunoNaTurma(int idTurma, Aluno a) throws Exception {
        cadastroTurma.matricularAlunoNaTurma(idTurma, a);
    }

    public String obterRelatorioTurma(int idTurma) throws Exception {
        return cadastroTurma.obterRelatorioTurma(idTurma);
    }
}
