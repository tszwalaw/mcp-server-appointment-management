# mcp-server-appointment-management
This project is a Java-based MCP (Model-Context-Protocol) server designed to manage appointment data from the database.It provides a modular framework that exposes internal tools for data access and manipulation, with built-in support for AI-driven features

## Features

- User verification and authentication
- Appointment scheduling and management
- PostgreSQL database integration

## Prerequisites
- Java 17 or higher
- Maven 3.6+
- PostgreSQL or mySQL - you can use other database*
- Spring Boot 
- Spring AI 1.0.0-M7

## Configure Database
Before running the application, configure your database connection. The server currently supports PostgreSQL and MySQL. To connect to your database, update the application.properties file in the src/main/resources folder with your database configuration:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/demodb
spring.datasource.username=admin
spring.datasource.password=adminpw

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Token-based Authentication and Authorization
In this application, tokens are used to authenticate and authorize users for appointment management actions. Once the user's identity is verified, a temporary token is generated. This token acts as a key to perform operations like:

Creating appointments
Updating existing appointments
Canceling appointments
The token must be passed in each MCP request to ensure that the operation is authorized. Tokens will expire after a set period or can be revoked manually.

* You can change or extend the authentication method to suit your needs. For example, you can implement user login functionality.

### Example Token Workflow:
1. User requests token by providing their credentials.
2. Upon successful verification, the system generates a temporary token.
3. The token is used in subsequent requests to perform appointment-related actions.
4. The token has a predefined expiration period for security reasons, which can be change in configuration file.

## Appointment Management
This system supports the following appointment management functionalities:

1. Create Appointment
   The system allows users to create new appointments. Once a user is authenticated and authorized, they can submit an appointment request, providing necessary details (e.g., time, date, and participants).

2. Update Appointment
   Users with valid tokens can update the details of an existing appointment. This includes changing the time, participants, or status of the appointment.

3. Cancel Appointment
   Users can cancel appointments using the system. Once canceled, the appointment is removed from the database, and the relevant notifications are sent.

## AI-Powered Features

The application uses the MCP protocol, which ensures that security is maintained for the internal database while still allowing the AI to perform critical actions on updating and managing appointments. This protocol layer provides a secure way for AI systems to access and manipulate data without directly exposing the internal database, thus protecting sensitive information and ensuring that only authorized actions are executed.

## Potential Use Cases
The integration of MCP with AI tools opens up exciting opportunities for a wide range of AI-powered applications:

### Chatbot Integration: 
With the AI-powered scheduling tools exposed via MCP, chatbots can assist users in scheduling, updating, and canceling appointments. These chatbots can understand the context of the user’s needs and provide intelligent suggestions based on their availability and preferences.

### Smart Scheduling Assistants:
AI-driven scheduling assistants can make real-time decisions for users, helping them book, reschedule, or cancel appointments without direct human interaction.

### Automated Conflict Resolution:
The AI can proactively resolve conflicts in appointment scheduling by using the exposed MCP tools. If two users attempt to book the same time slot, the AI can automatically suggest an alternative, thus minimizing human intervention.

## Contribution Guidelines
We welcome contributions! If you’d like to contribute to this project, follow these steps:
1. Fork the repository.
2. Create a new branch (git checkout -b feature-branch).
3. Make your changes.
4. Commit your changes (git commit -am 'Added new feature').
5. Push to the branch (git push origin feature-branch).
6. Create a pull request.