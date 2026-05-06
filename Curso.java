package PacoteCurso;

public class Curso {
    private int idCurso;
    private String nomeCurso;
    private Departamento departamento;
    private int numeroVagas;
    private int cargaHorariaTotal;
    private boolean ativo;

    public Curso (int idCurso, String nomeCurso, Departamento departamento,
                  int numeroVagas, int cargaHorariaTotal, boolean ativo){

        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.departamento = departamento;
        this.numeroVagas = numeroVagas;
        this.cargaHorariaTotal = cargaHorariaTotal;
        this.ativo = ativo;
//====================GETTERS AND SETTERS======================
    }
    public int getIdCurso() {
        return idCurso;
    }
    public String getNomeCurso() {
        return nomeCurso;
    }
    public Departamento getDepartamento(){
        return departamento;
    }
    public int getNumeroVagas(){
        return numeroVagas;
    }
    public int getCargaHorariaTotal(){
        return cargaHorariaTotal;
    }
    public boolean getAtivo(){
        return ativo;
    }

    public void setIdCurso(int idCurso){
        this.idCurso = idCurso;
    }
    public void setNomeCurso( String nomeCurso){
        this.nomeCurso = nomeCurso;
    }
    public void setDepartamento (Departamento departamento){
        this.departamento = departamento;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }
    public void setCargaHorariaTotal(int cargaHorariaTotal){
        this.cargaHorariaTotal = cargaHorariaTotal;
    }
    public void setAtivo( boolean ativo ){
        this.ativo = ativo;
    }
}