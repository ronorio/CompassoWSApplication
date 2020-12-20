# CompassoWS

[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
<a alt="Java">
    <img src="https://img.shields.io/badge/Java-v 1.8-orange.svg" />
</a>
<a alt="Maven">
    <img src="https://img.shields.io/badge/Maven-v 3.6.3-orange.svg" />
</a>
<a alt="Swagger">
    <img src="https://img.shields.io/badge/Swagger-v 2.9.2-orange.svg" />
</a>

REST API utilizando [Spring Boot](https://spring.io/projects/spring-boot), [SQL Server](https://www.microsoft.com/pt-br/sql-server) e [Swagger](https://swagger.io/).

## Requisitos

Para rodar esta aplicação você precisa de:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Rodando a aplicação localmente


Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método `main` na classe `com/uol/CompassoWS/CompassoWsApplication.java` na sua IDE.


Como alternativa você pode utilizar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) da seguinte maneira:

```shell
mvn spring-boot:run
```

## Começando

Essas instruções fornecerão uma cópia do projeto instalado e funcionando em sua máquina local para fins de desenvolvimento e teste.

### Pré Requisito

* Você precisa ter o SQL Server instalado em sua máquina para executar o aplicativo no perfil de desenvolvimento. Usando o Microsft SQL Server Management Studio ou em qualquer outro cliente/console, crie as tabelas cliente e cidade.

```sql
USE [SEU_BANCO_DE_DADOS]
GO

/****** Object:  Table [dbo].[cidade] ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cidade](
	[cod_cidade] [numeric](10, 0) IDENTITY(1,1) NOT NULL,
	[des_nome] [varchar](255) NOT NULL,
	[cod_uf] [varchar](2) NOT NULL,
 CONSTRAINT [PK_cidade] PRIMARY KEY CLUSTERED 
(
	[cod_cidade] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
```

```sql
USE [SEU_BANCO_DE_DADOS]
GO

/****** Object:  Table [dbo].[cliente] ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cliente](
	[cod_cliente] [numeric](10, 0) IDENTITY(1,1) NOT NULL,
	[des_nome] [varchar](255) NOT NULL,
	[ind_sexo] [nchar](1) NOT NULL,
	[dat_nascimento] [datetime] NOT NULL,
	[qtd_anos]  AS (case when datepart(month,getdate())>datepart(month,[dat_nascimento]) OR datepart(month,getdate())=datepart(month,[dat_nascimento]) AND datepart(day,getdate())>=datepart(day,[dat_nascimento]) then datediff(year,[dat_nascimento],getdate()) else datediff(year,[dat_nascimento],getdate())-(1) end),
	[cod_cidade] [numeric](10, 0) NOT NULL,
 CONSTRAINT [PK_cliente] PRIMARY KEY CLUSTERED 
(
	[cod_cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
```
Depois de criar o banco de as tabelas, você precisa adicionar seu nome de `usuário`, `senha` e `banco` SQL Server no arquivo `application.properties` em `src/main/resource`. As linhas que devem ser modificadas são as seguintes:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1443;databaseName=[SEU_BANCO_DE_DADOS]
spring.datasource.username=[USUARIO]
spring.datasource.password=[SENHA]
```

## Documentação

Esta aplicação utiliza o Swagger V 2.9.2, visualizar a documentação acesso o link http://localhost:8080/swagger-ui.html

## Copyright

Distribuído sob a Licença Apache 2.0. Veja a [LICENÇA](http://www.apache.org/licenses/LICENSE-2.0.html).