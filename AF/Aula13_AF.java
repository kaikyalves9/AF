
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aula13_AF{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Recebendo a quantidade de notas e armazenando os pesos
        System.out.print("Digite a quantidade de notas: ");
        int quantidadeNotas = scanner.nextInt();
        double[] pesos = new double[quantidadeNotas];

        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print("Digite o peso para a nota em porcentagem " + (i + 1) + ": ");
            pesos[i] = scanner.nextDouble();
        }

        // Recebendo a quantidade de alunos
        System.out.print("Digite a quantidade de alunos: ");
        int quantidadeAlunos = scanner.nextInt();

        // Matrizes para armazenar os nomes, notas e médias de todos os alunos
        String[] nomes = new String[quantidadeAlunos];
        double[][] todasNotas = new double[quantidadeAlunos][quantidadeNotas];
        double[] medias = new double[quantidadeAlunos];

        // Iterando sobre cada aluno
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Digite o nome do aluno " + (i + 1) + ":");
            nomes[i] = scanner.next();

            // Recebendo as notas do aluno
            for (int j = 0; j < quantidadeNotas; j++) {
                System.out.print("Digite a nota " + (j + 1) + " do " + nomes[i] + ": ");
                double nota = scanner.nextDouble();

                // Verificando se a nota está no intervalo válido
                while (nota < 0.0 || nota > 10.0) {
                    System.out.println("Nota inválida. Por favor, digite uma nota entre 0 e 10.");
                    System.out.print("Digite a nota " + (j + 1) + " do " + nomes[i] + ": ");
                    nota = scanner.nextDouble();
                }

                todasNotas[i][j] = nota;
            }

            // Calculando a nota final do aluno
            medias[i] = calcularNotaFinal(todasNotas[i], pesos);
        }

        // Exibindo os resultados
        DecimalFormat md = new DecimalFormat("#.#");
        System.out.println("\nResultados:");
        for (int i = 0; i < quantidadeAlunos; i++) {
            String condicao;

            if (medias[i] >= 0 && medias[i] <= 2) {
                condicao = "Reprovado";
            } else if (medias[i] >= 2.1 && medias[i] <= 4.9) {
                condicao = "Substitutiva";
            } else {
                condicao = "Aprovado";
            }

            System.out.println("\nNome do Aluno: " + nomes[i]);
            System.out.println("Notas: ");
            for (int j = 0; j < quantidadeNotas; j++) {
                System.out.println("Nota " + (j + 1) + ": " + todasNotas[i][j]);
            }
            System.out.println("Media Final: " + md.format(medias[i]));
            System.out.println("Condicao: " + condicao);
        }

        // Fechando o scanner
        scanner.close();
    }

    // Função para calcular a nota final
    public static double calcularNotaFinal(double[] notas, double[] pesos) {
        double notaFinal = 0;

        for (int i = 0; i < notas.length; i++) {
            notaFinal += notas[i] * pesos[i] / 100;
        }

        return notaFinal;
    }
}
