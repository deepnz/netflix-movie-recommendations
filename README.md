# netflix-movie-recommendations
#In-progress
Using a sentiment analysis algorithm to recommend movies to the user by analysing data containing movie descriptions, and unstructured data related to a movie, and using NLP techniques like topic modelling to build the dataset. Later the user can enter a query with a set of tags, or certain words/ genres of movies, and will output movie recommendations.

Another feature in backlog will be to develop a watch list, and movie ratings feature.

Another feature will also use "liked" movies to recommend similar movies, this will be done by presenting another view of  movies displayed in boxes to like.

An ambitious last feature to explore is to add a WebLLM component with embedded vectorizations to provide recommendations, and then to compare and contrast the 2 algos performance.

The stack will be-
MongoDB / Cassandra (NoSQL db) for the data layer. Will explore Redis as an in-memory caching layer as well.
React Frontend with a few libraries.
Java 17 features (with use of Records & Sealed classes/interfaces) built backend service layer
Docker/Spring boot microservice
