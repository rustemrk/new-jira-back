alter table todo
    drop foreign key fk_todo_type;

alter table todo
    drop index fk_todo_type;

alter table todo
    drop column type;