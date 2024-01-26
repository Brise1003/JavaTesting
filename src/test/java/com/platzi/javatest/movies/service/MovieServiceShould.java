package com.platzi.javatest.movies.service;

import com.platzi.javatest.movies.data.Movierepository;
import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class MovieServiceShould {

    MovieService movieService;

    @Before
    public void setUp() throws Exception {
        Movierepository movierepository = Mockito.mock(Movierepository.class);

        Mockito.when(movierepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION),
                        new Movie(8, "Superman", 123, Genre.ACTION)
                )
        );

        movieService = new MovieService(movierepository);
    }

    @Test
    public void return_movies_by_genre(){


        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList( 3, 6)));
    }

    @Test
    public void return_movies_by_length(){

        Collection<Movie> movies = movieService.findMoviesByLenght(120);

        assertThat(getMovieIds(movies), is(Arrays.asList(2,3,4,5,6)));

    }

    @Test
    public void return_movies_by_name(){
        Collection<Movie> movies = movieService.findMoviesByName("super");

        assertThat(getMovieIds(movies), is(Arrays.asList(4,8)));

    }

    @Test
    public  void return_movies_by_template(){

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie(null, 150, Genre.ACTION));
        assertThat(getMovieIds(movies), is(Arrays.asList(7,8)) );
    }

    private static List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}