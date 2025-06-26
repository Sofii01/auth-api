# Auth API

Una API de autenticación basada en **JWT** con control de **roles**. Permite a los usuarios registrarse y loguearse usando email y contraseña. Al registrarse, se asigna un rol (por defecto `USER` si no se especifica).

## ✨ Funcionalidades principales

- Registro de usuario con email, password y rol.
- Login con email y password para obtener un token **JWT**.
- Control de acceso a endpoints según rol (`ADMIN`, `USER`).
- Documentación interactiva con **Swagger**.

## 🚀 Tecnologías y herramientas

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **JPA / Hibernate**
- **MySQL**
- **MapStruct**
- **Maven**
- **Docker / Docker Compose**
- **Swagger (springdoc-openapi)**

## 🐳 Cómo levantar el proyecto con Docker

1️⃣ Asegurate de tener configuradas las variables de entorno en el archivo `docker-compose.yml` (por ejemplo: usuario y contraseña de la base de datos, secret key para JWT, etc).

2️⃣ Ejecutá:

```bash
mvn clean package -DskipTests
docker build -t authapi .
docker-compose up --build
