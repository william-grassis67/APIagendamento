# API Agendamento

API REST desenvolvida em Java com Spring Boot para gerenciamento de usuários, autenticação e agendamentos.

O projeto foi desenvolvido com foco na aplicação de conceitos de desenvolvimento backend, arquitetura em camadas, persistência de dados e construção de APIs REST.

## Tecnologias

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Git
* GitHub

## Arquitetura

O projeto utiliza uma arquitetura organizada em camadas, separando as responsabilidades da aplicação.

```text
src/
└── main/
    └── java/
        └── com/
            └── william/
                └── meu_projeto/
                    ├── controller/
                    ├── dto/
                    ├── enums/
                    ├── exceptions/
                    ├── model/
                    ├── repository/
                    └── service/
```

### Camadas

**Controller**

Responsável por receber as requisições HTTP e retornar as respostas da API.

**DTO**

Responsável pelo transporte de dados entre as diferentes camadas da aplicação, evitando a exposição direta das entidades.

**Enums**

Contém as enumerações utilizadas pelo sistema, como tipos e estados definidos pela aplicação.

**Exceptions**

Centraliza as exceções e regras relacionadas ao tratamento de erros da aplicação.

**Model**

Contém as entidades que representam os dados persistidos no banco de dados.

**Repository**

Responsável pela comunicação entre a aplicação e o banco de dados utilizando Spring Data JPA.

**Service**

Contém as regras de negócio e a lógica principal da aplicação.

## Funcionalidades

Atualmente, a API possui funcionalidades relacionadas a:

* Cadastro de usuários
* Autenticação de usuários
* Login
* Gerenciamento de agendamentos
* Persistência de dados utilizando JPA
* Validação e tratamento de exceções
* Organização da aplicação utilizando arquitetura em camadas

## Autenticação

### Login

**POST** `/login`

Exemplo de requisição:

```json
{
    "email": "usuario@email.com",
    "senha": "123456"
}
```

Exemplo de resposta:

```json
{
    "token": "token_de_autenticacao"
}
```

## Configuração do projeto

### Pré-requisitos

Antes de executar o projeto, é necessário possuir instalado:

* Java 17 ou superior
* MySQL
* Maven

### Clonando o repositório

```bash
git clone https://github.com/william-grassis67/APIagendamento.git
```

Entre no diretório:

```bash
cd APIagendamento
```

### Configuração do banco de dados

Crie um banco de dados MySQL e configure as credenciais no arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/agendamento
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Não utilize credenciais reais diretamente no código ou em arquivos versionados.

### Executando a aplicação

Utilizando o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Ou utilizando o Maven instalado no sistema:

```bash
mvn spring-boot:run
```

A aplicação será iniciada, por padrão, em:

```text
http://localhost:8080
```

## Testando a API

A API pode ser testada utilizando ferramentas como:

* Insomnia
* Postman
* cURL

Exemplo utilizando cURL:

```bash
curl -X POST http://localhost:8080/login \
-H "Content-Type: application/json" \
-d '{
    "email": "usuario@email.com",
    "senha": "123456"
}'
```

## Status do projeto

Em desenvolvimento.

Novas funcionalidades, melhorias na autenticação, validações e recursos relacionados ao gerenciamento de agendamentos serão implementados conforme a evolução do projeto.

## Autor

William Roque

GitHub: https://github.com/william-grassis67
