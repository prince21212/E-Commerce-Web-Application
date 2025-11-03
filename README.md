# 🛍️ E-Commerce Web Application

A production-ready E-Commerce platform built using Spring Boot, Spring Security (JWT), Spring Data JPA, and MySQL.  
This project demonstrates a modular backend architecture supporting Admin, Seller, and Customer roles, complete with secure authentication, role-based authorization, and REST APIs documented via Swagger.

---

🌟 Project Overview

This web application enables users to buy and sell products online through a structured backend API.  
It manages products, categories, carts, orders, users, and payments — all using clean, maintainable Java code.

🧩 Main Objectives
- Implement a secure authentication and authorization mechanism.
- Manage all e-commerce entities (Product, Cart, Order, Payment, User, etc.).
- Expose all APIs through Swagger UI for easy testing and documentation.


---

🚀 Features

🧑‍💻 Authentication & Authorization
- JWT-based login & registration system
- Role-based access control (Admin / Seller / User)
- Secure password storage using BCrypt

🛒 E-Commerce Functionalities
- Product listing, addition, update, and deletion
- Category management
- Cart and Order handling
- Payment and address management

🧩 Additional Integrations
- Swagger UIfor API documentation & testing
- Centralized exception handling
- Database mapping using Hibernate/JPA

---

🧰 Tech Stack

| Layer | Technology |
|-------|-------------|
| Backend | Java 17+, Spring Boot, Spring Security, Spring Data JPA |
| Database | MySQL |
| Build Tool | Maven | IntellijIdea |
| API Docs | Swagger (OpenAPI 3) |
| Authentication | JWT (JSON Web Token) |

---

⚙️ Setup Instructions (Local)

1️⃣ Clone the repository
```bash
git clone https://github.com/your-username/E-Commerce-Web-Application.git
cd E-Commerce-Web-Application
