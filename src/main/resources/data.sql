DROP TABLE IF EXISTS finance;
 
create table finance (
id bigint not null auto_increment, 
number_of_customer bigint, 
number_of_facilities integer, 
sector varchar(255), 
primary key (id));
  
INSERT INTO finance (number_of_customer, number_of_facilities, sector) VALUES (100, 2, 'ABC');
INSERT INTO finance (number_of_customer, number_of_facilities, sector) VALUES (400, 15, 'BCD');
INSERT INTO finance (number_of_customer, number_of_facilities, sector) VALUES (150, 5, 'CDE');
