📄 Conversor de Moedas — ONE | Oracle Next Education

Este projeto foi desenvolvido como parte do desafio da formação Oracle Next Education (ONE), em parceria com a Alura.

O objetivo é criar um conversor de moedas em Java, consumindo dados reais da ExchangeRate-API, com foco em praticar Programação Orientada a Objetos (POO), requisições HTTP, manipulação de JSON e boas práticas de organização de código.

//

🚀 Funcionalidades

Conversão entre diferentes moedas utilizando taxas de câmbio em tempo real

Consumo da ExchangeRate-API

Interface interativa via terminal

Menu de opções para escolha da conversão

Estrutura simples com classes separadas por responsabilidade

Tratamento básico de erros para evitar falhas na aplicação

//

🛠️ Tecnologias Utilizadas

Java 17+

ExchangeRate-API

Gson (para leitura e interpretação de JSON)

Java HTTP Client (java.net.http)

//

📦 Como Executar o Projeto
1️⃣ Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

2️⃣ Acesse a pasta do projeto
cd conversor-moedas

3️⃣ Compile os arquivos
javac Principal.java Moedas.java ConsumoAPI.java

4️⃣ Execute o programa
java Principal

//

🔧 Como o Projeto Funciona Internamente
📥 Entrada do Usuário

O programa utiliza a classe Scanner para permitir que o usuário:

Escolha a opção de conversão no menu

Informe o valor a ser convertido

//

🌐 Requisição à API

A aplicação monta a URL da seguinte forma:

https://v6.exchangerate-api.com/v6/SUA-CHAVE-API/latest/USD


E realiza a requisição utilizando o HttpClient do Java.

//

📄 Leitura do JSON

A resposta da API é interpretada com o Gson, extraindo as taxas de conversão:

JsonObject taxas = json.getAsJsonObject("conversion_rates");
double taxa = taxas.get(moedaDestino).getAsDouble();

//

🧮 Cálculo da Conversão
double convertido = valor * taxa;


O resultado é exibido diretamente no terminal.

//

📁 Estrutura do Projeto
conversor-moedas
├── Principal.java     # Contém o fluxo principal e o menu
├── Moedas.java        # Armazena a moeda base e a moeda de destino
├── ConsumoAPI.java    # Responsável por consumir a API externa
└── README.md

//

🔑 Sobre a API

Este projeto utiliza a ExchangeRate-API, que fornece taxas de câmbio atualizadas.

Para utilizar o projeto, é necessário possuir uma chave de API.

🔗 https://www.exchangerate-api.com/


📚 O Que Aprendi com Este Projeto

✔ Requisições HTTP em Java

✔ Consumo de APIs externas

✔ Manipulação de JSON com Gson

✔ Programação Orientada a Objetos

✔ Separação de responsabilidades

✔ Estruturação de projetos Java simples

//

📝 Melhorias Futuras

Implementar enum para representar moedas

Melhorar o menu de opções

Tratar erros específicos da API (moeda inválida, API indisponível)

Evitar múltiplas chamadas repetidas à API

Criar interface gráfica (JavaFX ou Swing)

Adicionar testes automatizados
