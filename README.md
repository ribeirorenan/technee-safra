# technee-safra
Repositório para armazenamento de código fonte e documentação do projeto de hackaton do Technee do Banco Safra.


## Executar a api localmente (backend)
- Ter uma instância do MySQL v5.7 rodando
- Criar um database 'safra-technee'
- Configurar o usuário e senha no application.yml
- Acesssar em http://localhost:8080/ 

## Arquitetura do backend
- Aplicação Spring Boot (EC2)
- Banco de dados relacional MySQL (RDS)
- EC2 e RDS configurados para comunicar apenas na mesma VPC.