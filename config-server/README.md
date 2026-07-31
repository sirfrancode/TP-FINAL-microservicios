# Config Server

## Descripción

Microservicio encargado de centralizar la configuración de los demás servicios utilizando Spring Cloud Config.

Obtiene los archivos de configuración desde un repositorio Git remoto para evitar configuraciones duplicadas.

## Puerto

`8888`

## Tecnologías

- Java 21
- Spring Boot
- Spring Cloud Config Server

## Funcionalidad

- Centralizar la configuración de los microservicios.
- Obtener los archivos `.yml` desde un repositorio Git remoto.

## Endpoints de prueba

```text
http://localhost:8888/customer-service/default
http://localhost:8888/product-service/default
```
## Orden de ejecución

Debe iniciarse primero.