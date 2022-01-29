drop table if exists Usuarios;
drop table if exists Clientes;
drop table if exists Administracion;
drop table if exists Tickets;

create table Usuarios(idUsuario int AUTO_INCREMENT PRIMARY KEY, contrasena varchar(250), rol varchar(25) not null, nombre varchar(250),correo varchar(250),disponible int(1));
create table Clientes(idCliente int AUTO_INCREMENT PRIMARY KEY, idUsuario int,numDoc int(50), tipoDoc varchar(50),empresa varchar(250),cargo varchar(250));
create table Administracion(idAdministracion int AUTO_INCREMENT PRIMARY KEY,idUsuario int);
create table Tickets(idTicket int AUTO_INCREMENT PRIMARY KEY, idCliente int not null, idEncargado int, tipoSoporte varchar(50), prioridad varchar(15), numTicket varchar(250), descripcionSoporte varchar(250), estado int(1));

alter table Clientes ADD FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario);
alter table Administracion ADD FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario);
alter table Tickets ADD FOREIGN KEY (idCliente) REFERENCES Usuarios(idUsuario);
alter table Tickets ADD FOREIGN KEY (idEncargado) REFERENCES Usuarios(idUsuario);


insert into Usuarios (contrasena,rol, nombre, correo,disponible) values ('123','ROL_C','Juan Torres','juan@mail.com',1),('123','ROL_A','Jose Benavides', 'jose@mail.com',1);
insert into Clientes ( idUsuario,numDoc, tipoDoc,empresa,cargo) values (1,10074,'C.C', 'PulposOnline', 'CEO');
insert into Administracion (idUsuario) values (2);
insert into Tickets (idCliente,idEncargado,tipoSoporte,prioridad,numTicket,descripcionSoporte,estado) values (1,2,'Equipo','Alta','asda123123121','El equipo no calcula sumas', 0);