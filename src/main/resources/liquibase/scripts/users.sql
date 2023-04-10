-- liquibase formatted sql

-- changeset garry:1
create table users
(
    id   bigserial primary key,
    name varchar(255)
);


