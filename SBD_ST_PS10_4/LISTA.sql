create table LISTA
(
    ID_LISTA         NUMBER       not null
        constraint LISTA_PK
            primary key,
    NAZWA_LISTA      VARCHAR2(30) not null,
    PUBLICZNA        CHAR         not null,
    NAZWA_UZYTKOWNIK VARCHAR2(30) not null
        constraint LISTA_UZYTKOWNIK_FK
            references UZYTKOWNIK
)
/

