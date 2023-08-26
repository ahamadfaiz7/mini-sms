Save student request (http://localhost:8787/api/save)
----------------------------------------------------
{
"studentName": "Faiz Ahamad",
"studentNumber": 123,
"dateOfBirth": "1988-12-30",
"gender": "Male",
"startingDate": "2020-12-30",
"leavingDate": "2023-12-30",
"address": "ZIM",
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

Get student response (http://localhost:8787/api/students)
-----------------------
[

{
"studentId": 3,
"studentName": "Fardeen Ahamad",
"studentNumber": 10,
"dateOfBirth": "1988-12-30T00:00:00.000+00:00",
"gender": "Babu",
"startingDate": "2020-12-30T00:00:00.000+00:00",
"leavingDate": "2023-12-30T00:00:00.000+00:00",
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
