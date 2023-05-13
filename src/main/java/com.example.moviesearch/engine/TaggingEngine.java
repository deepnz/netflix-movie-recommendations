import java.util.*;

public class TaggingEngine {

    private Map<String, List<Movie>> tagsToMovies;

    public TaggingEngine(List<Movie> movies) {
        this.tagsToMovies = new HashMap<>();

        for (Movie movie : movies) {
            for (String tag : movie.getTags()) {
                if (!this.tagsToMovies.containsKey(tag)) {
                    this.tagsToMovies.put(tag, new ArrayList<>());
                }

                this.tagsToMovies.get(tag).add(movie);
            }
        }
    }

    public List<Movie> getMoviesByTag(String tag) {
        if (!this.tagsToMovies.containsKey(tag)) {
            return new ArrayList<>();
        }

        return this.tagsToMovies.get(tag);
    }

    public List<Movie> getMoviesByTags(List<String> tags) {
        Set<Movie> movies = new HashSet<>();

        for (String tag : tags) {
            movies.addAll(this.getMoviesByTag(tag));
        }

        return new ArrayList<>(movies);
    }

    public Map<Movie, Double> getSimilarMovies(Movie movie, List<Movie> movies, int numSimilarMovies) {
        Map<Movie, Double> similarMovies = new HashMap<>();

        for (Movie otherMovie : movies) {
            if (!otherMovie.equals(movie)) {
                double similarity = SimilarityCalculator.calculateCosineSimilarity(movie.getFeatureVector(), otherMovie.getFeatureVector());
                similarMovies.put(otherMovie, similarity);
            }
        }

        return sortByValue(similarMovies, numSimilarMovies);
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, int limit) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            if (limit > 0) {
                result.put(entry.getKey(), entry.getValue());
                limit--;
            } else {
                break;
            }
        }

        return result;
    }
}
