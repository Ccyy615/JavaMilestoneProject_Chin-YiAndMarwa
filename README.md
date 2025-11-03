o Project description

This project is a simple Flight Booking REST API built with Spring Boot, JPA, using an H2 database
It manages two main entities: Flights + Passengers
it is a OneToMany relationships where:
1 flight -> many passengers
1 passenger -> one flight 

Flights — containing flight details such as:
airline
placeDepart;
destination
departDate
arrivalDate
departTime
arrivalTime
internalCode

Passengers — containing passenger details:
passengerId
firstName
lastName
dateOfBirth
gender
address
phoneNumber
email
passportNumber
passportExpiryDate
creditCardNumber
numOfBaggage


The two entities are linked to a specific flight using flightId

The API supports full CRUD operations for both entities and includes:

Validation (e.g., invalid passport, underage passenger,
price flight must be minimum 50$, email must be in the right format, 
the date of birth must be in the past, the last name and first name cannot be blank)

If a flight is deleted than all passengers who are in that flight will also be deleted

Exception handling (400, 404 errors)
List of Exceptions: 
-Underage passenger (InvalidAgeBookingException)
-Expired passport (InvalidPassportExpiredException)
-Not found (404)
-Bad request (400)

startup using CommandLineRunner
Docker support for deployment 
used Render to deploy the spring boot app


o How to run locally
1- Clone the project
git clone https://github.com/Ccyy615/JavaMilestoneProject_Chin-YiAndMarwa.git
cd JavaMilestoneProject_Chin-YiAndMarwa

2- run with gradle
./gradlew bootRun

3- Try on postman with http://localhost:8080/flights or http://localhost:8080/passenger


o API endpoints table

FLIGHTS:
GET http://localhost:8080/flights -Get all the flights
GET http://localhost:8080/flights/1 - Get the flight by its Id
POST http://localhost:8080/flights - Creates a new flight 201 created
PUT http://localhost:8080/flights/2 - Updates an existing flight
DELETE http://localhost:8080/flights/4 - Deletes a flight with all passengers 204 no content
GET(Aggregated) http://localhost:8080/flights/2/passengers - Get all the passengers that are in Flight with Id 1 by example

PASSENGERS:
GET http://localhost:8080/passengers - Get all passengers
GET http://localhost:8080/passengers/2 - Get passenger by Id
POST http://localhost:8080/passengers - Creates a new passenger
PUT http://localhost:8080/passengers/2 - Updates an existing passenger
DELETE http://localhost:8080/passengers/2 - Deletes a passenger but not its flights
GET(Aggregated) http://localhost:8080/passengers/1/flights - Get a passenger with a summary of their flight 

o Sample curl/Postman requests

try to create a new passenger(Body + raw on postman) with this information down below:

{
"firstName": "James",
"lastName": "Wilson",
"dateOfBirth": "1988-03-15",
"gender": "Male",
"address": "1542 Rue Saint-Denis, Montreal, QC",
"phoneNumber": "438-922-3344",
"email": "james.wilson@email.com",
"passportNumber": "CA1234567",
"passportExpiryDate": "2027-08-22",
"creditCardNumber": "5274 8192 7364 9821",
"numOfBaggage": 1,
"flightId": 1
}


if you try this: 

{
"firstName": "James",
"lastName": "Wilson",
"dateOfBirth": "1990 -03-15",    
"gender": "Male",
"address": "1542 Rue Saint-Denis, Montreal, QC",
"phoneNumber": "438-922-3344",
"email": "james.wilson@email.com",
"passportNumber": "CA1234567",
"passportExpiryDate": "2020-08-22", <- EXPIRED PASSPORT
"creditCardNumber": "5274 8192 7364 9821",
"numOfBaggage": 1,
"flightId": 1
}

YOU will get as a response (Handling bad input from user):

{
"path": "/passengers",
"error": "We cannot accept this Passport",
"message": "Passport is expired",
"timestamp": "2025-11-02T22:10:01.411485",
"status": 400
}


o Deployment URL
our URL(used Render): https://milestoneproject-chin-yiandmarwa-axqq.onrender.com
try it with that: https://milestoneproject-chin-yiandmarwa-axqq.onrender.com/passengers

o Credentials (if any) 

