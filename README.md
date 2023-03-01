Projeto Kyros
O Projeto Kyros é um sistema de gerenciamento de empréstimos de livros para bibliotecas.

Como rodar o projeto?
Antes de tudo, é necessário ter instalado na sua máquina o Java 11 e o Maven. Em seguida, siga os seguintes passos:

Clone o repositório na sua máquina usando o comando abaixo:
bash
Copy code
git clone https://github.com/seu-usuario/projeto-kyros.git
Navegue até a pasta do projeto:
bash
Copy code
cd projeto-kyros
Compile o projeto com o Maven:
java
Copy code
mvn clean package
Inicie a aplicação:
bash
Copy code
java -jar target/projeto-kyros-1.0.0.jar
A aplicação estará rodando em http://localhost:8080.

Rotas disponíveis
GET /livros
Retorna a lista de todos os livros cadastrados no sistema.

POST /livros
Cadastra um novo livro no sistema. Deve ser enviado um JSON com os seguintes campos:

json
Copy code
{
  "titulo": "Livro 1",
  "autor": "Autor 1",
  "isbn": "978-3-16-148410-0",
  "editora": "Editora 1",
  "anoPublicacao": 2022
}
GET /livros/{id}
Retorna as informações de um livro específico, identificado pelo seu ID.

PUT /livros/{id}
Atualiza as informações de um livro específico, identificado pelo seu ID. Deve ser enviado um JSON com os seguintes campos:

json
Copy code
{
  "titulo": "Livro 2",
  "autor": "Autor 2",
  "isbn": "978-3-16-148410-1",
  "editora": "Editora 2",
  "anoPublicacao": 2021
}
DELETE /livros/{id}
Remove um livro específico, identificado pelo seu ID.

GET /emprestimos
Retorna a lista de todos os empréstimos cadastrados no sistema.

POST /emprestimos
Realiza um novo empréstimo de um livro para um usuário. Deve ser enviado um JSON com os seguintes campos:

json
Copy code
{
  "codigoLivro": 1,
  "idUsuario": 1,
  "tipo": "COMUM"
}
PUT /emprestimos/{id}
Realiza a devolução de um empréstimo específico, identificado pelo seu ID.

Tecnologias utilizadas
Java 11
Spring Boot
Spring Data JPA
Hibernate
H2 Database
Maven
Contribuindo
Sinta-se à vontade para contribuir com o projeto! Basta fazer um fork do repositório, fazer as modificações que desejar e enviar um pull request.

Licença
Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para obter mais informações.