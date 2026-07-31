# Eureka Server

## Descripción

Microservicio encargado del registro y descubrimiento de servicios dentro del ecosistema de microservicios.

Permite que los demás servicios se registren automáticamente y puedan comunicarse utilizando su nombre lógico.

## Puerto

`8761`

## Tecnologías

- Java 21
- Spring Boot
- Spring Cloud Netflix Eureka Server

## Funcionalidad

- Registrar los microservicios.
- Permitir el descubrimiento de servicios.
- Gestionar la comunicación entre los servicios mediante su nombre lógico.

## Dashboard

```text
http://localhost:8761
```

En el dashboard deben aparecer registrados:

- CUSTOMER-SERVICE
- PRODUCT-SERVICE

## Orden de ejecución

Debe iniciarse después de Config Server.