package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.util.Collection;

public class MovieRepositoryJDBC implements Movierepository {

    public JdbcTemplate jdbcTemplate;

    public MovieRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args,movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre) values (?,?,?);",
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString());
    }

    private static final RowMapper<Movie> movieMapper = (rs, i) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre"))

            );

    @Override
    public Collection<Movie> findByName(String name) {
        String[] args = {"%" + name.toLowerCase() + "%"};
        return jdbcTemplate.query("SELECT * FROM movies WHERE LOWER(name) LIKE ?", args, movieMapper);
    }
}
