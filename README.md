# to-dolist
API de gerenciamento de tarefas.

Projeto desenvolvido em Java usando o framework Spring Boot e banco de dados SQL Server. 

Endpoints -- Foi usado o Postman pra chamar os endpoints.

POST localhost:8080/tarefa

GET localhost:8080/tarefa

DEL localhost:8080/tarefa/id

PUT localhost:8080/tarefa

Scripts banco

create database bdtarefa;

use bdtarefa;

CREATE TABLE tarefa (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    titulo NVARCHAR(200) NOT NULL,
    descricao TEXT NULL,
    data_criacao DATETIME NOT NULL DEFAULT GETDATE(),
	status smallint
);

Além disso, é preciso alterar o nome do servidor do SQL Server no atributo "spring.datasource.url" do arquivo application.properties que está dentro do pacote resources.
