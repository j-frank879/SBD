create table "Polub/Artykul"
(
    NAZWA_UZYTKOWNIK VARCHAR2(30) not null
        constraint "Polub/Artykul_Uzytkownik_FK"
            references UZYTKOWNIK,
    ID_ARTYKUL       NUMBER       not null
        constraint "Polub/Artykul_Artykul_FK"
            references ARTYKUL,
    constraint "Polub/Artykul_PK"
        primary key (NAZWA_UZYTKOWNIK, ID_ARTYKUL)
)
/

