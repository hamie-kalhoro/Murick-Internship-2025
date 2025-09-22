# Murick Internship 2025

This project is a **Spring Boot CRUD Application** developed for the Murick Internship 2025 program.  
It demonstrates best practices for building a RESTful API using **Spring Boot**, **MySQL**, and **DTO-based design** for better security and data transfer.

---

## Features
- CRUD operations (`Create`, `Read`, `Update`, `Delete`) for `User` entity  
- Database persistence with **MySQL**  
- Separation of concerns with:
  - **Entity** (`User`)
  - **DTOs** (`UserDTO`, `UserRequestDTO`)
  - **Mapper** (`UserMapper`) for clean conversion
  - **Repository**, **Service**, and **Controller** layers  
- Excludes sensitive fields like `password` from API responses  
- Follows layered architecture for scalability and maintainability  

---

## Technologies Used
- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **MySQL 8+**
- **Maven**
https://github.com/hamie-kalhoro/murick-internship-2025.git
cd murick-internship-2025
