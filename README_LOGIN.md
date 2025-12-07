# Vereda Express - Sistema de Gestión de Pedidos

## Estructura del Proyecto

```
src/main/java/com/co/veredaexpress/
├── model/
│   ├── Usuario.java
│   ├── Pedido.java
│   ├── Pago.java
│   ├── Servicio.java
│   └── EstadoPedido.java (Enum)
├── repository/
│   ├── UsuarioRepository.java
│   ├── PedidoRepository.java
│   ├── PagoRepository.java
│   └── ServicioRepository.java
├── service/
│   ├── UsuarioService.java
│   ├── PedidoService.java
│   ├── PagoService.java
│   └── ServicioService.java
├── controller/
│   ├── UsuarioController.java
│   ├── PedidoController.java
│   ├── PagoController.java
│   └── ServicioController.java
├── dto/
│   ├── LoginRequest.java
│   ├── RegistroRequest.java
│   ├── UsuarioResponse.java
│   ├── PedidoCreateRequest.java
│   ├── PedidoUpdateRequest.java
│   ├── PedidoResponse.java
│   ├── ServicioRequest.java
│   ├── ServicioResponse.java
│   ├── PagoUpdateRequest.java
│   └── PagoResponse.java
└── mapper/
    └── EntityMapper.java
```

## Configuración de Base de Datos

1. Crear base de datos PostgreSQL:
```sql
CREATE DATABASE veredaexpress_db;
```

2. Configurar credenciales en `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/veredaexpress_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```

## Documentación API - Swagger

### Acceder a Swagger UI
- **Swagger UI**: http://localhost:8080/api/v0/swagger-ui/index.html
- **OpenAPI JSON**: http://localhost:8080/api/v0/v3/api-docs

### APIs Disponibles

#### Usuarios
- `POST /api/v0/usuarios/registro` - Registrar usuario
- `POST /api/v0/usuarios/login` - Iniciar sesión

#### Pedidos
- `POST /api/v0/pedidos` - Crear pedido
- `PUT /api/v0/pedidos/{id}` - Actualizar pedido
- `GET /api/v0/pedidos/{id}` - Obtener pedido por ID
- `GET /api/v0/pedidos/usuario/{usuarioId}` - Obtener pedidos por usuario

#### Servicios
- `POST /api/v0/servicios` - Crear servicio
- `GET /api/v0/servicios` - Obtener todos los servicios
- `GET /api/v0/servicios/{id}` - Obtener servicio por ID
- `DELETE /api/v0/servicios/{id}` - Eliminar servicio

#### Pagos
- `PUT /api/v0/pagos/{id}` - Actualizar pago
- `GET /api/v0/pagos/{id}` - Obtener pago por ID

## Ejecutar el Proyecto

```bash
mvn spring-boot:run
```

Luego accede a Swagger UI en: http://localhost:8080/api/v0/swagger-ui/index.html

## Características del Sistema

- **DTOs**: Protección de entidades del dominio
- **Validaciones**: Validación automática con Bean Validation
- **Documentación**: Swagger/OpenAPI integrado
- **Relaciones**: Usuario → Pedidos (1:N), Pedido → Servicio (N:1), Pedido → Pago (1:1)
- **Estados**: Enum para estados de pedido (CREADO, PAGADO, EN_REPARTO, ENTREGADO)
- **Mapeo**: Conversión automática entre entidades y DTOs

## Notas Importantes

- Las tablas se crean automáticamente con JPA/Hibernate
- Sistema completo de gestión de pedidos y servicios
- Arquitectura limpia con separación de responsabilidades
- Para producción: implementar seguridad (JWT, BCrypt, etc.)
