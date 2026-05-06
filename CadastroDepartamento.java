package PacoteDepartamento;

public class CadastroDepartamento {
    private RepositorioDepartamento repositorio;

    public CadastroDepartamento( RepositorioDepartamento repositorio ){
        this.repositorio = repositorio;
    }
    public void cadastrar(Departamento departamento) {
        if (departamento == null) {
            System.out.println("Erro: Não foi possível cadastar. Digite um nome válido.");
            return;
        }
        if(this.repositorio.buscar(departamento.getNomeDepartamento())!= null){
            System.out.println("Erro: já existe um departamento com esse nome. ");
            return;
        }

        System.out.println("PacoteDepartamento.Departamento " + departamento.getNomeDepartamento()+ " Cadastrado com sucesso!");
    }




}
