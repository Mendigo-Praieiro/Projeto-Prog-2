package PacoteAluno;

public class Boletim {
    private double[] notas;
    private int quantidadeNotas;

    public Boletim() {
        this.notas = new double[10];
        this.quantidadeNotas = 0;
    }

    public void adicionarNota(double nota) {
        if (quantidadeNotas < notas.length) {
            notas[quantidadeNotas] = nota;
            quantidadeNotas++;
        }
    }

    public double calcularMedia() {
        if (quantidadeNotas == 0) return 0.0;
        double soma = 0;
        for (int i = 0; i < quantidadeNotas; i++) {
            soma += notas[i];
        }
        return soma / quantidadeNotas;
    }
}