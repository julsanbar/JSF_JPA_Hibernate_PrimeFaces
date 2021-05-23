/*DROP DATABASE baloncesto;*/
create database baloncesto;
use baloncesto;

CREATE TABLE EQUIPOS
(
CODEQUIPO VARCHAR(10) ,
NOMBREQUIPO VARCHAR(50) NOT NULL ,
PRIMARY KEY (CODEQUIPO) 
);



CREATE TABLE TEMPORADA
  (
    CODTEMP VARCHAR(3),
    NOMBRE  VARCHAR(30),
    PRIMARY KEY (CODTEMP) 
    );
    
    
CREATE  TABLE PARTIDOS (
  CODPARTIDO VARCHAR(10) PRIMARY KEY ,
  TEMPORADA VARCHAR(3) NOT NULL ,
  JORNADA INTEGER NOT NULL ,
  PUNTOSLOCAL INTEGER  ,
  PUNTOSVISITANTE INTEGER ,
  CODEQUIPOLOCAL VARCHAR(10) NOT NULL ,
  CODEQUIPOVISITANTE VARCHAR(10) NOT NULL ,
  FOREIGN KEY(CODEQUIPOLOCAL) REFERENCES EQUIPOS(CODEQUIPO) ,  
  FOREIGN KEY ( CODEQUIPOVISITANTE )  REFERENCES EQUIPOS(CODEQUIPO) ,  
  FOREIGN KEY (TEMPORADA )  REFERENCES TEMPORADA(CODTEMP) 
   );




CREATE TABLE JUGADORES
  (
    CODJUGADOR   VARCHAR(10),
    NOMBREJUGADOR VARCHAR(50) NOT NULL ,
    PRIMARY KEY (CODJUGADOR) ,
    FECHANAC date 
  );
  



CREATE TABLE PARTIDOS_JUGADORES
  (
    CODPARTIDO  VARCHAR(10 ),
    CODJUGADOR  VARCHAR(10 ),
    CANASTAS   INTEGER,
    ASISTENCIAS INTEGER,
    REBOTES     INTEGER,
    PRIMARY KEY (CODPARTIDO, CODJUGADOR) ,
    CONSTRAINT FK_JUGADAS2 FOREIGN KEY (CODJUGADOR) REFERENCES JUGADORES (CODJUGADOR),
    CONSTRAINT FK_JUGADAS3 FOREIGN KEY (CODPARTIDO) REFERENCES PARTIDOS (CODPARTIDO)
  );


CREATE TABLE TEMP_EQUIPO_JUGADOR
  (
    CODTEMP    VARCHAR(3 ),
    CODEQUIPO  VARCHAR(10 ),
    CODJUGADOR VARCHAR(10 ),
    SALARIO INTEGER,
    CONSTRAINT PKF0 PRIMARY KEY (CODTEMP, CODEQUIPO, CODJUGADOR),
    CONSTRAINT FKF1 FOREIGN KEY (CODTEMP) REFERENCES TEMPORADA(CODTEMP)  ,
    CONSTRAINT FKF2 FOREIGN KEY (CODEQUIPO) REFERENCES EQUIPOS(CODEQUIPO) , 
    CONSTRAINT FKF3 FOREIGN KEY (CODJUGADOR) REFERENCES JUGADORES (CODJUGADOR)
  );


insert into  TEMPORADA   ( CODTEMP , NOMBRE )  values ('t1','2008_2009');
insert into  TEMPORADA   ( CODTEMP , NOMBRE )  values ('t2','2009_2010');
insert into  TEMPORADA   ( CODTEMP , NOMBRE )  values ('t3','2010_2011');



INSERT INTO EQUIPOS (CODEQUIPO,NOMBREQUIPO) VALUES ('e1','Asefa Estudiantes');
INSERT INTO EQUIPOS (CODEQUIPO,NOMBREQUIPO) VALUES ('e2','Caja Sol Sevilla');
INSERT INTO EQUIPOS (CODEQUIPO,NOMBREQUIPO) VALUES ('e3','Unicaja Málaga');
INSERT INTO EQUIPOS (CODEQUIPO,NOMBREQUIPO) VALUES ('e4','Madrid');



insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j1','Esteban D.','1985-10-10');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j2','Rafa Martinez','1980-10-10');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j3','Banie','1990-10-10');

insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j4','Fitch.','1992-10-10');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j5','Telotovic','1989-02-13');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j6','Juan Peñi','1985-10-10');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j7','Juan Xi','1991-02-10');


insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j8','Mario G','1991-02-10');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j9','Telvio J','1992-02-10');


insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j10','Mario G','1991-02-10');
insert into JUGADORES  (CODJUGADOR ,NOMBREJUGADOR,FECHANAC) values ('j11','Telvio J','1991-02-10');



insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE ) values ('p1','t1','1',88,99,'e1','e2');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p2','t1','1',77,66,'e3','e4');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p3','t1','2',77,66,'e4','e3');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p4','t1','2',77,66,'e2','e1');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p5','t1','3',77,66,'e1','e4');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p6','t1','3',77,66,'e3','e2');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p7','t1','4',97,66,'e4','e1');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p8','t1','4',70,90,'e2','e3');

insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p9','t2','1',54,78,'e1','e2');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p10','t2','1',79,56,'e3','e4');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p11','t2','2',70,90,'e4','e3');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE ) values ('p12','t2','2',90,66,'e2','e1');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p13','t2','3',90,66,'e1','e4');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p14','t2','3',77,65,'e3','e2');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p15','t2','4',97,65,'e4','e1');
insert into PARTIDOS (CODPARTIDO  ,TEMPORADA,JORNADA,PUNTOSLOCAL ,PUNTOSVISITANTE ,CODEQUIPOLOCAL ,CODEQUIPOVISITANTE )  values ('p16','t2','4',90,90,'e2','e3');



insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j1',4,5,6);
insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j2',2,0,6);
insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j3',4,5,3);
insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j5',0,5,6);
insert into PARTIDOS_JUGADORES  (CODPARTIDO, CODJUGADOR,CANASTAS ,ASISTENCIAS, REBOTES) values ('p1','j6',2,5,6);

insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e1','j1',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e1','j2',1050);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e1','j3',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e2','j4',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e2','j5',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e2','j6',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e2','j7',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e3','j8',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e3','j9',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e3','j1',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e2','j10',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t1','e2','j11',1000);

insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e2','j3',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e2','j7',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e1','j1',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e2','j5',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e3','j5',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e4','j5',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e3','j1',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e4','j7',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e2','j8',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e2','j9',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e1','j2',1000);
insert into TEMP_EQUIPO_JUGADOR  (CODTEMP,CODEQUIPO,CODJUGADOR,SALARIO) values ('t2','e3','j2',1000);
