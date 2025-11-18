# 💱 Conversor de Moedas em Java

Um **conversor de moedas interativo em Java**, desenvolvido com o objetivo de praticar **Programação Orientada a Objetos (POO)** e o consumo de **APIs externas**.  
O programa permite converter valores entre diferentes moedas em tempo real, utilizando dados atualizados da [ExchangeRate API](https://www.exchangerate-api.com/).

---

## 🚀 Funcionalidades

- Conversão entre as seguintes moedas:
  - 🇺🇸 Dólar (USD)
  - 🇦🇷 Peso Argentino (ARS)
  - 🇧🇷 Real Brasileiro (BRL)
  - 🇨🇴 Peso Colombiano (COP)
- Consulta automática da taxa de câmbio em tempo real.
- Exibição clara e formatada do valor convertido.
- Menu interativo e repetitivo até que o usuário opte por sair.

---

## 📝 Histórico de Conversões (Nova Funcionalidade!)

Toda vez que uma conversão é realizada, o programa registra:

📅 Data e hora da conversão

💵 Valor original digitado

💱 Moeda de origem e moeda de destino

📈 Taxa de conversão aplicada

💰 Valor convertido final

---

## 📂 Estrutura do Projeto

📦 ConversorDeMoedas

 ┣ 📜 Principal.java          → Menu interativo e lógica principal
 
 ┣ 📜 ConsultaApi.java        → Responsável pelas requisições HTTP usando HttpClient
 
 ┣ 📜 Moeda.java              → Record representando os dados recebidos da API
 
 ┣ 📜 Historico.java          → Classe que armazena cada conversão realizada
 
 ┣ 📜 LocalDateTimeAdapter    → Adaptador para serializar datas no JSON (Gson)
 
 ┗ 📄 historicoConversao.json → Arquivo gerado automaticamente com seu histórico

---

## 🧠 Conceitos Aplicados

Este projeto foi criado com o propósito de consolidar os seguintes conceitos:

- **Programação Orientada a Objetos (POO)**  
  - Criação e encapsulamento de classes.
  - Utilização de construtores e métodos.
- **Consumo de APIs REST com `HttpClient`**
- **Manipulação de JSON usando `Gson`**
- **Estruturas de repetição e controle de fluxo**
- **Boas práticas de código limpo e legível**
