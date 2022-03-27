package com.bazarek.bazarek.db.model;

import com.bazarek.bazarek.db.model.type.MovieType;
import com.bazarek.bazarek.rating.RatingWatcher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Movie implements Comparable<Movie>{
    private String title;
    private int year;
    private RatingWatcher rating;
    private String country;
    private MovieType typeMovies;

    public Movie(String title, int year, RatingWatcher rating, String country, MovieType typeMovies) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.country = country;
        this.typeMovies = typeMovies;
    }

    @Override
    public String toString() {
        return "Filmy: " +
                "tytuł - '" + title + '\'' +
                ", rok - '" + year +'\'' +
                ", ocena - '" + rating + '\''+
                ", kraj - '" + country + '\'' +
                ", kategoria: " + typeMovies +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, rating, country);
    }

    @Override
    public int compareTo(Movie movies) {
        if (rating.getWatcherRate() < movies.rating.getWatcherRate())
            return -1;
        if (rating.getWatcherRate() > movies.rating.getWatcherRate())
            return 1;
        return this.title.compareTo(movies.title);
    }
}
