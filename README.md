# Bound Interview Exercise

This exercise is split in two parts: a coding exercise and an architectural discussion. 

For the first part, you'll have an hour to "complete" the exercise detailed below. We use quotation marks around "complete" 
because we do not expect you to complete it. It's deliberately too much for one hour, so you will have to choose what to
focus on. As a startup with a small team, we are constantly having to choose where we can afford to spend our time so 
how you prioritise is something we care about. Don't worry about how much or how little you complete; we're more interested
in how you approach the problem and how you think about software design. TODOs are your friend.

If you prefer to perform the exercise in a pair programming manner with screen sharing, cameras and microphones, we're happy
with that. If you prefer to work independently in silence and just ping us if you have a question, that's also good. Your call.

Once you've cloned this repository, please create a new branch. At the end of the exercise, we'll ask you to push your
code to this branch.

## The Coding Exercise

You've just joined a new startup called We Know Books. You and the team are on a mission to get people reading (and make some 
money doing it). You have ambitious goals to build mobile and web apps that will give your readers a list of book 
recommendations and the ability to buy those books. It's early days and you don't have all the content you need to build
the recommendations, nor do you have the shipping and purchasing infrastructure. To get to market quickly, you are partnering
with a book search engine called Boogle and an online bookstore called Valdivia.

The founders have come up with the following user stories for the team to build, and you are tasked with the backend implementation:
1. As a reader, I would like to be able to search for books by author
2. As a reader, I would like to be able to find out how much a book costs
3. As a reader, I would like to be able to purchase a book and get it delivered to my door
4. As part of the marketing team, I would like to be able to find out what books our readers search for and how often they order them

The tools, languages and frameworks you use to meet these requirements is up to you. The only restriction is that you
must deliver a REST API. Not GraphQL, not gRPC, definitely not SOAP. REST. We're a Java shop, so we have given you 
a Gradle Java project to get going with, and there are some stubs for talking to Boogle and Valdivia. If you'd prefer Maven, or 
Kotlin or Go or whatever, you're welcome to set up an alternative project. Like most engineers, we make extensive use of search
engines and StackOverflow; feel free to do the same in this exercise. If you want to use Spring Initializr or similar to get
something up and running, you're welcome to do so. 

Things we don't care about in this exercise:
* Authentication. If you need a user ID, just assume that a gateway has populated a `User-Id` header and you can trust the value.
* Payment details or addresses. Somehow Valdivia knows how to bill our customers and where to send the books.

### The "Client" "Libraries"

We've included a Gradle sub-project with some stubbed clients for Boogle and Valdivia. If you're sticking with Java or Kotlin,
we expect you to use these. They are obviously returning hard-coded data, but you should assume that they are communicating
with remote APIs across the internet. The two main classes are `BoogleClient` and `ValdiviaClient`.

#### BoogleClient

There's three methods here that you may care about:
* `searchBooksByAuthor`: This takes a string representing the author name, and returns a list of `BookSummary` objects
* `getAllBooks`: This returns a list of `BookSummary` objects for all books that Boogle knows about 
* `getBookDetails`: This gets detailed information for a book.

Note that the `getBookDetails` call includes an ISBN (International Standard Book Number) in the response.

#### ValdiviaClient

There are two methods in this class:
* `getBookQuote`: This takes an ISBN and returns a price for the book
* `purchaseBook`: Purchase the book by specifying a valid quote ID retrieved from `getBookQuote`

## The Architectural Discussion

Once you've completed the coding exercise, we'll move on to an architectural discussion. This will be very heavily based
on the coding exercise. We'll ask you to share your screen and draw some diagrams using https://www.websequencediagrams.com.
This website, as the name suggests, provides a simple way of drawing sequence diagrams and uses a simple DSL for creating them.
To start you off, we'll use the following template:
```
actor User as U
participant We Know\nBooks as W
participant Boogle as B
participant Valdivia as V

alt User Story 1
    U->W: Search request
    W->B: searchBooksByAuthor
    B->W: List<BookSummary>
    W->U: List<BookSummary>
else User Story 2

else User Story 3

end
```
You can probably guess what the first thing we're going to ask you to do is!
