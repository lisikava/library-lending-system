Library Lending System
=======

This library system was developed as a coding task for an internship. The system allows storing information about books, authors, and members, and supports lending and returning books. 

Requirements
=======
- `JDK 21+`
- `Maven 3.6.0+`
- `PostgreSQL 16+`

Installation
======
- Copy the code from the repository with `git clone`
- Configure your own PostgreSQL database username and password in `resources/application.properties`

Usage
=======
Some sample requests the system supports:
- Creating a book:
`curl --header "Content-Type: application/json" --request POST --data '{"title":"Sample Book", "isbn":"12345", "author"
:{"id":1}}' http://localhost:8080/api/books`
- Lending a book:
`curl --request POST "http://localhost:8080/api/loans/lend?bookId=2&memberId=1"`
- Returning a book:
`curl --request POST "http://localhost:8080/api/loans/1/return"`

