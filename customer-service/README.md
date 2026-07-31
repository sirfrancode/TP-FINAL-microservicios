# Customer Service

## Descripción

Microservicio encargado de la gestión de clientes.

Además, consume el Product Service mediante OpenFeign para obtener los productos asociados a un cliente.

## Puerto

`8081`

## Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Cloud OpenFeign
- Spring Cloud Netflix Eureka Client
- H2 Database

## Funcionalidades

- Crear clientes.
- Listar clientes.
- Buscar clientes por ID.
- Actualizar clientes.
- Obtener un cliente junto con sus productos mediante OpenFeign.

## Endpoints

### Crear cliente

```text
POST /customers
```

### Listar clientes

```text
GET /customers
```

### Buscar cliente por ID

```text
GET /customers/{id}
```

### Actualizar cliente

```text
PUT /customers/{id}
```

### Obtener cliente con productos

```text
GET /customers/{id}/products
```

## Dependencias

- Config Server
- Eureka Server
- Product Service

## Orden de ejecución

Debe iniciarse después de Config Server, Eureka Server y Product Service.