CREATE TABLE student (
  studentId int NOT NULL,
  studentName varchar(50) NOT NULL,
  studentNumber int NOT NULL,
  dateOfBirth date NOT NULL,
  gender varchar(50) NOT NULL,
  startingDate date NOT NULL,
  leavingDate date NOT NULL,
  address varchar(50) NOT NULL,
  PRIMARY KEY (studentId)
);

insert into student(studentId, studentName,studentNumber,dateOfBirth,gender,startingDate,leavingDate,address)
values(1,'Faiz',6,'1988-12-31','male','2020-12-31','2023-12-31','NZ');

insert into student(studentId, studentName,studentNumber,dateOfBirth,gender,startingDate,leavingDate,address)
values(2,'Ahamad',7,'1989-12-31','female','2020-12-31','2023-12-31','AUS');