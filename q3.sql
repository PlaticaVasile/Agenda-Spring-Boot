use DiaryUser;
show tables;
show databases;
drop table student;
drop table user_new;
drop table persoana;

select Notes from Agenda where ID_User = (select ID from User where Username = 'Stefan32');
select * from `User`;