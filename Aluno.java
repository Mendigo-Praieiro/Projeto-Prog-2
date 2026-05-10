package PacoteAluno;

import PacoteProfessor.Pessoa; // Importa a classe do seu colega

public class Aluno extends Pessoa {
    private int matricula;
    private boolean statusMatricula; // true = Ativo, false = Trancado
    private String statusCurso; // Ex: "Cursando", "Trancado", "Formado"

    private Boletim boletim;
    private Historico historico;

    public Aluno(String nome, String cpf, int matricula) {
        super(nome, cpf); // Puxa nome e cpf da classe Pessoa
        this.matricula = matricula;
        this.statusMatricula = true;
        this.statusCurso = "Cursando";

        // Composição: O boletim e histórico nascem junto com o aluno
        this.boletim = new Boletim();
        this.historico = new Historico();
    }

    // ================= GETTERS E SETTERS =================
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    public boolean isStatusMatricula() { return statusMatricula; }
    public void setStatusMatricula(boolean statusMatricula) { this.statusMatricula = statusMatricula; }

    public String getStatusCurso() { return statusCurso; }
    public void setStatusCurso(String statusCurso) { this.statusCurso = statusCurso; }

    public Boletim getBoletim() { return boletim; }
    public Historico getHistorico() { return historico; }
}