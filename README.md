Student Management System is a springboot application with H2 in memory database. 
For the ui design it uses spring-boot-starter-thymeleaf, bootstrap and HTML. 
Application can be accessed from a web browser as a UI OR from  any rest client like postman.

Steps to run the application from front end UI
----------------------------------------------
1. Clone the project from https://github.com/ahamadfaiz7/mini-sms 
2. Import the project in your ide and do a clean build.
3. Run the application bly running StudentManagementSystemApplication.java
4. After the server is started the in memory db will be hosted on http://localhost:8787/h2-console.
5. The url,username and password to connect to H2 database is in application.properties
6. You can access the application and add a student on http://localhost:8787/students/add
7. Creating a student will redirect you to the list of student page http://localhost:8787/students/showStudents
8. In the student's list you can view the student details,view contacts & delete the student

Steps to run the application from a REST client
-----------------------------------------
1. After starting the StudentManagementSystemApplication.java springboot application do a Http 
POST request with below request body to save a new student

Save student request (http://localhost:8787/api/save)
----------------------------------------------------
{
"studentName": "Mohammad Faiz Ahamad",
"studentNumber": 123,
"dateOfBirth": "1988-12-30",
"gender": "MALE",
"startingDate": "2020-12-30",
"leavingDate": "2023-12-30",
"address": "145 Civalry Road, Auckland",
"category": {
"categoryName": "SENIOR"
},
"contacts": [{
"contactName": "Salma",
"relationship": "Sister",
"address": "192 Main Avenue",
"email": "ahamad.faiz7@gmail.com",
"phone": "+64211899955"
},
{
"contactName": "Afsar",
"relationship": "Brother",
"address": "168 Main Avenue",
"email": "ahamad.faiz897@gmail.com",
"phone": "+64211899955"
}
]
}


2. Do a http get to fetch all the students
Get student response (http://localhost:8787/api/students)
-----------------------
Response will show all the students
[
{
"studentId": 3,
"studentName": "Fardeen Ahamad",
"studentNumber": 10,
"dateOfBirth": "1988-12-30",
"gender": "FEMALE",
"startingDate": "2020-12-30",
"leavingDate": "2023-12-30",
"address": "NZ",
"category": {
"categoryId": 1,
"categoryName": "Junior"
},
"contacts": [
{
"contactId": 1,
"contactName": "Salma",
"relationship": "Sister",
"address": "192 Main Avenue",
"email": "ahamad.faiz7@gmail.com",
"phone": "+64211899955"
}
]
}
]

3. Do a http delete to delete a student with student id
 (http://localhost:8787/api/remove/1)

Break down structure in completing this application
-----------------------------------------------------
1. Analyzing and understanding the requirements - 1 hour
2. project design - 3 hours
3. Coding - 12 hours
4. Testing - 2 hours
5. Bugs fixes - 4 hours

Future improvements
----------------------
1. validations on the UI should be done in later stages.
2. Intuitive validation errors for the end user should be added.
3. Validation on the client side and database columns should be synchronized.
4. Few more unit tests to be added in the test suite in the future.
5. Logging should be done using AOP advices.
