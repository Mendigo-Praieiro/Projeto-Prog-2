package pacoteNegocios;

import pacoteDados.IRepositorio;
import pacoteDados.RepositorioSalasArray;
import pacoteDados.Excecoes.SalaException;
import pacoteEntidades.Sala;

public class CadastroSala {

    //Usando a interface genérica
    private IRepositorio<Sala, Integer> repositorio;

    public CadastroSala() {
        this.repositorio = RepositorioSalasArray.getInstancia();
    }

    // Verificiação de parametros de cadastro
    public void cadastrar(int numero, String bloco, int capacidadeMaxima) throws Exception {

        // Verifica se já existe uma sala com esse número
        if (this.repositorio.buscar(numero) != null) {
            throw new SalaException("Erro: Já existe uma sala cadastrada com o número " + numero);
        }

        // Criação do obj
        Sala novaSala = new Sala(numero, bloco, capacidadeMaxima);

        // inserção de nova sala
        this.repositorio.inserir(novaSala);
    }

    // Remoção direto do repositório
    public void remover(Integer numero) throws Exception {
        this.repositorio.remover(numero);
    }

    public Sala buscar(Integer numero) {
        return this.repositorio.buscar(numero);
    }

    // Retorna String para a interface
    public String emitirRelatorio() {
        int total = this.repositorio.getTotal();

        if (total == 0) {
            return "Nenhuma sala cadastrada no momento.\n";
        }

        Sala[] lista = this.repositorio.listar();
        String texto = "======== Relatório de Salas ========\n";

        for (int i = 0; i < total; i++) {
            texto += "- Sala: " + lista[i].getNumero() +
                    " | Bloco: " + lista[i].getBloco() +
                    " | Capacidade: " + lista[i].getCapacidadeMaxima() + " alunos\n";
        }
        texto += "====================================\n";

        return texto;
    }
}
