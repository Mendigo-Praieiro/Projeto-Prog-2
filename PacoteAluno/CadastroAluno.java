package pacoteNegocios;

import pacoteDados.IRepositorio;
import pacoteDados.RepositorioAlunoArray;
import pacoteDados.Excecoes.AlunoException;
import pacoteDados.Excecoes.LimiteAtingException;
import pacoteEntidades.Aluno;

public class CadastroAluno {
    //Vinculo com o repositório
    private IRepositorio<Aluno, String> repositorio;

    // A fachada consulta a partir do repositório
    public CadastroAluno() {
        this.repositorio = RepositorioAlunoArray.getInstancia();
    }

    // Criação do objeto
    public void cadastrar(String nome, String cpf, int matricula) throws AlunoException, LimiteAtingException, Exception {
        if (nome == null || cpf == null || matricula <= 0) {
            // usando exceção do aluno
            throw new AlunoException("Erro: Dados do aluno inválidos (campos nulos).");
        }

        if (repositorio.buscar(cpf) != null) {
            throw new AlunoException("Erro: Aluno com este CPF já existe no sistema.");
        }

        // Criação do objeto
        Aluno novoAluno = new Aluno(nome, cpf, matricula);


        // Salva no repositório
        repositorio.inserir(novoAluno);
    }

    public Aluno buscar(String cpf) {
        return this.repositorio.buscar(cpf);
    }

    // Alterar status
    public void trancarMatricula(String cpf) throws AlunoException {
        Aluno a = repositorio.buscar(cpf);
        if (a != null) {
            a.setStatusMatricula(false); // Trancado
            a.setStatusCurso("Trancado");
        } else {
            throw new AlunoException("Erro: Aluno não encontrado para trancamento.");
        }
    }

    // Rendimento Global
    public void atualizarRendimento(String cpf) {
        Aluno a = repositorio.buscar(cpf);
        if (a != null) {
            double mediaAtual = a.getBoletim().calcularMedia();
            a.getHistorico().setRendimentoGlobal(mediaAtual);
        }
    }

    // Retornar texto para o scene builder
    public String gerarRelatorioHistorico(String cpf) throws AlunoException {
        Aluno a = repositorio.buscar(cpf);
        if (a == null) {
            throw new AlunoException("Erro: Aluno não encontrado para gerar histórico.");
        }

        String texto = "======= HISTÓRICO ESCOLAR =======\n";
        texto += "Nome: " + a.getNome() + "\n";
        texto += "CPF: " + a.getCpf() + "\n";
        texto += "Status: " + a.getStatusCurso() + "\n";
        texto += "Rendimento Global: " + a.getHistorico().getRendimentoGlobal() + "\n";
        texto += "=================================\n";

        return texto;
    }
}
