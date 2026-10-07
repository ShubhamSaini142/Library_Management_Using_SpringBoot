<h1 align="center">📚 Library Management System</h1>

<p align="center">
  A <b>Spring Boot</b> REST API for running a library: books, members, borrowing and returns, and subscription plans.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.1-6DB33F?style=flat-square&logo=springboot&logoColor=white" alt="Spring Boot 3.1"/>
  <img src="https://img.shields.io/badge/Spring%20Data%20JPA-Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white" alt="Spring Data JPA"/>
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white" alt="MySQL"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white" alt="Maven"/>
</p>

## ✨ Features

- 📖 **Book catalogue**: add, list, view, update and delete books
- 🔄 **Borrowing and returns**: lend a book to a member, track who has it, and mark it returned
- 👥 **Members**: register users and list them
- 💳 **Subscription plans** with a name, description and price. Members can subscribe and unsubscribe.
- 🩺 **Monitoring** with Spring Boot Actuator (`/actuator/health`, `/actuator/info`, `/actuator/metrics`)
- 🧱 **Layered design**: controllers, services, repositories and DTOs

## 🔌 API

| Method | Endpoint | Description |
|:--|:--|:--|
| `POST` | `/api/books` | Add a book |
| `GET` | `/api/books` | List all books |
| `GET` | `/api/books/{id}` | Get a book |
| `PUT` | `/api/books/{id}` | Update a book |
| `DELETE` | `/api/books/{id}` | Delete a book |
| `GET` | `/api/users` | List members |
| `POST` | `/api/users` | Register a member |
| `POST` | `/api/users/{userId}/subscribe/{subscriptionId}` | Subscribe a member to a plan |
| `POST` | `/api/users/{userId}/unsubscribe` | Cancel a member's subscription |
| `POST` | `/api/users/{bookId}/borrow/{userId}` | Borrow a book |
| `POST` | `/api/users/{bookId}/return` | Return a book |
| `GET` | `/api/subscriptions` | List subscription plans |

## 🚀 Getting Started

**Prerequisites:** Java 17, MySQL

```bash
# 1. Create the database
mysql -u root -p -e "CREATE DATABASE lms;"

# 2. Set your database credentials in src/main/resources/application.properties

# 3. Run the app
./mvnw spring-boot:run        # runs on http://localhost:8080
```
