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

INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
VALUES (nextval('seq_desarrollador'), 'Electronic Arts', '1982-05-27', 'Trip Hawkins', 12900, 'Redwood City, California', 'https://www.ea.com/es-es', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Electronic_Arts_2020.svg/250px-Electronic_Arts_2020.svg.png');

INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
VALUES (nextval('seq_desarrollador'), 'Level 5', '1998-10-13', 'Akihiro Hino', 280, 'Fukuoka, Japón', 'https://www.level5.co.jp/vision2023/en/', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Level-5_Inc._logo.svg/320px-Level-5_Inc._logo.svg.png');

INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
VALUES (nextval('seq_desarrollador'), 'Bethesda Game Studios', '2001-03-24', 'Todd Howard', 400, 'Rockville, Maryland', 'https://bethesda.net/es/dashboard', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Bethesda_Game_Studios_logo.svg/1200px-Bethesda_Game_Studios_logo.svg.png');

-- JUEGOS

-- 1- Rockstar
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Red dead redemption 2', 'Acción-Aventura', '2018-10-26', 'https://i.blogs.es/juegos/13424/red_dead_3__nombre_temporal_/fotos/maestras/red_dead_3__nombre_temporal_-4030936.jpg', 65, 154, 23000000, 1, 9.2);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Red dead revolver', 'Acción-Aventura', '2005-05-26', 'https://upload.wikimedia.org/wikipedia/en/c/c1/Red_Dead_Revolver_Coverart.jpg', 7, 2.37, 920000, 1, 7.3);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Grand Theft Auto V', 'Acción-Aventura', '2013-09-17', 'https://image.api.playstation.com/vulcan/ap/rnd/202203/0911/VIB0SeEj9vT6DTv7P4thJLZi.jpg', 30, 110, 190000000, 1, 9.6);

-- 2- Nintendo
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'The Legend of Zelda: Breath of the Wild', 'Acción-Aventura', '2017-03-03', 'https://www.nintendo.com/content/dam/noa/es_MX/games/switch/t/the-legend-of-zelda-breath-of-the-wild-switch/legend-of-zelda-breath-of-the-wild-switch-hero.jpg', 50, 13.4, 23000000, 2, 9.5);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Punch-Out!!', 'Deportes', '1984-02-01', 'https://static.wikia.nocookie.net/punchout-nintendo/images/f/f1/Punch-Out%21%21_NES.jpg/revision/latest?cb=20210107195652&path-prefix=es', 5, 0.00003, 2000000, 2, 9.2);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Wario Land 3', 'Plataformas', '2000-03-21', 'https://static.wikia.nocookie.net/mario/images/a/a2/363px-Wario_Land_3_-_NA_Boxart.png/revision/latest?cb=20120424215424&path-prefix=es', 10, 3.0 , 2200000, 2, 9.8);

-- 3- Ubisoft
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Assassins Creed Valhalla', 'Acción-Aventura', '2020-11-10', 'https://store.ubi.com/dw/image/v2/ABBS_PRD/on/demandware.static/-/Sites-masterCatalog/default/dw1edddc9e/images/large/5ea3d3aaf42e123ecb3e0654.jpg?sw=341&sh=470&sm=fit', 60, 50.2, 13000000, 3, 8.7);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Rayman Legends', 'Plataformas', '2013-08-29', 'https://cdn1.epicgames.com/offer/fc8d1547232045f6a23257cfd04ef3e8/RAYL_StorePortrait_1200x1600_1200x1600-fb12d95d31bf845aa33409748940b904', 15, 2.9, 28000000, 3, 8.8);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Anno 1404', 'Construcción de ciudades', '2009-06-23', 'https://media.vandal.net/m/9367/2009623152520_1.jpg', 17, 4.3, 1000000, 3, 9.2);

-- 4- Naughty Dog
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'The Last of Us Part II', 'Acción-Aventura', '2020-06-19', 'https://image.api.playstation.com/vulcan/img/rnd/202010/2618/w48z6bzefZPrRcJHc7L8SO66.png', 30, 78.5, 4000000, 4, 9.4);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Crash Bandicoot', 'Plataformas', '1996-12-04', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Crash_bandicoot_logo_by_jerimiahisaiah.png/250px-Crash_bandicoot_logo_by_jerimiahisaiah.png', 6, 0.4, 6000000, 4, 9.3);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Jack II', 'Plataformas', '2003-10-14', 'https://ih1.redbubble.net/image.2338773486.2909/flat,750x,075,f-pad,750x1000,f8f8f8.jpg', 18, 2.55, 2000000, 4, 8.7);

-- 5- From Software
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Dark Souls I', 'Rol de acción', '2011-09-22', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Dark_Souls_logo_black.svg/500px-Dark_Souls_logo_black.svg.png', 60, 8.0, 33400000, 5, 9.5);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Shekiro: Shadows Die Twice', 'Acción-Aventura', '2019-03-22', 'https://group.kadokawa.co.jp/media/002/202309/mode3_w700-2023092601_img01.jpg', 30, 3.67, 10000000, 5, 8.8);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Demons souls', 'Rol de acción', '2020-11-12', 'https://image.api.playstation.com/vulcan/img/rnd/202011/1717/GemRaOZaCMhGxQ9dRhnQQyT5.png', 15, 66, 12000000, 5, 9.5);

-- 6- Electronic Arts
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Fifa Street', 'Deportes', '2005-02-22', 'https://upload.wikimedia.org/wikipedia/en/8/8c/FIFA_Street_Coverart.jpg', 10, 5.0, 300000, 6, 6.0);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Los Simpson: el videojuego', 'Acción-Aventura', '2007-10-09', 'https://media.vandal.net/t200/7160/201242892921_1.jpg', 8, 0.65, 5500000, 6, 8.0);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Dead Space', 'Terror y supervivencia', '2008-10-13', 'https://image.api.playstation.com/vulcan/ap/rnd/202209/1918/MP0I6Folca9wOgs9A39wwvj1.png', 13, 0.256, 2000000, 6, 9.4);

-- 7- Level 5
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'El profesor Layton y la villa misteriosa', 'Puzle', '2007-02-15', 'https://www.nintendo.com/eu/media/images/10_share_images/games_15/nintendo_ds_22/H2x1_NDS_ProfessorLaytonAndTheCuriousVillage_esES_image1600w.jpg', 20, 8, 1650000, 7, 8.8);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Inazuma Eleven', 'Rol y deportes', '2008-08-22', 'https://m.media-amazon.com/images/I/61aKmSiCVrL._AC_UF894,1000_QL80_.jpg', 18, 5.1, 1180000, 7, 7.8);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Fantasy Life', 'Rol', '2012-12-27', 'https://m.media-amazon.com/images/I/71G1n0WCXnL.jpg', 31, 6.85, 1200000, 7, 8.5);

-- 8- Bethesda
INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Fallout 4', 'Rol de acción', '2015-11-10', 'https://image.api.playstation.com/vulcan/ap/rnd/202009/2500/4GZyUQ1bHTjICP6GCRG7f65n.png', 30, 35, 12000000, 8, 9.2);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'The Elder Scrolls V: Skyrim', 'ARPG', '2011-11-11', 'https://image.api.playstation.com/vulcan/ap/rnd/202110/2019/aDSOgerXg4V6sf5A7VzHiTun.jpg', 40, 14.3, 60000000, 8, 9.6);

INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
VALUES (nextval('seq_juegos'), 'Starfield', 'Rol', '2023-09-06', 'https://shared.cloudflare.steamstatic.com/store_item_assets/steam/apps/1716740/capsule_616x353.jpg?t=1704299959', 40, 125, 13000000, 8, 8.3);

COMMIT;