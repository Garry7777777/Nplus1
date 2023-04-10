-- liquibase formatted sql

-- changeset garry:1
create table post
(
    id      bigserial primary key,
    body    varchar(255),
    title   varchar(255),
    user_id bigint references users
);
