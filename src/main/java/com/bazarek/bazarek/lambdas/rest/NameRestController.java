package com.bazarek.bazarek.lambdas.rest;

import com.bazarek.bazarek.db.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("/name")
public interface NameRestController {

    @RequestMapping("/{name}")
    ResponseEntity<char[]> getMyName(@PathVariable ("name") String name);

    @RequestMapping("/movies")
    ResponseEntity<Map<String, Movie>> getMyMovie();

    @RequestMapping("/movies/{letter}")
    ResponseEntity<List<Movie>> getMyMovieByFirstLetter(@PathVariable("letter") String firstLetter);
}
