package com.bazarek.bazarek.db;

import com.bazarek.bazarek.db.model.Movie;
import java.util.List;
import java.util.Map;

public interface MoviesOperations {
    Map<String, Movie> allMovies();

    void addMovie(String key, Movie movies);

    /**
     * Created by K.Sulejewski
     *
     * @param firstLetter it's first letter which found movie
     * @return list all movie which starts with firstLetter
     */
    List<Movie> movieByTitle(String firstLetter);

    /**
     * @param movieTitle it's first movie title for db if exist
     * @param otherMovieTitle it's second movie title for db if exist
     * @return StringBuilder both movies titles and best rating
     */
    StringBuilder getBestMovieByRating(String movieTitle, String otherMovieTitle);

    int size();
}
