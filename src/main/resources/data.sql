/*
truncate table users cascade;
truncate table teams cascade;

alter table users alter column id restart with 1;
alter table teams alter column id restart with 1;
*/
