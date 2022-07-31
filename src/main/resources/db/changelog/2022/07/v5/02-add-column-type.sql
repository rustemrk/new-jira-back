alter table todo
    add column type int;

alter table todo
    add constraint fk_todo_type foreign key (type) references todo_type (id) on delete restrict;