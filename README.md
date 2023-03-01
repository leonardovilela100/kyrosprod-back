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
<p>O banco de dados utilizado neste projeto é o H2. Ele é um banco de dados em memória, o qual é criado e populado automaticamente durante a inicialização da aplicação</p>


<h2>Executando a Aplicação</h2>
<p>Para executar a aplicação, basta executar o seguinte comando:</p>
<p>java -jar target/nome-do-projeto.jar </p>



<h4>A aplicação estará rodando em http://localhost:8080.</h4>




-----------------------------------------------------------------------------------------------



<h1> (1) Rota de Usuários </h1>

| Método | URL | Descrição |
| -------- | -------- | -------- |
| GET  | /api/usuarios  | Retorna todos os usuários cadastrados com paginação|
| POST  | /api/usuarios | 	Cadastra um novo usuário  |
| PATCH  |	/api/usuarios/ativar/{id} | 	Ativar um usuário  |
| PATCH  |	/api/usuarios/desativar/{id} | 	Desativar um usuário  |
| DELETE  |		/api/usuarios/{id} | 	Exclui um usuário específico  |

<h2>Formato do JSON</h2>
<h3>Cadastrar Usuário</h3>

```json

{
  "nome": "João",
  "tipo_usuario": "professor",
  "cpf": "118.834.248-79"
}
```
<h2>Rota de API para busca paginada </h2>

<p>Esta rota de API é usada para buscar Usuários paginados, permitindo que o usuário especifique quantos itens por página e qual página ele quer visualizar. Os parâmetros suportados são:</p>

- page: número da página a ser visualizada (padrão: 1)
- size: quantidade de itens por página (padrão: 10)
- sortBy: nome do campo a ser usado para ordenar os resultados (padrão: id)
- sortOrder: direção da ordenação (ascendente ou descendente, padrão: asc)

 <h4>OUTROS FILTROS </h4>

- ativo: False ou True, para retornar usuários que estão desativados ou ativados 
- id: Codigo
- nomedousuario: Busca pelo nome do usuário 
- tipo_usuario: Busca pelo tipo do usuário, se ele é professor ou aluno 

<h4>Exemplo de requisição:</h4>
<p> GET/api/usuarios?page=0&size=20&page=0&ativo=false&id=iddosuario&nome=nomedousuario&tipo_usuario=professor </p>
<p> GET /api/usuarios?page=0&size=20&sortBy=name&sortOrder=desc </p>

-----------------------------------------------------------------------------------------------

<h1> (2) Rota do livro </h1>

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
  "autor": "Paul Deitel ",
  "editora": "Pearson Education do Brasil S.A",
  "ano_edicao": "10/05/2016"
}
```

<h2>Rota da API para busca paginada </h2>

<p>Esta rota de API é usada para buscar Livros paginados, permitindo que o usuário especifique quantos itens por página e qual página ele quer visualizar. Os parâmetros suportados são:</p>

- page: Número da página a ser visualizada (padrão: 1)
- size: Quantidade de itens por página (padrão: 10)
- sortBy: Nome do campo a ser usado para ordenar os resultados (padrão: id)
- sortOrder: Direção da ordenação (ascendente ou descendente, padrão: asc)

 <h4>OUTROS FILTROS </h4>

- emprestado:  False ou True, para retornar livros emprestados
- codigo: Busca pelo Código do Livro 
- titulo: Busca pelo título
- autor: Busca pelo autor do livro

<h4>Exemplo de requisição:</h4>
<p> GET/api/livros?page=0&size=20&page=0&emprestado=false&codigo=codigodolivro&titulo=titulodolivro&autor=autordolivro </p>
<p> GET /api/livros?page=0&size=20&sortBy=name&sortOrder=desc</p>



--------------------------------------------------------------------------------------------------------------------------------------


<h1> (3) Rota de Ebook </h1>

| Método | URL | Descrição |
| -------- | -------- | -------- |
| GET  | /api/ebooks  | Retorna todos os ebooks cadastrados com paginação |
| POST  | /api/ebooks | 	Cadastra um novo ebook  |
| PATCH  |	/api/ebooks/ativar/{id} | 	Ativar um ebook  |
| PATCH  |	/api/ebooks/desativar/{id} | 	Desativar um ebook  |
| DELETE  |		/api/ebooks/{id} | 	Exclui um ebook específico  |

<h2>Formato do JSON</h2>
<h3>Cadastrar Ebook</h3>

```json

{
  "titulo": "Java para Iniciantes",
  "autor": "Luiz Duarte ",
  "ano_edicao": "2017",
  "url": "https://www.amazon.com.br/Java-para-Iniciantes-Luiz-Duarte-ebook/dp/B01MY7VBE5"
  "numero": 45578,
}
```

<h2>Rota da API para busca paginada </h2>

<p>Esta rota de API é usada para buscar Ebooks paginados, permitindo que o usuário especifique quantos itens por página e qual página ele quer visualizar. Os parâmetros suportados são:</p>

- page: Número da página a ser visualizada (padrão: 1)
- size: Quantidade de itens por página (padrão: 10)
- sortBy: Nome do campo a ser usado para ordenar os resultados (padrão: id)
- sortOrder: Direção da ordenação (ascendente ou descendente, padrão: asc)

 <h4>OUTROS FILTROS </h4>

- emprestado:  False ou True, para retornar ebooks que estão emprestados
- codigo: Busca pelo Código do Ebook 
- titulo: Busca pelo título
- autor: Busca pelo autor do Ebook

<h4>Exemplo de requisição:</h4>
<p> GET/api/ebooks?page=0&size=20&page=0&emprestado=false&codigo=codigodoebook&titulo=titulodoebook&autor=autordoebook </p>
<p> GET /api/ebooks?page=0&size=20&sortBy=name&sortOrder=desc</p>



-----------------------------------------------------------------------------------------------

<h1> (4) Rota de Revista </h1>

| Método | URL | Descrição |
| -------- | -------- | -------- |
| GET  | /api/revistas  | Retorna todos as revistas cadastradas com paginação |
| POST  | /api/revistas | 	Cadastra uma nova revistas  |
| PATCH  |	/api/revistas/ativar/{id} | 	Ativar uma revista  |
| PATCH  |	/api/revistas/desativar/{id} | 	Desativar uma revista  |
| DELETE  |		/api/revistas/{id} | 	Exclui uma revista específica  |

<h2>Formato do JSON</h2>
<h3>Cadastrar Revista</h3>

```json

{
  "titulo": "Revista Programar",
  "ano_edicao": "2023",
  "numero": 45578,
}
```

<h2>Rota da API para busca paginada </h2>

<p>Esta rota de API é usada para buscar Revistas paginadas, permitindo que o usuário especifique quantos itens por página e qual página ele quer visualizar. Os parâmetros suportados são:</p>

- page: Número da página a ser visualizada (padrão: 1)
- size: Quantidade de itens por página (padrão: 10)
- sortBy: Nome do campo a ser usado para ordenar os resultados (padrão: id)
- sortOrder: Direção da ordenação (ascendente ou descendente, padrão: asc)

 <h4>OUTROS FILTROS </h4>

- emprestado:  False ou True, para retornar revistas que estão emprestadas
- codigo: Busca pelo Código da Revista 
- titulo: Busca pelo título da Revista
- ano_edicao: Busca pelo ano da Revista
<h4>Exemplo de requisição:</h4>
<p> GET/api/revistas?page=0&size=20&page=0&emprestado=false&codigo=codigodarevista&titulo=titulodarevista&ano_edicao=anodarevista </p>
<p> GET /api/revistas?page=0&size=20&sortBy=name&sortOrder=desc</p>

-----------------------------------------------------------------------------------------------




<h1> (5) Rota de Empréstimo </h1>

| Método | URL | Descrição |
| -------- | -------- | -------- |
| GET  | /api/locacao/emprestimos  | Retorna todos os empréstimos |
| POST  |/api/locacao/emprestimos | 	Cadastra um novo empréstimo |
| POST  | /api/locacao/devolucao/{id} | Finaliza o empréstimo do produto  |

<h2>Formato do JSON</h2>
<h3>Cadastrar um Empréstimo</h3>

```json

{
  "tipo_produto": "revista",
  "codigo_produto": "1",
  "id_usuario": 1,
}
```
<h4>“Obs”: Envio padrão do codigo_produto: (revista, ebook, livro) </h4>




-----------------------------------------------------------------------------------------------






<h2>Utilizando a API</h2>
<p>Para utilizar a API, basta acessar a URL http://localhost:8080/api/rotas_disponiveis_acima utilizando uma ferramenta como o Postman ou o cURL.</p>
