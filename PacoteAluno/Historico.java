package PacoteAluno;

public class Historico {
    private String[] disciplinasConcluidas;
    private int totalDisciplinas;
    private double rendimentoGlobal;

    public Historico() {
        this.disciplinasConcluidas = new String[50];
        this.totalDisciplinas = 0;
        this.rendimentoGlobal = 0.0;
    }

    public void registrarAprovacao(String nomeDisciplina) {
        if (totalDisciplinas < disciplinasConcluidas.length) {
            disciplinasConcluidas[totalDisciplinas] = nomeDisciplina;
            totalDisciplinas++;
        }
    }

    public double getRendimentoGlobal() { return rendimentoGlobal; }
    public void setRendimentoGlobal(double rendimentoGlobal) { this.rendimentoGlobal = rendimentoGlobal; }
}