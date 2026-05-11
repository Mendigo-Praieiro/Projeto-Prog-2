package PacoteControle;

import PacoteAluno.*;
import PacoteProfessor.*;
import PacoteCurso.*;
import PacoteDepartamento.*;
import PacoteTurma.*;
import PacoteSala.*;
import PacoteCadeira.*;
import ExceptionsRepositorioCurso.LAException;

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
        this.cadastroAluno = new CadastroAluno(new RepositorioAlunoArray(100));
        this.cadastroProfessor = new CadastroProfessor(new RepositorioProfessoresArray(50));
        this.cadastroCurso = new CadastroCurso(new RepositorioCursosArray(50));
        this.cadastroDepartamento = new CadastroDepartamento(new RepositorioDepartamentoArray(10));
        this.cadastroTurma = new CadastroTurma(new RepositorioTurmasArray(50));
        this.cadastroSala = new CadastroSala(new RepositorioSalasArray());
        this.cadastroCadeira = new CadastroCadeira(new RepositorioCadeirasArray());
    }

    // Padrão Singleton
    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    // =========================================================
    // MÉTODOS DELEGADOS (A ponte entre o Menu e os Cadastros)
    // =========================================================

    public void cadastrarAluno(Aluno a) throws Exception { cadastroAluno.cadastrar(a); }
    public void trancarMatricula(String cpf) throws Exception { cadastroAluno.trancarMatricula(cpf); }
    
    public void cadastrarProfessor(Professor p) throws ProfessorException { cadastroProfessor.cadastrar(p); }
    public Professor buscarProfessor(String cpf) { return cadastroProfessor.buscar(cpf); }
    
    public void cadastrarDepartamento(Departamento d) { cadastroDepartamento.cadastrar(d); }
    
    public void cadastrarCurso(Curso c) throws CursoException, LAException { cadastroCurso.cadastrar(c); }
    
    public void cadastrarSala(Sala s) throws SalaException { cadastroSala.cadastrar(s); }
    public Sala buscarSala(int numero) { return cadastroSala.buscar(numero); }
    
    public void cadastrarCadeira(Cadeira c) throws CadeiraException { cadastroCadeira.cadastrar(c); }
    public Cadeira buscarCadeira(int codigo) { return cadastroCadeira.buscar(codigo); }
    
    public void cadastrarTurma(Turma t) throws Exception { cadastroTurma.cadastrar(t); }
    public void matricularAlunoNaTurma(int idTurma, Aluno a) throws Exception { cadastroTurma.matricularAlunoNaTurma(idTurma, a); }
    public String obterRelatorioTurma(int idTurma) throws Exception { return cadastroTurma.obterRelatorioTurma(idTurma); }
}
