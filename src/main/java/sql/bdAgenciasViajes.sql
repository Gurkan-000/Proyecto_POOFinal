drop database if exists bddagenciaviajes;
create database bddAgenciaViajes;
use bddAgenciaViajes;

create table usuario (
usuario varchar(30),
contraseña varchar(15)
);

insert into usuario values('admin','n1ca*12');

  
create table Rutas (
idRuta int auto_increment primary key,
coste decimal(6,2),
nombre varchar(20)
);

insert into Rutas values(null,200,'Lima'),
			(null,500,'Chachapoyas'),
                        (null,300,'Huanuco'),
                        (null,700,'Oxapampa'),
                        (null,750,'Tumbes'),
                        (null,750,'Tacna');

create table Viajes (
idViaje int auto_increment primary key,
fecha date,
hora time,
idBus int,
asientosDisponibles int,
pagoChofer decimal(6,2),
idRuta int
);



create table Buses (
idBus int auto_increment primary key,
idChofer int
);



create table Boletos (
idBoleto int auto_increment primary key,
nombrePasj varchar(40),
tipoPasj varchar(40),
idAsiento int,
idViaje int,
coste decimal(6,2)
);



create table Choferes (
idChofer int auto_increment primary key,
nombre varchar(40),
categoria varchar(40),
fechaIngreso date
);



create table Asientos (
idAsiento int auto_increment primary key
);

insert into Asientos values (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15),(16),(17),(18),(19),(20);

create table AsientosPorViaje (
idAsiento int,
idViaje int
);


alter table AsientosPorViaje add constraint UNQ_AsientoViaje UNIQUE (idAsiento,idViaje);
alter table Viajes add constraint FK_Viajes_Buses foreign key (idBus) references Buses(idBus);
alter table Viajes add constraint FK_Viajes_Rutas foreign key (idRuta) references Rutas(idRuta);
alter table Buses add constraint FK_Buses_Choferes foreign key (idChofer) references Choferes(idChofer);
alter table Boletos add constraint FK_Boletos_Asientos foreign key (idAsiento) references Asientos(idAsiento);
alter table Boletos add constraint FK_Boletos_Viajes foreign key (idViaje) references Viajes(idViaje);
alter table AsientosPorViaje add constraint FK_AsientosPorViaje_Asientos foreign key(idAsiento) references Asientos(idAsiento);
alter table AsientosPorViaje add constraint FK_AsientosPorViaje_Viajes foreign key(idViaje) references Viajes(idViaje);viajes

--Llenar objetos y tablas --
delimiter //
create procedure sp_llenarRutas()
begin
select idRuta, coste, nombre from Rutas;
end //
delimiter ;


delimiter //
create procedure sp_llenarViajes()
begin
select idViaje, fecha, hora, idBus, asientosDisponibles, idRuta from Viajes;
end //
delimiter ;

delimiter //
create procedure sp_llenarBuses()
begin
select idBus, idChofer from Buses;
end //
delimiter ;


delimiter //
create procedure sp_llenarBoletos()
begin
select idBoleto, nombrePasj, tipoPasj, idViaje, idAsiento, coste from Boletos;
end //
delimiter ;


delimiter //
create procedure sp_llenarAsientosViaje()
begin
select idViaje, idAsiento from AsientosporViaje;
end //
delimiter ;


delimiter //
create procedure sp_llenarChoferes()
begin
select idChofer, nombre, categoria, fechaIngreso from Choferes;
end //
delimiter ;

-- Generar los objetos--
delimiter //
create procedure sp_generarChofer(in p_nombre varchar(40), in p_categoria varchar(40), in p_fechaIngreso date)
begin
insert into Choferes values (null,p_nombre,p_categoria,p_fechaIngreso);
select last_insert_id() as codigo;
end //
delimiter ;


delimiter //
create procedure sp_generarBus( in p_idChofer int)
begin
insert into Buses values(null,p_idChofer);
select last_insert_id() as codigo;
end // 
delimiter ;


delimiter //
create procedure sp_generarViaje(in p_fecha date,in p_hora time,in p_idBus int,in p_pagoChofer decimal(6,2), in p_idRuta int)
begin
insert into Viajes values(null,p_fecha,p_hora,p_idBus,20,p_pagoChofer,p_idRuta);
select last_insert_id() as codigo;
end //
delimiter ;


delimiter //
create procedure sp_generarBoleto(in p_nombrePasj varchar(40), in p_tipoPasj varchar(40), in p_idAsiento int, in p_idViaje int, in p_coste decimal(6,2))
begin
declare asientos int;
start transaction;
select asientosDisponibles into asientos from Viajes where idViaje=p_idViaje;
if asientos<=0 then 
rollback;
signal sqlstate '45000' set  message_text = 'no hay asientos disponibles';
else
insert into Boletos values(null,p_nombrePasj,p_tipoPasj,p_idAsiento,p_idViaje,p_coste);
insert into AsientosPorViaje values(p_idAsiento,p_idViaje);
update Viajes set asientosDisponibles = asientosDisponibles-1 where idViaje=p_idViaje;
commit;
select last_insert_id() as codigo;
end if;
end //
delimiter ;


-- Actualizar los objetos --
delimiter //
create procedure sp_actualizarBus(in p_idBus int,in p_idChofer int)
begin
update Buses set idChofer=p_idChofer where idBus=p_idBus;
end //
delimiter ;


delimiter //
create procedure sp_actualizarChofer(in p_idChofer int, in p_nombre varchar(40),in p_categoria varchar(40), in p_fechaIngreso date)
begin
update Choferes set nombre=p_nombre,categoria=p_categoria,fechaIngreso=p_fechaIngreso where idChofer=p_idChofer;
end //
delimiter ;


delimiter //
create procedure sp_actualizarViaje(in p_idViaje int,in p_fecha date,in p_hora time,in p_idBus int,in p_idRuta int)
begin 
update Viajes set fecha=p_fecha,hora=p_hora,idBus=p_idBus,idRuta=p_idRuta where idViaje=p_idViaje;
end //
delimiter ;


delimiter //
create procedure sp_actualizarBoleto(in p_idBoleto int,in p_nombrePasj varchar(40),in p_tipoPasj varchar(40),in p_idAsiento int,in p_idViaje int,in p_coste decimal(6,2))
begin
    declare asientoAnterior int;
    declare viajeAnterior int;
    declare ocupado int default 0;

    start transaction;
    
    select idAsiento, idViaje into asientoAnterior, viajeAnterior from Boletos where idBoleto = p_idBoleto;

    -- Validar si el asiento está ocupado en el nuevo viaje
    if not (asientoAnterior = p_idAsiento and viajeAnterior = p_idViaje) then
        select count(*) into ocupado from AsientosPorViaje where idAsiento = p_idAsiento and idViaje = p_idViaje;
        
        if ocupado > 0 then
            rollback;
            signal sqlstate '45000' set message_text = 'El asiento ya está ocupado en ese viaje';
        end if;
    end if;

    -- Actualizar tabla intermedia si cambia asiento o viaje
    if not (asientoAnterior = p_idAsiento and viajeAnterior = p_idViaje) then delete from AsientosPorViaje where idAsiento = asientoAnterior and idViaje = viajeAnterior;
        insert into AsientosPorViaje values(p_idAsiento, p_idViaje);

        -- Actualizar disponibilidad si cambia de viaje
        if viajeAnterior != p_idViaje then
            update Viajes set asientosDisponibles = asientosDisponibles + 1 where idViaje = viajeAnterior;
            update Viajes set asientosDisponibles = asientosDisponibles - 1 where idViaje = p_idViaje;
        end if;
        
    end if;

    -- Actualizar el boleto
    update Boletos set nombrePasj = p_nombrePasj, tipoPasj = p_tipoPasj, idAsiento = p_idAsiento, idViaje = p_idViaje, coste = p_coste where idBoleto = p_idBoleto;
    commit;
end //
delimiter ;


-- Eliminar los objetos --
delimiter //
create procedure sp_eliminarBus (in p_idBus int)
begin
declare cantidad int default 0;
select count(*) into cantidad from Viajes where idBus=p_idBus;
if cantidad>0 then
signal sqlstate '45000' set message_text='no se puede eliminar un bus con viajes asociados';
else
delete from Buses where idBus=p_idBus;
end if;
end //
delimiter ;


delimiter //
create procedure sp_eliminarChofer (in p_idChofer int)
begin
start transaction;
update Buses set idChofer=null where idChofer=p_idChofer;
delete from Choferes where idChofer=p_idChofer;
commit;
end //
delimiter ;


delimiter //
create procedure sp_eliminarViaje (in p_idViaje int)
begin
declare cantidad int default 0;
select count(*) into cantidad from boletos where idViaje=p_idViaje;
if cantidad>0 then
signal sqlstate '45000' set message_text='no se puede eliminar un viaje con boletos emitidos';
else
delete from Viajes where idViaje=p_idViaje;
end if;
end //
delimiter ;


delimiter //
create procedure sp_eliminarBoleto (in p_idBoleto int)
begin
declare asiento int;
declare viaje int;
start transaction;
select idAsiento into asiento from Boletos where idBoleto=p_idBoleto;
select idViaje into viaje from Boletos where idBoleto=p_idBoleto;
delete from Boletos where idBoleto=p_idBoleto;
delete from AsientosPorViaje where idAsiento=asiento and idViaje=viaje;
update Viajes set asientosDisponibles = asientosDisponibles+1 where idViaje=viaje;
commit;
end //
delimiter ;


