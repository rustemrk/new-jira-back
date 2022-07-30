create table todo
(
    id          bigint       not null primary key auto_increment,
    title       varchar(255) not null,
    description varchar(255)
)