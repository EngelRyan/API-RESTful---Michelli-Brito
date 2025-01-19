# API Restful de Produtos

Este projeto foi desenvolvido em colaboração com a Desenvolvedora Michelli Brito. O objetivo foi criar uma API Restful para gerenciar produtos, utilizando o Spring Boot e seguindo as boas práticas recomendadas para construção de APIs escaláveis e eficientes.

### Descrição

A API foi construída para gerenciar produtos em um sistema de e-commerce ou inventário. Ela segue os princípios de maturidade de Richardson (Level 3), o que significa que a API foi projetada com a utilização de HTTP corretamente, estrutura de URLs bem definidas e a implementação de HATEOAS, que oferece uma navegação mais intuitiva e dinâmica entre os recursos expostos pela API.

### Funcionalidades

A API permite as seguintes operações:

- **POST /products**: Criação de um novo produto.
- **GET /products**: Retorna a lista de todos os produtos.
- **GET /products/{id}**: Retorna um produto específico pelo ID.
- **PUT /products/{id}**: Atualiza as informações de um produto existente.
- **DELETE /products/{id}**: Deleta um produto específico.

A API foi projetada com foco em simplicidade e aderência aos padrões RESTful, além de garantir uma boa experiência para o desenvolvedor e facilidade de integração.

### Principais Tecnologias Utilizadas

- **Spring Boot**: Framework utilizado para a construção da API. O Spring Boot facilita a criação de aplicações Java com a mínima configuração, proporcionando rapidez no desenvolvimento.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar as informações dos produtos. A API foi configurada para conectar-se ao PostgreSQL, utilizando o Spring Data JPA para manipulação de dados.
- **HATEOAS**: A API implementa HATEOAS (Hypermedia as the engine of application state) para proporcionar links dinâmicos entre os recursos. Isso melhora a navegabilidade e torna a API mais intuitiva, permitindo que os clientes da API descubram automaticamente as operações disponíveis em cada recurso.
- **Lombok**: A biblioteca Lombok foi utilizada para reduzir a quantidade de código boilerplate, simplificando a criação de getters, setters, construtores, `toString`, entre outros, com anotações simples.
- **BeanUtils**: Utilizamos o `BeanUtils.copyProperties()` para converter objetos DTOs em modelos de entidades, simplificando a implementação dos métodos da API.
- **JPA (Java Persistence API)**: A API foi construída para interagir com o banco de dados utilizando o Spring Data JPA, o que facilita a persistência e manipulação dos dados.
- **Validation**: Utilização de anotações de validação (`@Valid`, `@NotNull`, etc.) para garantir que os dados recebidos nas requisições estejam no formato correto, proporcionando maior segurança e confiabilidade na aplicação.

### Conhecimentos e Práticas Testadas

Ao longo deste projeto, foram testadas e aplicadas diversas boas práticas para o desenvolvimento de uma API robusta e eficiente, tais como:

- **Boas práticas RESTful**: Organização adequada das rotas, uso correto dos métodos HTTP (GET, POST, PUT, DELETE), e implementação de códigos de status HTTP apropriados.
- **Segurança e validação**: Utilização de validação de entradas com JSR-303/JSR-380, garantindo que os dados inseridos sejam válidos e minimizando erros na aplicação.
- **Estrutura de projetos Spring Boot**: Implementação do Spring Boot para garantir uma arquitetura limpa e modularizada, com separação de responsabilidades entre camadas (controllers, services, repositories).
- **Integração com banco de dados**: Conexão e integração com o PostgreSQL utilizando o Spring Data JPA, com foco em facilitar a manipulação e persistência de dados no banco.
- **Documentação**: Embora não implementado neste momento, a utilização de bibliotecas como o Swagger ou Springdoc para documentar a API de maneira automática é uma boa prática a ser considerada.

### Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/EngelRyan/API-RESTful---Michelli-Brito.git
   
2. Configure as variáveis de ambiente do banco de dados (por exemplo, no **application.properties** ou **application.yml**) para conectar ao seu banco **PostgreSQL**.
