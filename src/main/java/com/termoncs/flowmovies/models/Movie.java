
package com.termoncs.flowmovies.models;

import com.termoncs.flowmovies.validators.CustomUrlConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Movie Model
 * @author aiden
 */

//@Entity
//@Table(name="movie")
//@Data @NoArgsConstructor @AllArgsConstructor @Builder
//public class Movie {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message="Movie name required")
//    private String name;
//
//    @NotBlank(message="Director name required")
//    private String director;
//
//    @Min(value=1, message="Budget must be greater than $0")
//    private double budget;
//
//    @Min(value=1900, message = "Earliest acceptable production year is 1900")
//    private int year;
//
//    @Min(value=0  , message="Minimum duration is 0 minutes")
//    @Max(value=320, message = "Maximum duration is 320 minutes")
//    private int duration;
//
//    @Min(value=0, message="Rating must be 0-5")
//    @Max(value=5, message="Rating must be 0-5")
//    private int rating;
//
//    @CustomUrlConstraint
//    private String posterUrl;
//
//    private Genre genre;
//
//    @Column(columnDefinition = "TEXT")
//    private String cast;
//
//    @Column(columnDefinition = "TEXT")
//    private String plot;
//
//    //private double earnings;
//
//    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
//   //@JsonIgnore
//    public List<Review> reviews;
//
//}

@Entity
@Table(name="movie")
@Where(clause = "year>1980")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Movie name required")
    private String name;

    @NotBlank(message="Director name required")
    private String director;

    @Min(value=1, message="Budget must be greater than $0")
    private double budget;

    @Min(value=1900, message = "Earliest acceptable production year is 1900")
    private int year;

    @Min(value=0  , message="Minimum duration is 0 minutes")
    @Max(value=320, message = "Maximum duration is 320 minutes")
    private int duration;

    @Min(value=0, message="Rating must be 0-5")
    @Max(value=5, message="Rating must be 0-5")
    private int rating;

    @CustomUrlConstraint
    private String posterUrl;

    private Genre genre;
    private String cast;

    @Column(columnDefinition = "TEXT")
    private String plot;

    @Min(value=0, message="Earnings must be positive")
    private int earnings;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    //@JsonIgnore
    public List<Review> reviews;

    public Movie() {
        this.setPosterUrlThen("")
                .setCastThen("")
                .setPlotThen("")
                .setGenreThen(Genre.UNKNOWN)
                .setReviewsThen(new ArrayList<>());
    }

//    public Movie(long _id, String _name, String _director, double _budget, int _year, String _url, int earnings) {
//        this.setId(_id)
//                .setName(_name)
//                .setDirector(_director)
//                .setBudget(_budget)
//                .setDuration(0)
//                .setEarnings(earnings)
//                .setYear(_year)
//                .setCast("")
//                .setGenre(Genre.UNKNOWN)
//                .setPlot("")
//                .setRating(0)
//                .setPosterUrl(_url)
//                .setReviews(new ArrayList<>());
//    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getBudget() { return budget; }
    public int getYear() { return year; }
    public String getDirector() { return director; }
    public int getDuration() { return duration; }
    public String getPosterUrl() { return posterUrl; }
    public Genre getGenre() { return genre; }
    public String getCast() { return cast; }
    public String getPlot() { return plot; }
    public int getRating()  { return rating; }
    public int getEarnings()  { return earnings; }
    public List<Review> getReviews() { return reviews; }

    public Movie setId(long id) { this.id = id; return this; }
    public void setName(String name) { this.name = name; }
    public void setBudget(double budget) { this.budget = budget;  }
    public void setYear(int year) { this.year = year;  }
    public void setDirector(String director) { this.director = director;  }
    public void setDuration(int duration) { this.duration = duration;  }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl;  }
    public void setGenre(Genre genre) { this.genre = genre;  }
    public void setCast(String cast) { this.cast = cast; }
    public void setPlot(String plot) { this.plot = plot;  }
    public void setRating(int rating) { this.rating = rating; }
    public void setEarnings(int earnings) { this.earnings = earnings; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }

    public Movie setIdThen(long id) { this.id = id; return this; }
    public Movie setNameThen(String name) { this.name = name; return this; }
    public Movie setBudgetThen(double budget) { this.budget = budget; return this; }
    public Movie setYearThen(int year) { this.year = year; return this; }
    public Movie setDirectorThen(String director) { this.director = director; return this; }
    public Movie setDurationThen(int duration) { this.duration = duration; return this; }
    public Movie setPosterUrlThen(String posterUrl) { this.posterUrl = posterUrl; return this; }
    public Movie setGenreThen(Genre genre) { this.genre = genre; return this; }
    public Movie setCastThen(String cast) { this.cast = cast; return this; }
    public Movie setPlotThen(String plot) { this.plot = plot; return this; }
    public Movie setRatingThen(int rating) { this.rating = rating; return this; }
    public Movie setEarningsThen(int earnings) { this.earnings = earnings; return this; }
    public Movie setReviewsThen(List<Review> reviews) { this.reviews = reviews; return this; }

    @Override
    public String toString() {
        return  getId() + " " + getName() + " " + getDirector() + " " + getYear() + " " + getBudget() + " " + getPlot() + " " +
                getGenre() + " " + getDuration() +  getCast() + " " + getPosterUrl() + " " + getRating() + " " + getPlot() + " " + getEarnings();
    }
}
