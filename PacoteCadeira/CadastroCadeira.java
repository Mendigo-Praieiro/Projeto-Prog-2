package pacoteNegocios;

import pacoteDados.IRepositorio;
import pacoteDados.RepositorioCadeirasArray;
import pacoteDados.Excecoes.CadeiraException;
import pacoteEntidades.Cadeira;


public class CadastroCadeira {

    // Usando a interface genérica
    private IRepositorio<Cadeira, Integer> repositorio;

    // acionando o Singleton
    public CadastroCadeira() {
        this.repositorio = RepositorioCadeirasArray.getInstancia();
    }

    public void cadastrar(int codigo, String nome, String ementa, int cargaHorariaCadeira, String tipo) throws Exception {

        // Verifica se já existe para não duplicar
        if (this.repositorio.buscar(codigo) != null) {
            throw new CadeiraException("Erro: Já existe uma cadeira com o código " + codigo);
        }

        // Garantindo que tudo seja lido maiúsculo
        Cadeira.TipoDisciplina tipoEnum = Cadeira.TipoDisciplina.valueOf(tipo.toUpperCase());

        // Criação do objeto com todos os parâmetros na ordem certa
        Cadeira novaCadeira = new Cadeira(codigo, nome, ementa, cargaHorariaCadeira, tipoEnum);

        this.repositorio.inserir(novaCadeira);
    }

    public void remover(Integer codigo) throws Exception {
        this.repositorio.remover(codigo);
    }

    public Cadeira buscar(Integer codigo) {
        return this.repositorio.buscar(codigo);
    }

    // Retorna string para a interface
    public String emitirRelatorio() {
        int total = this.repositorio.getTotal();

        if (total == 0) {
            return "Nenhuma cadeira cadastrada no momento.\n";
        }

        Cadeira[] lista = this.repositorio.listar();
        String texto = "======== Relatório de Cadeiras ========\n";

        for (int i = 0; i < total; i++) {
            texto += "- [" + lista[i].getCodigoCadeira() + "] " + lista[i].getNomeCadeira() +
                    " | " + lista[i].getCargaHorariaCadeira() + "h" +
                    " | Tipo: " + lista[i].getTipo() + "\n";
        }
        texto += "=======================================\n";

        return texto;
    }
}
