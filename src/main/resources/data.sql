drop table if exists Usuarios;
drop table if exists Clientes;
drop table if exists Administracion;
drop table if exists Tickets;
drop table if exists Prioridad;

create table Usuarios(idUsuario int AUTO_INCREMENT PRIMARY KEY, contrasena varchar(250), rol varchar(25) not null, nombre varchar(250),correo varchar(250),disponible int(1));
create table Clientes(idCliente int AUTO_INCREMENT PRIMARY KEY, idUsuario int,numDoc int(50), tipoDoc varchar(50),empresa varchar(250),cargo varchar(250));
create table Administracion(idAdministracion int AUTO_INCREMENT PRIMARY KEY,idUsuario int);
create table Tickets(idTicket int AUTO_INCREMENT PRIMARY KEY, idCliente int not null, idEncargado int, tipoSoporte varchar(50), idPrioridad int, numTicket varchar(250), descripcion varchar(250), fechayhora DATETIME ,estado int(1));
create table Prioridad(idPrioridad int AUTO_INCREMENT PRIMARY KEY, prioridad varchar(250));

alter table Clientes ADD FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario);
alter table Administracion ADD FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario);
alter table Tickets ADD FOREIGN KEY (idCliente) REFERENCES Usuarios(idUsuario);
alter table Tickets ADD FOREIGN KEY (idEncargado) REFERENCES Usuarios(idUsuario);
alter table Tickets ADD FOREIGN KEY (idPrioridad) REFERENCES Prioridad(idPrioridad);


insert into Usuarios (contrasena,rol, nombre, correo,disponible) values ('$2a$12$555qlmu/U.ih6UIZRABRTeK/QygRSHj/Dtu4gTgJImf2yo80WvNhy','ROL_S','Juan Supervisor','super@admin.com',1),('$2a$12$SjmhGU5qaeE06brACOR4Dep1Lj6rWgYLUsGh2YPOhlFu6SOLdChLy','ROL_T','Jose tecnico','jose@tecnico.com',1),('$2a$12$6GTMF9PMQfZ3yphbETlmeeMlx7bIOE6XKEJ4tQEY5JX/XLHH.O4Fi','ROL_T','Camilo Tecnico','camilo@tecnico.com',1);
insert into Administracion (idUsuario) values (1),(2),(3);
insert into Prioridad(prioridad) values('Alta'),('Media'),('Baja');
