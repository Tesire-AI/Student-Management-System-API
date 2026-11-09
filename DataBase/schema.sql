create table students(id serial primary key,
full_name varchar(150) not null,
age integer check(age>18),
email varchar(150) unique);