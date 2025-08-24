# Gestión de Productos y Pedidos - API REST

API desarrollada con Spring Boot que permite administrar un catálogo de productos y procesar pedidos.


## 📌 Características principales

- Operaciones CRUD completas para productos
- Gestión de pedidos con múltiples items
- Validación de datos y manejo de errores
- Base de datos MySQL con JPA/Hibernate
- Documentación de API incluida

## 🛠 Tecnologías utilizadas

- **Backend**: Java 21 + Spring Boot 3.5
- **Base de datos**: MySQL 8 (producción) / H2 (desarrollo)
- **Herramientas**: Maven, Lombok, MapStruct
- **Documentación**: OpenAPI/Swagger

## 📚 Documentación de la API

### Productos

| Método | Endpoint         | Descripción                    |
| ------ | ---------------- | ------------------------------ |
| GET    | `/products`      | Obtener todos los productos    |
| POST   | `/products`      | Crear nuevo producto           |
| GET    | `/products/{id}` | Obtener un producto específico |
| PUT    | `/products/{id}` | Actualizar producto            |
| DELETE | `/products/{id}` | Eliminar producto              |

### Pedidos

| Método | Endpoint       | Descripción              |
| ------ | -------------- | ------------------------ |
| POST   | `/orders`      | Crear nuevo pedido       |
| GET    | `/orders`      | Listar todos los pedidos |
| GET    | `/orders/{id}` | Obtener pedido por ID    |

## 🔧 Configuración

1. Clonar repositorio:

   ```bash
   git clone https://github.com/tu-usuario/proyecto.git
   cd proyecto

    Configurar la base de datos en src/main/resources/application.properties:
    properties
   ```

spring.datasource.url=jdbc:mysql://localhost:3306/talentotech
spring.datasource.username=usuario
spring.datasource.password=contraseña

Ejecutar la aplicación:
bash

    mvn spring-boot:run

