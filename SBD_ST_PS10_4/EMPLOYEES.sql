create table EMPLOYEES
(
    EMPLOYEE_ID       NUMBER(9),
    LASTNAME          VARCHAR2(20),
    FIRSTNAME         VARCHAR2(10),
    TITLE             VARCHAR2(30),
    TITLE_OF_COURTESY VARCHAR2(25),
    BIRTHDATE         DATE,
    HIREDATE          DATE,
    ADDRESS           VARCHAR2(60),
    CITY              VARCHAR2(15),
    REGION            VARCHAR2(15),
    POSTAL_CODE       VARCHAR2(10),
    COUNTRY           VARCHAR2(15),
    HOME_PHONE        VARCHAR2(24),
    EXTENSION         VARCHAR2(4),
    PHOTO             VARCHAR2(255),
    NOTES             VARCHAR2(2000),
    REPORTS_TO        NUMBER(9)
)
/

