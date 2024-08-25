import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Inicialização do Scanner para ler entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Criação de um array para armazenar objetos da classe Retangulo
        Retangulo[] retangulos = new Retangulo[5]; // Vetor inicialmente com capacidade para 5 retângulos

        // Coleta de informações para cada retângulo e armazenamento no array
        for (int i = 0; i < retangulos.length; i++) {
            System.out.println("Retângulo " + (i + 1) + ":");

            // Solicitação e leitura da largura do retângulo
            System.out.print("Digite a largura (use ponto para números decimais): ");
            double largura = scanner.nextDouble();

            // Solicitação e leitura da altura do retângulo
            System.out.print("Digite a altura (use ponto para números decimais): ");
            double altura = scanner.nextDouble();

            System.out.println("------------------------------------------------------");

            // Criação de um novo objeto Retangulo com as dimensões fornecidas e armazenamento no array
            retangulos[i] = new Retangulo(largura, altura);
        }

        // Exibição das informações de todos os retângulos
        System.out.println("Os cálculos dos retângulos são: ");
        for (int i = 0; i < retangulos.length; i++) {
            System.out.println("Retângulo " + (i + 1) + ":");
            retangulos[i].exibirInformacoes();
        }

        // Identificação do retângulo com a maior área
        double maiorArea = 0;
        double areaAtual = 0;
        int indiceDaMaiorArea = -1;

        for (int i = 0; i < retangulos.length; i++) {
            areaAtual = retangulos[i].calculaArea();
            if (areaAtual > maiorArea) {
                maiorArea = areaAtual;
                indiceDaMaiorArea = i + 1; // Ajuste no índice para apresentação
            }
        }

        // Exibição do índice do retângulo com a maior área
        System.out.println("****************************************************************");
        System.out.println("Retângulo com a maior área: Retângulo " + indiceDaMaiorArea);

        // Identificação do retângulo com o menor perímetro
        double menorPerimetro = Double.MAX_VALUE;
        double perimetroAtual = 0;
        int indiceDoMenorPerimetro = -1;

        for (int i = 0; i < retangulos.length; i++) {
            perimetroAtual = retangulos[i].calculaPerimetro();
            if (perimetroAtual < menorPerimetro) {
                menorPerimetro = perimetroAtual;
                indiceDoMenorPerimetro = i + 1; // Ajuste no índice para apresentação
            }
        }

        // Exibição do índice do retângulo com o menor perímetro
        System.out.println("Retângulo com o menor perímetro: " + indiceDoMenorPerimetro);
        System.out.println("****************************************************************");

        // Expansão do vetor para armazenar mais retângulos
        System.out.println("Expandindo vetor de retângulos...");

        // Criação de um novo array com capacidade maior para armazenar até 10 retângulos
        Retangulo[] expandirRetangulos = Arrays.copyOf(retangulos, 10);

        // Coleta de informações para os novos retângulos e armazenamento nas novas posições do array
        for (int i = retangulos.length; i < expandirRetangulos.length; i++) {
            System.out.println("Retângulo " + (i + 1) + ":");

            // Solicitação e leitura da largura para o novo retângulo
            System.out.print("Digite a largura (use ponto para números decimais): ");
            double largura = scanner.nextDouble();

            // Solicitação e leitura da altura para o novo retângulo
            System.out.print("Digite a altura (use ponto para números decimais): ");
            double altura = scanner.nextDouble();
            System.out.println("------------------------------------------------------");

            // Criação de um novo objeto Retangulo com as dimensões fornecidas e armazenamento no array expandido
            expandirRetangulos[i] = new Retangulo(largura, altura);
        }

        // Criação de um array de índices para manter a ordem original dos retângulos
        Integer[] indices = new Integer[expandirRetangulos.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // Ordenação do array de índices com base no perímetro dos retângulos
        Arrays.sort(indices, (i1, i2) -> Double.compare(expandirRetangulos[i2].calculaPerimetro(), expandirRetangulos[i1].calculaPerimetro()));

        // Exibição dos retângulos após a ordenação por perímetro, mantendo a ordem original
        System.out.println("Retângulos ordenados por perímetro (decrescente):");
        for (int i = 0; i < indices.length; i++) {
            int inicio = indices[i];
            if (expandirRetangulos[inicio] != null) { // Para evitar mostrar valores nulos
                System.out.println("Retângulo " + (inicio + 1) + ": " + expandirRetangulos[inicio]);
            }
        }

        // Fechamento do Scanner para liberar recursos
        scanner.close();
    }
}
