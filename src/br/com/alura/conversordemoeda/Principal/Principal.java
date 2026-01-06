package br.com.alura.conversordemoeda.Principal;

import br.com.alura.conversordemoeda.Service.ConsumoAPI;
import br.com.alura.conversordemoeda.model.Moedas;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;

public class Principal {


    public void exibeMenu() throws IOException, InterruptedException {

        Moedas moedas = new Moedas();
        Scanner leitura = new Scanner(System.in);
        ConsumoAPI consumo = new ConsumoAPI();

        var opcao = -1;

        while (opcao != 8) {

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

            opcao = leitura.nextInt();

            if (opcao == 1) {
                moedas.setMoedaBase("BRL");
                moedas.setMoedaAConverter("USD");
            } else if (opcao == 2) {
                moedas.setMoedaBase("USD");
                moedas.setMoedaAConverter("BRL");
            } else if (opcao == 3) {
                moedas.setMoedaBase("JPY");
                moedas.setMoedaAConverter("BRL");
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

            JsonObject taxas = consumo.buscarTaxas(moedas.getMoedaBase());

            if (taxas.has(moedas.getMoedaAConverter())) {

                double taxa = taxas.get(moedas.getMoedaAConverter()).getAsDouble();

                System.out.print("Digite o valor a converter (" + moedas.getMoedaBase() + "): ");
                double valor = leitura.nextDouble();

                double convertido = valor * taxa;

                System.out.printf(
                        "Valor convertido: %.2f %s = %.2f %s%n",
                        valor,
                        moedas.getMoedaBase(),
                        convertido,
                        moedas.getMoedaAConverter()
                );
            } else {
                System.out.println("Não foi possível encontrar a taxa de conversão para "
                        + moedas.getMoedaAConverter());
            }
        }
    }
}