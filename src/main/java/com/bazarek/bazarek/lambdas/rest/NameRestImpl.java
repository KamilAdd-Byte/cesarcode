package com.bazarek.bazarek.lambdas.rest;

import com.bazarek.bazarek.db.MoviesDataBase;
import com.bazarek.bazarek.lambdas.inte.FunctionCompleteName;
import com.bazarek.bazarek.secretmap.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class NameRestImpl implements NameRestController{

    private final FunctionCompleteName functionCompleteName;
    private final MoviesDataBase movie;

    @Autowired
    public NameRestImpl(final FunctionCompleteName functionCompleteName, MoviesDataBase movie) {
        this.functionCompleteName = functionCompleteName;
        this.movie = movie;
    }

    @Override
    @GetMapping(value = "/{name}")
    public ResponseEntity<char[]> getMyName(@PathVariable ("name") String name) {
        char[] apply = functionCompleteName.apply(name);
        return ResponseEntity.ok().body(apply);
    }

    @Override
    @GetMapping(value = "/movies")
    public ResponseEntity<Map<String,Movies>> getMyMovie() {
        Map<String, Movies> stringMoviesMap = movie.allMovies();
        return ResponseEntity.ok().body(stringMoviesMap);
    }

    @Override
    @GetMapping(value = "/movies/{letter}")
    public ResponseEntity<List<Movies>> getMyMovieByFirstLetter(@PathVariable ("letter") String firstLetter) {
        List<Movies> movieByTitle = movie.movieByTitle(firstLetter);
        return ResponseEntity.ok().body(movieByTitle);
    }

}
