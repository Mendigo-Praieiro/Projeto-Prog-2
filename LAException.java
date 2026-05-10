package ExceptionsRepositorioCurso;

public class LAException extends Exception{
    private int indice;

    public LAException (int indice){
        super("Erro: limite máximos de cursos atingidos.");
        this.indice = indice;

    }

    public int getIndice() {
        return indice;
    }
    public void setIndice(int indice) {
        this.indice = indice;
    }
}
