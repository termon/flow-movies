package com.termoncs.flowmovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;
import java.util.Date;

//@Entity()
//@Table(name="review")
//@Data @NoArgsConstructor @AllArgsConstructor @Builder
//public class Review {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String comment;
//    private Date created;
//
//    @Min(1)
//    @Max(5)
//    private int rating;
//
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    // configure join column to be non insertable/updateable as this is handled by the movieId column
//    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
//    @JsonIgnore
//    private Movie movie;
//
//    // adding this column to support non JPA services
//    @Column(name = "movie_id", nullable = false)
//    @JsonIgnore
//    private Long movieId;
//}

@Entity()
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String comment;
    private Date created;

    @Min(1) @Max(5)
    private int rating;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    // configure join column to be non insertable/updateable as this is handled by the movieId column
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    @JsonIgnore
    private Movie movie;

    // adding this column to support non JPA services
    @Column(name ="movie_id", nullable = false)
    @JsonIgnore
    private Long movieId;

    public Review() {
        setOn(Date.from(Instant.now()));
    }


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getComment() {
        return comment;
    }
    public Date getCreated() {
        return created;
    }
    public int getRating() {
        return rating;
    }
    public Movie getMovie() {
        return movie;
    }
    public long getMovieId() { return this.movieId; }

    public void setId(Long id) { this.id = id;  }
    public void setName(String name) { this.name = name;  }
    public void setComment(String comment) { this.comment = comment;  }
    public void setOn(Date on) { this.created = on;  }
    public void setRating(int rating) { this.rating = rating;  }
    public void setMovie(Movie movie) { this.movie = movie; this.movieId = movie.getId();  }
    public void setMovieId(long movieId) { this.movieId = movieId; }

    public Review setIdThen(Long id) { this.id = id; return this; }
    public Review setNameThen(String name) { this.name = name; return this; }
    public Review setCommentThen(String comment) { this.comment = comment; return this; }
    public Review setOnThen(Date on) { this.created = on; return this; }
    public Review setRatingThen(int rating) { this.rating = rating; return this; }
    public Review setMovieThen(Movie movie) { this.movie = movie; this.movieId = movie.getId(); return this; }
    public Review setMovieIdThen(long movieId) { this.movieId = movieId; return this; }

}
