public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    List<Movie> findLikedMovies(String userId);
    List<Movie> findDislikedMovies(String userId);
    List<Movie> findRecommendedMovies(String userId);
    void addToLikedMovies(User user, String movieId);
    void addToDislikedMovies(User user, String movieId);
    void addRecommendedMovies(String userId, List<Movie> movies);
}
