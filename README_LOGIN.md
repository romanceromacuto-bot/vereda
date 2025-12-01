# Sistema de Login de Usuarios - Vereda Express

## Estructura MVC Creada

```
src/main/java/com/co/veredaexpress/
├── model/
│   └── Usuario.java          (Entidad JPA)
├── repository/
│   └── UsuarioRepository.java (Acceso a datos)
├── service/
│   └── UsuarioService.java    (Lógica de negocio)
├── controller/
│   └── UsuarioController.java (Endpoints REST)
└── dto/
    ├── LoginRequest.java
    └── RegistroRequest.java
```

## Configuración de Base de Datos

1. Crear base de datos MySQL (o se creará automáticamente):
```sql
CREATE DATABASE veredaexpress_db;
```

2. Configurar credenciales en `application.properties`:
```properties
spring.datasource.username=root
spring.datasource.password=tu_password
```

## Endpoints Disponibles

### 1. Registro de Usuario
**POST** `http://localhost:8080/api/usuarios/registro`

Body (JSON):
```json
{
  "username": "usuario1",
  "password": "123456",
  "email": "usuario1@example.com"
}
```

### 2. Login de Usuario
**POST** `http://localhost:8080/api/usuarios/login`

Body (JSON):
```json
{
  "username": "usuario1",
  "password": "123456"
}
```

## Ejecutar el Proyecto

```bash
mvnw spring-boot:run
```

## Notas Importantes

- La tabla `usuarios` se creará automáticamente en la base de datos
- Las contraseñas se guardan en texto plano (solo para educación)
- Para producción, implementar BCrypt para encriptar contraseñas
- El sistema registra la fecha de creación y último acceso automáticamente
