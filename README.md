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

<h1> (1) Rota de usuarios </h1>

| Método | URL | Descrição |
| -------- | -------- | -------- |
| GET  | /api/usuarios  | Retorna todos os usuarios cadastrados com paginação|
| POST  | /api/usuarios | 	Cadastra um novo usuario  |
| PATCH  |	/api/usuarios/ativar/{id} | 	Ativar um usuario  |
| PATCH  |	/api/usuarios/desativar/{id} | 	Desativar um usuario  |
| DELETE  |		/api/usuarios/{id} | 	Exclui um usuario específico  |

<h2>Formato do JSON</h2>
<h3>Cadastrar Usuario</h3>

```json

{
  "nome": "João",
  "tipo_usuario": "professor",
  "cpf": "118.834.248-79"
}
```
<h2>Rota de API para busca paginada </h2>

<p>Esta rota de API é usada para buscar itens paginados, permitindo que o usuário especifique quantos itens por página e qual página ele quer visualizar. Os parâmetros suportados são:</p>

- page: número da página a ser visualizada (padrão: 1)
- size: quantidade de itens por página (padrão: 10)
- sortBy: nome do campo a ser usado para ordenar os resultados (padrão: id)
- sortOrder: direção da ordenação (ascendente ou descendente, padrão: asc)

<h4>Exemplo de requisição:</h4>
<p> GET/api/usuarios?page=2&size=20&page=0&ativo=false&id=1&tipo_usuario=professor& </p>
<p> GET /api/usuarios?page=2&size=20&sortBy=name&sortOrder=desc </p>


<h1> (2) Rota de Livros </h1>

| Método | URL | Descrição |
| -------- | -------- | -------- |
| GET  | /api/livros  | Retorna todos os livros cadastrados com paginação |
| POST  | /api/livros | 	Cadastra um novo livro  |
| PATCH  |	/api/livros/ativar/{id} | 	Ativar um livro  |
| PATCH  |	/api/livros/desativar/{id} | 	Desativar um livro  |
| DELETE  |		/api/livros/{id} | 	Exclui um livro específico  |

<h2>Formato do JSON</h2>
<h3>Cadastrar Livro</h3>

```json

{
  "titulo": "Java Como Programar",
  "autor": ", Paul Deitel ",
  "editora": "Pearson Education do Brasil S.A"
}
```
<h2>Rota de API para busca paginada </h2>

<p>Esta rota de API é usada para buscar itens paginados, permitindo que o usuário especifique quantos itens por página e qual página ele quer visualizar. Os parâmetros suportados são:</p>

- page: número da página a ser visualizada (padrão: 1)
- size: quantidade de itens por página (padrão: 10)
- sortBy: nome do campo a ser usado para ordenar os resultados (padrão: id)
- sortOrder: direção da ordenação (ascendente ou descendente, padrão: asc)

<h4>Exemplo de requisição:</h4>
<p> GET/api/usuarios?page=2&size=20&page=0&ativo=false&id=1&tipo_usuario=professor& </p>
<p> GET /api/usuarios?page=2&size=20&sortBy=name&sortOrder=desc </p>












<h2>Utilizando a API</h2>
<p>Para utilizar a API, basta acessar a URL http://localhost:8080/api/produtos utilizando uma ferramenta como o Postman ou o cURL.</p>

<h2> </h2>
<p> </p>
