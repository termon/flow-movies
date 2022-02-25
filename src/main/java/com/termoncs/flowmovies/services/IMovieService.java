package com.termoncs.flowmovies.services;

import com.termoncs.flowmovies.models.Movie;
import com.termoncs.flowmovies.models.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IMovieService {

    long getCount();

    List<Movie> getMovies();

    Page<Movie> findByPage(Pageable p);

    Movie getMovieById(long id);

    void addMovie(Movie m);

    void updateMovie(Movie m);

    void deleteMovieById(long id);

    void deleteAllMovies();

    Movie addReview(Review r);

    void deleteReview(long id);
}
