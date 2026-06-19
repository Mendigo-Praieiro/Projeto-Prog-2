package pacoteDados;

import pacoteEntidades.Departamento;
import pacoteDados.Excecoes.DepartamentoException;


// interface genérica: Objeto é Departamento, o ID (nomeDepartamento) é String
public class RepositorioDepartamentoArray implements IRepositorio<Departamento, String> {


    private static RepositorioDepartamentoArray instancia;


    private Departamento[] departamentos;
    private int indice;


    private RepositorioDepartamentoArray(int tamanhoMaximo){
        this.departamentos = new Departamento[tamanhoMaximo];
        this.indice = 0;
    }


    public static RepositorioDepartamentoArray getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioDepartamentoArray(10);
        }
        return instancia;
    }

    @Override
    public void inserir(Departamento departamento) throws Exception {
        if (this.indice < this.departamentos.length) {
            this.departamentos[this.indice] = departamento;
            this.indice++;
        } else {

            throw new DepartamentoException("Erro: Limite máximo de departamentos atingido no banco de dados.");
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
    public void remover(String nomeDepartamento) throws Exception {
        for (int i = 0; i < this.indice; i++) {
            if (this.departamentos[i].getNomeDepartamento().equals(nomeDepartamento)) {
                this.departamentos[i] = this.departamentos[this.indice - 1];
                this.departamentos[this.indice - 1] = null; // Limpa a última posição
                this.indice--;
                return;
            }
        }

        throw new DepartamentoException("Erro: Departamento '" + nomeDepartamento + "' não encontrado para remoção.");
    }


    @Override
    public void atualizar(Departamento departamento) {
        for (int i = 0; i < this.indice; i++) {
            if (this.departamentos[i].getNomeDepartamento().equals(departamento.getNomeDepartamento())) {
                this.departamentos[i] = departamento;
                return;
            }
        }
    }


    @Override
    public Departamento[] listar() {
        Departamento[] copia = new Departamento[this.indice];
        for (int i = 0; i < this.indice; i++) {
            copia[i] = this.departamentos[i];
        }
        return copia;
    }

    @Override
    public int getTotal() {
        return this.indice;
    }
}
