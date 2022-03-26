package com.bazarek.bazarek.secretmap;

import java.util.Objects;

public class Movies implements Comparable<Movies>{
    private String title;
    private int year;
    private double rating;
    private String country;
    private TypeMovies typeMovies;

    public Movies() {
    }

    public Movies(String title, int year, double rating, String country, TypeMovies typeMovies) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.country = country;
        this.typeMovies = typeMovies;
    }

    public String getTitle (){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        if (!(o instanceof Movies)) return false;
        Movies movies = (Movies) o;
        return year == movies.year && Double.compare(movies.rating, rating) == 0 && Objects.equals(title, movies.title) && Objects.equals(country, movies.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, rating, country);
    }

    @Override
    public int compareTo(Movies movies) {
//        if (rating < movies.rating)
//            return -1;
//        if (rating > movies.rating)
//            return 1;
        return this.title.compareTo(movies.title);
    }

    //klasa wewnętrzna
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

        private void setCategory(Category category) {
            this.category = category;
        }

        private boolean isWatches() {
            return watches;
        }

        private void setWatches(boolean watches) {
            this.watches = watches;
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
