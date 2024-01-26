package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import com.platzi.javatest.movies.service.MovieService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class MovierepositoryJDBCIntegrationTest {

    private static DataSource dataSource = new DriverManagerDataSource(
            "jdbc:h2:mem:test;MODE=MYSQL",
            "sa",
            "sa");

    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    private MovieRepositoryJDBC movieRepositoryJDBC = new MovieRepositoryJDBC(jdbcTemplate);

    private MovieService movieService;

    @Before
    public void setup() throws ScriptException, SQLException {
       ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        MovieRepositoryJDBC movieRepositoryJDBC = new MovieRepositoryJDBC(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        Collection<Movie> movies = movieRepositoryJDBC.findAll();

        List<Movie> list = Arrays.asList(
                new Movie(1, "Dark knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        );

        Assert.assertEquals(list, movies);
    }

    @Test
    public void load_movie_by_id() {

        Movie movie = movieRepositoryJDBC.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @After
    public void tearDow() throws SQLException {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }

    @Test
    public void insert_a_movie(){
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);
        movieRepositoryJDBC.saveOrUpdate(movie);

        Movie expectedMovie = movieRepositoryJDBC.findById(4);
        assertThat(expectedMovie.getName(), is(movie.getName()));
    }

    @Test
    public void load_movies_by_name(){

        Collection<Movie> moviesAdded = Arrays.asList(
                new Movie(4, "Super 8", 112, Genre.THRILLER),
                new Movie(5, "Superman", 95, Genre.ACTION),
                new Movie(6, "Superior", 123, Genre.COMEDY)
        );

        moviesAdded.forEach(movie -> {movieRepositoryJDBC.saveOrUpdate(movie);});

        Collection<Movie> moviesFound = movieRepositoryJDBC.findByName("super");
        System.out.println(Arrays.toString(moviesFound.toArray()));
        Assert.assertEquals(moviesAdded, moviesFound);
    }

}