# book-store

REST API for E-commerce website for buying books

Technology Stack
- Spring Boot
- Spring Security
- Spring Data
- Swagger 2
- JUnit
- Java 11

Links

BOOK

get book by id:    GET    http://localhost:8443/api/books/{id}

get all books:     GET    http://localhost:8443/api/books

create book:       POST   http://localhost:8443/api/books/add

delete book by id: DELETE http://localhost:8443/api/books/{id}

update book:       PUT    http://localhost:8443/api/books/update

IMAGE

upload image:      POST   http://localhost:8443/api/images/upload

USER

get user by id:    GET    http://localhost:8443/api/users/{id}

get all users:     GET    http://localhost:8443/api/users 

register new user: POST   http://localhost:8443/api/users/register

delete user by id: DELETE http://localhost:8443/api/users/{id}

update user info:  PUT    http://localhost:8443/api/users/update/{id}
