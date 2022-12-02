create table ARTYKUL
(
    ID_ARTYKUL       NUMBER       not null
        constraint ARTYKUL_PK
            primary key,
    NAZWA_ARTYKUL    VARCHAR2(30) not null,
    DATA_PUBLIKACJI  DATE         not null,
    NAZWA_UZYTKOWNIK VARCHAR2(30) not null
        constraint ARTYKUL_UZYTKOWNIK_FK
            references UZYTKOWNIK
)
/

