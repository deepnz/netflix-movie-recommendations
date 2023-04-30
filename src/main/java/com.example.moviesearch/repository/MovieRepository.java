public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findAll();
    List<Movie> findByTagsContaining(String tag);
    Movie findByIdAndPopulateSimilar(String movieId);
}
