import org.bson.types.ObjectId;

import java.util.*;

public class MovieRecommendationEngine {
    private final MovieRepository movieRepository;

    public MovieRecommendationEngine(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDocument> recommendMoviesByLikedMovies(ObjectId userId) {
        // Get the user's liked movies and movie genres
        UserDocument user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        List<ObjectId> likedMovieIds = user.getLikedMovies();
        Set<String> userGenres = user.getGenres();

        // Calculate the cosine similarity of each movie to the user's liked movies
        Map<MovieDocument, Double> movieSimilarities = new HashMap<>();
        for (MovieDocument movie : movieRepository.findAll()) {
            // Calculate the movie's similarity score based on user's liked movies and genres
            double similarity = calculateSimilarity(movie, likedMovieIds, userGenres);
            movieSimilarities.put(movie, similarity);
        }

        // Sort the movies by similarity score in descending order
        List<Map.Entry<MovieDocument, Double>> sortedMovieSimilarities = new ArrayList<>(movieSimilarities.entrySet());
        sortedMovieSimilarities.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Get the top 10 recommended movies
        List<MovieDocument> recommendedMovies = new ArrayList<>();
        int numRecommendedMovies = Math.min(sortedMovieSimilarities.size(), 10);
        for (int i = 0; i < numRecommendedMovies; i++) {
            recommendedMovies.add(sortedMovieSimilarities.get(i).getKey());
        }

        return recommendedMovies;
    }

    private double calculateSimilarity(MovieDocument movie, List<ObjectId> likedMovieIds, Set<String> userGenres) {
        List<ObjectId> movieIds = movie.getSimilarMovies();
        Set<ObjectId> intersection = new HashSet<>(likedMovieIds);
        intersection.retainAll(movieIds);
        double similarity = (double) intersection.size() / (Math.sqrt(likedMovieIds.size()) * Math.sqrt(movieIds.size()));

        // Weight the similarity score based on movie genre and rating
        if (userGenres != null && !userGenres.isEmpty()) {
            double genreWeight = 0.5;
            double ratingWeight = 0.5;
            double genreScore = calculateGenreScore(movie, userGenres);
            double ratingScore = movie.getRating();
            similarity = (genreWeight * genreScore) + (ratingWeight * ratingScore);
