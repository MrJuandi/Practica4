# Practica4 - API REST para Gestión de Usuarios

Este proyecto es una implementación de una API REST para la gestión de usuarios utilizando **Spring Boot**. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los usuarios.

## Endpoints

### 1. Crear un nuevo usuario (POST)
**Ruta:** `/api/users`  
**Método:** `POST`  
**Descripción:** Crea un nuevo usuario en el sistema.  
**Cuerpo:**
{
"name": "Juan",
"email": "juan@example.com",
"password": "password123"
}
**Respuesta (201 Created):**
{
"id": 1,
"name": "Juan",
"email": "juan@example.com",
"password": "password123"
}
**Posibles errores:**
- **409 Conflict:** Si el correo electrónico ya está registrado.

### 2. Obtener todos los usuarios (GET)
**Ruta:** `/api/users`  
**Método:** `GET`  
**Descripción:** Devuelve una lista de todos los usuarios registrados.  
**Respuesta (200 OK):**
[
{
"id": 1,
"name": "Juan",
"email": "juan@example.com"
},
{
"id": 2,
"name": "Maria",
"email": "maria@example.com"
}
]

### 3. Obtener un usuario por ID (GET)
**Ruta:** `/api/users/{id}`  
**Método:** `GET`  
**Descripción:** Devuelve los detalles de un usuario específico por su ID.  
**Respuesta (200 OK):**
{
"id": 1,
"name": "Juan",
"email": "juan@example.com"
}
**Posibles errores:**
- **404 Not Found:** Si el usuario no existe.

### 4. Actualizar un usuario (PUT)
**Ruta:** `/api/users/{id}`  
**Método:** `PUT`  
**Descripción:** Actualiza la información de un usuario existente.  
**Cuerpo:**
{
"name": "Juan Actualizado",
"email": "juan.actualizado@example.com",
"password": "nuevaPassword123"
}
**Respuesta (200 OK):**
{
"id": 1,
"name": "Juan Actualizado",
"email": "juan.actualizado@example.com",
"password": "nuevaPassword123"
}
**Posibles errores:**
- **404 Not Found:** Si el usuario no existe.

### 5. Eliminar un usuario (DELETE)
**Ruta:** `/api/users/{id}`  
**Método:** `DELETE`  
**Descripción:** Elimina un usuario del sistema.  
**Respuesta (204 No Content):**  
**Posibles errores:**
- **404 Not Found:** Si el usuario no existe.

## Cómo ejecutar el proyecto
