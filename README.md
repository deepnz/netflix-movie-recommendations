# netflix-movie-recommendations
Using a sentiment analysis algorithm to recommend movies to the user by analysing data containing movie descriptions, and unstructured data related to a movie, and using NLP techniques like topic modelling to build the dataset. Later the user can enter a query with a set of tags, or certain words/ genres of movies, and will output movie recommendations.

Another feature will also use "liked" movies to recommend similar movies, this will be done by presenting another view of  movies displayed in boxes to like.

The final plan is to explore and add embedded vectorizations, to compare and contrast the 2 algos

The stack will be-
MongoDB or Cassandra (NoSQL db) for the data layer
React Frontend
Java 17 features (with use of Records & Sealed classes/interfaces) built backend service layer
Docker/Spring boot microservice
