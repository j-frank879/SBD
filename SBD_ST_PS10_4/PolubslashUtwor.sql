create table "Polub/Utwor"
(
    NAZWA_UZYTKOWNIK VARCHAR2(30) not null
        constraint "Polub/Utwor_Uzytkownik_FK"
            references UZYTKOWNIK,
    ID_UTWOR         NUMBER       not null
        constraint "Polub/Utwor_Utwor_FK"
            references UTWOR,
    constraint "Polub/Utwor_PK"
        primary key (NAZWA_UZYTKOWNIK, ID_UTWOR)
)
/

