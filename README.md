# API de Pedidos

Este projeto é uma **API de Pedidos** desenvolvida em **Java 21**, utilizando **Spring Boot** e **Maven**, que simula um gerenciamento de pedidos de usuários, pedidos e produtos.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.3**
- **Maven**
- **Spring Web** → Criação de APIs REST
- **Spring Data JPA** → Persistência e integração com banco de dados
- **Spring Validation** → Validação de dados de entrada
- **PostgreSQL (via Docker)** → Banco de dados relacional utilizado no ambiente de desenvolvimento
- **Jackson** → Serialização/Desserialização de objetos JSON
- **DevTools** → Hot reload em ambiente de desenvolvimento
- **JWT** -> Token de Authenticação
- **Spring Security** -> Login e codificação
- **BCrypt** -> codificação de logins

---

## 📦 Estrutura do Projeto

```

├───.mvn
│   └───wrapper
├───src
  ├───main
  │   ├───java
  │   │   └───com
  │   │       └───lucas_costa
  │   │           └───course                           → Código fonte principal
  │   │               ├───config
  │   │               ├───entities
  │   │               │   ├───enums
  │   │               │   └───pk
  │   │               ├───repositories
  │   │               ├───resources
  │   │               │   └───exceptions
  │   │               ├───services
  │   │               │   └───exceptions
  │   │               └───Swagger
  │   └───resources                                     → Configurações (application.properties)
  │       ├───DB
  │       ├───keys
  │       ├───static
  │       └───templates
  └───test                                              → Testes unitários e de integração
      └───java


```

---

## ⚙️ Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/luxas12300/Sistema-de-pedidos.git
   ```

2. Suba os containers do banco de dados (PostgreSQL) e demais serviços com Docker Compose:
   ```bash
   docker-compose up -d
   ```

3. Compile e execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a aplicação no navegador:
   ```
   http://localhost:8080
   ```

---

## 📖 Documentação de Referência

- [Documentação oficial do Maven](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/3.5.5/maven-plugin)
- [Spring Web](https://docs.spring.io/spring-boot/3.5.5/reference/web/servlet.html)
- [PostgreSQL Docker Image](https://hub.docker.com/_/postgres)
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.5/reference/data/sql.html#data.sql.jpa-and-spring-data)
- [JWT](https://www.jwt.io/)

---

## ✨ Observações

- Caso o projeto utilize credenciais sensíveis (como banco de dados em produção), recomenda-se usar **variáveis de ambiente** ou arquivos externos de configuração ao invés de versionar no Git.

---

## 👨‍💻 Autor

Projeto desenvolvido por **Lucas Costa**.

