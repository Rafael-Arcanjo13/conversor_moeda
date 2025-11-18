import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {

    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        ArrayList<Historico> listaDeHistorico = new ArrayList<>();
        ConsultaApi consulta = new ConsultaApi();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        int opcao = 0;
        while (opcao != 8) {
            System.out.println("""
                    ******************************************************
                    Seja bem-vindo(a) ao Conversor de Moeda :)
                    
                    1) Dólar => Peso argentino
                    2) Peso argentino => Dólar
                    3) Dólar => Real brasileiro
                    4) Real brasileiro => Dólar
                    5) Dólar => Peso colombiano
                    6) Peso colombiano => Dólar
                    7) Histórico de conversões
                    8) Sair
                    
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

                }
                case 8 -> {
                    System.out.println("Encerrando o programa...");
                    continue;
                }
                default -> System.out.println("Opção inválida. Tente novamente!");
            }

            if (opcao >= 1 && opcao <= 6) {
                System.out.println("Digite o valor que deseja converter: ");
                valor = leitura.nextInt();
                Moeda resultado = consulta.consultar(moedaBase, moedaDestino);

                LocalDateTime dateAndHours = LocalDateTime.now();
                double valorConvertido = resultado.conversion_rate() * valor;

                listaDeHistorico.add(new Historico(dateAndHours, resultado.conversion_rate(), valor, moedaBase, valorConvertido, moedaDestino));

                FileWriter historico = new FileWriter("historicoConversao.json");
                historico.write(gson.toJson(listaDeHistorico));
                historico.close();



                System.out.println("Taxa de conversão: " + resultado.conversion_rate());
                System.out.println("O valor " + valor + " [" + moedaBase + "] " + "corresponde ao valor final de =>>> " + valorConvertido + " " + " [" + moedaDestino + "]");
            }

            if(opcao == 7) {
                for (Historico conversao : listaDeHistorico) {
                    System.out.println(conversao);
                }
            }
        }
        leitura.close();
    }
}