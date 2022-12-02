create table WIADOMOSC
(
    ID_WIADOMOSC    NUMBER        not null
        constraint WIADOMOSC_PK
            primary key,
    DATA_WYSLANIA   DATE          not null,
    TRESC           VARCHAR2(150) not null,
    NAZWA_NADAWCY   VARCHAR2(30)  not null
        constraint WIADOMOSC_UZYTKOWNIK_FKV2
            references UZYTKOWNIK,
    NAZWA_ODBIORCY1 VARCHAR2(30)  not null
        constraint WIADOMOSC_UZYTKOWNIK_FK
            references UZYTKOWNIK
)
/

