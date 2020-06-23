# Central de Erros

## Objetivo

Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas em serviços ou microsserviços. Nestes ambientes complexos, erros podem surgir em diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços distintos. Desta forma, é muito importante que os desenvolvedores possam centralizar todos os registros de erros em um local, de onde podem monitorar e tomar decisões mais acertadas. Neste projeto vamos implementar uma API Rest para centralizar registros de erros de aplicações.

Abaixo estão os requisitos desta API, o time terá total liberdade para tomar as decisões técnicas e de arquitetura da API, desde que atendam os requisitos abaixo.

## API
### Tecnologia
Utilizar a tecnologia base da aceleração para o desenvolvimento (Java).

### Premissas
* A API deve ser pensada para atender diretamente um front-end.
* Deve ser capaz de gravar os logs de erro em um banco de dados relacional.
* O acesso a ela deve ser permitido apenas por requisições que utilizem um token de acesso válido.

### Funcionalidades

* Deve permitir a autenticação do sistema que deseja utilizar a API gerando o Token de Acesso.
* Pode ser acessado por multiplos sistemas.
* Deve permitir gravar registros de eventos de log salvando informações de **Level(error, warning, info), Descrição do Evento, LOG do Evento, ORIGEM(Sistema ou Serviço que originou o evento), DATA(Data do evento), QUANTIDADE(Quantidade de Eventos de mesmo tipo).**
* Deve permitir a listagem dos eventos juntamente com a filtragem de 
eventos por qualquer parâmetro especificado acima.
* Deve suportar Paginação.
* Deve suportar Ordenação por diferentes tipos de atributos.
* A consulta de listagem **não deve retornar os LOGs** dos Eventos
Deve permitir a busca de um evento por um ID, dessa maneira exibindo o LOG desse evento em específico.


## Tecnologias

* Java
* Maven
* Spring Boot
* Spring Security com OAUTH 2
* Banco de dados H2
* GitHub

## Banco de dados

###  Tabelas
CREATE TABLE **LEVEL**
(
  LEV_ID INT IDENTITY PRIMARY KEY,
  LEV_DESCRICAO VARCHAR(250) NOT NULL
);

CREATE TABLE **SISTEMA**
(
  SIS_ID INT IDENTITY PRIMARY KEY,
  SIS_DESCRICAO VARCHAR(250) NOT NULL,
  SIS_STATUS VARCHAR(1) NOT NULL
);

CREATE TABLE **CRASH**
(
  CRA_ID INT IDENTITY PRIMARY KEY,
  LEV_ID INT NOT NULL,
  CRA_DESCRICAO_EVENTO VARCHAR(250) NOT NULL,
  CRA_LOG VARCHAR(250) NOT NULL,
  SIS_ID INT NOT NULL,
  CRA_DATA TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CRA_QUANTIDADE INT NOT NULL
);

CREATE TABLE **USUARIO**
(
  USE_ID INT IDENTITY PRIMARY KEY,
  USE_NOMECOMPLETO VARCHAR(50) NOT NULL,
  USE_EMAIL VARCHAR(50) NOT NULL,
  USE_PASSWORD VARCHAR(150) NOT NULL,
  USE_DATA TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE **PERMISSAO**
(
  PER_ID INT IDENTITY PRIMARY KEY,
  USE_ID INT NOT NULL,
  PER_VALOR VARCHAR(50) NOT NULL
);

### Relacionamentos entre tabelas

ALTER TABLE **CRASH**
    ADD FOREIGN KEY (LEV_ID) 
    REFERENCES **LEVEL**(LEV_ID);

ALTER TABLE **CRASH**
    ADD FOREIGN KEY (SIS_ID) 
    REFERENCES **SISTEMA**(SIS_ID);


ALTER TABLE **PERMISSAO**
    ADD FOREIGN KEY (USE_ID) 
    REFERENCES **USUARIO**(USE_ID);


## Camadas
1. Models
2. Repositories
3. Services
4. Mappers
5. DTOs
6. Controllers

## Recursos

![alt text](https://github.com/Ivairpuerari/api-crash/blob/master/classController.PNG)

## Exemplo de request

![alt text](https://github.com/Ivairpuerari/api-crash/blob/master/example_authorization.gif)


