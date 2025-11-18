import java.time.LocalDateTime;

public class Historico {
    int valor;
    String moedaBase;
    double valorConvertido;
    String moedaDestino;
    LocalDateTime data;
    double taxa;

    public Historico(LocalDateTime data, double taxa, int valor, String moedaBase, double valorConvertido, String moedaDestino) {
        this.data = data;
        this.taxa = taxa;
        this.valor = valor;
        this.moedaBase = moedaBase;
        this.valorConvertido = valorConvertido;
        this.moedaDestino = moedaDestino;
    }

    @Override
    public String toString() {
        return "[" + data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear() + "] " + valor + " " + moedaBase + " => " + String.format("%.2f", valorConvertido) + " " + moedaDestino + " | Taxa: " + String.format("%.2f", taxa);
    }
}
