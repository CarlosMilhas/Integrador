# Product Management & Order API - Integrador

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)

## 📋 Descripción

**Integrador** es una API REST desarrollada con Spring Boot para la gestión de productos y órdenes. Este proyecto forma parte del trabajo práctico integrador final para el curso de Talento Tech. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos y gestionar órdenes con múltiples productos.

## 🚀 Características

- ✅ **API REST completa** con operaciones CRUD para productos y órdenes
- ✅ **Respuestas HTTP apropiadas** con códigos de estado correctos
- ✅ **Validación de datos** y manejo de errores
- ✅ **Base de datos MySQL** con JPA/Hibernate
- ✅ **Arquitectura en capas** (Controller, Service, Repository)
- ✅ **DTOs especializados** para requests y responses
- ✅ **Relaciones JPA** entre órdenes y productos
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

## 📱 PRODUCTOS

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

#### 4. Buscar productos por nombre

```bash
GET /products/name/Samsung
```

#### 5. Actualizar un producto (partial update)

```bash
PUT /products/1
Content-Type: application/json

{
  "name": "Smartphone Samsung Galaxy S24",
  "price": 899.99,
  "stock": 30
}
```

#### 6. Eliminar un producto

```bash
DELETE /products/1
```

## 🛒 ÓRDENES

#### 1. Crear una nueva orden

```bash
POST /orders
Content-Type: application/json

{
  "orderLines": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 2,
      "quantity": 1
    }
  ]
}
```

**Respuesta:**

```json
{
  "id": 1,
  "orderLines": [
    {
      "id": 1,
      "productId": 1,
      "productName": "Smartphone Samsung",
      "productPrice": 599.99,
      "quantity": 2,
      "subtotal": 1199.98
    },
    {
      "id": 2,
      "productId": 2,
      "productName": "Laptop Dell",
      "productPrice": 1299.99,
      "quantity": 1,
      "subtotal": 1299.99
    }
  ]
}
```

#### 2. Obtener todas las órdenes

```bash
GET /orders
```

#### 3. Obtener una orden específica

```bash
GET /orders/1
```

#### 4. Eliminar una orden

```bash
DELETE /orders/1
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
│   │       ├── IntegradorApplication.java          # Clase principal
│   │       ├── controller/
│   │       │   ├── ProductController.java          # Controlador REST - Productos
│   │       │   └── OrderController.java            # Controlador REST - Órdenes
│   │       ├── service/
│   │       │   ├── ProductService.java             # Lógica de negocio - Productos
│   │       │   └── OrderService.java               # Lógica de negocio - Órdenes
│   │       ├── repository/
│   │       │   ├── IProductRepository.java         # Acceso a datos - Productos
│   │       │   └── IOrderRepository.java           # Acceso a datos - Órdenes
│   │       ├── model/
│   │       │   ├── Product.java                    # Entidad JPA - Producto
│   │       │   ├── Order.java                      # Entidad JPA - Orden
│   │       │   └── OrderLine.java                  # Entidad JPA - Línea de Orden
│   │       ├── dto/
│   │       │   ├── ProductDto.java                 # DTO - Producto
│   │       │   ├── OrderDto.java                   # DTO - Orden (Response)
│   │       │   ├── OrderCreateDto.java             # DTO - Crear Orden (Request)
│   │       │   ├── OrderLineDto.java               # DTO - Línea de Orden (Response)
│   │       │   └── OrderLineCreateDto.java         # DTO - Crear Línea (Request)
│   │       └── exceptions/
│   │           └── NoStockException.java           # Excepción personalizada
│   └── resources/
│       ├── application.properties                  # Configuración
│       ├── static/                                # Archivos estáticos
│       └── templates/                             # Plantillas
└── test/
    └── java/                                      # Tests unitarios
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

**¡Gracias por usar Product Management & Order API!** 🎉
