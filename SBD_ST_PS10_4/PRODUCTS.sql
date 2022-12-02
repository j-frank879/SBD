create table PRODUCTS
(
    PRODUCT_ID        NUMBER(9),
    PRODUCT_NAME      VARCHAR2(40),
    SUPPLIER_ID       NUMBER(9),
    CATEGORY_ID       NUMBER(9),
    QUANTITY_PER_UNIT VARCHAR2(20),
    UNIT_PRICE        NUMBER(10, 2) default 0,
    UNITS_IN_STOCK    NUMBER(9)     default 0,
    UNITS_ON_ORDER    NUMBER(9)     default 0,
    REORDER_LEVEL     NUMBER(9)     default 0,
    DISCONTINUED      CHAR          default 'N'
)
/

