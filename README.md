# to-dolist
API de gerenciamento de tarefas.

Projeto desenvolvido utilizado as seguintes tecnologias:

- Java 17
  
- Framework Spring Boot v3.4.1
  
- Banco de dados SQL Server
  
- Servidor de aplicação Apache Tomcat v11.0

- Maven 4.0

# Endpoints 

Foi usado o Postman pra chamar os endpoints.

POST -- responsável por acionar a ação de inserção dos dados no banco. Endereço da requisição localhost:8080/tarefa

No body(corpo) da requisição deve-se passar os valores da tarefa da forma a seguir(formato JSON): 
{
    "titulo": "Tarefa 1",
    "descricao": "Tarefa de teste",
    "dataCriacao": "26/01/2025",
    "status":"3"
   }

Importante destacar que o título da tarefa nunca pode estar vazio.

GET -- responsável por listar todos os dados que estão cadastrados no banco. Endereço da requisição localhost:8080/tarefa. Ao executar essa requisição serão listadas todas as tarefas cadastradas no modelo JSON.

DEL -- responsável por excluir uma tarefa que está cadastrada no banco, ao chamar essa requisição deve-se passar o id da tarefa a ser excluída. Endereço da requisição localhost:8080/tarefa/id.

PUT -- responsável por alterar uma tarefa que está cadastrada no banco, só será possível alterar se informar um ida já existente no banco. Endereço da requisição localhost:8080/tarefa. Para executar essa requisição deve-se passar no body da requisição os dados a serem alterados da tarefa e seu id. Exemplo { "id":"1", "titulo": "Tarefa 1", "descricao": "Tarefa de teste",
    "dataCriacao": "26/01/2025", "status":"3"}

# Scripts banco

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
