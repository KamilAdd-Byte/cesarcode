package com.bazarek.bazarek.secretmap;

import java.util.HashMap;
import java.util.Map;

public class UserKamilSecretMap {

    public Map<String,Movies> moviesMap = new HashMap<>();

    public Map<String,Movies> myMoviesToMap(){
        moviesMap.put("Bat-1",new Movies("Batman",2000,7.2,"USA",new Movies.TypeMovies("Action",true)));
        moviesMap.put("Bat-5",new Movies("Batman-Mroczny rycerz",2018,8.3,"USA",new Movies.TypeMovies("Action",true)));
        moviesMap.put("Bos-6",new Movies("Boso po ściernisku",2017,0.0,"Danish",new Movies.TypeMovies("Moral",false)));
        moviesMap.put("Bol-1",new Movies("Ból",2017,0.0,"Belgium",new Movies.TypeMovies("Stories",false)));
        moviesMap.put("Czp-2",new Movies("Czarny Piotruś",1963,0.0,"Slowakia",new Movies.TypeMovies("Moral",false)));
        moviesMap.put("Dgm-9",new Movies("Dogman",2018,0.0,"France",new Movies.TypeMovies("Moral",false)));
        moviesMap.put("Gno-2",new Movies("GNIAZDO",2017,0.0,"Portugal",new Movies.TypeMovies("Dramat",false)));
        moviesMap.put("Isa-3",new Movies("Istota",2017,0.0,"Polish",new Movies.TypeMovies("Dramat",false)));
        moviesMap.put("Wqe-1",new Movies("Skazani na Shawshank",1994,8.76,"USA",new Movies.TypeMovies("Dramat",true)));
        moviesMap.put("WPP-4",new Movies("Władca Pierścieni: Powrót króla",2003,8.33,"New Zeland",new Movies.TypeMovies("Fantasy",true)));
        moviesMap.put("LsS-4",new Movies("Lista Schindlera",1993,8.4,"USA",new Movies.TypeMovies("Dramat",true)));
        moviesMap.put("Sev-7",new Movies("Siedem",1995,8.3,"USA",new Movies.TypeMovies("Thriller",true)));
        moviesMap.put("Cpp-4",new Movies("Chłopiec w pasiastej piżamie",2008,8.1,"UK",new Movies.TypeMovies("Dramat",false)));
        return moviesMap;
    }

    public void addMovieToMap(String key, Movies movies){
        moviesMap.put(key, movies);
    }
    public int sizeMap(){
        int size = moviesMap.size();
        return size;
    }

    public Map<String, Movies> getMoviesMap() {
        return moviesMap;
    }

    private void setMoviesMap(Map<String, Movies> moviesMap) {
        this.moviesMap = moviesMap;
    }
}
