# TP Final - Ecosistema de Microservicios FinTech

Proyecto integrador desarrollado para la Diplomatura en Desarrollo de Software FinTech: IA y Microservicios.

El sistema implementa un ecosistema de microservicios con Spring Boot y Spring Cloud. Permite gestionar clientes y productos financieros, utilizando Eureka para el descubrimiento de servicios, OpenFeign para la comunicación entre microservicios y Spring Cloud Config para centralizar las configuraciones.

## Arquitectura

El ecosistema está compuesto por cuatro aplicaciones independientes:

- **config-server**: centraliza las configuraciones de los demás servicios desde un repositorio Git remoto.
- **eureka-server**: registra y permite descubrir los microservicios disponibles.
- **product-service**: gestiona productos financieros asociados a clientes.
- **customer-service**: gestiona clientes y consulta sus productos mediante OpenFeign.

Flujo principal de comunicación:

```text
Repositorio Git de configuración
              |
              v
        Config Server
              |
              v
        Eureka Server
          /       \
         v         v
Customer Service  Product Service
         |
         | OpenFeign
         v
 Product Service

##Tecnologías utilizadas:
Java 21
Spring Boot
Spring Cloud
Spring Cloud Config
Netflix Eureka
OpenFeign
Spring Data JPA
H2 Database
Maven
Postman
Git y GitHub


##Estructura del repositorio
TP-FINAL-microservicios/
├── config-server/
├── eureka-server/
├── product-service/
├── customer-service/
└── README.md

## El repositorio remoto de configuraciones se encuentra en:
https://github.com/sirfrancode/tp-config-repo


## Puertos
Aplicación	Puerto
Config Server	8888
Eureka Server	8761
Customer Service	8081
Product Service	8082

## Orden de ejecución
Los servicios deben iniciarse en el siguiente orden:

config-server
eureka-server
product-service
customer-service

Este orden permite que los servicios obtengan primero su configuración y después se registren correctamente en Eureka.
Ejecución

Cada proyecto puede ejecutarse desde IntelliJ IDEA utilizando su clase principal.

También puede ejecutarse desde una terminal ubicada dentro de cada proyecto:
./mvnw spring-boot:run
En Windows:
.\mvnw.cmd spring-boot:run

##Verificación de infraestructura
Config Server

##Configuración de Product Service:
http://localhost:8888/product-service/default

##Configuración de Customer Service:
http://localhost:8888/customer-service/default

##Eureka Dashboard
http://localhost:8761

##En el dashboard deben aparecer registrados:
PRODUCT-SERVICE
CUSTOMER-SERVICE

##Endpoints de Product Service
URL base:
http://localhost:8082/products

Método	       Endpoint	                         Descripción
POST	       /products	                         Crear un producto
GET	         /products	                         Listar todos los productos
GET	         /products/{id}	                     Buscar un producto por ID
GET          /products/customer/{customerId}	   Listar productos asociados a un cliente
PUT	         /products/{id}	                     Actualizar un producto
DELETE	     /products/{id}	                     Eliminar un producto

##Ejemplo para crear un producto
{
  "customerId": 1,
  "name": "Cuenta Corriente",
  "type": "ACCOUNT",
  "balance": 150000
}


##Comunicación mediante OpenFeign
customer-service utiliza un Feign Client para consumir el siguiente endpoint de product-service:
GET /products/customer/{customerId}

La comunicación se realiza utilizando el nombre lógico:
product-service

##Eureka se encarga de localizar la instancia correspondiente sin necesidad de escribir directamente la URL o el puerto del servicio.
El endpoint que demuestra la integración completa es:
GET http://localhost:8081/customers/{id}/products
Ejemplo de respuesta:

{
  "id": 1,
  "name": "Enzo Fernández",
  "document": "40123456",
  "email": "enzo@email.com",
  "balance": 250000,
  "products": [
    {
      "id": 1,
      "customerId": 1,
      "name": "Cuenta Corriente",
      "type": "ACCOUNT",
      "balance": 150000
    }
  ]
}

##Persistencia
Los servicios utilizan bases de datos H2 en memoria:

customersdb
productsdb

Al detener o reiniciar los servicios, los datos almacenados pueden perderse.

Diseño del proyecto

##Los microservicios de negocio utilizan una arquitectura por capas:

controller
service
repository
entity
dto
mapper
exception

customer-service también contiene:
client
donde se encuentra la interfaz de OpenFeign.
Los controllers trabajan con DTOs y no exponen directamente las entidades. Los mappers realizan las conversiones entre DTOs y entidades.

##Manejo de excepciones
Se implementaron excepciones personalizadas y @RestControllerAdvice para devolver respuestas claras cuando un cliente o producto no existe.
Ejemplo:
{
  "timestamp": "2026-07-23T00:38:05",
  "status": 404,
  "message": "Producto no encontrado con id: 999"
}

##Pruebas
Los endpoints fueron probados utilizando Postman.
Se verificó:
creación y consulta de clientes;
creación y consulta de productos;
búsqueda de productos por ID de cliente;
respuestas 404 para recursos inexistentes;
registro de los servicios en Eureka;
lectura de configuraciones desde Config Server;
comunicación entre Customer Service y Product Service mediante OpenFeign.


