# Product Service

## Descripción

Microservicio encargado de la administración de productos financieros asociados a un cliente.

Cada producto almacena el identificador del cliente propietario para permitir la integración con Customer Service.

## Puerto

`8082`

## Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Cloud Netflix Eureka Client
- H2 Database

## Funcionalidades

- Crear productos.
- Listar productos.
- Buscar productos por ID.
- Actualizar productos.
- Eliminar productos.
- Obtener los productos asociados a un cliente.

## Endpoints

### Crear producto

```text
POST /products
```

### Listar productos

```text
GET /products
```

### Buscar producto por ID

```text
GET /products/{id}
```

### Actualizar producto

```text
PUT /products/{id}
```

### Eliminar producto

```text
DELETE /products/{id}
```

### Obtener productos por cliente

```text
GET /products/customer/{customerId}
```

## Dependencias

- Config Server
- Eureka Server

## Orden de ejecución

Debe iniciarse después de Config Server y Eureka Server.