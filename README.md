# Ticket API

A REST API for a movie theater ticketing system, built with **Spring Boot** and **MySQL**. It manages movies, their authors, screening rooms, and users. Sessions, tickets, and payments are planned next.

> **Status:** early development. Some domain classes are still placeholders.

## Tech stack

- Java 17
- Spring Boot 4 (Web MVC, Data JPA / Hibernate)
- MySQL, started automatically through Docker Compose (`spring-boot-docker-compose`)
- Testcontainers for integration tests
- Maven (wrapper included)

## Architecture

The `session_management` module follows a layered, ports-and-adapters design. Dependencies point inward: `web` and `infrastructure` depend on `application`, and `application` depends on `domain`. The domain has no Spring or JPA code.

```
web  ──►  application  ──►  domain
              ▲
infrastructure ┘  (implements the repository ports)
```

| Layer | Contents | Responsibility |
|-------|----------|----------------|
| `domain` | `Author`, `Movie`, `Room`, `Session`, exceptions | Plain Java models and business rules. Immutable; new objects come from `create(...)` factories. |
| `application` | `*UseCase`, `*Repository` interfaces | One class per use case (`execute(...)`), transaction boundaries, and the repository **ports** the use cases need. |
| `infrastructure` | `*JpaEntity`, `*JpaRepository`, `*RepositoryAdapter` | JPA persistence. Adapters implement the ports and map between JPA entities and domain objects (`fromDomain` / `toDomain`). |
| `web` | `*Controller`, `*DTO`, `SessionManagementExceptionHandler` | HTTP endpoints, request/response DTOs, and mapping of domain exceptions to HTTP errors. |

## Project structure

```
src/main/java/com/main/ticket_api/
├── TicketApiApplication.java          # Spring Boot entry point
├── session_management/                # Movies, authors, rooms, sessions
│   ├── domain/                        # Author, Movie, Room, Session, Chair, Ticket + exceptions
│   ├── application/                   # Use cases and repository ports
│   ├── infrastructure/                # JPA entities, Spring Data repositories, adapters
│   └── web/                           # Controllers, DTOs, exception handler
├── user/                              # User registration and listing (not layered yet)
└── financial/                         # Payment, CreditCard, PayPal (placeholders)

src/main/resources/application.properties   # App configuration
compose.yaml                                 # MySQL container for local runs
src/test/                                    # Tests (Testcontainers + MySQL)
```

## Domain overview

| Entity | Description |
|--------|-------------|
| Author | Movie author/director (name, origin) |
| Movie | Name, author, category (`ACTION`, `COMEDY`, `DRAMA`, `HORROR`, `ROMANCE`), duration, release date |
| Room | Screening room with a unique name, seat capacity, and status (`FREE`, `OCCUPIED`). New rooms start as `FREE`. |
| Session | A movie shown in a room at a given date and time *(domain model only, not persisted or exposed yet)* |
| User | Name, email, password, birth date |
| Chair, Ticket, Payment | Placeholders for future features |

## API endpoints

All routes are served under the `/api` context path.

### Authors

| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/author/add` | Create an author. Returns `{ "author_id" }`. |
| GET | `/api/author/all` | List all authors |
| GET | `/api/author/get_by_id?author_id={id}` | Get an author by id (404 if missing) |

```json
POST /api/author/add
{ "name": "Christopher Nolan", "origin": "UK" }
```

### Movies

| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/movie/add` | Create a movie. Returns `{ "movie_id" }`. 404 if the author doesn't exist. |
| GET | `/api/movie/find?category={category}&author={id}` | Movies matching both category and author |
| GET | `/api/movie/find_all` | List all movies |

```json
POST /api/movie/add
{
  "name": "Interstellar",
  "author_id": 1,
  "category": "DRAMA",
  "duration": 169,
  "release_date": "2014-11-07T00:00:00.000+00:00"
}
```

### Rooms

| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/room/add` | Create a room. 409 if the name is already taken. |
| GET | `/api/room/find_all` | List all rooms |
| GET | `/api/room/find_by_id?id={id}` | Get a room by id (404 if missing) |

```json
POST /api/room/add
{ "name": "Room 1", "chairCapacity": 120 }
```

### Users

| Method | Path | Description |
|--------|------|-------------|
| POST | `/api/user/add` | Register a user. Returns `Saved`. |
| GET | `/api/user/all` | List all users |

```json
POST /api/user/add
{ "name": "Ana", "email": "ana@example.com", "password": "secret", "birthDate": "1995-04-20" }
```

### Errors

Domain errors in `session_management` are returned as [RFC 9457 Problem Details](https://www.rfc-editor.org/rfc/rfc9457):

| Exception | Status |
|-----------|--------|
| `AuthorNotFoundException`, `RoomNotFoundException` | 404 Not Found |
| `RoomNameAlreadyExistsException` | 409 Conflict |

## Running locally

Requirements: JDK 17+ and Docker.

```bash
./mvnw spring-boot:run      # Windows: mvnw.cmd spring-boot:run
```

Spring Boot starts the MySQL container from `compose.yaml` automatically. Hibernate creates and updates the schema (`ddl-auto=update`). The app runs at `http://localhost:8080/api`.

To run the app against a throwaway Testcontainers database instead, start `TestTicketApiApplication` from `src/test`.

## Running tests

```bash
./mvnw test
```

The tests use Testcontainers to start a MySQL instance, so Docker must be running.

## Roadmap

- Persist and expose sessions (scheduling a movie in a room, avoiding time overlaps)
- Generate chairs per room and sell tickets per session
- Payments (credit card, PayPal)
- Move the `user` module to the same layered structure, hash passwords, and stop returning them in responses
