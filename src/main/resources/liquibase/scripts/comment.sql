-- liquibase formatted sql

-- changeset garry:1
create table comment
(
    id      bigserial   primary key,
    body    varchar(255),
    post_id bigint references post,
    user_id bigint references users
);
