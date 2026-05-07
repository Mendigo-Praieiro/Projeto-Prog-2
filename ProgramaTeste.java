import PacoteCurso.CadastroCurso;
import PacoteCurso.Curso;
import PacoteCurso.RepositorioCursos;
import PacoteDepartamento.Departamento;

public class ProgramaTeste {
    public static void main(String[] args) {
        CadastroCurso cursosUfrpe = new CadastroCurso(RepositorioCursos);
        try {
            cursosUfrpe.cadastrar(new Curso(88188, "Licenciatura em computa��o",
                    new Departamento(1234, "Departamento de Computacao", "Campus Sede", "Exatas"),
                    40, 2800, true ));



        } catch (Exception e) { // Adicionar uma exce��o para teste.
            throw new RuntimeException(e);
        }



    }

    }
