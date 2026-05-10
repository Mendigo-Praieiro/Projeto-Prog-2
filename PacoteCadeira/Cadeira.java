package PacoteCadeira;

public class Cadeira {

    public enum TipoDisciplina {
        OBRIGATORIA,
        OPTATIVA,
        EQUIVALENTE
    }

    private int codigoCadeira;
    private String nomeCadeira;
    private String ementa;
    private int cargaHorariaCadeira;
    private TipoDisciplina tipo;

    private Cadeira[] preRequisitos;
    private int quantidadePreRequisitos;

    public Cadeira(int codigo, String nome, String ementa,
                   int cargaHoraria, TipoDisciplina tipo) {

        this.codigoCadeira = codigo;
        this.nomeCadeira = nome;
        this.ementa = ementa;
        this.cargaHorariaCadeira = cargaHoraria;
        this.tipo = tipo;

        preRequisitos = new Cadeira[10];
        quantidadePreRequisitos = 0;
    }

    public void adicionarPreRequisito(Cadeira disciplina) {
        if (quantidadePreRequisitos < preRequisitos.length) {
            preRequisitos[quantidadePreRequisitos] = disciplina;
            quantidadePreRequisitos++;
        }
    }

    public int getCodigoCadeira() {
        return codigoCadeira;
    }

    public String getNomeCadeira() {
        return nomeCadeira;
    }

    public String getEmenta() {
        return ementa;
    }

    public int getCargaHorariaCadeira() {
        return cargaHorariaCadeira;
    }

    public TipoDisciplina getTipo() {
        return tipo;
    }

    public int getQuantidadePreRequisitos() {
        return quantidadePreRequisitos;
    }
    public Cadeira[] getPreRequisitos() {
        return preRequisitos;
    }
}
