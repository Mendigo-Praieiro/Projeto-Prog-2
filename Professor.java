package PacoteProfessor;
import PacoteDepartamento.Departamento;

public class Professor extends Pessoa {
    protected Departamento departamento;
    protected String especialidade;
    protected Cadeira[] cadeiras; // interação com a classe das cadeiras
    private int indiceCadeiras; //

    public Professor(String nome, String cpf, Departamento departamento, String especialidade) {
        super(nome, cpf);
        this.departamento = departamento;
        this.especialidade = especialidade;
        this.cadeiras = new Cadeira[6]; // Limite de 6 turmas por professor
        this.indiceCadeiras = 0;
    }

    // ========== GETTERS E SETTERS ==========

    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


    public void atribuirCadeira(Cadeira cadeira) {
        if (this.indiceCadeiras < this.cadeiras.length) {
            this.cadeiras[this.indiceCadeiras] = cadeira;
            this.indiceCadeiras++;
        } else {
            System.out.println("Erro: Este professor já atingiu o limite de cadeiras.");
        }
    }






}
