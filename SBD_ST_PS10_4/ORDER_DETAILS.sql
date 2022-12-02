create table ORDER_DETAILS
(
    ORDER_ID   NUMBER(9),
    PRODUCT_ID NUMBER(9),
    UNIT_PRICE NUMBER(10, 2) default 0,
    QUANTITY   NUMBER(9)     default 1,
    DISCOUNT   NUMBER(4, 2)  default 0
)
/

