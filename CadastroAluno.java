package PacoteAluno;

public class CadastroAluno {
    private RepositorioAluno repositorio;

    public CadastroAluno(RepositorioAluno repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Aluno aluno) throws Exception {
        if (aluno == null || aluno.getCpf() == null) {
            throw new Exception("Dados do aluno inválidos.");
        }
        if (repositorio.buscar(aluno.getCpf()) != null) {
            throw new Exception("Aluno com este CPF já existe.");
        }
        repositorio.inserir(aluno);
    }

    // Regra de Negócio: Alterar Status
    public void trancarMatricula(String cpf) throws Exception {
        Aluno a = repositorio.buscar(cpf);
        if (a != null) {
            a.setStatusMatricula(false); // Trancado
            a.setStatusCurso("Trancado");
        } else {
            throw new Exception("Aluno não encontrado.");
        }
    }

    // Regra de Negócio: Rendimento Global
    public void atualizarRendimento(String cpf) {
        Aluno a = repositorio.buscar(cpf);
        if (a != null) {
            // Aqui podes somar as notas do Boletim e atualizar o Histórico
            double mediaAtual = a.getBoletim().calcularMedia();
            a.getHistorico().setRendimentoGlobal(mediaAtual);
        }
    }

    public void gerarRelatorioHistorico(String cpf) {
        Aluno a = repositorio.buscar(cpf);
        if (a != null) {
            System.out.println("======= HISTÓRICO ESCOLAR =======");
            System.out.println("Nome: " + a.getNome());
            System.out.println("CPF: " + a.getCpf());
            System.out.println("Status: " + a.getStatusCurso());
            System.out.println("Rendimento Global: " + a.getHistorico().getRendimentoGlobal());
            System.out.println("=================================");
        }
    }
}