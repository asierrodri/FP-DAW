create database mapalocales;
use mapalocales;

create table locales(
	id_local int auto_increment primary key,
    nombre varchar(50),
    poblacion varchar(100),
    coordenadas varchar(100),
    tipo varchar(100) check (tipo in ('Restaurante', 'Bar', 'Discoteca'))
    );
    
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Restaurante La Bien Aparecida', 'Madrid', '{ lat: 40.423846566667365, lng: -3.687058358821944 }', 'Restaurante');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Madrid me Mata', 'Madrid', '{ lat: 40.42654530103279, lng:  -3.6901024396658477 }', 'Bar');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('FABRIK', 'Madrid', '{ lat: 40.26542637712164, lng: -3.8164569297001885 }', 'Discoteca');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Mesón Jesús Restaurante', 'Barcelona', '{ lat: 41.381569106753375, lng:  2.184699297069487 }', 'Restaurante');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Bar Sincopa', 'Barcelona', '{ lat: 41.3808914234871, lng: 2.196472797098501 }', 'Bar');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Razzmatazz', 'Barcelona', '{ lat: 41.39796044618054, lng: 2.1983172160579896 }', 'Discoteca');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Umamie', 'Bilbao', '{ lat: 43.25514754013933, lng: -2.9150377150440905 }', 'Restaurante');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Bar Plaza Unamuno', 'Bilbao', '{ lat: 43.25802416358255, lng: -2.907312328439748 }', 'Bar');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('SALA SANTANA 27', 'Bilbao', '{ lat: 43.24950839418731, lng: -2.889371778962398 }', 'Discoteca');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Restaurante Camaleón', 'Valencia', '{ lat: 39.46419141080741, lng: -0.37637759402868415 }', 'Restaurante');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Bar El Mercat', 'Valencia', '{ lat: 39.47346644091447, lng: -0.3645428525858042 }', 'Bar');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Discoteca Spook', 'Valencia', '{ lat: 39.41162305479897, lng: -0.31731988300784 }', 'Discoteca');
insert into locales(nombre, poblacion, coordenadas, tipo) values ('Discoteca Jardines Del Real', 'Valencia', '{ lat: 39.47781592267568, lng: -0.358133907550716 }', 'Discoteca');