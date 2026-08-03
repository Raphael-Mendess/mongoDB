# MongoDB NoSQL Workshop

API REST de um sistema de blog (usuários, posts e comentários), desenvolvida com **Spring Boot** e **MongoDB**. O projeto é um workshop prático sobre bancos de dados **NoSQL orientados a documentos**, explorando referências (`@DBRef`) e documentos aninhados (embutidos).

## 🚀 Tecnologias

- **Java 25**
- **Spring Boot 4.0.4**
  - Spring Web MVC
  - Spring Data MongoDB
- **MongoDB** (banco de dados NoSQL orientado a documentos)
- **Maven**

## 📦 Estrutura do domínio

```
com.raphael.workshopmongo
├── domain               # Documentos MongoDB (User, Post)
├── dto                    # Objetos de transferência (UserDTO, AuthorDTO, CommentDTO)
├── repository            # Interfaces Spring Data MongoDB
├── resources              # Controllers REST
│   ├── exception          # Tratamento de exceções da API
│   └── util                # Utilitários (parsing de URL/data)
├── services                # Regras de negócio
│   └── exception           # Exceções de serviço
└── config                   # Carga inicial de dados (seed)
```

### Modelagem

O projeto ilustra dois padrões comuns de modelagem em bancos NoSQL:

- **`User`** é um `@Document` (coleção própria no MongoDB) e mantém uma lista de `Post` via **`@DBRef`** (referência a outra coleção).
- **`Post`** não é uma coleção separada visível diretamente pela API — ele guarda o autor (`AuthorDTO`) e a lista de comentários (`CommentDTO`) como **documentos embutidos** (embedded), sem precisar de outra coleção para os comentários.

| Classe | Tipo | Descrição |
|---|---|---|
| `User` | Document | Usuário do blog, com nome, e-mail e lista de posts |
| `Post` | Domain | Post do blog: título, corpo, data, autor e comentários |
| `AuthorDTO` | DTO | Representação simplificada do autor (id + nome) |
| `CommentDTO` | DTO | Comentário embutido em um post (texto, data, autor) |
| `UserDTO` | DTO | Representação simplificada de usuário (sem a lista de posts) |

## 🔌 Endpoints disponíveis

### Usuários — `/users`
| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/users` | Lista todos os usuários |
| GET | `/users/{id}` | Busca um usuário por ID |
| GET | `/users/{id}/posts` | Lista os posts de um usuário |
| POST | `/users` | Cria um novo usuário |
| PUT | `/users/{id}` | Atualiza um usuário existente |
| DELETE | `/users/{id}` | Remove um usuário |

### Posts — `/posts`
| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/posts/{id}` | Busca um post por ID |
| GET | `/posts/titlesearch?text=` | Busca posts pelo título (busca parcial) |
| GET | `/posts/fullsearch?text=&minDate=&maxDate=` | Busca completa: por texto (título/corpo/comentários) e intervalo de datas |

## ⚙️ Configuração

```properties
spring.mongodb.uri=mongodb://localhost:27017/workshop_mongo
```

A aplicação se conecta a uma instância do MongoDB rodando localmente na porta padrão (`27017`), utilizando o banco `workshop_mongo`.

### Carga inicial de dados

Ao iniciar, a aplicação executa a classe `Instantiation` (`CommandLineRunner`), que **limpa as coleções existentes** e insere dados de exemplo: 3 usuários (Batman, Raphael e Joker) e 2 posts com comentários, para facilitar os testes da API.

## ▶️ Como executar

### Pré-requisitos
- Java 25 instalado
- Maven (ou use o Maven Wrapper, se presente no projeto)
- Uma instância do **MongoDB** rodando em `localhost:27017` (pode ser local ou via Docker)

Subir um MongoDB rapidamente com Docker, se necessário:
```bash
docker run -d -p 27017:27017 --name mongo-workshop mongo
```

### Passos

Clone o repositório:
```bash
git clone https://github.com/Raphael-Java/mongodb-nosql.git
cd mongodb-nosql
```

Execute a aplicação:
```bash
mvn spring-boot:run
```

Por padrão, a aplicação roda em:
```
http://localhost:8080
```

## 🧪 Testes

```bash
mvn test
```

## 📌 Status do projeto

Projeto de estudo (workshop), com o objetivo de praticar modelagem de dados em MongoDB usando Spring Data (referências com `@DBRef` e documentos embutidos), além de busca textual e por intervalo de datas.

## 👤 Autor

Desenvolvido por Raphael Alvim.
