# Premier Zone API 

A RESTful backend web service built to manage and query a comprehensive database of English Premier League player statistics. 

This API provides full CRUD (Create, Read, Update, Delete) functionality and advanced filtering mechanisms to seamlessly retrieve player data based on various metrics like team, position, and nationality.

##  Tech Stack

* **Language:** Java 21
* **Framework:** Spring Boot (v3.5)
* **Data Access:** Spring Data JPA
* **Database:** PostgreSQL
* **Build Tool:** Maven
* **Testing:** Postman

##  Architecture 

The application is built using MVC architecture to ensure clean separation of concerns, modularity, and maintainability:
* **Controller Layer:** Manages routing and handles incoming HTTP REST requests and responses.
* **Service Layer:** Encapsulates the core business logic and data processing.
* **Repository Layer:** Interfaces directly with the PostgreSQL database utilizing Spring Data JPA for data persistence.

##  Features

* **Full CRUD Operations:** Add new players, update existing stats, delete records, and retrieve full rosters.
* **Dynamic Search & Filtering:** Custom repository queries allow users to filter players by specific teams, playing positions, nationalities, or even partial name matches.
* **Relational Database Integration:** Designed with PostgreSQL and Spring Data JPA for robust data persistence.
* **RESTful Architecture:** Clean, stateless endpoint mapping adhering to standard HTTP methods and status codes.

##  API Endpoints

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/player` | Retrieve a list of all players |
| `GET` | `/api/v1/player?team={team}` | Retrieve players belonging to a specific team |
| `GET` | `/api/v1/player?name={text}` | Search for a player by a partial or full name |
| `GET` | `/api/v1/player?pos={pos}` | Retrieve players by their field position (e.g., FW, MF, DF) |
| `GET` | `/api/v1/player?nation={nation}` | Retrieve players by their nationality |
| `GET` | `/api/v1/player?team={team}&pos={pos}`| Filter players by both team and position |
| `POST` | `/api/v1/player` | Add a new player to the database |
| `PUT` | `/api/v1/player/{id}` | Update an existing player's statistics |
| `DELETE` | `/api/v1/player/{id}` | Remove a player from the database |

## 🚀 Local Setup & Installation

**Prerequisites:**
* Java 21 JDK
* PostgreSQL installed and running locally
* Maven

**1. Clone the repository**
```bash
git clone [https://github.com/Burhan-B2240/premier-league-api.git](https://github.com/Burhan-B2240/premier-league-api.git)
```
**2. Configure the Database** Open `src/main/resources/application.properties` and update the database credentials to match your local PostgreSQL setup:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
**3. Run the Application**
Navigate to the project directory and run:

```bash
./mvnw spring-boot:run
```

*The server will start on port 8080. You can test the endpoints using Postman or your browser at `http://localhost:8080/api/v1/player`.*
