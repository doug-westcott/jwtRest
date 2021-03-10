drop table CARTITEM if exists;
drop table CART if exists;
drop table PRODUCT if exists;
drop table USER if exists;

-- ID field value will match jwtUser username 1-1
CREATE TABLE USER
(
    ID    VARCHAR(255) not null primary key,
    NAME  VARCHAR(255) not null,
    ROLE  VARCHAR(255) not null,
    PICTURE VARCHAR(255) not null
);

insert into USER (ID, NAME, ROLE, PICTURE) VALUES ('joe@joe.com', 'Joe', 'Customer', '');
insert into USER (ID, NAME, ROLE, PICTURE) VALUES ('ann@ann.com', 'Ann', 'Customer', '');
insert into USER (ID, NAME, ROLE, PICTURE) VALUES ('fred@fred.com', 'Fred', 'Support', '');
insert into USER (ID, NAME, ROLE, PICTURE) VALUES ('admin@admin.com', 'Admin', 'Admin', '');

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
    USERID VARCHAR(255) not null REFERENCES USER (ID)
);

CREATE TABLE CARTITEM
(
    ID        BIGINT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1),
    QUANTITY  INT    not null,
    CARTID    BIGINT not null REFERENCES CART (ID),
    PRODUCTID BIGINT not null REFERENCES PRODUCT (ID)
);
