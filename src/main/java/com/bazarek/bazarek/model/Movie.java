package com.bazarek.bazarek.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private long idMovie;

    @Column(name = "movie_title")
    private String title;

    @Column(name = "rating")
    private double rating;

}
