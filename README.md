# Auth API

Una API de autenticación basada en **JWT** con control de **roles**. Permite a los usuarios registrarse y loguearse usando email y contraseña. Al registrarse, se asigna un rol (por defecto `USER` si no se especifica).

##  Funcionalidades principales

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

##  Cómo levantar el proyecto con Docker

1. Asegurate de tener configuradas las variables de entorno en el archivo `docker-compose.yml` (por ejemplo: usuario y contraseña de la base de datos, secret key para JWT, etc).

2. Ejecuta:

```
mvn clean package -DskipTests
docker build -t authapi .
docker-compose up --build
```
3. Probar la API:
Una vez levantado el proyecto, accedé a Swagger para probar los endpoints:

##  Endpoints 

| Endpoint              | Método | Descripción                   | Rol necesario |
|-----------------------|--------|-------------------------------|---------------|
| `/api/auth/register`   | POST   | Registrar nuevo usuario        | Público       |
| `/api/auth/login`      | POST   | Login y obtener token JWT      | Público       |
| `/api/test/public`     | GET    | Endpoint de prueba pública     | Público       |
| `/api/test/user`       | GET    | Endpoint para USER             | USER          |
| `/api/test/admin`      | GET    | Endpoint para ADMIN            | ADMIN         |


👉 http://localhost:8080/swagger-ui/index.html
4. Autenticación con Bearer Token en Swagger

    
En la interfaz de Swagger: 
- Click en el botón Authorize (arriba a la derecha). 
- Ingresá:
Bearer <TU_TOKEN>
(y presioná Authorize).