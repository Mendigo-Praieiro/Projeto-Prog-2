package PacoteAluno;

public class RepositorioAlunoArray implements RepositorioAluno {
    private Aluno[] alunos;
    private int indice;

    public RepositorioAlunoArray(int tamanhoMaximo) {
        this.alunos = new Aluno[tamanhoMaximo];
        this.indice = 0;
    }

    @Override
    public void inserir(Aluno aluno) {
        if (indice < alunos.length) {
            alunos[indice] = aluno;
            indice++;
        } else {
            System.out.println("Erro: Limite de alunos atingido.");
        }
    }

    @Override
    public Aluno buscar(String cpf) {
        for (int i = 0; i < indice; i++) {
            if (alunos[i].getCpf().equals(cpf)) {
                return alunos[i];
            }
        }
        return null;
    }

    @Override
    public void remover(String cpf) {
        for (int i = 0; i < indice; i++) {
            if (alunos[i].getCpf().equals(cpf)) {
                alunos[i] = alunos[indice - 1];
                alunos[indice - 1] = null;
                indice--;
                return;
            }
        }
    }

    @Override
    public void atualizar(Aluno aluno) {
        for (int i = 0; i < indice; i++) {
            if (alunos[i].getCpf().equals(aluno.getCpf())) {
                alunos[i] = aluno;
                return;
            }
        }
    }

    @Override
    public Aluno[] listar() {
        Aluno[] copia = new Aluno[indice];
        for (int i = 0; i < indice; i++) {
            copia[i] = alunos[i];
        }
        return copia;
    }

    @Override
    public int getTotal() {
        return indice;
    }
}