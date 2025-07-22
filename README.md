# Product Management API - Integrador

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)

## 📋 Descripción

**Integrador** es una API REST desarrollada con Spring Boot para la gestión de productos. Este proyecto forma parte del trabajo práctico integrador final para el curso de Talento Tech. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos a través de endpoints RESTful.

## 🚀 Características

- ✅ **API REST completa** con operaciones CRUD
- ✅ **Respuestas HTTP apropiadas** con códigos de estado correctos
- ✅ **Validación de datos** y manejo de errores
- ✅ **Base de datos MySQL** con JPA/Hibernate
- ✅ **Arquitectura en capas** (Controller, Service, Repository)
- ✅ **Lombok** para reducir código boilerplate
- ✅ **Spring Boot Actuator** para monitoreo
- ✅ **H2 Database** configurada para desarrollo

## 🛠️ Tecnologías Utilizadas

| Tecnología          | Versión | Descripción                           |
| ------------------- | ------- | ------------------------------------- |
| **Java**            | 21      | Lenguaje de programación              |
| **Spring Boot**     | 3.5.3   | Framework principal                   |
| **Spring Data JPA** | -       | Persistencia de datos                 |
| **Spring Web**      | -       | Desarrollo web y REST API             |
| **MySQL**           | 8.0+    | Base de datos principal               |
| **H2 Database**     | -       | Base de datos en memoria (desarrollo) |
| **Lombok**          | -       | Reducción de código boilerplate       |
| **Maven**           | 3.6+    | Gestión de dependencias               |

## 📦 Modelo de Datos

### Product Entity

```java
{
  "id": 1,
  "name": "Producto Ejemplo",
  "description": "Descripción del producto",
  "price": 29.99,
  "category": "Electrónicos",
  "imageUrl": "https://ejemplo.com/imagen.jpg",
  "stock": 100
}
```

## 🌐 API Endpoints

### Base URL: `http://localhost:8080`

| Método   | Endpoint         | Descripción                   | Respuesta                                         |
| -------- | ---------------- | ----------------------------- | ------------------------------------------------- |
| `GET`    | `/products`      | Obtener todos los productos   | `200 OK` + Lista de productos                     |
| `GET`    | `/products/{id}` | Obtener producto por ID       | `200 OK` + Producto / `404 Not Found`             |
| `POST`   | `/products`      | Crear nuevo producto          | `201 Created` + Producto creado                   |
| `PUT`    | `/products/{id}` | Actualizar producto existente | `200 OK` + Producto actualizado / `404 Not Found` |
| `DELETE` | `/products/{id}` | Eliminar producto             | `204 No Content` / `404 Not Found`                |

### Ejemplos de Uso

#### 1. Crear un nuevo producto

```bash
POST /products
Content-Type: application/json

{
  "name": "Smartphone Samsung",
  "description": "Teléfono inteligente con pantalla AMOLED",
  "price": 599.99,
  "category": "Electrónicos",
  "imageUrl": "https://ejemplo.com/samsung.jpg",
  "stock": 50
}
```

#### 2. Obtener todos los productos

```bash
GET /products
```

#### 3. Obtener un producto específico

```bash
GET /products/1
```

#### 4. Actualizar un producto

```bash
PUT /products/1
Content-Type: application/json

{
  "name": "Smartphone Samsung Galaxy S24",
  "description": "Última generación con IA",
  "price": 899.99,
  "category": "Electrónicos",
  "imageUrl": "https://ejemplo.com/samsung-s24.jpg",
  "stock": 30
}
```

#### 5. Eliminar un producto

```bash
DELETE /products/1
```

## ⚙️ Configuración y Instalación

### Prerrequisitos

- Java 21 o superior
- Maven 3.6+
- MySQL 8.0+ (para producción)
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### 1. Clonar el repositorio

```bash
git clone https://github.com/CarlosMilhas/Integrador.git
cd Integrador
```

### 2. Configurar la base de datos

#### Para MySQL (Producción):

1. Crear la base de datos:

```sql
CREATE DATABASE integrador_talento_tech;
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON integrador_talento_tech.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;
```

2. Las configuraciones están en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/integrador_talento_tech?serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=admin
```

#### Para H2 (Desarrollo):

Descomenta las siguientes líneas en `application.properties`:

```properties
spring.h2.console.enabled=true
```

### 3. Compilar y ejecutar

#### Usando Maven:

```bash
# Compilar el proyecto
./mvnw clean compile

# Ejecutar la aplicación
./mvnw spring-boot:run
```

#### Usando Java:

```bash
# Compilar y empaquetar
./mvnw clean package

# Ejecutar el JAR
java -jar target/Integrador-0.0.1-SNAPSHOT.jar
```

### 4. Verificar la instalación

La aplicación estará disponible en: `http://localhost:8080`

Endpoints de salud:

- **Health Check**: `http://localhost:8080/actuator/health`
- **Info**: `http://localhost:8080/actuator/info`

## 🏗️ Arquitectura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/talentoTech/milhas/Integrador/
│   │       ├── IntegradorApplication.java      # Clase principal
│   │       ├── controller/
│   │       │   └── ProductController.java      # Controlador REST
│   │       ├── service/
│   │       │   └── ProductService.java         # Lógica de negocio
│   │       ├── repository/
│   │       │   └── IProductRepository.java     # Acceso a datos
│   │       └── model/
│   │           └── Product.java                # Entidad JPA
│   └── resources/
│       ├── application.properties              # Configuración
│       ├── static/                            # Archivos estáticos
│       └── templates/                         # Plantillas
└── test/
    └── java/                                  # Tests unitarios
```

## 🧪 Testing

### Ejecutar tests

```bash
./mvnw test
```

### Testing manual con cURL

#### Crear producto:

```bash
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop Dell",
    "description": "Laptop para desarrollo",
    "price": 1299.99,
    "category": "Computadoras",
    "imageUrl": "https://ejemplo.com/dell.jpg",
    "stock": 25
  }'
```

#### Obtener productos:

```bash
curl -X GET http://localhost:8080/products
```

## 🚀 Deployment

### Variables de Entorno

Para producción, configura las siguientes variables:

```bash
export SPRING_DATASOURCE_URL=jdbc:mysql://tu-servidor:3306/integrador_talento_tech
export SPRING_DATASOURCE_USERNAME=tu-usuario
export SPRING_DATASOURCE_PASSWORD=tu-password
export SPRING_PROFILES_ACTIVE=prod
```

### Docker (Opcional)

```dockerfile
FROM openjdk:21-jdk-slim
COPY target/Integrador-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 📊 Monitoreo

Spring Boot Actuator proporciona endpoints de monitoreo:

- `/actuator/health` - Estado de la aplicación
- `/actuator/info` - Información de la aplicación
- `/actuator/metrics` - Métricas de rendimiento

## 🤝 Contribuciones

Este es un proyecto académico para Talento Tech. Para contribuir:

1. Fork el proyecto
2. Crea tu rama de feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto es parte del curso de Talento Tech y está destinado para fines educativos.

## 👨‍💻 Autor

**Carlos Milhas**

- GitHub: [@CarlosMilhas](https://github.com/CarlosMilhas)

## 📞 Soporte

Si tienes alguna pregunta o problema:

1. Revisa la documentación
2. Verifica los logs de la aplicación
3. Abre un issue en GitHub

---

**¡Gracias por usar Product Management API!** 🎉
