show databases;
create database DB1;
use DB1;use sys;drop database DB1;
create table Tab1
(
ID int primary key identity,
Name nvarchar(100),
Age int
);
insert into Tab1 values ('Ion',21),('Dorin',12);
select * from Tab1;


create database Accountt;
use Accountt;
create table Userr
(
ID int not null auto_increment primary key,
Username nvarchar(50) not null,
Passwordd nvarchar(50) not null
);
insert into Userr (Username, Passwordd) values
('CojocDeUrs', 'mimi2'),
('FeciorulDeAur', 'tup5');
select * from Userr;
show tables;
drop table Persoana;
select * from persOana;
/* new start 01.04 with Arjun*/
use Accountt;
select * from Student;
select * from Userr;
select * from User;
/*03.04*/
use Accountt;
create table Masina
(
ID int auto_increment primary key,
Marca nvarchar(50),
Model nvarchar(30),
Culoare nvarchar(25)
);
insert into Masina (Marca, Model, Culoare) values
('VW', 'Golf 3', 'alb'),
('BMW', 'M3', 'rosu'),
('Dacja', 'Logan', 'verde');
select * from Masina;

/*06.04*/
use sys;
drop database Accountt;
drop database DiaryUser;

create database DiaryUser character set latin1 collate latin1_general_cs;
use DiaryUser;

create table `User`
(
`ID` int auto_increment primary key,
`Username` varchar(35) not null,
`Password` varchar(25) not null,
`Email` varchar(38) not null,
`Type` varchar(8) default 'Standard',
constraint `User_c1` check (`Type` = 'Standard' or `Type` = 'Premium')
);
alter table `User` add unique (`Username`);
alter table `User` add unique (`Email`);
alter table `User` add constraint `User_c2` check (char_length(`Password`) >= 8);

insert into `User` (`Username`, `Password`, `Email`, `Type`) values
('Stefan32', 'cod-trecere-cod-trecere', 'stefan2001_21@yahoo.ro', 'Standard'),
('Ionel', 'bustean-voluminos123', 'ionel_orasanu38@yahoo.com', 'Premium'),
('Raul Pop', 'gazonVerdeTOP', 'player_RAOL@gmail.com', 'Standard'),
('Anton Cocor', 'balastiera321', 'cocor_de_apaDulce2005@gmail.com', 'Standard');

select * from `User`;

create table `SecurityQuestion`
(
`ID` int auto_increment primary key,
`Question` varchar(40) not null,
`Answer` varchar(15) not null,
`ID_User` int,
constraint `SecurityQuestion_fk` foreign key (`ID_User`) references `User`(`ID`),
constraint `SecurityQuestion_c1` check (
`Question` = 'What is your dog name?' or 
`Question` = 'What is your childhood nickname?' or 
`Question` = 'When did you finish school?' or
`Question` = 'Where did you grow up?' or
`Question` = 'What sport are most attracted to?'),
constraint `SecurityQuestion_c2` check (char_length(`Answer`) >= 5)
);

insert into `SecurityQuestion` (`Question`, `Answer`, `ID_User`) values
('Where did you grow up?', 'Oslo City', 1),
('What is your dog name?', 'Rufus', 2),
('Where did you grow up?', 'Helsinki', 3),
('What sport are most attracted to?', 'Cricket', 4);

select * from `SecurityQuestion`;

create table `Agenda`
(
`ID` int auto_increment primary key,
`Notes` varchar(65000),
`Date` datetime default current_timestamp,
`ID_User` int,
constraint `Agenda_fk` foreign key (`ID_User`) references `User` (`ID`)
);

insert into `Agenda` (`Notes`, `ID_User`) values
('uda florile cu ingrasamant', 1);
insert into `Agenda` (`Notes`, `ID_User`) values
('suna pe Mariana pentru programare dentist!!', 1);
insert into `Agenda` (`Notes`, `ID_User`) values
('rescrie recenzie carte', 1);
insert into `Agenda` (`Notes`, `ID_User`) values
('program sala - mult sport', 3);
insert into `Agenda` (`Notes`, `ID_User`) values
('de vizitat parcul Brandusa!, sun-o pe Dorina', 2);

select * from `Agenda`;