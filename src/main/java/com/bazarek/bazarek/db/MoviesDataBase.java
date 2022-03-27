package com.bazarek.bazarek.db;

import com.bazarek.bazarek.db.model.Movie;
import com.bazarek.bazarek.db.model.type.MovieType;
import com.bazarek.bazarek.rating.RatingWatcher;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Getter
@Slf4j
public class MoviesDataBase implements MoviesOperations{

    Map<String, Movie> moviesMap;

    @Override
    public Map<String, Movie> allMovies(){
        moviesMap = new HashMap<>();
        moviesMap.put("Bat-1",new Movie("Batman",2000,new RatingWatcher(true,7.8),"USA", MovieType.ACTION));
        moviesMap.put("Bat-5",new Movie("Batman-Mroczny rycerz",2018,new RatingWatcher(true,8.2),"USA",MovieType.ACTION));
        moviesMap.put("Bos-6",new Movie("Boso po ściernisku",2017,new RatingWatcher(true,8.2),"Danish",MovieType.COMEDY));
        moviesMap.put("Bol-1",new Movie("Ból",2017,new RatingWatcher(true,2.2),"Belgium",MovieType.DRAMA));
        moviesMap.put("Czp-2",new Movie("Czarny Piotruś",1963,new RatingWatcher(true,5.3),"Slowakia",MovieType.WAR));
        moviesMap.put("Dgm-9",new Movie("Dogman",2018,new RatingWatcher(true,6.1),"France",MovieType.DRAMA));
        moviesMap.put("Gno-2",new Movie("GNIAZDO",2017,new RatingWatcher(true,3.2),"Portugal",MovieType.DRAMA));
        moviesMap.put("Isa-3",new Movie("Istota",2017,new RatingWatcher(true,7.2),"Polish",MovieType.SCIENTIFICATION));
        moviesMap.put("Wqe-1",new Movie("Skazani na Shawshank",1994,new RatingWatcher(true,8.8),"USA",MovieType.DRAMA));
        moviesMap.put("WPP-4",new Movie("Władca Pierścieni: Powrót króla",2003,new RatingWatcher(true,8.1),"New Zeland",MovieType.FANTASY));
        moviesMap.put("LsS-4",new Movie("Lista Schindlera",1993,new RatingWatcher(true,8.9),"USA",MovieType.DRAMA));
        moviesMap.put("Sev-7",new Movie("Siedem",1995,new RatingWatcher(true,8.6),"USA",MovieType.THRILLER));
        moviesMap.put("Cpp-4",new Movie("Chłopiec w pasiastej piżamie",2008,new RatingWatcher(true,6.5),"UK",MovieType.DRAMA));
        moviesMap.put("Qds-4",new Movie("SpiderMan",2020,new RatingWatcher(true,7.3),"UK",MovieType.DRAMA));
        moviesMap.put("eAs-4",new Movie("HULK",2018,new RatingWatcher(true,7.0),"UK",MovieType.FANTASY));
        moviesMap.put("WWW", new Movie("DIablo", 2021, new RatingWatcher(true,4.8), "Poland", MovieType.HORROR));
        return moviesMap;
    }

    @Override
    public void addMovie(String key, Movie movies){
        moviesMap.put(key, movies);
    }

    @Override
    public int size(){
        return allMovies().size();
    }

    /**
     * Created by K.Sulejewski
     *
     * @param firstLetter it's first letter which found movie
     * @return list all movie which starts with firstLetter
     */
    @Override
    public List<Movie> movieByTitle(String firstLetter) {
        String firstLetterToUpperCase = firstLetter.toUpperCase();
        return allMovies().values().stream().filter(t -> t.getTitle().toUpperCase().startsWith(firstLetterToUpperCase)).collect(Collectors.toList());
    }

    /**
     * @param movieTitle it's first movie title for db if exist
     * @param otherMovieTitle it's second movie title for db if exist
     * @return StringBuilder both movies titles and best rating
     */
    @Override
    public StringBuilder getBestMovieByRating(String movieTitle, String otherMovieTitle) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Movie, Double> moviesList = allMovies().values().stream()
                // dzięki operatorowi || podczas filter przefitruje oba argumenty
                .filter(m -> m.getTitle().contains(movieTitle) || m.getTitle().contains(otherMovieTitle))
                .collect(Collectors.toMap(d -> d, d -> d.getRating().getWatcherRate()));

        Movie bestMovie = moviesList.keySet().stream().max(Comparator.comparingDouble(m -> m.getRating().getWatcherRate())).get();

        for (Movie movie : moviesList.keySet()) {
            stringBuilder
                    .append(movie.getTitle()).append(" r: ").append(movie.getRating().getWatcherRate())
                    .append("\n");
        }

        stringBuilder.append("Film z większym rating: ").append(bestMovie);

        return stringBuilder;
    }
}
