create table "Utwor/Lista"
(
    ID_LISTA NUMBER not null
        constraint "Utwor/Lista_Lista_FK"
            references LISTA,
    ID_UTWOR NUMBER not null
        constraint "Utwor/Lista_Utwor_FK"
            references UTWOR,
    constraint "Utwor/Lista_PK"
        primary key (ID_LISTA, ID_UTWOR)
)
/

