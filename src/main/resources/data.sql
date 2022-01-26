drop table if exists Usuarios;
--drop table if exists Clientes;
drop table if exists Tickets;

create table Usuarios(idUsuario int AUTO_INCREMENT PRIMARY KEY, usuario varchar(250), contrasena varchar(250), rol varchar(25) not null,nombre varchar(250), direccion varchar(250), tel varchar(15), correo varchar(250));
--create table Clientes(idCliente int AUTO_INCREMENT PRIMARY KEY, nombre varchar(250), direccion varchar(250), tel int, correo varchar(250));
create table Tickets(idTicket int AUTO_INCREMENT PRIMARY KEY, nombreEquipo varchar(250), codigoEquipo varchar(250), idcreador int, estado int(1));

--alter table Ticket ADD FOREIGN KEY (idresponsable) REFERENCES Administradores(idAdministrador);
alter table Tickets ADD FOREIGN KEY (idcreador) REFERENCES Usuarios(idUsuario);


insert into Usuarios (usuario,contrasena,rol,nombre,direccion,tel,correo) values('juan123','123','ROL_A','David','cra 15 7 64','3228529597','david123#gmail.com'),('jose123','123','ROL_B','Valentina','cra 15 7 64','3228529597','valentina123#gmail.com');
--insert into Clientes (nombre,direccion,tel,correo) values(),();
insert into Tickets (nombreEquipo,codigoEquipo,idcreador,estado) values('Hp pavilion 32', '25021312',1,0);