create database employee_management_system;

create table employee
(emp_id int primary key auto_increment,
fname varchar(30)not null,
lname varchar(30)not null,
gender varchar(15)not null,
email varchar(50)unique not null,
mobno bigint unique not null,
dob date not null,
age int not null,
salary bigint not null,
role varchar(30)not null,
join_date date not null,
 experience int not null,
city varchar(30)not null,
 state varchar(30)not null,
country varchar(30)not null,
marital_status varchar(20)not null
,password varchar(8));

create table admin
(id int primary key auto_increment,
 name varchar(20),
 email varchar(50)unique,
 mobile_number mediumtext ,
 password varchar(8));
