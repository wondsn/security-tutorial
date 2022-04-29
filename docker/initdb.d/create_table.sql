create sequence hibernate_sequence start with 1 increment by 1;
create table member (
  id bigint not null,
  password varchar(255) not null,
  username varchar(255) not null,
  roles varchar(255) not null,
  primary key (id)) engine=InnoDB;
