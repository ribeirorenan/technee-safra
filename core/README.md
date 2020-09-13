# api-safra-risk

API contendo o core do Safra Risk.

## Requisitos para executar a api localmente
- Java 1.8 instalado
- Ter uma instância do MySQL v8.0.17 rodando
- Criar um database 'safra-technee'
- Configurar o usuário e senha no application.yml

## Rodando o projeto localmente
Para compilar e executar manualmente, a maneira mais simples é utilizando o script **mvnw** na pasta **api-safra-risk** com os seguintes comandos:
- mvnw clean
- mvnw install

E em sequência executar o arquivo .jar gerado:
- java -jar target/{arquivo-gerado}.jar

Também é possível executar o projeto importando o mesmo em uma IDE como o Intellij (utilizada no desenvolvimento da aplicação).

## Arquitetura de deploy de test durante o desenvolvimento da aplicação
- Aplicação Spring Boot (EC2)
- Banco de dados relacional MySQL (RDS)
- EC2 e RDS configurados para comunicar apenas na mesma VPC.
