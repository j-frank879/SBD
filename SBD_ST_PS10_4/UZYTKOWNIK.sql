create table UZYTKOWNIK
(
    NAZWA_UZYTKOWNIK VARCHAR2(30) not null
        constraint UZYTKOWNIK_PK
            primary key,
    HASLO            VARCHAR2(30) not null,
    BLOKADA          CHAR,
    EMAIL            VARCHAR2(40) not null,
    ROLA             VARCHAR2(15) not null
)
/

