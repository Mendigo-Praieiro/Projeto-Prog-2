package PacoteCadeira;

public class CadastroCadeira {
    private RepositorioCadeira repositorio;

    public CadastroCadeira(RepositorioCadeira repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Cadeira cadeira) throws CadeiraException {
        if (cadeira == null) {
            throw new CadeiraException("Cadeira invalida (nula).");
        }
        // Verifica se já existe uma cadeira com esse código para não duplicar
        if (this.repositorio.buscar(cadeira.getCodigoCadeira()) != null) {
            throw new CadeiraException("Ja existe uma cadeira com o codigo " + cadeira.getCodigoCadeira());
        }

        this.repositorio.inserir(cadeira);
        System.out.println("Cadeira " + cadeira.getNomeCadeira() + " cadastrada com sucesso!");
    }

    public void remover(int codigo) throws CadeiraException {
        boolean removido = this.repositorio.remover(codigo);
        if (!removido) {
            throw new CadeiraException("Cadeira de codigo " + codigo + " nao encontrada.");
        }
        System.out.println("Cadeira removida com sucesso.");
    }

    public Cadeira buscar(int codigo) {
        return this.repositorio.buscar(codigo);
    }

    public void emitirRelatorio() {
        Cadeira[] lista = this.repositorio.listar();
        System.out.println("\n======== Relatorio de Cadeiras ========");
        if (this.repositorio.getTotal() == 0) {
            System.out.println("Nenhuma cadeira cadastrada.");
            return;
        }

        for (int i = 0; i < this.repositorio.getTotal(); i++) {
            System.out.println("- [" + lista[i].getCodigoCadeira() + "] " + lista[i].getNomeCadeira() +
                    " | " + lista[i].getCargaHorariaCadeira() + "h" +
                    " | Tipo: " + lista[i].getTipo());
        }
        System.out.println("=======================================\n");
    }
}