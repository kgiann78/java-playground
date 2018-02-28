package playground.amazon;

import java.util.*;

public class MoviesNetwork {
    Set<Movie> getMovieRecommendations(Movie movie, int N) {
        // WRITE YOUR CODE HERE
        Set<Movie> movies = new HashSet<Movie>();
        HashMap<Integer, Movie> movieHashMap = new HashMap<Integer, Movie>();

//        TreeMap<Float, Integer> ratingTree = new TreeMap<Float, Integer>();
//        Stack<Movie> queue = new Stack<Movie>();
        System.out.println(movieHashMap);
        searchSimilarMovies(movieHashMap, movie);
        System.out.println(movieHashMap);

        for (Integer key : movieHashMap.keySet()) {
            movies.add(movieHashMap.get(key));
        }
        return movies;
    }

    private void searchSimilarMovies(HashMap<Integer, Movie> movieHashMap, Movie movie) {
        if (movie == null) return;
        for (Movie similarMovie : movie.getMovies()) {
            if (similarMovie.getMovieId() != movie.getMovieId()) {
                movieHashMap.put(similarMovie.getMovieId(), similarMovie);
            }
        }
    }

    public static void main(String[] args) {
        MoviesNetwork network = new MoviesNetwork();
        Movie movie = new Movie();
        movie.setMovieId(0);
        movie.setRating(4.5F);
        List<Movie> similarMovies = new ArrayList<Movie>();

        for (int i = 1; i <= 5; i++) {
            Movie similar = new Movie();
            similar.setMovieId(i);
            similar.setRating(i * 1.5F);
            similarMovies.add(similar);
        }
        movie.setMovies(similarMovies);
        System.out.println(network.getMovieRecommendations(movie, 4));
    }
}

class Movie {
    private int movieId;
    private float rating;
    private List<Movie> movies;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Movie> getMovies() {
        if (movies == null) movies = new ArrayList<Movie>();
        return movies;
    }

    public void setMovies(List<Movie> movie) {
        this.movies = movie;
    }
}
