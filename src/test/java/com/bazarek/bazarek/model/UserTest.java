package com.bazarek.bazarek.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void addMovies() {
        User user = new User();
        Movie movie = new Movie();
        movie.setIdMovie(1);
        movie.setTitle("Wonder Woman 1984");
        movie.setRating(5.6);
        //when
        user.addMovies(movie);

        String title = movie.getTitle();

        assertThat(title).as("title movie").isEqualTo("Wonder Woman 1984")
                .endsWith("1984");
    }

    @Test
    void shouldTestEqualsUser() {
        //given
        User user = new User();
        user.setId(33);
        user.setFirstName("bar");
        user.setLastName("foo");
        user.setAge(54);
        User user1 = new User();
        user1.setId(44);
        user1.setFirstName("bar");
        user1.setLastName("foo");
        //when
        boolean equals = user.equals(user1);
        //then
        assertThat(user).isNotNull();
        assertFalse(equals);
        assertThat(user.getAge()).as("check %s's firstName",user.getFirstName())
                .isEqualTo(54);

        System.out.println("stwierdzenie fałszu: " + equals);
    }

    @Test
    void shouldSetAgeOnUser() {
        //given
        User user = new User();
        user.setAge(77);
        //then
        assertThat(user.getAge()).as("check age").isEqualTo(77);
    }
}
