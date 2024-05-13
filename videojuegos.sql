drop sequence seq_juegos;
drop sequence seq_desarrollador;

drop table VIDEOJUEGO;
drop table DESARROLLADOR;


CREATE TABLE DESARROLLADOR
(
    ID 				INT,
    NOMBRE			VARCHAR(50),
    FUNDACION		DATE,
    FUNDADOR		VARCHAR(100),
    EMPLEADOS		INT,
    SEDE			VARCHAR(200),
    SITIOWEB		VARCHAR(200),
    LOGO            VARCHAR(1000),

    CONSTRAINT "PK_DESARROLLADOR"				PRIMARY KEY (ID),
    CONSTRAINT "NN_DESARROLLADOR.NOMBRE"		CHECK (NOMBRE IS NOT NULL),
    CONSTRAINT "NN_DESARROLLADOR.FUNDACION"		CHECK (FUNDACION IS NOT NULL),
    CONSTRAINT "NN_DESARROLLADOR.FUNDADOR"		CHECK (FUNDADOR IS NOT NULL),
    CONSTRAINT "NN_DESARROLLADOR.EMPLEADOS"		CHECK (EMPLEADOS IS NOT NULL),
    CONSTRAINT "NN_DESARROLLADOR.SEDE"			CHECK (SEDE IS NOT NULL),
    CONSTRAINT "NN_DESARROLLADOR.SITIOWEB"		CHECK (SITIOWEB IS NOT NULL),
    CONSTRAINT "NN_DESARROLLADOR.LOGO"          CHECK (LOGO IS NOT NULL)

);

CREATE TABLE VIDEOJUEGO
(
	ID 					INT,
	NOMBRE				VARCHAR(50),
	GENERO				VARCHAR(100),
	ESTRENO				DATE,
	PORTADA				VARCHAR(1000),
	DURACION			NUMERIC(4,1),
	TAMANIO				NUMERIC(4,1),
	VENTAS				INT,
	DESARROLLADOR		INT,
	NOTA				NUMERIC(3,1),

	CONSTRAINT "PK_VIDEOJUEGO"					PRIMARY KEY (ID),
	CONSTRAINT "NN_VIDEOJUEGO.NOMBRE"			CHECK (NOMBRE IS NOT NULL),
	CONSTRAINT "NN_VIDEOJUEGO.GENERO"			CHECK (GENERO IS NOT NULL),
	CONSTRAINT "NN_VIDEOJUEGO.ESTRENO"			CHECK (ESTRENO IS NOT NULL),
	CONSTRAINT "NN_VIDEOJUEGO.PORTADA"			CHECK (PORTADA IS NOT NULL),
	CONSTRAINT "NN_VIDEOJUEGO.DURACION"			CHECK (DURACION IS NOT NULL),
	CONSTRAINT "NN_VIDEOJUEGO.TAMANIO"			CHECK (TAMANIO IS NOT NULL),
	CONSTRAINT "NN_VIDEOJUEGO.VENTAS"			CHECK (VENTAS IS NOT NULL),
	CONSTRAINT "FK_VIDEOJUEGO.DESARROLLADOR"	FOREIGN KEY (DESARROLLADOR) REFERENCES DESARROLLADOR(ID),
	CONSTRAINT "NN_VIDEOJUEGO.DESARROLLADOR"	CHECK (DESARROLLADOR IS NOT NULL),
	CONSTRAINT "NN_VIDEOJUEGO.NOTA"				CHECK (NOTA IS NOT NULL),
	CONSTRAINT "CH_VIDEOJUEGO.NOTA"				CHECK (NOTA BETWEEN 0 AND 10)
);


CREATE SEQUENCE seq_juegos 			MINVALUE 1 MAXVALUE 10000 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_desarrollador	MINVALUE 1 MAXVALUE 5000 START WITH 1 INCREMENT BY 1;


-- DESARROLLADORES
INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
VALUES (nextval('seq_desarrollador'), 'Rockstar Games', '1998-12-05', 'Sam Houser', 2000, '40°43′44″ N, 73°59′24″ W', 'https://www.rockstar.com/', 'https://upload.wikimedia.org/wikipedia/commons/9/97/Rockstar_logo_for_tweets.png');

INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
VALUES (nextval('seq_desarrollador'), 'Nintendo', '1889-09-23', 'Fusajiro Yamauchi', 5800, 'Kyoto, Japón', 'https://www.nintendo.com/', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Nintendo.svg/2560px-Nintendo.svg.png');

INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
VALUES (nextval('seq_desarrollador'), 'Ubisoft', '1986-03-28', 'Christian Guillemot', 18000, 'Montreuil, Francia', 'https://www.ubisoft.com/', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Ubisoft_logo.svg/2238px-Ubisoft_logo.svg.png');

INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
VALUES (nextval('seq_desarrollador'), 'Naughty Dog', '1984-09-30', 'Andy Gavin, Jason Rubin', 300, 'Santa Mónica, California, EE. UU.', 'https://www.naughtydog.com/', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Naughty_Dog_logo.svg/1200px-Naughty_Dog_logo.svg.png');

INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
VALUES (nextval('seq_desarrollador'), 'From Software', '1986-11-01', 'Naotoshi Zin', 288, 'Tokio, Japón', 'https://www.fromsoftware.jp/ww/', 'https://static.wikia.nocookie.net/sekiro/images/a/ac/FromSoftware.jpg/revision/latest?cb=20190412211109&path-prefix=es');


-- JUEGOS
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Red dead redemption 2', 'Acción-Aventura', '2018-10-26', 'https://i.blogs.es/juegos/13424/red_dead_3__nombre_temporal_/fotos/maestras/red_dead_3__nombre_temporal_-4030936.jpg', 65, 154, 23000000, 1, 9.2);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'The Legend of Zelda: Breath of the Wild', 'Acción-Aventura', '2017-03-03', 'https://www.nintendo.com/content/dam/noa/es_MX/games/switch/t/the-legend-of-zelda-breath-of-the-wild-switch/legend-of-zelda-breath-of-the-wild-switch-hero.jpg', 50, 13.4, 23000000, 2, 9.5);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Assassins Creed Valhalla', 'Acción-Aventura', '2020-11-10', 'https://store.ubi.com/dw/image/v2/ABBS_PRD/on/demandware.static/-/Sites-masterCatalog/default/dw1edddc9e/images/large/5ea3d3aaf42e123ecb3e0654.jpg?sw=341&sh=470&sm=fit', 60, 50.2, 13000000, 3, 8.7);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'The Last of Us Part II', 'Acción-Aventura', '2020-06-19', 'https://images-na.ssl-images-amazon.com/images/I/71u3i5KyGbL._SL1200_.jpg', 30, 78.5, 4000000, 4, 9.4);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Grand Theft Auto V', 'Acción-Aventura', '2013-09-17', 'https://image.api.playstation.com/vulcan/ap/rnd/202203/0911/VIB0SeEj9vT6DTv7P4thJLZi.jpg', 30, 110, 190000000, 1, 9.6);

COMMIT;