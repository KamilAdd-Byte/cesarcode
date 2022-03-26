package com.bazarek.bazarek.secretmap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class UserKamilSecretMap {

    public Map<String,Movies> moviesMap = new HashMap<>();

    public Map<String,Movies> myMoviesToMap(){
        moviesMap.put("Bat-1",new Movies("Batman",2000,7.2,"USA",new Movies.TypeMovies(Movies.Category.ACTION,true)));
        moviesMap.put("Bat-5",new Movies("Batman-Mroczny rycerz",2018,8.3,"USA",new Movies.TypeMovies(Movies.Category.ACTION,true)));
        moviesMap.put("Bos-6",new Movies("Boso po ściernisku",2017,5.6,"Danish",new Movies.TypeMovies(Movies.Category.COMEDY,false)));
        moviesMap.put("Bol-1",new Movies("Ból",2017,0.0,"Belgium",new Movies.TypeMovies(Movies.Category.DRAMA,false)));
        moviesMap.put("Czp-2",new Movies("Czarny Piotruś",1963,8.0,"Slowakia",new Movies.TypeMovies(Movies.Category.SCIENTIFICATION,false)));
        moviesMap.put("Dgm-9",new Movies("Dogman",2018,4.1,"France",new Movies.TypeMovies(Movies.Category.DRAMA,false)));
        moviesMap.put("Gno-2",new Movies("GNIAZDO",2017,4.3,"Portugal",new Movies.TypeMovies(Movies.Category.DRAMA,false)));
        moviesMap.put("Isa-3",new Movies("Istota",2017,6.9,"Polish",new Movies.TypeMovies(Movies.Category.SCIENTIFICATION,false)));
        moviesMap.put("Wqe-1",new Movies("Skazani na Shawshank",1994,8.76,"USA",new Movies.TypeMovies(Movies.Category.DRAMA,true)));
        moviesMap.put("WPP-4",new Movies("Władca Pierścieni: Powrót króla",2003,8.33,"New Zeland",new Movies.TypeMovies(Movies.Category.SCIENTIFICATION,true)));
        moviesMap.put("LsS-4",new Movies("Lista Schindlera",1993,8.4,"USA",new Movies.TypeMovies(Movies.Category.DRAMA,true)));
        moviesMap.put("Sev-7",new Movies("Siedem",1995,8.3,"USA",new Movies.TypeMovies(Movies.Category.THRILLER,true)));
        moviesMap.put("Cpp-4",new Movies("Chłopiec w pasiastej piżamie",2008,8.1,"UK",new Movies.TypeMovies(Movies.Category.DRAMA,false)));
        moviesMap.put("Qds-4",new Movies("SpiderMan",2020,7.1,"UK",new Movies.TypeMovies(Movies.Category.DRAMA,false)));
        moviesMap.put("eAs-4",new Movies("HULK",2018,8.7,"UK",new Movies.TypeMovies(Movies.Category.SCIENTIFICATION,true)));
        return moviesMap;
    }

    public void addMovieToMap(String key, Movies movies){
        moviesMap.put(key, movies);
    }

    public int sizeMap(){
        int size = moviesMap.size();
        return size;
    }


    /**
     * Created by K.Sulejewski
     *
     * @param firstLetter it's first letter which found movie
     * @return list all movie which starts with firstLetter
     */
    public List<Movies> movieByTitle(String firstLetter) {
        String firstLetterToUpperCase = firstLetter.toUpperCase();
        return myMoviesToMap().values().stream().filter(t -> t.getTitle().toUpperCase().startsWith(firstLetterToUpperCase)).collect(Collectors.toList());
    }

    public StringBuilder test(String movieTitle, String otherMovieTitle) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Movies> moviesList = myMoviesToMap().values().stream()
                // dzięki operatorowi || podczas filter przefitruje oba argumenty
                .filter(m -> m.getTitle().contains(movieTitle) || m.getTitle().contains(otherMovieTitle))
                .collect(Collectors.toList());

        for (Movies movie : moviesList) {
            stringBuilder
                    .append(movie.getTitle()).append(" r: ").append(movie.getRating())
                    .append(" ");
        }

        moviesList.sort(Comparator.comparingDouble(Movies::getRating).reversed());
        Movies movies = moviesList.get(0);
        stringBuilder.append(" Największy ranking dla: ").append(movies.getTitle());

        return stringBuilder;
    }
}
