# OinoBackendDraft1
draft 1, testing micronaut

## 📘 Tech Stack and Architecture Guide for KMP Vocabulary App Backend

### 🔧 Project Overview
- **Client**: Kotlin Multiplatform (KMP) app to learn Basque through vocabulary quizzes
- **Backend Goal**: Provide vocabulary list updates and save user progress
- **Target Skills**: Java/Kotlin backend, Microservices, Cloud, Performance, Micronaut, Kafka, Observability

---

### ✅ Recommended Tech Stack

#### ⚙️ Backend Framework
- **Micronaut (Kotlin)**
  - Fast startup, low memory, ideal for microservices
  - Natively supports DI, AOT compilation, and GraalVM native image
  - Alternative: Spring Boot (for more jobs, heavier but richer ecosystem)

#### ☕ JVM & Language
- **Java 21** (LTS, modern features)
  - Micronaut fully supports it
  - Use with Kotlin for idiomatic DSLs and shared KMP logic

#### 🧪 Testing
- **JUnit 5 + Micronaut Test**
- Optional: **Testcontainers** (needs working Docker)

#### 📦 Build Tool
- **Gradle Kotlin DSL** (modern and native for Kotlin devs)

#### 🐬 Database
- **MariaDB** (or MySQL)
  - Supported in Micronaut via JDBC
  - Can be run locally via Docker or managed cloud service
  - Dev-only: H2 (in-memory, no setup)

#### 📡 HTTP Client
- **Micronaut HTTP Client** (included feature)
  - For calling external APIs if needed

#### 🐳 Docker / CI
- **Docker** for dev/prod containers
- **Docker Compose** for local MariaDB setup
- **GitLab CI** for pipelines (target company uses GitLab)

#### 📊 Observability
- **Grafana + Loki** (target job stack)
  - Optional: Prometheus, Micrometer, OpenTelemetry

#### 🔁 Messaging
- **Kafka** (bonus skill)
  - Not required early, but valuable for scaling

---

### 🏗️ Project Structure Guidelines

#### Shared Code
- Use **KMP Shared Module** for:
  - Data models (e.g., `VocabItem`, `ProgressDto`)
  - Serialization-compatible classes (`@Serializable`)

#### Backend
- Separate domain logic from HTTP/controllers
- Use services (`@Singleton`) for business logic
- Add database layer using Micronaut Data or Exposed ORM

#### Dev Setup
- Run MariaDB locally (via Docker or native install)
- Keep Micronaut `application.properties` tidy:
  ```properties
  datasources.default.url=jdbc:mariadb://localhost:3306/vocabdb
  datasources.default.username=your_user
  datasources.default.password=your_pass
  ````
- Disable Micronaut test resources if not using Docker:
  ```properties
  micronaut.test.resources.enabled=false
  ```

#### Docker Compose Example
```yaml
version: '3.8'
services:
  mariadb:
    image: mariadb:11
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: **
      MYSQL_DATABASE: vocabdb
      MYSQL_USER: vocabuser
      MYSQL_PASSWORD: **
    ports:
      - "3306:3306"
```

---

### 📈 Growth-Oriented Features
- Add JWT authentication (Micronaut Security)
- Add `/progress` endpoint to persist user data
- Add OpenAPI support (Micronaut Swagger)
- Containerize backend with Docker
- Deploy on Fly.io or Railway.app (for cheap cloud hosting)

---

### 🏁 Final Tips
- Use Java 21 unless targeting native image (Java 17 safer there)
- Avoid unused features (like Kafka) early — layer in later
- If you add Docker, ensure `docker run hello-world` works first
- For any Micronaut errors, check `application.properties` and disable test-resources if Docker isn’t running


## Micronaut 4.9.1 Documentation

- [User Guide](https://docs.micronaut.io/4.9.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.9.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.9.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://gradleup.com/shadow/)
## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Feature ksp documentation

- [Micronaut Kotlin Symbol Processing (KSP) documentation](https://docs.micronaut.io/latest/guide/#kotlin)

- [https://kotlinlang.org/docs/ksp-overview.html](https://kotlinlang.org/docs/ksp-overview.html)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#nettyHttpClient)


## Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)

