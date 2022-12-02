create table UZYTK_SLEDZ
(
    NAZWA_UZYTKOWNIK    VARCHAR2(30) not null
        constraint UZYTK_SLEDZ_UZYTKOWNIK_FK
            references UZYTKOWNIK,
    UZYTKOWNIK_SLEDZONY VARCHAR2(30) not null
        constraint UZYTK_SLEDZ_UZYTKOWNIK_FKV2
            references UZYTKOWNIK,
    constraint UZYTK_SLEDZ_PK
        primary key (NAZWA_UZYTKOWNIK, UZYTKOWNIK_SLEDZONY)
)
/

