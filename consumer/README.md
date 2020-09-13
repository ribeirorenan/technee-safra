# Safra Consumer UI

Aplicativo B2C (visão mobile) com o objetivo de permitir ao usuário o gerenciamento de suas contas bancárias e permissões concedidas.

## Requisitos para executar a api localmente
- Possuir Angular CLI instalado. Versão recomendada: v9.1.4

## Rodando o projeto localmente
Para servir o projeto em modo de desenvolvimento execute o seguinte comando na pasta **consumer-ui** (com o Angular CLI instalado):

* ng serve

E acesse na seguinte URL:

* http://localhost:4200/pages/consumer/home

Caso entre pela interface Desktop, mude para visão Mobile para ter a experiência adequada.

## Deploy da aplicação

Durante o desenvolvimento fizemos o deploy através do serviço Amazon Simple Storage Service (S3).
Para gerar os arquivos de deploy, execute o seguinte comando na pasta **consumer-ui**

* ng build --prod

Os arquivos finais estarão dentro da pasta **consumer-ui/dist**. Basta fazer o deploy desses arquivos para o serviço de preferência.