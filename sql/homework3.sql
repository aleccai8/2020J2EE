create table admin
(
    id       int auto_increment
        primary key,
    username varchar(20) not null,
    password varchar(20) not null
);

create table person
(
    id       varchar(11) not null
        primary key,
    name     varchar(11) not null,
    phone    varchar(20) not null,
    qq       varchar(20) null,
    email    varchar(50) null,
    password varchar(20) null,
    constraint person_phone_uindex
        unique (phone)
);

