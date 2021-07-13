package com.bazarek.bazarek.secretmap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoviesTest {

    @Autowired
    UserKamilSecretMap secretMap;

    @Test
    void getTitle() {
        //given
        Movies movies = new Movies();
        movies.setTitle("Batman");

        //then
        assertThat(movies.getTitle()).as("is title").isEqualTo("Batman");
    }

    @Test
    void setTitle() {
        int sizeMap = secretMap.sizeMap();


    }
}
