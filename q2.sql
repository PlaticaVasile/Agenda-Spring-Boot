use sys;
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
select distinct Type from `User`;

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

update `Agenda` set ID_User = 1 where ID_User is null;
alter table `Agenda` modify `ID_User` int not null;


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
insert into `Agenda` (`Notes`, `ID_User`) values
('mananca sanatos', 3);

select * from `Agenda`;

/* it works this way */
insert into `Agenda` (`ID_User`, `Notes`) values 
(
    (select `ID` from `User` where `Username` = 'Doru Dorut'),
    'notita buna!!!'
);

select Notes from Agenda where ID_User = (select ID from User where Username = 'Stefan32');
select Notes from Agenda where ID_User = (select ID from User where Username = 'Stefan32');