create table UTWOR
(
    ID_UTWOR         NUMBER       not null
        constraint UTWOR_PK
            primary key,
    NAZWA_UTWOR      VARCHAR2(30) not null,
    AUTOR            VARCHAR2(30) not null,
    OPIS             VARCHAR2(150),
    DATA_PUBLIKACJI  DATE         not null,
    UTWOR            BLOB,
    NAZWA_UZYTKOWNIK VARCHAR2(30) not null
        constraint UTWOR_UZYTKOWNIK_FK
            references UZYTKOWNIK
)
/

