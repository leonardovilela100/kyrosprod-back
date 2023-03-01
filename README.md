<h1>Projeto Kyros</h1>
<h2>O Projeto Kyros é um sistema de gerenciamento de empréstimos de livros para bibliotecas.</h2>

<h2>Pré-requisitos</h2>
<p>JDK 8 ou superior instalado<p>
<p>Maven instalado</p>

<h2>Como rodar o projeto?</h2>
<p>Antes de tudo, é necessário ter instalado na sua máquina o Java 11 e o Maven. Em seguida, siga os seguintes passos:<p>

<h2>Instalação</h2>
<p>Clone o repositório: git clone https://github.com/seu-usuario/nome-do-projeto.git</p>
<p>Acesse o diretório do projeto: cd nome-do-projeto</p>
<p>Execute o comando mvn install para compilar e empacotar o projeto</p>

<h2>Configuração do Banco de Dados</h2>
<p>O banco de dados utilizado neste projeto é o H2. Ele é um banco de dados em memória, que é criado e populado automaticamente durante a inicialização da aplicaçã</p>


<h2>Executando a Aplicação</h2>
<p>Para executar a aplicação, basta executar o seguinte comando:</p>
<p>java -jar target/nome-do-projeto.jar</p>

<h4>A aplicação estará rodando em http://localhost:8080.</h4>

| Método | URL | Descrição |
| -------- | -------- | -------- |
| GET  |/api/produtos  | Retorna todos os produtos cadastrados |
| POST  | /api/produtos | 	Cadastra um novo produto  |
| PATCH  |	/api/produtos/{id} | 	Ativar um produto  |
| PATCH  |	/api/produtos/{id} | 	Desativar um produto  |
| DELETE  |		/api/produtos/{id} | 	Exclui um produto específico  |

<h2>Formato do JSON</h2>
<h3>Cadastrar Produto</h3>

```json

{
  "nome": "João",
  "sobrenome": "Silva",
  "idade": 30
}
```

<h2>Utilizando a API</h2>
<p>Para utilizar a API, basta acessar a URL http://localhost:8080/api/produtos utilizando uma ferramenta como o Postman ou o cURL.</p>

<h2> </h2>
<p> </p>
