# Kaiburr_assingment
To implement the described application, you will need to use the following technologies and tools:

Java: A popular object-oriented programming language.
Spring Boot: An open-source Java framework for building standalone, production-grade applications.
MongoDB: A document-oriented NoSQL database.
Maven: A build automation tool used primarily for Java projects.
Postman: A popular API development tool used to test RESTful web services.
Here are the steps to implement the application:

Step 1: Set up the Development Environment
To set up your development environment, you will need to install the following:

Java Development Kit (JDK) version 8 or higher
IntelliJ IDEA or any other Java IDE of your choice
Maven
MongoDB
Step 2: Create a Spring Boot Project
In IntelliJ IDEA, select "New Project" from the "File" menu. Choose "Spring Initializr" as the project type and click "Next." Enter a group name, artifact name, and package name for your project. Select "Web," "MongoDB," and "Spring Data MongoDB" as the dependencies, and click "Next." Choose a project name and location, and click "Finish."

Step 3: Define the Server Model
Create a new class called "Server" in the package "com.example.demo.model". This class should have the following fields:

id: String
name: String
language: String
framework: String
Generate the getters and setters for each field.

Step 4: Create a Repository Interface
Create a new interface called "ServerRepository" in the package "com.example.demo.repository". This interface should extend "MongoRepository<Server, String>". This will give you access to basic CRUD operations on the "Server" collection in MongoDB.

Step 5: Create a Service Class
Create a new class called "ServerService" in the package "com.example.demo.service". This class should have the following methods:

findAll(): List<Server> - This method should return a list of all servers.
findById(String id): Server - This method should return a single server with the specified ID.
findByName(String name): List<Server> - This method should return a list of all servers whose names contain the specified string.
save(Server server): Server - This method should save the specified server to the database.
deleteById(String id): void - This method should delete the server with the specified ID from the database.
Step 6: Create a REST Controller
Create a new class called "ServerController" in the package "com.example.demo.controller". This class should have the following methods:

@GetMapping("/servers") - This method should return a list of all servers if no parameters are passed. If a server ID is passed as a parameter, it should return a single server or a 404 error if there's no such server.
@GetMapping("/servers/{name}") - This method should return a list of all servers whose names contain the specified string. If nothing is found, it should return a 404 error.
@PutMapping("/servers") - This method should save the specified server to the database.
@DeleteMapping("/servers/{id}") - This method should delete the server with the specified ID from the database.
Step 7: Test the Application
Start your application and use Postman or any other HTTP client to test the endpoints. Here are some examples:

GET http://localhost:8080/servers - Returns a list of all servers.
GET http://localhost:8080/servers/123 - Returns the server with the ID "123" if it exist
