package PacoteTurma;

import PacoteAluno.Aluno;
import PacoteProfessor.Professor;
import PacoteCadeira.Cadeira;
import PacoteSala.Sala;

public class Turma {
    private int idTurma;
    private Cadeira cadeira;
    private Professor professor;
    private Sala sala;
    private Aluno[] alunosMatriculados;
    private int totalAlunos;

    public Turma(int idTurma, Cadeira cadeira, Professor professor, Sala sala, int capacidadeMaxima) {
        this.idTurma = idTurma;
        this.cadeira = cadeira;
        this.professor = professor;
        this.sala = sala;
        this.alunosMatriculados = new Aluno[capacidadeMaxima];
        this.totalAlunos = 0;
    }

    public void matricularAluno(Aluno aluno) throws Exception {
        if (totalAlunos < alunosMatriculados.length) {
            alunosMatriculados[totalAlunos] = aluno;
            totalAlunos++;
        } else {
            throw new Exception("Erro: A turma " + idTurma + " já está lotada!");
        }
    }

    public void removerAluno(String cpf) throws Exception {
        for (int i = 0; i < totalAlunos; i++) {
            if (alunosMatriculados[i].getCpf().equals(cpf)) {
                alunosMatriculados[i] = alunosMatriculados[totalAlunos - 1];
                alunosMatriculados[totalAlunos - 1] = null;
                totalAlunos--;
                return;
            }
        }
        throw new Exception("Erro: Aluno não encontrado na turma " + idTurma);
    }

    // Ao invés de printar, retorna a String montada
    public String gerarDiarioDeClasse() {
        String diario = "\n--- DIÁRIO DE CLASSE: TURMA " + idTurma + " ---\n";
        diario += "Disciplina: " + cadeira.getNomeCadeira() + "\n";
        diario += "Professor: " + professor.getNome() + "\n";
        diario += "Sala: " + sala.getNumero() + " (" + sala.getBloco() + ")\n";
        diario += "Vagas ocupadas: " + totalAlunos + "/" + alunosMatriculados.length + "\n";
        diario += "Lista de Alunos:\n";

        if (totalAlunos == 0) {
            diario += "  > Nenhum aluno matriculado ainda.\n";
        } else {
            for (int i = 0; i < totalAlunos; i++) {
                diario += "  " + (i + 1) + ". " + alunosMatriculados[i].getNome() +
                        " (Matrícula: " + alunosMatriculados[i].getMatricula() + ")\n";
            }
        }
        diario += "----------------------------------------\n";
        return diario;
    }

    // Getters
    public int getIdTurma() { return idTurma; }
    public Cadeira getCadeira() { return cadeira; }
    public Professor getProfessor() { return professor; }
    public Sala getSala() { return sala; }
}
