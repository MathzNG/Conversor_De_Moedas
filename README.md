📄 Conversor de Moedas — ONE / Oracle Next Education

Este projeto foi desenvolvido como parte do desafio da formação Oracle Next Education (ONE) em parceria com a Alura.
O objetivo era criar um conversor de moedas utilizando a Exchange Rate API, aplicando conceitos fundamentais de Java, tratamento de JSON, requisições HTTP e boas práticas de programação.

🚀 Funcionalidades

Conversão entre diversas moedas utilizando dados em tempo real.

Consulta de taxas usando a ExchangeRate-API.

Interface via terminal interativa para o usuário escolher moedas e informar valores.

Estrutura simples utilizando classes separadas (Main e Moedas).

Tratamento de erros básicos para evitar falhas em requisições.

🛠️ Tecnologias utilizadas

Java 17+

ExchangeRate-API

Gson (para ler e interpretar JSON)

Java HTTP Client (java.net.http)


📦 Como executar o projeto

Clone o repositório

git clone https://github.com/seu-usuario/seu-repositorio.git


Acesse a pasta do projeto

Compile os arquivos

javac Main.java Moedas.java

Execute

java Main

🔧 Como funciona internamente
1. Entrada do usuário

O programa utiliza Scanner para permitir que o usuário digite:

Moeda base (ex.: USD)

Moeda a converter (ex.: BRL)

Valor para conversão

2. Requisição à API

O programa constrói uma URL assim:

https://v6.exchangerate-api.com/v6/SUA-CHAVE-API/latest/USD


E consulta as taxas de câmbio com:

HttpClient.newHttpClient()

3. Leitura do JSON com Gson

O programa usa:

JsonObject taxas = json.getAsJsonObject("conversion_rates");


E então obtém a taxa exata:

double taxa = taxas.get(moeda).getAsDouble();

4. Cálculo final
double convertido = valor * taxa;

📘 Estrutura do projeto
📁 conversor-moedas
 ├── Main.java        # Contém o fluxo principal do programa
 ├── Moedas.java      # Classe que armazena dados das moedas escolhidas
 └── README.md

🔑 Sobre a API

Este projeto utiliza a ExchangeRate-API, que fornece taxas de câmbio atualizadas.

Você precisa de uma chave pessoal.
Para obter uma:

🔗 https://www.exchangerate-api.com/

Depois, substitua no código:

String apiKey = "SUA_CHAVE_AQUI";

📚 O que aprendi com este desafio

✔ Requisições HTTP em Java
✔ Uso de Gson para manipular JSON
✔ Boas práticas de separação de responsabilidades
✔ Interação com APIs externas
✔ Estruturação de projetos Java simples

📝 Melhorias futuras

Criar um menu mais completo com várias opções de conversão

Tratar erros específicos (moeda inválida, API offline etc.)

Implementar interface gráfica (JavaFX ou Swing)

Adicionar testes automatizados
