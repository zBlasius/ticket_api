# Ticket API

A REST API for a movie theater ticketing system, built with **Spring Boot** and **MySQL**. It manages movies, their authors, screening rooms, and users. Sessions, tickets, and payments are planned next.

> **Status:** early development. Some domain classes are still placeholders.

## Tech stack

- Java 17
- Spring Boot 4 (Web MVC, Data JPA / Hibernate)
- MySQL, started automatically through Docker Compose (`spring-boot-docker-compose`)
- Testcontainers for integration tests
- Maven (wrapper included)

## Project structure

```
src/main/java/com/main/ticket_api/
├── TicketApiApplication.java    # Spring Boot entry point
├── session_management/          # Movies, authors, rooms, sessions
│   ├── *Controller.java         # REST endpoints
│   ├── *Service.java            # Business logic
│   ├── *Repository.java         # Spring Data JPA repositories
│   ├── *DTO.java                # Request/response objects
│   └── Movie, Author, Room, Session, Chair, TIcket   # Domain models
├── user/                        # User registration and listing
└── financial/                   # Payment, CreditCard, PayPal (placeholders)

src/main/resources/application.properties   # App configuration
compose.yaml                                 # MySQL container
src/test/                                    # Tests (Testcontainers + MySQL)
```

## Domain overview

| Entity  | Description |
|---------|-------------|
| Author  | Movie author/director (name, origin) |
| Movie   | Name, author, category (`ACTION`, `COMEDY`, `DRAMA`, `HORROR`, `ROMANCE`), duration, release date |
| Room    | Screening room with a unique name, seat capacity, and status (`FREE`, `OCCUPIED`) |
| Session | A movie shown in a room at a given date and time *(not yet persisted)* |
| User    | Name, email, password, birth date |
| Chair, Ticket, Payment | Placeholders for future features |

## API endpoints

All routes are served under the `/api` context path.

| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/author/add` | Create an author |
| GET  | `/api/author/all` | List all authors |
| GET  | `/api/author/get_by_id?author_id={id}` | Get an author by id |
| POST | `/api/movie/add` | Create a movie |
| GET  | `/api/movie/find?category={category}&author={id}` | Filter movies by category and author |
| GET  | `/api/movie/find_all` | List all movies |
| POST | `/api/room/add` | Create a room |
| GET  | `/api/room/find_all` | List all rooms |
| GET  | `/api/room/find_by_id?id={id}` | Get a room by id |
| POST | `/api/user/add` | Register a user |
| GET  | `/api/user/all` | List all users |

## Running locally

Requirements: JDK 17+ and Docker.

```bash
./mvnw spring-boot:run      # Windows: mvnw.cmd spring-boot:run
```

Spring Boot starts the MySQL container from `compose.yaml` automatically. The schema is created and updated by Hibernate (`ddl-auto=update`). The app runs at `http://localhost:8080/api`.

## Running tests

```bash
./mvnw test
```

The tests use Testcontainers to start a MySQL instance, so Docker must be running.
