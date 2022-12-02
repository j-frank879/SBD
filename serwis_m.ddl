-- Generated by Oracle SQL Developer Data Modeler 21.2.0.165.1515
--   at:        2022-11-21 15:02:23 CET
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE artykul (
    id_artykul       INTEGER NOT NULL,
    nazwa_artykul    VARCHAR2(30) NOT NULL,
    data_publikacji  DATE NOT NULL,
    nazwa_uzytkownik VARCHAR2(30) NOT NULL
);

ALTER TABLE artykul ADD CONSTRAINT artykul_pk PRIMARY KEY ( id_artykul );

CREATE TABLE komentarz (
    id_komentarz     INTEGER NOT NULL,
    data_publikacji  DATE NOT NULL,
    tresc            VARCHAR2(150) NOT NULL,
    nazwa_uzytkownik VARCHAR2(30) NOT NULL,
    id_utwor         INTEGER NOT NULL,
    id_artykul       INTEGER NOT NULL
);

ALTER TABLE komentarz ADD CONSTRAINT komentarz_pk PRIMARY KEY ( id_komentarz );

CREATE TABLE lista (
    id_lista         INTEGER NOT NULL,
    nazwa_lista      VARCHAR2(30) NOT NULL,
    publiczna        CHAR(1) NOT NULL,
    nazwa_uzytkownik VARCHAR2(30) NOT NULL
);

ALTER TABLE lista ADD CONSTRAINT lista_pk PRIMARY KEY ( id_lista );

CREATE TABLE "Polub/Artykul" (
    nazwa_uzytkownik VARCHAR2(30) NOT NULL,
    id_artykul       INTEGER NOT NULL
);

ALTER TABLE "Polub/Artykul" ADD CONSTRAINT "Polub/Artykul_PK" PRIMARY KEY ( nazwa_uzytkownik,
                                                                            id_artykul );

CREATE TABLE "Polub/Utwor" (
    nazwa_uzytkownik VARCHAR2(30) NOT NULL,
    id_utwor         INTEGER NOT NULL
);

ALTER TABLE "Polub/Utwor" ADD CONSTRAINT "Polub/Utwor_PK" PRIMARY KEY ( nazwa_uzytkownik,
                                                                        id_utwor );

CREATE TABLE utwor (
    id_utwor         INTEGER NOT NULL,
    nazwa_utwor      VARCHAR2(30) NOT NULL,
    autor            VARCHAR2(30) NOT NULL,
    opis             VARCHAR2(150),
    data_publikacji  DATE NOT NULL,
    utwor            BLOB,
    nazwa_uzytkownik VARCHAR2(30) NOT NULL
);

ALTER TABLE utwor ADD CONSTRAINT utwor_pk PRIMARY KEY ( id_utwor );

CREATE TABLE "Utwor/Lista" (
    id_lista INTEGER NOT NULL,
    id_utwor INTEGER NOT NULL
);

ALTER TABLE "Utwor/Lista" ADD CONSTRAINT "Utwor/Lista_PK" PRIMARY KEY ( id_lista,
                                                                        id_utwor );

CREATE TABLE uzytk_sledz (
    nazwa_uzytkownik    VARCHAR2(30) NOT NULL,
    uzytkownik_sledzony VARCHAR2(30) NOT NULL
);

ALTER TABLE uzytk_sledz ADD CONSTRAINT uzytk_sledz_pk PRIMARY KEY ( nazwa_uzytkownik,
                                                                    uzytkownik_sledzony );

CREATE TABLE uzytkownik (
    nazwa_uzytkownik VARCHAR2(30) NOT NULL,
    haslo            VARCHAR2(30) NOT NULL,
    blokada          CHAR(1),
    email            VARCHAR2(40) NOT NULL,
    rola             VARCHAR2(15) NOT NULL
);

ALTER TABLE uzytkownik ADD CONSTRAINT uzytkownik_pk PRIMARY KEY ( nazwa_uzytkownik );

CREATE TABLE wiadomosc (
    id_wiadomosc    INTEGER NOT NULL,
    data_wyslania   DATE NOT NULL,
    tresc           VARCHAR2(150) NOT NULL,
    nazwa_nadawcy   VARCHAR2(30) NOT NULL,
    nazwa_odbiorcy1 VARCHAR2(30) NOT NULL
);

ALTER TABLE wiadomosc ADD CONSTRAINT wiadomosc_pk PRIMARY KEY ( id_wiadomosc );

ALTER TABLE artykul
    ADD CONSTRAINT artykul_uzytkownik_fk FOREIGN KEY ( nazwa_uzytkownik )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE komentarz
    ADD CONSTRAINT komentarz_artykul_fk FOREIGN KEY ( id_artykul )
        REFERENCES artykul ( id_artykul );

ALTER TABLE komentarz
    ADD CONSTRAINT komentarz_utwor_fk FOREIGN KEY ( id_utwor )
        REFERENCES utwor ( id_utwor );

ALTER TABLE komentarz
    ADD CONSTRAINT komentarz_uzytkownik_fk FOREIGN KEY ( nazwa_uzytkownik )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE lista
    ADD CONSTRAINT lista_uzytkownik_fk FOREIGN KEY ( nazwa_uzytkownik )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE "Polub/Artykul"
    ADD CONSTRAINT "Polub/Artykul_Artykul_FK" FOREIGN KEY ( id_artykul )
        REFERENCES artykul ( id_artykul );

ALTER TABLE "Polub/Artykul"
    ADD CONSTRAINT "Polub/Artykul_Uzytkownik_FK" FOREIGN KEY ( nazwa_uzytkownik )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE "Polub/Utwor"
    ADD CONSTRAINT "Polub/Utwor_Utwor_FK" FOREIGN KEY ( id_utwor )
        REFERENCES utwor ( id_utwor );

ALTER TABLE "Polub/Utwor"
    ADD CONSTRAINT "Polub/Utwor_Uzytkownik_FK" FOREIGN KEY ( nazwa_uzytkownik )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE utwor
    ADD CONSTRAINT utwor_uzytkownik_fk FOREIGN KEY ( nazwa_uzytkownik )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE "Utwor/Lista"
    ADD CONSTRAINT "Utwor/Lista_Lista_FK" FOREIGN KEY ( id_lista )
        REFERENCES lista ( id_lista );

ALTER TABLE "Utwor/Lista"
    ADD CONSTRAINT "Utwor/Lista_Utwor_FK" FOREIGN KEY ( id_utwor )
        REFERENCES utwor ( id_utwor );

ALTER TABLE uzytk_sledz
    ADD CONSTRAINT uzytk_sledz_uzytkownik_fk FOREIGN KEY ( nazwa_uzytkownik )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE uzytk_sledz
    ADD CONSTRAINT uzytk_sledz_uzytkownik_fkv2 FOREIGN KEY ( uzytkownik_sledzony )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE wiadomosc
    ADD CONSTRAINT wiadomosc_uzytkownik_fk FOREIGN KEY ( nazwa_odbiorcy1 )
        REFERENCES uzytkownik ( nazwa_uzytkownik );

ALTER TABLE wiadomosc
    ADD CONSTRAINT wiadomosc_uzytkownik_fkv2 FOREIGN KEY ( nazwa_nadawcy )
        REFERENCES uzytkownik ( nazwa_uzytkownik );



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            10
-- CREATE INDEX                             0
-- ALTER TABLE                             26
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
