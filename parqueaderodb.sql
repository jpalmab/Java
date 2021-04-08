--JOHAN PALMA BURGOS

-- creo la base de datos
create database parqueaderodb;

-- selecciono la base de datos creada
use database parqueaderodb;

-- creo la tabla cliente con sus diversos campos
create table cliente
(
    idCliente int primary key,
    nombre varchar(200),
    apellido varchar(200),
    celular varchar(200),
    cedula int
);
