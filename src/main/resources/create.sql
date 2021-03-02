drop table CARTITEM if exists;
drop table CART if exists;
drop table PRODUCT if exists;
drop table USER if exists;

-- ID field value will match jwtUser id (1 - 1)
CREATE TABLE USER
(
    ID    BIGINT       not null primary key,
    EMAIL VARCHAR(255) not null,
    NAME  VARCHAR(255) not null
);

insert into USER (ID, EMAIL, NAME) VALUES (1, 'joe@joe.com', 'Joe');
insert into USER (ID, EMAIL, NAME) VALUES (2, 'ann@ann.com', 'Ann');
insert into USER (ID, EMAIL, NAME) VALUES (3, 'admin@admin.com', 'Admin');


CREATE TABLE PRODUCT
(
    ID    BIGINT       not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1),
    NAME  VARCHAR(255) not null,
    PRICE BIGINT       not null
);

insert into PRODUCT (NAME, PRICE) VALUES ('Cat', 100);
insert into PRODUCT (NAME, PRICE) VALUES ('Dog', 200);
insert into PRODUCT (NAME, PRICE) VALUES ('Fish', 50);

CREATE TABLE CART
(
    ID     BIGINT       not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1),
    STATUS VARCHAR(255) not null,
    USERID BIGINT not null REFERENCES USER (ID)
);

CREATE TABLE CARTITEM
(
    ID        BIGINT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1),
    QUANTITY  INT    not null,
    CARTID    BIGINT not null REFERENCES CART (ID),
    PRODUCTID BIGINT not null REFERENCES PRODUCT (ID)
);
