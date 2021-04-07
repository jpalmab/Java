create database parqueaderodb;
use database parqueaderodb;

create table cliente
(
    idCliente int primary key,
    nombre varchar(200),
    apellido varchar(200),
    celular varchar(200),
    cedula int
);
