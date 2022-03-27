package com.bazarek.bazarek.secretmap;

import com.bazarek.bazarek.db.MoviesDataBase;
import com.bazarek.bazarek.db.MoviesOperations;
import com.bazarek.bazarek.db.model.Movie;
import com.bazarek.bazarek.rating.Rating;
import com.bazarek.bazarek.rating.RatingCritic;
import com.bazarek.bazarek.rating.RatingWatcher;

import java.util.*;
import java.util.stream.Stream;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class TEST {
    public static void main(String[] args) {
        //utworzenie instancji klasy MoviesDataBase
        MoviesOperations movies = new MoviesDataBase();
        //dodanie filmu
        int size = movies.size();
        System.out.println("Ilość filmów: " + size);
        //klucze
        System.out.println("--------------------------KLUCZE-------------------------");
        Set<String> keySet = movies.allMovies().keySet();
        for (String s : keySet) {
            System.out.print(s + " ");
        }
        System.out.println();

        //utworzenie kolekcji
        Collection<Movie> values = movies.allMovies().values();


        //utworzenie strumienia
        Stream<Movie> stream = values.stream();
        stream
                .filter(movie -> movie.getRating().getWatcherRate() > 5)
                .filter(m -> m.getCountry().equalsIgnoreCase("Usa"))
                .forEach(System.out::println);


        StringBuilder batman = movies.getBestMovieByRating("Batman", "Batman-Mroczny rycerz");
        System.out.println(batman);

        int count = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, element) -> acc + element);

        List<Integer> together = Stream.of(asList(1, 2, 6, 8), asList(3, 4, 8, 7, 33))
                .flatMap(Collection::stream)
                .collect(toList());

        Map<String, Movie> myMovies = movies.allMovies();
        List<Movie> movieList = new ArrayList<>(myMovies.values());

       // Movie minRatingMovie = movieList.stream().min(Comparator.comparingDouble(Movie::getRating)).get();

        Rating rating = new RatingWatcher();
        rating.addRating(8.8);
        rating.setDescription("Cool movie");
        rating.setWatch(true);
        System.out.println(rating.getDescription());

        Rating criticRating = new RatingCritic();
        criticRating.setDescription("Fucking drama");
        criticRating.addRating(4.4);
        System.out.println(criticRating);
    }
}



