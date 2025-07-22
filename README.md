# Gestión de Productos y Pedidos - API REST

API desarrollada con Spring Boot para el proyecto integrador de Talento Tech, que permite administrar un catálogo de productos y procesar pedidos.

## Postman Link 
https://clubsimple-team.postman.co/workspace/My-Workspace~90eb8030-5174-4836-86aa-124c7118290d/collection/37996362-e7eed5e7-6268-4b71-ba53-52235514e8a3?action=share&creator=37996362

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

