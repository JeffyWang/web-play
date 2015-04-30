# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table pool (
  id                        integer auto_increment not null,
  create_date               datetime,
  update_date               datetime,
  pool_name                 varchar(255),
  host                      varchar(255),
  port                      integer,
  version                   varchar(255),
  constraint pk_pool primary key (id))
;

create table user (
  id                        integer auto_increment not null,
  create_date               datetime,
  update_date               datetime,
  user_name                 varchar(255),
  password                  varchar(255),
  tenant_name               varchar(255),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table pool;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

