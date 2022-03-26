package com.bazarek.bazarek.db;

import com.bazarek.bazarek.secretmap.Movies;
import java.util.List;
import java.util.Map;

public interface MoviesOperations {
    Map<String, Movies> allMovies();

    void addMovie(String key, Movies movies);

    /**
     * Created by K.Sulejewski
     *
     * @param firstLetter it's first letter which found movie
     * @return list all movie which starts with firstLetter
     */
    List<Movies> movieByTitle(String firstLetter);

    /**
     * @param movieTitle it's first movie title for db if exist
     * @param otherMovieTitle it's second movie title for db if exist
     * @return StringBuilder both movies titles and best rating
     */
    StringBuilder getBestMovieByRating(String movieTitle, String otherMovieTitle);

    int size();
}
