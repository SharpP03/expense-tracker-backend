# Transaction Tracker API

## Description

REST backend API for managing personal financial transactions.
The application provides user authentication and full CRUD operations for transactions.

---

## Features

* User registration and login (JWT authentication)
* Create, read, update, delete transactions
* Store transaction details:

  * amount
  * type (income / expense)
  * category
  * notes
  * date
* Secure endpoints (authenticated access)

---

## Tech Stack

* Java + Spring Boot
* Spring Security (JWT)
* Hibernate / JPA
* Database: TODO (PostgreSQL / MySQL / H2)

---

## Setup

```bash
git clone https://github.com/SharpP03/expense-tracker-backend.git
cd expense-tracker-backend
```

Configure database in `application.properties`:

```properties
spring.datasource.url=TODO
spring.datasource.username=TODO
spring.datasource.password=TODO
```

Run:

```bash
./mvnw spring-boot:run
```

---

# Authentication

## Register

**POST** `/api/auth/register`

### Request body:

```json
{
  "username": "testuser",
  "email": "test@example.com",
  "password": "password123"
}
```

### Response:

```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com"
}
```

---

## Login

**POST** `/api/auth/login`

### Request body:

```json
{
  "username": "testuser",
  "password": "password123"
}
```

### Response (200):

```json
{
  "token": "JWT_TOKEN"
}
```

### Error (401):

```json
"Invalid username or password"
```

---

# Transactions

All endpoints require Authorization header:

```
Authorization: Bearer YOUR_TOKEN
```

---

## Get all transactions

**GET** `/api/transactions`

### Response:

```json
[
  {
    "id": 1,
    "amount": 100.0,
    "type": "INCOME",
    "category": "SALARY",
    "note": "Monthly salary",
    "date": "2025-01-01"
  }
]
```

---

## Get transaction by ID

**GET** `/api/transactions/{id}`

### Response:

```json
{
  "id": 1,
  "amount": 100.0,
  "type": "INCOME",
  "category": "SALARY",
  "note": "Monthly salary",
  "date": "2025-01-01"
}
```

---

## Create transaction

**POST** `/api/transactions`

### Request body:

```json
{
  "amount": 50.0,
  "type": "EXPENSE",
  "category": "FOOD",
  "note": "Dinner",
  "date": "2025-01-02"
}
```

### Response:

```json
{
  "id": 2,
  "amount": 50.0,
  "type": "EXPENSE",
  "category": "FOOD",
  "note": "Dinner",
  "date": "2025-01-02"
}
```

---

## ➤ Update transaction

**PUT** `/api/transactions/{id}`

### Request body:

```json
{
  "amount": 60.0,
  "type": "EXPENSE",
  "category": "FOOD",
  "note": "Dinner updated",
  "date": "2025-01-02"
}
```

### Response:

```json
{
  "id": 2,
  "amount": 60.0,
  "type": "EXPENSE",
  "category": "FOOD",
  "note": "Dinner updated",
  "date": "2025-01-02"
}
```

---

## ➤ Delete transaction

**DELETE** `/api/transactions/{id}`

### Response:

```
204 No Content
```

---

# Test endpoints

## Health check

**GET** `/api/test`

Response:

```
hello world
```

---

## App info

**GET** `/api/info`

Response:

```json
{
  "appName": "Aplikacja Budżetowa",
  "version": "1.0",
  "message": "Witaj w aplikacji budżetowej stworzonej ze Spring Boot!"
}
```

# Future Improvements

* Add unit & integration tests
* Add Swagger / OpenAPI documentation

---
