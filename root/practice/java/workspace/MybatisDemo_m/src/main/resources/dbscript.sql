
create database a default charset utf8 COLLATE utf8_general_ci;

use  a;

create table t_system_users (
id int primary key auto_increment,
username varchar(250),
password varchar(250),
create_date datetime
)


insert into t_system_users (username,password,create_date) values ('admin','admin',now());
insert into t_system_users (username,password,create_date) values ('admin1','admin1',now());

