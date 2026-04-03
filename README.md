# Password Validator — Desafio Técnico

Descrição
- Projeto Java Spring Boot que implementa uma API para validação de senhas.

Repositório
- URL: `https://github.com/JuliiaSerena/password-validator.git`
- Branch: `master`
- Artifact: `password-validator` (versão `0.0.1-SNAPSHOT`)

Stack e dependências principais
- Java 17
- Spring Boot (parent `4.0.5`)
- Spring Web / Actuator / Spring Data REST
- springdoc-openapi (Swagger UI)
- Lombok
- SLF4J
- Build: Maven

Pré-requisitos (Windows)
- JDK 17 instalado e variável `JAVA_HOME` configurada
- Maven instalado (`mvn` disponível no PATH)
- IntelliJ IDEA 2025.1.2 (recomendado) com plugin Lombok ou annotation processing ativado

Como rodar (linha de comando)
1. Clonar o repositório:
    - `git clone https://github.com/JuliiaSerena/password-validator.git`
2. Executar em modo desenvolvimento:
    - `mvn spring-boot:run`
3. Gerar pacote e executar:
    - `mvn clean package`
    - `java -jar target/password-validator-0.0.1-SNAPSHOT.jar`

Testes
- Executar testes unitários:
    - `mvn test`

Documentação da API
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- Actuator (ex.: health): `http://localhost:8080/actuator/health`

Observações técnicas e decisões
- Uso do Springdoc para documentação automática das rotas \- facilita a avaliação do comportamento da API.
- Lombok para reduzir boilerplate; lembre-se de habilitar annotation processing na IDE.
- Dependências escolhidas para alinhar com padrões usados em aplicações corporativas.

Contato
- GitHub: `JuliiaSerena`
