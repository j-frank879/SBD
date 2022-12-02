create table KOMENTARZ
(
    ID_KOMENTARZ     NUMBER        not null
        constraint KOMENTARZ_PK
            primary key,
    DATA_PUBLIKACJI  DATE          not null,
    TRESC            VARCHAR2(150) not null,
    NAZWA_UZYTKOWNIK VARCHAR2(30)  not null
        constraint KOMENTARZ_UZYTKOWNIK_FK
            references UZYTKOWNIK,
    ID_UTWOR         NUMBER        not null
        constraint KOMENTARZ_UTWOR_FK
            references UTWOR,
    ID_ARTYKUL       NUMBER        not null
        constraint KOMENTARZ_ARTYKUL_FK
            references ARTYKUL
)
/

