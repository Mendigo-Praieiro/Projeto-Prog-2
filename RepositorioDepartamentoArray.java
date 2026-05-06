package PacoteDepartamento;

public class RepositorioDepartamentoArray implements RepositorioDepartamento {
    private Departamento [] departamentos;
    protected int indice;

    private RepositorioDepartamentoArray (int tamanhoMaximo){
        this.departamentos = new Departamento[tamanhoMaximo];
        this.indice = 0;

    }

    @Override
    public void inserir(Departamento departamento) {
        if (this.indice < this.departamentos.length) {
            this.departamentos[this.indice]     = departamento;
            this.indice++;
        } else {
            System.out.println("Erro, limite máximo de departamentos Tá chei.");
        }

    }

    @Override
    public Departamento buscar(String nomeDepartamento) {
        for (int i = 0; i < this.indice; i++) {
            if (this.departamentos[i].getNomeDepartamento().equals(nomeDepartamento)) {
                return this.departamentos[i];
            }
        }
        return null;
    }

    @Override
    public void remover(String nomeDepartamento) {
        for (int i = 0; i < this.indice; i++) {
            if (this.departamentos[i].getNomeDepartamento().equals(nomeDepartamento)) {
                this.departamentos[i] = this.departamentos[this.indice - 1];
                this.departamentos[this.indice - 1] = null; // Limpa a última posição
                this.indice--;
                return;
            }
        }
        System.out.println("Erro: departamento não encontrado para remoção.");

    }

    @Override
    public String listar() {
        String texto = "========Listagem de Departamentos========\n";
        for (int i = 0; i < this.indice; i++) {
            // Corrigido para this.cursos[i]
            texto += "-" + this.departamentos[i].getNomeDepartamento() + " Area: " + this.departamentos[i].getArea() + "\n";
        }
        return texto;

    }
}
