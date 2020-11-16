# api-pismo
Teste prático aplicado pela empresa Pismo para criação de uma API de Rotina de Transações

# Como a API funciona?

De acordo com os requisitos informados, a API deve criar uma conta, consultar uma conta de acordo com um ID informado e criar uma transação.
Os endpoints são:


`POST /accounts`: **(criação de uma conta)**  

`Request Body:
{ 
"document_number": "12345678900" 
}`  

*Retorna um 201 em caso de sucesso.*

 
`GET /accounts/:accountId`: **(consulta de informações de uma conta específica a partir do código de uma conta)**   

`Response Body: 
{ 
"account_id": 1, 
"document_number": "12345678900" 
}`  

*Retorna 200 em caso de sucesso*

`POST /transactions`: **(criação de uma transação)**  

`Request Body: 
{ 
"account_id": 1, 
"operation_type_id": 4, 
"amount": 123.45 
}`  
*Retorna um 201 em caso de sucesso.*  

# Execução:
Para rodar a API, utilizei o Eclipse e o Postman.  
No Eclipse: executar o projeto e logo após a conclusão da execução, rodar os endpoints informados no Postman.  
Não é necessário se preocupar com Banco de Dados pois o Spring Boot cria um banco em memória no momento da execução do projeto.  

Para construir a API, utilizei a linguagem Java e o Spring Boot.
O motivo dessa escolha foi que a Linguagem Java eu já utilizo a bastante tempo nas empresas e tenho mais conhecimento e experiência.
E o Spring Boot eu aprendi para a realização do teste da Pismo.
A respeito do Spring Boot, pesquisei e aprendi que com ele é mais rápido iniciar uma aplicação do zero. 
E também quis me desafiar a aprender uma tecnologia nova com um prazo definido.

Adotei o desenvolvimento em camadas por ser mais fácil o entendimento e a manutenção. 
E também por vir ao longo desses anos trabalhando com esse modelo. É muito mais fácil trabalhar assim e a codificação fica mais enxuta. 

