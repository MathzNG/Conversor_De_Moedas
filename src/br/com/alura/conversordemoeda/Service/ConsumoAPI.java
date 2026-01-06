package br.com.alura.conversordemoeda.Service;

import br.com.alura.conversordemoeda.model.Moedas;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public JsonObject buscarTaxas(String moedaBase)throws IOException, InterruptedException {

        String endereco = "https://v6.exchangerate-api.com/v6/ae2d103b8851858d397bcaff/latest/" + moedaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonElement elemento = JsonParser.parseString(response.body());
        JsonObject objetoMoeda = elemento.getAsJsonObject();

        return objetoMoeda.getAsJsonObject("conversion_rates");
    }
}
