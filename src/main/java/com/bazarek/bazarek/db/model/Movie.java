package com.bazarek.bazarek.db.model;

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
    private double rating;
    private String country;
    private TypeMovies typeMovies;

    public Movie(String title, int year, double rating, String country, TypeMovies typeMovies) {
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
                ", info dodatkowe: " + typeMovies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movies = (Movie) o;
        return year == movies.year && Double.compare(movies.rating, rating) == 0 && Objects.equals(title, movies.title) && Objects.equals(country, movies.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, rating, country);
    }

    @Override
    public int compareTo(Movie movies) {
        if (rating < movies.rating)
            return -1;
        if (rating > movies.rating)
            return 1;
        return this.title.compareTo(movies.title);
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class TypeMovies {
        private Category category;
        boolean watches;

        public TypeMovies(Category category, boolean watches) {
            this.category = category;
            this.watches = watches;
        }

        private Category getCategory() {
            return category;
        }

        @Override
        public String toString() {
            String result = "Typ filmu: ";
            result+= " Kategoria: " + category.toString();
            result+= " Czy oglądałem?: " + watches;
            return result;
        }
    }
    public enum Category {
        THRILLER, COMEDY, SCIENTIFICATION, DRAMA, ACTION, HORROR;
    }
}
