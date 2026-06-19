package pacoteNegocios;

import pacoteDados.IRepositorio;
import pacoteDados.RepositorioDepartamentoArray;
import pacoteDados.Excecoes.DepartamentoException;
import pacoteEntidades.Departamento;

public class CadastroDepartamento {

    //Usando a interface
    private IRepositorio<Departamento, String> repositorio;

    // construtor puxando o Singleton
    public CadastroDepartamento() {
        this.repositorio = RepositorioDepartamentoArray.getInstancia();
    }

    // Recebendo os dados
    public void cadastrar(String nomeDepartamento, String area) throws Exception {
        if (nomeDepartamento == null || nomeDepartamento.trim().isEmpty()) {
            throw new DepartamentoException("Erro: Não foi possível cadastrar. Nome do departamento inválido.");
        }

        if (this.repositorio.buscar(nomeDepartamento) != null) {
            // chamando exception
            throw new DepartamentoException("Erro: Já existe um departamento com o nome " + nomeDepartamento + ".");
        }

        // Criando o obj
        Departamento novoDepartamento = new Departamento(nomeDepartamento, area);

        this.repositorio.inserir(novoDepartamento);
    }

    public void remover(String nomeDepartamento) throws Exception {
        // chamando a lista renovada
        this.repositorio.remover(nomeDepartamento);
    }

    public Departamento buscar(String nomeDepartamento) {
        return this.repositorio.buscar(nomeDepartamento);
    }

    // retorna ‘string’ para a ‘interface’
    public String emitirRelatorio() {
        int total = this.repositorio.getTotal();

        if (total == 0) {
            return "Nenhum departamento cadastrado no momento.\n";
        }

        Departamento[] lista = this.repositorio.listar();
        String texto = "======== Listagem de Departamentos ========\n";

        for (int i = 0; i < total; i++) {
            texto += "- Departamento: " + lista[i].getNomeDepartamento() +
                     " | Área: " + lista[i].getArea() + "\n";
        }
        texto += "===========================================\n";

        return texto;
    }
}
