package pacoteDados;

import pacoteEntidades.Professor;
import pacoteDados.Excecoes.ProfessorException;

public class RepositorioProfessoresArray implements IRepositorio<Professor, String> {


    private static RepositorioProfessoresArray instancia;

    private Professor[] professores;
    private int indice;


    private RepositorioProfessoresArray(int tamanhoMaximo) {
        this.professores = new Professor[tamanhoMaximo];
        this.indice = 0;
    }


    public static RepositorioProfessoresArray getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioProfessoresArray(50);
        }
        return instancia;
    }

    @Override
    public void inserir(Professor professor) throws Exception {
        if (this.indice < this.professores.length) {
            this.professores[this.indice] = professor;
            this.indice++;
        } else {

            throw new ProfessorException("Erro: Limite máximo de professores atingido no sistema.");
        }
    }

    @Override
    public Professor buscar(String cpf) {
        for (int i = 0; i < this.indice; i++) {
            // Puxa o CPF herdado da classe pacoteEntidades.Pessoa para comparar
            if (this.professores[i].getCpf().equals(cpf)) {
                return this.professores[i];
            }
        }
        return null;
    }

    @Override
    public void remover(String cpf) throws Exception {
        for (int i = 0; i < this.indice; i++) {
            if (this.professores[i].getCpf().equals(cpf)) {
                // Move o último elemento para o buraco deixado pela remoção
                this.professores[i] = this.professores[this.indice - 1];
                this.professores[this.indice - 1] = null;
                this.indice--;
                return;
            }
        }

        throw new ProfessorException("Erro: Professor com CPF " + cpf + " não encontrado para remoção.");
    }


    @Override
    public void atualizar(Professor professor) {
        for (int i = 0; i < this.indice; i++) {
            if (this.professores[i].getCpf().equals(professor.getCpf())) {
                this.professores[i] = professor;
                return;
            }
        }
    }


    @Override
    public Professor[] listar() {
        Professor[] copia = new Professor[this.indice];
        for (int i = 0; i < this.indice; i++) {
            copia[i] = this.professores[i];
        }
        return copia;
    }

    @Override
    public int getTotal() {
        return this.indice;
    }
}
