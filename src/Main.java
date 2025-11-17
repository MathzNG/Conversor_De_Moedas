import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    private Object getMoedaAConverter;

    public void main(String[] args) throws IOException, InterruptedException {
        Moedas moedas = new Moedas();
        Scanner leitura = new Scanner(System.in);

        for (; ;) {

            System.out.println("""
                    *************************************************
                    Escolha uma das opções abaixo para conversão:
                    
                    1° BRL > USD
                    2° USD > BRL
                    3° JPY > BRL
                    4° BRL > JPY
                    5° EUR > BRL
                    6° BRL > EUR
                    7° EUR > USD
                    8° Sair
                    
                    *************************************************
                    """);
            int opcao = leitura.nextInt();


            if (opcao == 1) {
                moedas.setMoedaBase("BRL");
                moedas.setMoedaAConverter("USD");
            } else if (opcao == 2) {
                moedas.setMoedaBase("USD");
                moedas.setMoedaAConverter("BRL");
            } else if (opcao == 3) {
                moedas.setMoedaBase("JPY");
                moedas.setMoedaAConverter("USD");
            } else if (opcao == 4) {
                moedas.setMoedaBase("BRL");
                moedas.setMoedaAConverter("JPY");
            } else if (opcao == 5) {
                moedas.setMoedaBase("EUR");
                moedas.setMoedaAConverter("BRL");
            } else if (opcao == 6) {
                moedas.setMoedaBase("BRL");
                moedas.setMoedaAConverter("EUR");
            } else if (opcao == 7) {
                moedas.setMoedaBase("EUR");
                moedas.setMoedaAConverter("USD");
            } else if (opcao == 8) {
                System.out.println("Conversor encerrado!!");
                break;
            } else {
                System.out.println("Opção inválida.");
                return;
            }

            String endereco = "https://v6.exchangerate-api.com/v6/ae2d103b8851858d397bcaff/latest/" + moedas.getMoedaBase();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement elemento = JsonParser.parseString(response.body());
            JsonObject objetoMoeda = elemento.getAsJsonObject();
            JsonObject taxas = objetoMoeda.getAsJsonObject("conversion_rates");

            if (taxas.has(moedas.getMoedaAConverter())) {
                double taxa = taxas.get(moedas.getMoedaAConverter()).getAsDouble();

                System.out.print("Digite o valor a converter (" + moedas.getMoedaBase() + "): ");
                double valor = leitura.nextDouble();

                double convertido = valor * taxa;

                System.out.printf("Valor convertido: %.2f %s = %.2f %s%n", valor, moedas.getMoedaBase(), convertido, moedas.getMoedaAConverter());
            } else {
                System.out.println("Não foi possível encontrar a taxa de conversão para " + moedas.getMoedaAConverter());
            }

        }
    }
}

