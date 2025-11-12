import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("""
                    ******************************************************
                    Seja bem-vindo(a) ao Conversor de Moeda :)
                    
                    1) Dólar => Peso argentino
                    2) Peso argentino => Dólar
                    3) Dólar => Real brasileiro
                    4) Real brasileiro => Dólar
                    5) Dólar => Peso colombiano
                    6) Peso colombiano => Dólar
                    7) Sair
                    
                    Escolha uma opção válida:
                    ******************************************************
                    """);

            opcao = leitura.nextInt();

            String moedaBase = "";
            String moedaDestino = "";
            int valor = 0;

            switch (opcao) {
                case 1 -> {
                    moedaBase = "USD";
                    moedaDestino = "ARS";
                }
                case 2 -> {
                    moedaBase = "ARS";
                    moedaDestino = "USD";
                }
                case 3 -> {
                    moedaBase = "USD";
                    moedaDestino = "BRL";
                }
                case 4 -> {
                    moedaBase = "BRL";
                    moedaDestino = "USD";
                }
                case 5 -> {
                    moedaBase = "USD";
                    moedaDestino = "COP";
                }
                case 6 -> {
                    moedaBase = "COP";
                    moedaDestino = "USD";
                }
                case 7 -> {
                    System.out.println("Encerrando o programa...");
                    continue;
                }
                default -> System.out.println("Opção inválida. Tente novamente!");
            }

            if (opcao >= 1 && opcao <= 6) {
                System.out.println("Digite o valor que deseja converter: ");
                valor = leitura.nextInt();
                Moeda resultado = consulta.consultar(moedaBase, moedaDestino);
                double valorConvertido = resultado.conversion_rate() * valor;
                System.out.println("Taxa de conversão: " + resultado.conversion_rate());
                System.out.println("O valor " + valor + " [" + moedaBase + "] " + "corresponde ao valor final de =>>> " + valorConvertido + " " + " [" + moedaDestino + "]");
            }
        }
        leitura.close();
    }
}