import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaApi {

    public Moeda consultar(String moedaBase, String moedaDestino) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            URI url = URI.create("https://v6.exchangerate-api.com/v6/b8800b5014d33743ec1267e7/pair/" + moedaBase + "/" + moedaDestino);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro na consulta da API: código " + response.statusCode());
            }

            String json = response.body();

            Moeda moeda = gson.fromJson(json, Moeda.class);
            return moeda;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
