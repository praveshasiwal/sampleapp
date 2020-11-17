DROP TABLE IF EXISTS finance;
 
create table finance (
id bigint not null, 
number_of_customer bigint, 
number_of_facilities integer, 
sector varchar(255), 
primary key (id));
 
  
INSERT INTO finance VALUES (1, 100, 2, 'ABC');
INSERT INTO finance VALUES (2, 400, 15, 'BCD');
INSERT INTO finance VALUES (3, 150, 5, 'CDE');
