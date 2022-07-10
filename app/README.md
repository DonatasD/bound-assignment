# Bound Interview Exercise

## Endpoints created:

* GET http://localhost:8080/books/ - Provides available books
* GET http://localhost:8080/books/{{bookId}} - Returns books by bookId; 404 if not found
* POST http://localhost:8080/purchases/ - Allows creating a purchase order
* GET http://localhost:8080/marketing/books/purchases - Returns top 5 most popular purchases
* GET http://localhost:8080/marketing/books/searches - Returns top 5 most popular searches
