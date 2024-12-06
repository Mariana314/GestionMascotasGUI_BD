CREATE DATABASE gestion_mascotas;

USE gestion_mascotas;

CREATE TABLE mascotas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    especie VARCHAR(100),
    raza VARCHAR(100),
    edad INT
);
