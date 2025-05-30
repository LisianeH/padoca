# 📖 Padoca Delivery — Sistema de Montagem de Tortas

Projeto desenvolvido para a disciplina **Engenharia de Software II**, com o objetivo de aplicar o uso de padrões de projeto e boas práticas, desenvolvido em Java.

A aplicação simula um sistema de delivery de tortas, permitindo que o usuário personalize sua torta interativamente via console.

---

## 📚 Tecnologias Utilizadas

- **Java 21.0.4**
- **Spring Boot 3.4.6**
- **Maven** para gerenciamento de dependências
- **Scanner (Java Console)** para entrada interativa de dados no terminal

---

## 🏛️ Organização e Boas Práticas

O projeto foi estruturado de forma a manter uma separação clara entre responsabilidades, agrupando classes por contexto:

- **package `model`**: contém os modelos de domínio da aplicação e as classes enum responsáveis por representar valores fixos como tipos de recheio, cobertura, tamanho e camada, deixando mais organizado sem o uso do banco de dados.
- **package `service`**: armazena os serviços responsáveis pelas regras de montagem e interação com o usuário no terminal.
- **package `documents`**: reúne toda a documentação explicativa sobre cada padrão de código aplicado no projeto, além das midias com foto da arquitetura e vídeo funcional do projeto.
- **package `factory`**: concentra as implementações do padrão de projeto **Factory Method**.
- **package `decorator`**: concentra as implementações do padrão de código **Decorator**.
- **package `strategy`**: responsável pelas implementações do padrão **Strategy**.

---

## 💡 Padrões de Projeto Utilizados

- **Factory Method**: para montagem dinâmica de tortas conforme o tipo (doce ou salgada).
- **Decorator**: utilizado para adicionar dinamicamente funcionalidades extras, sem modificar as classes base.
- **Strategy**: permitindo definir diferentes estratégias e sendo atribuída dinamicamente a um pedido, proporcionando flexibilidade e desacoplamento no processo de entrega.

Todos os padrões estão devidamente documentados no package `documents`, com descrição conceitual e explicação sobre sua aplicação no projeto.

---

## 🎯 Funcionalidades

- Montagem personalizada de tortas **doces** ou **salgadas**.
- Definição de:
  - Tamanho da torta.
  - Quantidade de camadas.
  - Tipo de recheio.
  - Cobertura.
  - Opções de extra (embalagem especial, cartão com mensagem).
  - Entrega.
- Exibição de mensagem de confirmação ao final com a torta montada.

---

## 📌 Como Executar

Para executar a aplicação, basta rodar o projeto Spring Boot diretamente pela IDE:

- Navegue até a classe `PadocaApplication`.
- Execute clicando em **Run** ou utilizando o atalho **Shift + F10** (no IntelliJ IDEA).
- A aplicação será inicializada no console para interação via terminal.

---

## 📌 Observações

- **Testes unitários** com spring boot test nesta versão do projeto.
- O projeto foi organizado considerando possíveis expansões futuras para integração com banco de dados, API REST e testes automatizados.
