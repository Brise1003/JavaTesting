package com.platzi.javatest.movies.service;

import com.platzi.javatest.movies.data.Movierepository;
import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieService {

    private final Movierepository movierepository;

    public MovieService(Movierepository movierepository) {
        this.movierepository = movierepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movierepository.findAll().stream().filter(movie -> movie.getGenre() == genre)
                .collect(Collectors.toList());

    }

    public Collection<Movie> findMoviesByLenght(int length) {
        return movierepository.findAll().stream().filter(movie -> movie.getMinutes() <= length)
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name){
        return movierepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(name))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template){

        if (template.getId() != null) {
            Movie movie = movierepository.findById(template.getId());
            return movie != null ? Collections.singletonList(movie) : new ArrayList<>();
        }

        if (template.getMinutes() < 0) {
            throw new IllegalArgumentException("duration must be greater or equal than zero.");
        }

        List<Predicate<Movie>> filters = new ArrayList<>();
        if (template.getName() != null) {
            filters.add(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase().trim()));
        }
        if (template.getMinutes() != null) {
            filters.add(movie -> movie.getMinutes() <= template.getMinutes());
        }
        if (template.getGenre() != null) {
            filters.add(movie -> movie.getGenre().equals(template.getGenre()));
        }

        return movierepository.findAll().stream()
                    .filter(movie -> filters.stream().allMatch(filter -> filter.test(movie)))
                    .collect(Collectors.toList());
    }
}
