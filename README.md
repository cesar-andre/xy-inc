Desafio XY Inc
=======

Este repositorio contém uma solução para o desafio da empresa XY Inc, empresa especializada na produção de excelentes receptores GPS.

O desafio consiste em desenvolver um plataforma com 3 serviços básicos:

 - **Serviço para cadastrar pontos de interesse com 3 atributos**
Nome do POI, Coordenada X (inteiro não negativo), Coordenada Y (inteiro não negativo). Os POIs devem ser armazenados em uma base de dados.

 - **Serviço para listar todos os POIs cadastrados.**
 
 - **Serviço para listar POIs por proximidade.**
 Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, em como uma distância máxima (dmax) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

## O que foi utilizado ##

 - JBoss Forge, para o kickoff do projeto
 - Java 8
 - Spring MVC
 - Hibernate
 - MySQL
 - Rest Assured, para testes do serviço
 - Tomcat 9
 - Insomnia, cliente HTTP
 - Maven

## Instruções para execução do projeto ##


Pré-requisitos:
 - Maven instalado
 - Tomcat 9 para deploy


 **Passo 1:** Criar o Schema na database correta
 
    CREATE SCHEMA `xyinc` ;


**Passo 2:** Alterar o arquivo enviroment.properties (que se encontra em *src/main/resources*) com informações de database.

**Passo 3:** Montar o arquivo .war para o deploy

    mvn package -Dmaven.test.skip=true

**Passo 4:** Fazer o deploy do arquivo .war gerado no Tomcat

**Passo 5:** Executar o arquivo popular_schema_inicial.sql (*/src/main/resources/sql*), para inserir os valores padrão

Pronto, temos a projeto basico rodando.


## Instruções para teste ##

1) Retorna a lista com todos os pontos de interesse cadastrados

**URL:** /pontos-interesse

**Metodo:** GET

**Resultado**:

Content-Type: application/json;charset=UTF-8

Transfer-Encoding: chunked

Date: Thu, 13 Jul 2017 02:59:21 GMT

[{"id":1,"nome":"Lanchonete","coordenadaX":27,"coordenadaY":12},{"id":2,"nome":"Posto","coordenadaX":31,"coordenadaY":18},{"id":3,"nome":"Joalheria","coordenadaX":15,"coordenadaY":12},{"id":4,"nome":"Floricultura","coordenadaX":19,"coordenadaY":21},{"id":5,"nome":"Pub","coordenadaX":12,"coordenadaY":8},{"id":6,"nome":"Supermercado","coordenadaX":23,"coordenadaY":6},{"id":7,"nome":"Churrascaria","coordenadaX":28,"coordenadaY":2}]

2) Retorna a lista com todos os pontos de interesse por proximidade

**URL:** /pontos-interesse/{coordenadaX}/{coordenadaY}/{distancia}

**Metodo:** GET

**Resultado**

Content-Type: application/json;charset=UTF-8

Transfer-Encoding: chunked

Date: Thu, 13 Jul 2017 03:01:15 GMT

[{"id":1,"nome":"Lanchonete","coordenadaX":27,"coordenadaY":12},{"id":3,"nome":"Joalheria","coordenadaX":15,"coordenadaY":12},{"id":5,"nome":"Pub","coordenadaX":12,"coordenadaY":8},{"id":6,"nome":"Supermercado","coordenadaX":23,"coordenadaY":6}]

3) Inserir novo ponto de interesse

**URL:** /pontos-interesse

**Metodo:** POST

**Body:**

    {
		"nome": "Casa do Cesar",
		"coordenadaX": 35,
		"coordenadaY": 15
	}
	
**Resultado**

Content-Type: application/json;charset=UTF-8

Transfer-Encoding: chunked

Date: Thu, 13 Jul 2017 03:02:40 GMT

{"id":8,"nome":"Casa do Cesar","coordenadaX":35,"coordenadaY":15}

