create table todo_type
(
    id   int auto_increment primary key,
    name varchar(255)
);

alter table todo_type
    add constraint chk_name check (name is not null);

insert into todo_type (name)
values ('Задача'),
       ('Баг');

