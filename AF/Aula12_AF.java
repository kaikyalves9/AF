
import java.text.DecimalFormat;
import java.util.Scanner;

public class Aula12_AF {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String condicao;

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

        // Iterando sobre cada aluno
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("nome do aluno " + (i + 1) + ":");
            String nome = scanner.next();

            // Recebendo as notas do aluno
            double[] notas = new double[quantidadeNotas];
            for (int j = 0; j < quantidadeNotas; j++) {
                System.out.print("Digite a nota " + (j + 1) + " do " + nome + " : " );
                notas[j] = scanner.nextDouble();

                while (notas [j] < 0.0 || notas [j] > 10.0) {
                    return;  
                  
                  }
            }

            // Calculando a nota final do aluno
            double notaFinal = calcularNotaFinal(notas, pesos);

            // Armazenando a nota final (aqui você pode armazenar em um vetor, banco de dados, etc.)
            System.out.println("Nota final do " + nome + (i + 1) + ": " + notaFinal);

            if (notaFinal >= 0 && notaFinal <= 2) {
                condicao = "Reprovado"; // Se sua média for até 2 aparece que você foi reprovado
            } else if (notaFinal >= 2.1  && notaFinal <= 4.9) {
                condicao = "Substitutiva"; // Se sua média for até 4,9 aparece que você poderá fazer a prova substitutiva
            } else {
                condicao = "Aprovado"; // Se sua média for até acima de 4,9 aparece que você foi aprovado
            }

            DecimalFormat md = new DecimalFormat("#.#");

            System.out.println("\nNome do Aluno: " + nome); // Aparece o nome do aluno
          System.out.println("Media Final: " + md.format(notaFinal)); // Aparece a média final
          System.out.println("Condicao: " + condicao); // Aparece se foi aprovado, substitutiva ou reprovado
        }



        

        // Fechando o scanner
        scanner.close();
    }

    // Função para calcular a nota final
    public static double calcularNotaFinal(double[] notas, double[] pesos) {
        double notaFinal = 0;

        for (int i = 0; i < notas.length; i++) {
            notaFinal += notas[i] * pesos[i]/100;
        }

        

        return notaFinal;
    }
}