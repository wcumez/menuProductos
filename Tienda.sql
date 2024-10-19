create database BDBecksport;

use BDBecksport;
create table producto(
codigoProducto varchar(10) primary key,
nombreProducto varchar(30) not null,
precioUnitario decimal(10,2) not null,
cantidadProducto int not null,
fechaVencimiento date default '2024-10-08'
);

show columns from producto;

insert into producto(codigoProducto,nombreProducto,precioUnitario,cantidadProducto,fechaVencimiento)
 values('bs001','Balon de futbol','300','100','2028-10-02'),
 ('bs002','Balon de playa','70','100','2027-10-02'),
 ('bs003','Balon de baloncesto','250','100','2029-10-02'),
 ('bs004','Balon de tenis','100','100','2028-01-02'),
 ('bs005','Balon de pingpong','20','100','2028-11-02'),
 ('ts001','Tenis azul','500','16','2029-10-02'),
 ('ts002','Tenis negro','500','123','2029-10-06'),
 ('ts003','Tenis roja','500','10','2028-01-07'),
 ('ts004','Tenis verda','500','12','2027-11-02'),
 ('ts005','Tenis amarillo','500','1000','2027-10-02'),
 ('ps001','Pantaloneta roja','40','50','2029-10-02'),
 ('ps002','Pantaloneta azul','40','170','2025-01-02'),
 ('ps003','Pantaloneta verde','40','10','2028-12-02'),
 ('ps004','Pantaloneta amarilla-blanca','100','100','2028-09-02'),
 ('ps005','Pantaloneta roja-azul','100','30','2025-01-02'),
 ('gs001','Guante futbol-rojo','190','50','2029-10-02'),
 ('gs002','Guante futbol-negro','190','170','2025-01-02'),
 ('gs003','Guante futbol-azul','190','10','2028-12-02'),
 ('gs004','Guante futbol-amarillo','300','60','2025-01-02'),
 ('gs005','Guante futbol-verda','300','300','2025-01-02');
 
insert into producto(codigoProducto,nombreProducto,precioUnitario,cantidadProducto,fechaVencimiento)
 values('ms001','Media futbol-negro','300','100','2028-10-02'),
 ('ms002','Media futbol-azul','70','100','2027-10-02'),
 ('ms003','Media baloncesto-negro','250','100','2029-10-02'),
 ('ms004','Media baloncesto-rojo','100','100','2028-01-02'),
 ('ms005','Media futbol-corta-negro','20','100','2028-11-02');
 
 update producto set precioUnitario = 250 where codigoProducto = 'bs001';
 update producto set cantidadProducto = 50 where codigoProducto = 'bs002';
 update producto set fechaVencimiento = '2030-11-02' where codigoProducto = 'bs003';
 update producto set nombreProducto = 'Balon de tenis-azul' where codigoProducto = 'bs004';
 update producto set cantidadProducto = 20 where codigoProducto = 'bs005';
 
 delete from producto where codigoProducto= 'bs001';
 delete from producto where codigoProducto= 'bs002';
 delete from producto where codigoProducto= 'bs003';
 delete from producto where codigoProducto= 'bs004';
 delete from producto where codigoProducto= 'bs005';

select * from producto;




