package PacoteProfessor;

public class RepositorioProfessoresArray implements RepositorioProfessores {

    private Professor[] professores;
    private int indice;

    public RepositorioProfessoresArray(int tamanhoMaximo) {
        this.professores = new Professor[tamanhoMaximo];
        this.indice = 0;
    }

    @Override
    public void inserir(Professor professor) {
        if (this.indice < this.professores.length) {
            this.professores[this.indice] = professor;
            this.indice++;
        } else {
            System.out.println("Erro: Limite máximo de professores atingido no sistema.");
        }
    }

    @Override
    public Professor buscar(String cpf) {
        for (int i = 0; i < this.indice; i++) {
            // Puxa o CPF herdado da classe PacoteProfessor.Pessoa para comparar
            if (this.professores[i].getCpf().equals(cpf)) {
                return this.professores[i];
            }
        }
        return null;
    }

    @Override
    public void remover(String cpf) {
        for (int i = 0; i < this.indice; i++) {
            if (this.professores[i].getCpf().equals(cpf)) {
                // Move o último elemento para o buraco deixado pela remoção
                this.professores[i] = this.professores[this.indice - 1];
                this.professores[this.indice - 1] = null;
                this.indice--;
                return;
            }
        }
        System.out.println("Erro: Professor não encontrado para remoção.");
    }

    @Override
    public String listar() {
        String texto = "======== Relatório de Professores ========\n";
        for (int i = 0; i < this.indice; i++) {
            texto += "- Nome: " + this.professores[i].getNome() + " | CPF: " + this.professores[i].getCpf() +
                    " | Especialidade: " + this.professores[i].getEspecialidade() + "\n";
        }
        return texto;
    }
}