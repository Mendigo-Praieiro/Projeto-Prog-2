// Importando o Pacote de Cursos
import PacoteCurso.CadastroCurso;
import PacoteCurso.Curso;
import PacoteCurso.RepositorioCursosArray;
import PacoteCurso.CursoException;

// Importando o Pacote de Departamentos
import PacoteDepartamento.CadastroDepartamento;
import PacoteDepartamento.Departamento;
import PacoteDepartamento.RepositorioDepartamentoArray;
import PacoteDepartamento.DepartamentoException;

// Importando o Pacote de Professores
import PacoteProfessor.CadastroProfessor;
import PacoteProfessor.Professor;
import PacoteProfessor.RepositorioProfessoresArray;
import PacoteProfessor.ProfessorException;

// Importando o Pacote de Salas
import PacoteSala.CadastroSala;
import PacoteSala.Sala;
import PacoteSala.RepositorioSalasArray;
import PacoteSala.SalaException;

// Importando o Pacote de Cadeiras
import PacoteCadeira.CadastroCadeira;
import PacoteCadeira.Cadeira;
import PacoteCadeira.RepositorioCadeirasArray;
import PacoteCadeira.CadeiraException;
import PacoteCadeira.Cadeira.TipoDisciplina;

public class ProgramaTeste {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   INICIANDO TESTES GERAIS DO SISTEMA ");
        System.out.println("======================================\n");

        // 1. INSTANCIANDO OS REPOSITÓRIOS (Memória RAM do sistema)
        RepositorioDepartamentoArray repDep = new RepositorioDepartamentoArray(10);
        RepositorioCursosArray repCurso = new RepositorioCursosArray(100);
        RepositorioProfessoresArray repProf = new RepositorioProfessoresArray(50);
        RepositorioSalasArray repSala = new RepositorioSalasArray();
        RepositorioCadeirasArray repCadeira = new RepositorioCadeirasArray();

        // 2. INSTANCIANDO OS CADASTROS (Gerentes de Regras de Negócio)
        CadastroDepartamento cadDep = new CadastroDepartamento(repDep);
        CadastroCurso cadCurso = new CadastroCurso(repCurso);
        CadastroProfessor cadProf = new CadastroProfessor(repProf);
        CadastroSala cadSala = new CadastroSala(repSala);
        CadastroCadeira cadCadeira = new CadastroCadeira(repCadeira);

        // 3. BLOCO DE TESTES (Protegido pelo Try-Catch)
        try {

            // --- TESTANDO DEPARTAMENTO ---
            System.out.println(">> TESTE 1: Departamento");
            Departamento depExatas = new Departamento(1234, "Departamento de Computacao", "Campus Sede", "Exatas");
            cadDep.cadastrar(depExatas);
            cadDep.emitirRelatorio();


            // --- TESTANDO CURSO ---
            System.out.println(">> TESTE 2: Curso");
            // Note que passamos o objeto 'depExatas' criado acima para dentro do Curso
            Curso cursoLC = new Curso(88188, "Licenciatura em Computacao", depExatas, 40, 2800, true);
            cadCurso.cadastrar(cursoLC);
            cadCurso.emitirRelatorio();


            // --- TESTANDO PROFESSOR ---
            System.out.println(">> TESTE 3: Professor");
            // Passamos o mesmo departamento para o professor
            Professor profPaulo = new Professor("Paulo Anselmo", "111.222.333-44", depExatas, "Engenharia de Software");
            cadProf.cadastrar(profPaulo);
            cadProf.emitirRelatorio();


            // --- TESTANDO SALA ---
            System.out.println(">> TESTE 4: Sala");
            Sala sala1 = new Sala(101, "Bloco A", 40);
            cadSala.cadastrar(sala1);
            cadSala.emitirRelatorio();


            // --- TESTANDO CADEIRA ---
            System.out.println(">> TESTE 5: Cadeira (Disciplina)");
            Cadeira cadeiraIP2 = new Cadeira(10, "Introducao a Programacao 2", "Java e POO", 60, TipoDisciplina.OBRIGATORIA);
            cadCadeira.cadastrar(cadeiraIP2);
            cadCadeira.emitirRelatorio();


            // --- TESTANDO AS EXCEÇÕES ---
            System.out.println(">> TESTE 6: Forcando um erro para testar Excecoes...");
            // Vamos tentar cadastrar a mesma cadeira novamente para ver o sistema barrar
            Cadeira cadeiraBug = new Cadeira(10, "Cadeira Clonada", "Ementa Falsa", 30, TipoDisciplina.OPTATIVA);
            cadCadeira.cadastrar(cadeiraBug);

            System.out.println("Se você ler isso, a exceção falhou!");

        } catch (DepartamentoException | CursoException | ProfessorException | SalaException | CadeiraException e) {
            // Se qualquer um dos módulos jogar uma exceção, ela cai aqui!
            System.out.println("\n[ERRO CAPTURADO COM SUCESSO]: " + e.getMessage());

        } catch (Exception e) {
            // Fallback para qualquer outro erro genérico do Java
            System.out.println("\n[ERRO FATAL INESPERADO]: " + e.getMessage());
        }

        System.out.println("\n======================================");
        System.out.println("        TESTES FINALIZADOS            ");
        System.out.println("======================================");
    }
}