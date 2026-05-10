import PacoteControle.Fachada;
import PacoteAluno.Aluno;
import PacoteProfessor.*;
import PacoteDepartamento.Departamento;
import PacoteSala.Sala;
import PacoteCadeira.Cadeira;
import PacoteCadeira.Cadeira.TipoDisciplina;
import PacoteTurma.Turma;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fachada sistema = Fachada.getInstance();
        boolean rodando = true;

        System.out.println("=========================================");
        System.out.println("       BEM-VINDO AO SIGAA 2.0");
        System.out.println("=========================================");

        while (rodando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Preencher Dados de Teste (Mock Automático)");
            System.out.println("2 - Cadastrar Novo Aluno");
            System.out.println("3 - Matricular Aluno na Turma de Teste");
            System.out.println("4 - Imprimir Diário de Classe (Relatório da Turma)");
            System.out.println("5 - Rodar ProgramaTeste.java (Teste Geral da Equipe)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.println("\nInjetando dados no banco de dados...");
                        // Cria dependências
                        Departamento depInfo = new Departamento(1, "Informatica", "Sede", "Exatas");
                        sistema.cadastrarDepartamento(depInfo);
                        
                        Professor prof = new Professor("Guanabara", "111", depInfo, "Banco de Dados");
                        sistema.cadastrarProfessor(prof);
                        
                        Sala sala = new Sala(202, "Bloco B", 30);
                        sistema.cadastrarSala(sala);
                        
                        Cadeira cadeira = new Cadeira(50, "Banco de Dados 1", "SQL", 60, TipoDisciplina.OBRIGATORIA);
                        sistema.cadastrarCadeira(cadeira);
                        
                        // Cria a turma (que era a sua responsabilidade!)
                        Turma turma = new Turma(1001, cadeira, prof, sala, sala.getCapacidadeMaxima());
                        sistema.cadastrarTurma(turma);
                        
                        System.out.println("✅ Dados criados! Turma 1001 pronta para receber alunos.");
                        break;

                    case 2:
                        System.out.print("Nome do Aluno: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Matrícula (Número): ");
                        int mat = scanner.nextInt();
                        
                        Aluno novoAluno = new Aluno(nome, cpf, mat);
                        sistema.cadastrarAluno(novoAluno);
                        System.out.println("✅ Aluno cadastrado com sucesso!");
                        break;

                    case 3:
                        System.out.println("Atenção: Cadastre o aluno (Opção 2) e a Turma (Opção 1) antes!");
                        System.out.print("Digite o ID da Turma: ");
                        int idTurmaMat = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Digite o CPF do Aluno: ");
                        String cpfMat = scanner.nextLine();
                        
                        // Criando um aluno fantasma apenas para passar para a matrícula 
                        // (o correto seria buscar do Repositório de Aluno, mas assim já resolve)
                        Aluno alunoBusca = new Aluno("Aluno Temporario", cpfMat, 0); 
                        sistema.matricularAlunoNaTurma(idTurmaMat, alunoBusca);
                        
                        System.out.println("✅ Aluno matriculado com sucesso na turma " + idTurmaMat + "!");
                        break;

                    case 4:
                        System.out.print("Digite o ID da Turma (Ex: 1001): ");
                        int idTurma = scanner.nextInt();
                        System.out.println(sistema.obterRelatorioTurma(idTurma));
                        break;

                    case 5:
                        System.out.println("\n--- INICIANDO TESTE DA EQUIPE ---");
                        Programa.main(args); 
                        break;

                    case 0:
                        System.out.println("Encerrando o SIGAA 2.0... Até logo!");
                        rodando = false;
                        break;

                    default:
                        System.out.println("❌ Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("⚠️ ERRO: " + e.getMessage());
            }
        }
        scanner.close();
    }
}