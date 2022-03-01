# Bound Interview Exercise

This exercise is split in two parts: a coding exercise and an architectural discussion. For the first part, you'll have
an hour to "complete" the exercise detailed below. We use quotation marks around "complete" because we do not expect you
to complete it. It's deliberately too much for one hour, so we expect you to prioritise. What you choose to focus on will
be something that we evaluate you on.

If you prefer to perform the exercise in a pair programming manner with screen sharing, cameras and microphones, we're happy
with that. If you prefer to work independently in silence and just ping us if you have a question, that's also good. Your call.

Once you've cloned this repository, please create a new branch. At the end of the exercise, we'll ask you to push your
code to this branch.

## The Coding Exercise

You've just joined a new startup called We Know Books. You and the team are on a mission to get people reading (and make some 
money doing it). You have ambitious goals to build mobile and web apps that will give your readers a list of book 
recommendations and the ability to buy those books. It's early days and you don't have all the content you need to build
the recommendations, nor do you have the shipping and purchasing infrastructure. To get to market quickly, you are partnering
with a book search engine called Books'R'Us and an online bookstore called Valdivia.

The founders have come up with the following user stories for the team to build, and you are tasked with the backend implementation:
1. As a reader, I would like to be able to search for books by title
2. As a reader, I would like to be able to find out how much a book costs
3. As a reader, I would like to be able to purchase a book and get it delivered to my door
4. As part of the marketing team, I would like to be able to find out what books our readers search for and how often they order them

The tools, languages and frameworks you use to meet these requirements is up to you. The only restriction is that you
must deliver a REST API. Not GraphQL, not gRPC, definitely not SOAP. REST. We're a Java shop, so we have given you 
a Gradle Java project to get going with, and there are some stubs for talking to Books'R'Us and Valdivia. If you'd prefer Maven, or 
Kotlin or Go or whatever, you're welcome to set up an alternative project. Like most engineers, we spend half our life
copying code from StackOverflow and you are welcome to do the same. If you want to use Spring Initializr to get something
up and running, you're welcome to do so.

Things we don't care about in this exercise:
* Authentication. If you need a user ID, just assume that a gateway has populated a `User-Id` header and you can trust the value.
* Payment details or addresses. Somehow Validivia knows how to bill our customers and where to send the books.