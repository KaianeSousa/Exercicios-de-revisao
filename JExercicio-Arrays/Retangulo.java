public class Retangulo {
    // Atributo que armazena a altura do retângulo
    private double altura;

    // Atributo que armazena a largura do retângulo
    private double largura;

    // Construtor da classe Retangulo
    // Inicializa a altura e a largura com os valores fornecidos
    public Retangulo(double largura, double altura){
        this.altura = altura;
        this.largura = largura;
    }

    // Método que retorna a altura do retângulo
    public double getAltura() {
        return altura;
    }

    // Método que retorna a largura do retângulo
    public double getLargura() {
        return largura;
    }

    // Método que calcula a área do retângulo, multiplicando a largura pela altura e retorna o valor calculado
    public double calculaArea(){
        double area = largura * altura;
        return area;
    }

    // Método que calcula o perímetro do retângulo, somando a largura e a altura, depois multiplica por 2 e retorna o valor calculado
    public double calculaPerimetro(){
        double perimetro = 2 * (largura + altura);
        return perimetro;
    }

    // Método que exibe as informações do retângulo e imprime a largura, a altura, a área e o perímetro formatados
    void exibirInformacoes(){
        System.out.printf("Largura: %.2f, Altura: %.2f, Área: %.2f, Perímetro: %.2f%n",
                largura, altura, calculaArea(), calculaPerimetro());
    }

    // Método sobrescrito da classe Objeto, que retorna uma representação em string do retângulo
    @Override
    public String toString() {
        return String.format("Largura: %.2f, Altura: %.2f, Área: %.2f, Perímetro: %.2f",
                largura, altura, calculaArea(), calculaPerimetro());
    }
}
