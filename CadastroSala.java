package PacoteSala;

public class CadastroSala {

    private RepositorioSalas repositorio;

    public CadastroSala(RepositorioSalas repositorio) {
        this.repositorio = repositorio;
    }


    public void cadastrar(Sala sala) throws SalaException {
        if (sala == null) {
            throw new SalaException("A sala fornecida eh invalida (nula).");
        }

        // Verifica se já existe uma sala com esse número
        if (this.repositorio.buscar(sala.getNumero()) != null) {
            throw new SalaException("Ja existe uma sala cadastrada com o numero " + sala.getNumero());
        }

        this.repositorio.salvar(sala);
        System.out.println("Sala " + sala.getNumero() + " (Bloco " + sala.getBloco() + ") cadastrada com sucesso!");
    }

    // Removendo com Exception
    public void remover(int numero) throws SalaException {
        boolean removido = this.repositorio.remover(numero);
        if (!removido) {
            throw new SalaException("Sala numero " + numero + " nao encontrada para remocao.");
        }
        System.out.println("Sala " + numero + " removida com sucesso.");
    }

    public Sala buscar(int numero) {
        return this.repositorio.buscar(numero);
    }

    public void emitirRelatorio() {
        Sala[] lista = this.repositorio.listar();
        System.out.println("\n======== Relatorio de Salas ========");
        if (this.repositorio.getTotal() == 0) {
            System.out.println("Nenhuma sala cadastrada.");
            return;
        }

        for (int i = 0; i < this.repositorio.getTotal(); i++) {
            System.out.println("- Sala: " + lista[i].getNumero() +
                    " | Bloco: " + lista[i].getBloco() +
                    " | Capacidade: " + lista[i].getCapacidadeMaxima() + " alunos");
        }
        System.out.println("====================================\n");
    }
}