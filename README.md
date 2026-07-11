# 🛠️ Sistema de Cortes: Calhas e Rufos

Um sistema de terminal desenvolvido em **Java** para automatizar o cálculo de corte de chapas e a logística de entrega para o setor de calhas e rufos. 

O projeto tem como objetivo facilitar o dia a dia de uma oficina, reduzindo erros manuais e aplicando regras de negócio reais para o transporte das peças.

## 🚀 Funcionalidades

- **Cálculo Dinâmico:** Adapta a quantidade de medidas solicitadas de acordo com o modelo escolhido (Calha Quadrada, Beiral, Escadinha ou Rufos variados).
- **Entrada em Padrão Brasileiro (pt-BR):** Suporte nativo para números decimais com vírgula (ex: 15,5 cm).
- **Inteligência Logística:**
  - Peças com até **7 metros** são enviadas inteiras.
  - Peças maiores que 7 metros são automaticamente divididas em partes iguais e simétricas de no máximo **5 metros**, facilitando o transporte e garantindo a estética das emendas.

## 💻 Tecnologias Utilizadas

- **Java** (Lógica de programação, Estruturas de repetição, Condicionais, Classe `Scanner` e `Locale` e a classe `Math`).

## ⚙️ Como executar o projeto

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado no seu computador.
2. Faça o clone deste repositório ou baixe o arquivo `.java`.
3. Abra o terminal na pasta onde o arquivo está salvo.
4. Compile o código com o comando:
   ```bash
   javac SistemaCalhasRufos.java
