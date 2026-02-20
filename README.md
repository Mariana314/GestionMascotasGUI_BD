# Gestión de Mascotas - Java GUI con Base de Datos

## 📌 Descripción

Este proyecto es una aplicación desarrollada en Java que permite gestionar información de mascotas mediante una interfaz gráfica (GUI) conectada a una base de datos MySQL.

El sistema permite:

- Registrar nuevas mascotas
- Consultar mascotas registradas
- Editar información
- Eliminar registros

---

## 🛠 Tecnologías utilizadas

- Java SE
- Swing (Interfaz gráfica)
- MySQL
- JDBC
- Eclipse IDE

---

## ⚙️ Configuración de la Base de Datos

1. Crear la base de datos en MySQL ejecutando el archivo `database.sql`.

2. Configurar sus credenciales en el archivo:

Modificar las siguientes líneas:

```java
private String usuario = "TU_USUARIO";
private String password = "TU_PASSWORD";